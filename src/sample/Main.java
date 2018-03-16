package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.tableData5;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class Main extends Application {
    private Button button1 = new Button("press me");
    private Button button21 = new Button("press me");
    private Button button22 = new Button("press me");
    private Button button3 = new Button("press me");
    private Button button4 = new Button("press me");
    private Button button51 = new Button("press me");
    private Button button52 = new Button("press me");
    private Button button53 = new Button("press me");
    private Button start = new Button("start");
    private Button stop = new Button("stop");
    private TextField textField1 = new TextField();
    private TextField textField2 = new TextField();
    private TextField textField3 = new TextField();
    private TextField textField4 = new TextField();
    private TextField textField5 = new TextField();
    private ComboBox<String> list = new ComboBox<String>();
    private RadioButton radioButton1 = new RadioButton("1");
    private RadioButton radioButton2 = new RadioButton("2");
    private RadioButton radioButton3 = new RadioButton("3");
    private CheckBox checkBox1 = new CheckBox("1");
    private CheckBox checkBox2 = new CheckBox("2");
    private CheckBox checkBox3 = new CheckBox("3");
    private TableView<sample.tableData5> table5 = new TableView<sample.tableData5>();
    private TableColumn<tableData5, String> col1 = new TableColumn<tableData5, String>();
    private TableColumn<tableData5, String> col2 = new TableColumn<tableData5, String>();
    private final ObservableList<tableData5> data = FXCollections.observableArrayList();
    private int loop = 0;

    private void alert(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("WARNING!!!");
        alert.setHeaderText(null);
        alert.setContentText(text);

        alert.showAndWait();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        button1.setOnAction(event -> {
            if (textField1.getText().equals("")) {
                alert("Please, type some text");
            } else {
                if (list.getItems().contains(textField1.getText())) {
                    alert("You cannot add this text. It's already added");
                } else {
                    list.getItems().add(textField1.getText());
                }
            }
        });
        button21.setOnAction(event -> {
        if (textField2.getText().equals("")) {
            alert("Please, type some text");
        }
        else {
            button22.setText(textField2.getText());
        }
        });
        button22.setOnAction(event -> {
            String var = button21.getText();
            button21.setText(button22.getText());
            button22.setText(var);
        });
        button3.setOnAction(event -> {
            if (textField3.getText().equals(radioButton1.getText())) {
                radioButton1.setSelected(true);
                radioButton2.setSelected(false);
                radioButton3.setSelected(false);
            }
        else if (textField3.getText().equals(radioButton2.getText())) {
                radioButton1.setSelected(false);
                radioButton2.setSelected(true);
                radioButton3.setSelected(false);
            }
        else if (textField3.getText().equals(radioButton3.getText())) {
                radioButton1.setSelected(false);
                radioButton2.setSelected(false);
                radioButton3.setSelected(true);
            }
        else {
            alert("This text is not equals to any button");
        }
        });
        button4.setOnAction(event -> {
            if (textField4.getText().equals(checkBox1.getText())) {
                checkBox1.setSelected(true);
            }
        else if (textField4.getText().equals(checkBox2.getText())) {
                checkBox2.setSelected(true);
            }
        else if (textField4.getText().equals(checkBox3.getText())) {
                checkBox3.setSelected(true);
            }
        else {
                alert("This text is not equals to any box");
            }
        });
        button52.setOnAction(event -> {
            if (table5.getSelectionModel().getSelectedItems().isEmpty()) {
                alert("Please, select any row on table");
            } else {
                ObservableList<tableData5> selected_item = table5.getSelectionModel().getSelectedItems();
                if (!selected_item.get(0).getFirstList().equals("")){
                    data.set(data.indexOf(selected_item.get(0)), new tableData5("", selected_item.get(0).getFirstList()));
                }
            }
        });
        button53.setOnAction(event -> {
        if (table5.getSelectionModel().getSelectedItems().isEmpty()) {
            alert("Please, select any row on table");
        } else {
            ObservableList<tableData5> selected_item = table5.getSelectionModel().getSelectedItems();
            if (!selected_item.get(0).getSecondList().equals("")){
                data.set(data.indexOf(selected_item.get(0)), new tableData5(selected_item.get(0).getSecondList(), ""));
            }
        }
    });
        button51.setOnAction(event -> {
            if (textField5.getText().equals("")){
                alert("Please, enter any text");
            }
            else {
                col1.setCellValueFactory(new PropertyValueFactory<>("firstList"));
                col2.setCellValueFactory(new PropertyValueFactory<>("secondList"));
                data.add(new tableData5(textField5.getText(), ""));
                table5.setItems(data);
            }
        });
        Accordion accordion = new Accordion();
        TitledPane pane1 = new TitledPane(),
                pane2 = new TitledPane(),
                pane3 = new TitledPane(),
                pane4 = new TitledPane(),
                pane5 = new TitledPane();
        Pane pan1 = new Pane(),
                pan2 = new Pane(),
                pan3 = new Pane(),
                pan4 = new Pane(),
                pan5 = new Pane();

        pane1.setAnimated(false);
        pane1.setText("task #1");
        pan1.getChildren().addAll(button1, textField1, list);
        pane1.setContent(pan1);

        pane2.setAnimated(false);
        pane2.setText("task #2");
        pan2.getChildren().addAll(button21, button22, textField2);
        pane2.setContent(pan2);

        pane3.setAnimated(false);
        pane3.setText("task #3");
        pan3.getChildren().addAll(textField3, button3, radioButton1, radioButton2, radioButton3);
        pane3.setContent(pan3);

        pane4.setAnimated(false);
        pane4.setText("task #4");
        pan4.getChildren().addAll(textField4, button4, checkBox1, checkBox2, checkBox3);
        pane4.setContent(pan4);

        pane5.setAnimated(false);
        pane5.setText("task #5");
        table5.setEditable(true);
        table5.getColumns().addAll(col1, col2);
        pan5.getChildren().addAll(textField5, button51, button52, button53, table5);
        pane5.setContent(pan5);

        accordion.getPanes().addAll(pane1, pane2, pane3, pane4, pane5);


        Scene scene = new Scene(new Group(), 640, 480);
        accordion.setMinHeight(scene.getHeight()/2);
        accordion.setMinSize(scene.getWidth()/2, scene.getWidth()/2);
        Group root = (Group)scene.getRoot();

        root.getChildren().addAll(accordion, start, stop);

        primaryStage.setTitle("PIVS - 1");
        primaryStage.setScene(scene);
        primaryStage.show();

        button1.setLayoutY(textField1.getHeight());
        list.setLayoutY(textField1.getHeight() + button1.getHeight());

        button21.setLayoutY(textField2.getHeight());
        button22.setLayoutY(textField2.getHeight() + button21.getHeight());
        button22.setLayoutX(button21.getLayoutX());

        button3.setLayoutY(textField3.getHeight());
        radioButton1.setLayoutY(textField3.getHeight() + button3.getHeight());
        radioButton2.setLayoutY(textField3.getHeight() + button3.getHeight() + radioButton1.getHeight());
        radioButton3.setLayoutY(textField3.getHeight() + button3.getHeight() + radioButton1.getHeight() +
                radioButton2.getHeight());

        button4.setLayoutY(textField4.getHeight());
        checkBox1.setLayoutY(textField4.getHeight() + button4.getHeight());
        checkBox2.setLayoutY(textField4.getHeight() + button4.getHeight() + radioButton1.getHeight());
        checkBox3.setLayoutY(textField4.getHeight() + button4.getHeight() + checkBox1.getHeight() +
                checkBox2.getHeight());

        button51.setLayoutX(textField5.getWidth());
        button52.setLayoutX(textField5.getWidth() + button51.getWidth());
        button53.setLayoutX(textField5.getWidth() + button51.getWidth() + button52.getWidth());
        table5.setLayoutY(textField5.getHeight());
        table5.setPrefWidth(accordion.getWidth());
        col1.setPrefWidth(accordion.getWidth() / 2);
        col2.setPrefWidth(accordion.getWidth() / 2);

        start.setLayoutX(scene.getWidth() - start.getWidth());
        stop.setLayoutX(scene.getWidth() - stop.getWidth());
        stop.setLayoutY(start.getWidth());

        ObservableList<TitledPane> panes = accordion.getPanes();
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                while (loop != -1){
                    panes.get(loop).setExpanded(true);
                    loop = (loop + 1) % panes.size();
                    System.out.print(loop);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        start.setOnAction((ActionEvent event) -> {
            th.start();
        });
        stop.setOnAction(event -> {
            loop = -1;
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
