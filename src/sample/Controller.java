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
    public TextField text_field1;
    public TextField text_field2;
    public TextField text_field3;
    public TextField text_field4;
    public TextField text_field5;
    public ComboBox<String> list;
    public RadioButton radio_button_1;
    public RadioButton radio_button_2;
    public RadioButton radio_button_3;
    public CheckBox check_box_1;
    public CheckBox check_box_2;
    public CheckBox check_box_3;
    public TableView<table_5_data> table_5;
    public TableColumn<String, String> col1;
    public TableColumn<String, String> col2;
    private final ObservableList<table_5_data> data = FXCollections.observableArrayList();

    private void alert(String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("WARNING!!!");
        alert.setHeaderText(null);
        alert.setContentText(text);

        alert.showAndWait();
    }

    public void press_but1(ActionEvent actionEvent) {
        if (text_field1.getText().equals("")){
           alert("Please, type some text");
        }
        else {
            if (list.getItems().contains(text_field1.getText())) {
                alert("You cannot add this text. It's already added");
            } else {
                list.getItems().add(text_field1.getText());
            }
        }
    }

    public void press_but52(ActionEvent actionEvent) {
        if (table_5.getSelectionModel().getSelectedItems() == null) {
            alert("Please, select any row on table");
        } else {
            ObservableList<table_5_data> selected_item = table_5.getSelectionModel().getSelectedItems();
            if (!selected_item.get(0).getFirst_list().equals("")){
                data.set(data.indexOf(selected_item.get(0)), new table_5_data("", selected_item.get(0).getFirst_list()));
            }
        }
    }

    public void press_but53(ActionEvent actionEvent) {
        if (table_5.getSelectionModel().getSelectedItems() == null) {
            alert("Please, select any row on table");
        } else {
            ObservableList<table_5_data> selected_item = table_5.getSelectionModel().getSelectedItems();
            if (!selected_item.get(0).getSecond_list().equals("")){
                data.set(data.indexOf(selected_item.get(0)), new table_5_data(selected_item.get(0).getSecond_list(), ""));
            }
        }
    }

    public class table_5_data{
        private String first_list;
        private String second_list;

        table_5_data(String first_list, String second_list){
            this.first_list = first_list;
            this.second_list = second_list;
        }

        public String getFirst_list() {
            return first_list;
        }

        public String getSecond_list() {
            return second_list;
        }
    }

    public void press_but51(ActionEvent actionEvent) {
        if (text_field5.getText().equals("")){
            alert("Please, enter any text");
        }
        else {
            col1.setCellValueFactory(new PropertyValueFactory<String, String>("first_list"));
            col2.setCellValueFactory(new PropertyValueFactory<String, String>("second_list"));
            String first_list = "";
            String second_list = "";
            first_list = "ASD";
            second_list = "FRE";
            data.add(new table_5_data(text_field5.getText(), ""));
            table_5.setItems(data);
        }
    }

    public void press_but4(ActionEvent actionEvent) {
        if (text_field4.getText().equals(check_box_1.getText())){
            check_box_1.setSelected(true);
            check_box_2.setSelected(false);
            check_box_3.setSelected(false);
        }
        else if (text_field4.getText().equals(check_box_2.getText())){
            check_box_1.setSelected(false);
            check_box_2.setSelected(true);
            check_box_3.setSelected(false);
        }
        else if (text_field4.getText().equals(check_box_3.getText())){
            check_box_1.setSelected(false);
            check_box_2.setSelected(false);
            check_box_3.setSelected(true);
        }
        else {
            alert("This text is not equals to any box");
        }
    }

    public void press_but3(ActionEvent actionEvent) {
        if (text_field3.getText().equals(radio_button_1.getText())){
            radio_button_1.setSelected(true);
            radio_button_2.setSelected(false);
            radio_button_3.setSelected(false);
        }
        else if (text_field3.getText().equals(radio_button_2.getText())){
            radio_button_1.setSelected(false);
            radio_button_2.setSelected(true);
            radio_button_3.setSelected(false);
        }
        else if (text_field3.getText().equals(radio_button_3.getText())){
            radio_button_1.setSelected(false);
            radio_button_2.setSelected(false);
            radio_button_3.setSelected(true);
        }
        else {
            alert("This text is not equals to any button");
        }
    }

    public void press_but21(ActionEvent actionEvent) {
        if (text_field2.getText().equals("")){
            alert("Please, type some text");
        }
        else{
            button22.setText(text_field2.getText());
        }

    }
    public void press_but22(ActionEvent actionEvent) {
            String var = button21.getText();
            button21.setText(button22.getText());
            button22.setText(var);
    }
}
