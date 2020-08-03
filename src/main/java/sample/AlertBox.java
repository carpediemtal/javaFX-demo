package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlertBox {
    public static void display(String title, String message) {
        Stage stage = new Stage();
        stage.setTitle(title);

        Label label = new Label();
        label.setText(message);

        Button closeBtn = new Button("close");
        closeBtn.setOnAction(actionEvent -> stage.close());

        VBox vBox = new VBox();
        vBox.getChildren().add(label);
        vBox.getChildren().add(closeBtn);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox, 500, 200);

        stage.setScene(scene);
        stage.showAndWait();
    }
}
