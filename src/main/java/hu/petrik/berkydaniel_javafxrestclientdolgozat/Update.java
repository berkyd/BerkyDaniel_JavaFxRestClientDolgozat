package hu.petrik.berkydaniel_javafxrestclientdolgozat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Update extends Controller {
    @FXML
    private TextField nameField;
    @FXML
    private TextField birthplaceField;
    @FXML
    private Spinner<Integer> ageField;
    @FXML
    private Spinner<Boolean> questionField;
    @FXML
    private Button updateButton;
    private People person;


    public void setPerson(People person) {
        this.person = person;
        nameField.setText((this.person.getName()));
        birthplaceField.setText((this.person.getBirthplace()));
        ageField.getValueFactory().setValue((this.person.getAge()));

    }



    @FXML
    public void updateClick(ActionEvent actionEvent) {
        String name = nameField.getText().trim();
        String birthplace = birthplaceField.getText().trim();
        int age = ageField.getValue();
        Boolean igenek = questionField.getValue();
        if (name.isEmpty()) {
            warning("Nevet meg kell adni!");
            return;
        }
        if (birthplace.isEmpty()) {
            warning("Születési helyet meg kell adni!");
            return;
        }
        // TODO: validate email format
        this.person.setName(name);
        this.person.setBirthplace(birthplace);
        this.person.setAge(age);
        this.person.setQuestion(questionField);
        Gson converter = new Gson();
        String json = converter.toJson(this.person);
        try {
            String url= App.BASE_URL+ "/" +this.person.getId();
            Response response = RequestHandler.put(url, json);
            if (response.getResponseCode() == 200) {
                Stage stage =(Stage) this.updateButton.getScene().getWindow();
                stage.close();
            } else {
                String content = response.getContent();
                error(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
