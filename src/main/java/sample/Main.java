package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TableColumn<Hero, String> nameColumn = new TableColumn<>("name");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Hero, String> voiceLineColumn = new TableColumn<>("voice line");
        voiceLineColumn.setMinWidth(400);
        voiceLineColumn.setCellValueFactory(new PropertyValueFactory<>("voiceLine"));

        TableColumn<Hero, Integer> hpColumn = new TableColumn<>("hp");
        hpColumn.setMinWidth(100);
        hpColumn.setCellValueFactory(new PropertyValueFactory<>("hp"));

        TableView<Hero> tableView = new TableView<>();
        var heroes = getHeroes();
        tableView.setItems(heroes);
        tableView.getColumns().add(nameColumn);
        tableView.getColumns().add(voiceLineColumn);
        tableView.getColumns().add(hpColumn);

        TextField nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        TextField voiceLineInput = new TextField();
        voiceLineInput.setPromptText("voice line");
        voiceLineInput.setMinWidth(400);

        TextField hpInput = new TextField();
        hpInput.setPromptText("hp");
        hpInput.setMinWidth(100);

        Button addBtn = new Button("add");
        addBtn.setOnAction(actionEvent -> addBtnClicked(heroes, nameInput, voiceLineInput, hpInput));
        Button deleteBtn = new Button("delete");
        deleteBtn.setOnAction(actionEvent -> heroes.remove(tableView.getSelectionModel().getSelectedItem()));


        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.getChildren().addAll(nameInput, voiceLineInput, hpInput, addBtn, deleteBtn);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(tableView, hBox);
        vBox.setPadding(new Insets(20, 20, 20, 20));


        Scene scene = new Scene(vBox, 1000, 500);

        primaryStage.setTitle("overwatch");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("file:ow.jpg"));
        primaryStage.show();
    }

    private void addBtnClicked(ObservableList<Hero> heroes, TextField nameInput, TextField voiceLineInput, TextField hpInput) {
        try {
            int hp = Integer.parseInt(hpInput.getText());
            if (hp < 0 || hp > 1000) {
                System.out.println("hp must be between 0 and 1000");
            }
            String name = nameInput.getText();
            String voiceLine = voiceLineInput.getText();
            heroes.add(new Hero(name, voiceLine, hp));
            // when add button activity finished, clear the input label
            nameInput.clear();
            voiceLineInput.clear();
            hpInput.clear();
        } catch (NumberFormatException e) {
            System.out.println("hp must be a number");
        }
    }

    public ObservableList<Hero> getHeroes() {
        ObservableList<Hero> heroes = FXCollections.observableArrayList();
        Hero tracer = new Hero("tracer", "The world could always use more heroes", 150);
        Hero genji = new Hero("genji", "White tiger becomes me", 200);
        Hero mercy = new Hero("mercy", "Heroes never die", 200);
        Hero mcCree = new Hero("mcCree", "It's high noon", 200);
        Hero hanzo = new Hero("hanzo", "I choose you, spirit wolf", 200);
        heroes.addAll(tracer, genji, mercy, mcCree, hanzo);
        return heroes;
    }
}
