package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class view1controller {

	@FXML
	private Button applybutton, noob, hardworker, arnold;

	public void closeOperation() {
		System.exit(0);
	}

	@FXML
	private AnchorPane anchorpane;

	@FXML
	protected void loginregister(ActionEvent event) {

		Stage stage;
		Parent root = null;

		stage = (Stage) anchorpane.getScene().getWindow();

		try {
			root = FXMLLoader.load(getClass().getResource("/application/view2.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		view3controller v3 = Loader.getController();
		
		if (event.getSource() == noob) {
			
		}

		else if (event.getSource() == hardworker) {
			
			
		} else {
			
		}
	}
}
