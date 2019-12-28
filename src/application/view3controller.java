package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class view3controller {

	private double xOffset = 0;
	private double yOffset = 0;
	
	private String contract;

	@FXML
	private Label contracttype, contractnumber;

	@FXML
	private AnchorPane anchorpane;
	
	@FXML
	private Button traininghistory;

	@FXML
	protected void trainingHistory(ActionEvent event) {

		Parent root = null;

		Stage stage;

		stage = (Stage) anchorpane.getScene().getWindow();

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/view4.fxml"));

		try {
			root = (Parent) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Scene scene = new Scene(root);

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

		stage.setScene(scene);

		stage.show();
	}

	public void setContracttype(String Contracttype) {
		this.contract = Character.toUpperCase(Contracttype.charAt(0)) + Contracttype.substring(1);
		this.contracttype.setText(this.contract + " " + "-");
	}
	
	public void cancle() {
		
	}
	
	public void edit() {
		
	}
	
	public void pause() {
		
	}

	public void closeOperation() {
		view1controller v1 = new view1controller();
		v1.closeOperation();
	}

}
