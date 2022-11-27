package hu.petrik.berkydaniel_javafxrestclientdolgozat;

import javafx.scene.control.Spinner;

public class People {
    private int id;
    @Expose
    private String name;
    @Expose
    private String birthplace;
    @Expose
    private int age;
    @Expose
    private boolean question;

    public People(int id, String name, String birthplace, int age, String question) {
        this.id = id;
        this.name = name;
        this.birthplace = birthplace;
        this.age = age;
        this.question= Boolean.parseBoolean(question);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getQuestion() {
        return question;
    }

    public void setQuestion(Spinner<Boolean> questionField){
    }
}
