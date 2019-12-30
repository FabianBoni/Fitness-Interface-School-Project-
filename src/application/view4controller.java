package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class view4controller {

	private double xOffset = 0;
	private double yOffset = 0;
	private String contracttype;

	@FXML
	private AnchorPane anchorpane;

	@FXML
	private ListView<String> listview;

	@FXML
	protected void myContract(ActionEvent event) {

		Parent root = null;

		Stage stage;

		stage = (Stage) anchorpane.getScene().getWindow();

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/view3.fxml"));

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

		view3controller v3 = fxmlLoader.<view3controller>getController();
		v3.setContracttype(this.contracttype);
	}

	public void getContracttyype(String contracttype) {
		this.contracttype = contracttype;
	}

	public void addElement() {
		listview.getItems().add("some new element");
	}

	public void removeElement() {
		final int selectedItem = listview.getSelectionModel().getSelectedIndex();
		listview.getItems().remove(selectedItem);
	}
	
	public void editElement() {

	}
	
	public void getNewValue() {
		
	}

	public void closeOperation() {
		view1controller v1 = new view1controller();
		v1.closeOperation();
	}

}