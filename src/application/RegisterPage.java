package application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class RegisterPage {

    private Stage stage;

    public RegisterPage(Stage stage) {
        this.stage = stage;
        createUI();
    }

    private void createUI() {

        StackPane root = new StackPane();
        root.getStyleClass().add("root");

        VBox formBox = new VBox(25);
        formBox.setMaxWidth(450);
        formBox.setAlignment(Pos.CENTER);
        formBox.getStyleClass().add("form-container");

        Label title = new Label("Create Account");
        title.getStyleClass().add("title");

        TextField username = new TextField();
        username.setPromptText("Choose Username");

        PasswordField password = new PasswordField();
        password.setPromptText("Choose Password");

        Button registerBtn = new Button("Register");
        registerBtn.setMaxWidth(Double.MAX_VALUE);

        Button backBtn = new Button("Back to Login");
        backBtn.setMaxWidth(Double.MAX_VALUE);
        backBtn.getStyleClass().add("secondary-button");

        Label message = new Label();
        message.getStyleClass().add("message");

        registerBtn.setOnAction(e -> {
            if(username.getText().isEmpty() ||
               password.getText().isEmpty()) {
                message.setText("All fields required!");
            } else {
                message.setText("Registration Successful!");
            }
        });

        backBtn.setOnAction(e -> {
            new LoginPage(stage);
        });

        formBox.getChildren().addAll(
                title,
                username,
                password,
                registerBtn,
                backBtn,
                message
        );

        root.getChildren().add(formBox);

        Scene scene = new Scene(root, Main.WIDTH, Main.HEIGHT);

        scene.getStylesheets().add(
                getClass().getResource("style.css").toExternalForm()
        );

        stage.setScene(scene);
    }
}