package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class view1controller {
	
	private double xOffset = 0;
	private double yOffset = 0;

	@FXML
	private Button applybutton, noob, hardworker, arnold;
	
	@FXML
	private AnchorPane anchorpane;

	@FXML
	protected void loginregister(ActionEvent event) {

		Stage stage;

		stage = (Stage) anchorpane.getScene().getWindow();

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/view2.fxml"));

		Parent root = null;
		try {
			root = (Parent) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		view2controller v2 = fxmlLoader.<view2controller>getController();
		
		root.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			}
		});
		root.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				stage.setX(event.getScreenX() - xOffset);
				stage.setY(event.getScreenY() - yOffset);
			}
		});
		
		Scene scene = new Scene(root);

		stage.setScene(scene);

		stage.show();

		if (event.getSource() == noob) {
			v2.setButton(noob.getId());
		}

		else if (event.getSource() == hardworker) {
			v2.setButton(hardworker.getId());
		} else {
			v2.setButton(arnold.getId());
		}
	}
	
	public void closeOperation() {
		System.exit(0);
	}

}