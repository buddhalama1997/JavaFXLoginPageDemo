package application; 	 	
	
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	 public static final int WIDTH = 1700;
	 public static final int HEIGHT = 900;
	@Override
	public void start(Stage primaryStage) {
		// Define device resolution constants

		try {
			primaryStage.setTitle("Library Management System");

	        primaryStage.setWidth(WIDTH);     // Set width 1920
	        primaryStage.setHeight(HEIGHT);   // Set height 1080

	        primaryStage.setMinWidth(1000);   // Minimum resizing limit
	        primaryStage.setMinHeight(700);

	        new LoginPage(primaryStage);      // Load login page

	        primaryStage.show();

	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}