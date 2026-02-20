package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// --- 1. LAYOUT SETUP (The Container) ---
	        GridPane grid = new GridPane();
	        grid.setAlignment(Pos.CENTER); // Keeps the entire grid centered in the window
	        grid.setHgap(15);               // Horizontal spacing between columns
	        grid.setVgap(15);               // Vertical spacing between rows
	        grid.setPadding(new Insets(40)); // Padding around the edges of the grid
	        
	        // Add a CSS class to the grid for background styling
	        grid.getStyleClass().add("root-pane");

	        // RESPONSIVE SETTING: Make the second column (the inputs) grow with the window
	        ColumnConstraints column1 = new ColumnConstraints();
	        ColumnConstraints column2 = new ColumnConstraints();
	        column2.setHgrow(Priority.ALWAYS); // This allows the text fields to expand horizontally
	        grid.getColumnConstraints().addAll(column1, column2);

	        // --- 2. UI ELEMENTS (The Content) ---

	        // Title Text
	        Text sceneTitle = new Text("Account Login");
	        sceneTitle.setId("welcome-text"); // Specific ID for CSS
	        // Add to col 0, row 0, span 2 columns, 1 row
	        grid.add(sceneTitle, 0, 0, 2, 1);

	        // Username Label & Field
	        Label userName = new Label("Username");
	        grid.add(userName, 0, 1);
	        
	        TextField userTextField = new TextField();
	        userTextField.setPromptText("e.g. jdoe123"); // Placeholder text
	        grid.add(userTextField, 1, 1);

	        // Password Label & Field
	        Label pw = new Label("Password");
	        grid.add(pw, 0, 2);
	        
	        PasswordField pwBox = new PasswordField();
	        pwBox.setPromptText("••••••••"); // Placeholder text
	        grid.add(pwBox, 1, 2);

	        // Login Button
	        Button btn = new Button("Sign In");
	        btn.getStyleClass().add("login-button");
	        // Make the button fill the width of its cell
	        btn.setMaxWidth(Double.MAX_VALUE); 
	        grid.add(btn, 1, 4);

	        // --- 3. SCENE & STAGE (The Window) ---
	        
	        // Create the Scene with a preferred starting size
	        Scene scene = new Scene(grid, 450, 400);
	        
	        // Connect the external CSS file
	        // Ensure style.css is in the same folder as this file
	        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

	        primaryStage.setTitle("JavaFX Responsive Login");
	        primaryStage.setMinWidth(350); // Prevent the window from getting too small
	        primaryStage.setMinHeight(350);
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
