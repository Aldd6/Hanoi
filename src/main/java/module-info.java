module com.das6.hanoi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.das6.hanoi to javafx.fxml;
    exports com.das6.hanoi;
}