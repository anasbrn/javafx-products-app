package com.moveup.products_app_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class ProductApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ProductApplication.class.getResource("product-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 600);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toString());
        stage.setTitle("Products");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
