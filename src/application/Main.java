package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage stage1) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("view1.fxml"));
			Scene scene = new Scene(root,970,540);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage1.setScene(scene);
			stage1.initStyle(StageStyle.TRANSPARENT);
			stage1.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
