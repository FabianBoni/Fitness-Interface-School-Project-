package application;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	private int random;

	@FXML
	private Label contracttype, contractnumber, attention, confirmationinfo, contractlabels1, contractlabels2,
			contractlabels3, contractlabels4, contractlabels5, contractlabels6, infolabel;

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
		v4.getContractNumber(this.random);
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

		if (canclecontract.getText().equals("Pausieren")) {
			v1.getContracttype(this.contract);
			v1.pauseContract();
		}
		if (canclecontract.getText().equals("Kündigen")) {
			v1.getContracttype(this.contract);
			v1.cancelledContract();
		}
		if (canclecontract.getText().equals("Auswahl")) {
			v1.editContract();
		}
	}

	public void setContracttype(String Contracttype) {
		this.contract = Character.toUpperCase(Contracttype.charAt(0)) + Contracttype.substring(1);
		this.contracttype.setText(this.contract + " " + "-");

		if (Contracttype.equals("hardworker")) {
			contractnumber.setLayoutX(190);
		}

		if (Contracttype.equals("arnold")) {
			contractnumber.setLayoutX(145);
		}
	}

	public void setContractNumber(int cnumber) {
		this.random = cnumber;
		contractnumber.setText("" + this.random);
		setDate();
		setTrainingDate();
	}

	public void setDate() {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		Date realDate = c.getTime();
		contractlabels4.setText(dateformat.format(realDate));
		setTrainingDate();
	}

	public void setTrainingDate() {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DATE, 7);
		Date realDate = c.getTime();
		contractlabels6.setText(dateformat.format(realDate));
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
		confirmationinfo.setText("Wollen Sie den Vertrag wirklich kündigen?");
		canclecontract.setVisible(true);
		canclecontract.setText("Kündigen");
		cancle.setVisible(true);
	}

	public void edit() {
		cancle();
		confirmationinfo.setText("Wollen Sie den Vertrag ändern?");
		confirmationinfo.setLayoutX(270);
		canclecontract.setLayoutX(282);
		canclecontract.setText("Auswahl");
	}

	public void pause() {
		cancle();
		confirmationinfo.setText("Wollen Sie den Vertrag pausieren?");
		confirmationinfo.setLayoutX(250);
		canclecontract.setLayoutX(282);
		canclecontract.setText("Pausieren");
	}

	public void cancleOrder() {
		traininghistory.setDisable(false);
		canclecontractoption.setDisable(false);
		changecontract.setDisable(false);
		pausecontract.setDisable(false);
		attention.setVisible(false);
		confirmationinfo.setVisible(false);
		canclecontract.setVisible(false);
		cancle.setVisible(false);
		traininghistory.setEffect(null);
		canclecontractoption.setEffect(null);
		changecontract.setEffect(null);
		pausecontract.setEffect(null);
		contractlabels1.setEffect(null);
		contractlabels2.setEffect(null);
		contractlabels3.setEffect(null);
		contractlabels4.setEffect(null);
		contractlabels5.setEffect(null);
		contractlabels6.setEffect(null);
		contractnumber.setEffect(null);
		contracttype.setEffect(null);
		contractimage.setEffect(null);
	}
	
	public void showInfo() {
		if (infolabel.isVisible()) {
			infolabel.setVisible(false);
		} else {
			infolabel.setVisible(true);
		}
	}

	public void closeOperation() {
		view1controller v1 = new view1controller();
		v1.closeOperation();
	}

}