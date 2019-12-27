package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	private double xOffset = 0;
	private double yOffset = 0;

	@Override
	public void start(Stage stage1) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/application/view1.fxml"));
			Scene scene = new Scene(root, 970, 540);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			root.setOnMousePressed(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					xOffset = event.getSceneX();
					yOffset = event.getSceneY();
				}
			});
			root.setOnMouseDragged(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					stage1.setX(event.getScreenX() - xOffset);
					stage1.setY(event.getScreenY() - yOffset);
				}
			});

			stage1.setScene(scene);
			stage1.initStyle(StageStyle.TRANSPARENT);
			stage1.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
