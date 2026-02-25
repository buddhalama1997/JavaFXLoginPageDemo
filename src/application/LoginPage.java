package application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginPage {

    private Stage stage;

    public LoginPage(Stage stage) {
        this.stage = stage;
        createUI();
    }

    private void createUI() {

        // Root layout fills entire screen
        StackPane root = new StackPane();
        root.getStyleClass().add("root");

        // Responsive form container
        VBox formBox = new VBox(25);
        formBox.setMaxWidth(450);  // Card width
        formBox.setAlignment(Pos.CENTER);
        formBox.getStyleClass().add("form-container");

        Label title = new Label("Login Page");
        title.getStyleClass().add("title");

        TextField username = new TextField();
        username.setPromptText("Username");

        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        Button loginBtn = new Button("Login");
        loginBtn.setMaxWidth(Double.MAX_VALUE);

        Button registerBtn = new Button("Create Account");
        registerBtn.setMaxWidth(Double.MAX_VALUE);
        registerBtn.getStyleClass().add("secondary-button");

        Label message = new Label();
        message.getStyleClass().add("message");

        // Login logic
        loginBtn.setOnAction(e -> {
            if(username.getText().equals("admin") &&
               password.getText().equals("1234")) {
                message.setText("Login Successful!");
            } else {
                message.setText("Invalid Credentials!");
            }
        });

        // Switch page
        registerBtn.setOnAction(e -> {
            new RegisterPage(stage);
        });

        formBox.getChildren().addAll(
                title,
                username,
                password,
                loginBtn,
                registerBtn,
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