package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    public Button button1;
    public Button button21;
    public Button button22;
    public Button button3;
    public Button button4;
    public Button button51;
    public Button button52;
    public Button button53;
    public TextField textField1;
    public TextField textField2;
    public TextField textField3;
    public TextField textField4;
    public TextField textField5;
    public ComboBox<String> list;
    public RadioButton radioButton1;
    public RadioButton radioButton2;
    public RadioButton radioButton3;
    public CheckBox checkBox1;
    public CheckBox checkBox2;
    public CheckBox checkBox3;
    public TableView<tableData5> table5;
    public TableColumn<String, String> col1;
    public TableColumn<String, String> col2;
    private final ObservableList<tableData5> data = FXCollections.observableArrayList();

    private void alert(String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("WARNING!!!");
        alert.setHeaderText(null);
        alert.setContentText(text);

        alert.showAndWait();
    }

    public void pressBut1(ActionEvent actionEvent) {
        if (textField1.getText().equals("")){
           alert("Please, type some text");
        }
        else {
            if (list.getItems().contains(textField1.getText())) {
                alert("You cannot add this text. It's already added");
            } else {
                list.getItems().add(textField1.getText());
            }
        }
    }

    public void pressBut52(ActionEvent actionEvent) {
        if (table5.getSelectionModel().getSelectedItems() == null) {
            alert("Please, select any row on table");
        } else {
            ObservableList<tableData5> selected_item = table5.getSelectionModel().getSelectedItems();
            if (!selected_item.get(0).getFirstList().equals("")){
                data.set(data.indexOf(selected_item.get(0)), new tableData5("", selected_item.get(0).getFirstList()));
            }
        }
    }

    public void pressBut53(ActionEvent actionEvent) {
        if (table5.getSelectionModel().getSelectedItems() == null) {
            alert("Please, select any row on table");
        } else {
            ObservableList<tableData5> selected_item = table5.getSelectionModel().getSelectedItems();
            if (!selected_item.get(0).getSecondList().equals("")){
                data.set(data.indexOf(selected_item.get(0)), new tableData5(selected_item.get(0).getSecondList(), ""));
            }
        }
    }

    public void pressBut51(ActionEvent actionEvent) {
        if (textField5.getText().equals("")){
            alert("Please, enter any text");
        }
        else {
            col1.setCellValueFactory(new PropertyValueFactory<>("firstList"));
            col2.setCellValueFactory(new PropertyValueFactory<>("secondList"));
            data.add(new tableData5(textField5.getText(), ""));
            table5.setItems(data);
        }
    }

    public void pressBut4(ActionEvent actionEvent) {
        if (textField4.getText().equals(checkBox1.getText())){
            checkBox1.setSelected(true);
            checkBox2.setSelected(false);
            checkBox3.setSelected(false);
        }
        else if (textField4.getText().equals(checkBox2.getText())){
            checkBox1.setSelected(false);
            checkBox2.setSelected(true);
            checkBox3.setSelected(false);
        }
        else if (textField4.getText().equals(checkBox3.getText())){
            checkBox1.setSelected(false);
            checkBox2.setSelected(false);
            checkBox3.setSelected(true);
        }
        else {
            alert("This text is not equals to any box");
        }
    }

    public void pressBut3(ActionEvent actionEvent) {
        if (textField3.getText().equals(radioButton1.getText())){
            radioButton1.setSelected(true);
            radioButton2.setSelected(false);
            radioButton3.setSelected(false);
        }
        else if (textField3.getText().equals(radioButton2.getText())){
            radioButton1.setSelected(false);
            radioButton2.setSelected(true);
            radioButton3.setSelected(false);
        }
        else if (textField3.getText().equals(radioButton3.getText())){
            radioButton1.setSelected(false);
            radioButton2.setSelected(false);
            radioButton3.setSelected(true);
        }
        else {
            alert("This text is not equals to any button");
        }
    }

    public void pressBut21(ActionEvent actionEvent) {
        if (textField2.getText().equals("")){
            alert("Please, type some text");
        }
        else{
            button22.setText(textField2.getText());
        }

    }
    public void pressBut22(ActionEvent actionEvent) {
            String var = button21.getText();
            button21.setText(button22.getText());
            button22.setText(var);
    }
}
