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
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class view3controller {

	private double xOffset = 0;
	private double yOffset = 0;

	private String contract;

	@FXML
	private Label contracttype, contractnumber, attention, confirmationinfo, contractlabels1, contractlabels2,
			contractlabels3, contractlabels4, contractlabels5, contractlabels6;

	@FXML
	private AnchorPane anchorpane;

	@FXML
	private Button traininghistory, canclecontract, cancle, canclecontractoption, changecontract, pausecontract;

	@FXML
	private ImageView contractimage;

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
		
		view4controller v4 = fxmlLoader.<view4controller>getController();
		v4.getContracttyype(this.contract);
	}

	@FXML
	protected void startPage(ActionEvent event) {
		Parent root = null;

		Stage stage;

		stage = (Stage) anchorpane.getScene().getWindow();

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/view1.fxml"));

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

		view1controller v1 = fxmlLoader.<view1controller>getController();

		v1.getContracttype(this.contract);
		v1.cancelledContract();
	}

	public void setContracttype(String Contracttype) {
		this.contract = Character.toUpperCase(Contracttype.charAt(0)) + Contracttype.substring(1);
		this.contracttype.setText(this.contract + " " + "-");
	}

	public void cancle() {
		BoxBlur blur = new BoxBlur();
		blur.setHeight(10);
		blur.setWidth(10);
		blur.setIterations(5);
		traininghistory.setEffect(blur);
		traininghistory.setDisable(true);
		canclecontractoption.setEffect(blur);
		canclecontractoption.setDisable(true);
		changecontract.setEffect(blur);
		changecontract.setDisable(true);
		pausecontract.setEffect(blur);
		pausecontract.setDisable(true);
		contractlabels1.setEffect(blur);
		contractlabels2.setEffect(blur);
		contractlabels3.setEffect(blur);
		contractlabels4.setEffect(blur);
		contractlabels5.setEffect(blur);
		contractlabels6.setEffect(blur);
		contractnumber.setEffect(blur);
		contracttype.setEffect(blur);
		contractimage.setEffect(blur);
		attention.setVisible(true);
		confirmationinfo.setVisible(true);
		canclecontract.setVisible(true);
		cancle.setVisible(true);
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