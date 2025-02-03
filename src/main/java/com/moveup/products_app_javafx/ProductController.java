package com.moveup.products_app_javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
    @FXML
    public TextField textFieldName;
    @FXML
    public TextField textFieldPrice;
    @FXML
    public ListView<Product> listView;
    private final ObservableList<Product> data = FXCollections.observableArrayList();

    public void addProduct() {
        try {
            String name = textFieldName.getText();
            if (name.trim().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please fill the field name!!");
                alert.show();
                return;
            }
            double price = Double.parseDouble(textFieldPrice.getText());
            Product product = new Product(textFieldName.getText(), price);
            data.add(product);
            resetData();
            System.out.println(listView.getItems());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter a valid price!!");
            alert.show();
        }
    }

    public void deleteProduct() {
        int index = listView.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            data.remove(index);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select a product first!");
            alert.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setItems(data);
    }

    private void resetData() {
        textFieldName.setText("");
        textFieldPrice.setText("");
    }
}
