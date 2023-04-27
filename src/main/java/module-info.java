module cr.ac.una.monopolyjunior {
    
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.web;
    requires javafx.graphicsEmpty;
    requires java.logging;
    requires java.base;
    requires com.jfoenix;
    
    opens cr.ac.una.monopolyjunior to javafx.fxml, com.jfoenix;
    opens cr.ac.una.monopolyjunior.controller to com.jfoenix,javafx.fxml,javafx.media,javafx.web;
    opens cr.ac.una.monopolyjunior.util to com.jfoenix,javafx.fxml,javafx.media;
        
    exports cr.ac.una.monopolyjunior;    
    exports cr.ac.una.monopolyjunior.controller;
    exports cr.ac.una.monopolyjunior.util;
}
