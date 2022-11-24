module hu.petrik.berkydaniel_javafxrestclientdolgozat {
    requires javafx.controls;
    requires javafx.fxml;


    opens hu.petrik.berkydaniel_javafxrestclientdolgozat to javafx.fxml;
    exports hu.petrik.berkydaniel_javafxrestclientdolgozat;
}