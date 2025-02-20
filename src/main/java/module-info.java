module com.das6.hanoi {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.das6.hanoi.controller to javafx.graphics, javafx.fxml;
    exports com.das6.hanoi.controller;
}