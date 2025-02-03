module com.moveup.products_app_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.moveup.products_app_javafx to javafx.fxml;
    exports com.moveup.products_app_javafx;
}