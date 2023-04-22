module cr.ac.una.monopolyjunior {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.logging;
    
    opens cr.ac.una.monopolyjunior to javafx.fxml, com.jfoenix;
    opens cr.ac.una.monopolyjunior.controller to com.jfoenix,javafx.fxml;
    opens cr.ac.una.monopolyjunior.util to com.jfoenix,javafx.fxml;
    
    exports cr.ac.una.monopolyjunior;    
    exports cr.ac.una.monopolyjunior.controller;
    exports cr.ac.una.monopolyjunior.util;
}
