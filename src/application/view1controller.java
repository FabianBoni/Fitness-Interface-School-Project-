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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class view1controller {

	private double xOffset = 0;
	private double yOffset = 0;
	private String contracttype;

	@FXML
	private Button applybutton, noob, hardworker, arnold;

	@FXML
	private AnchorPane anchorpane;

	@FXML
	Rectangle confirmationcontainer1, confirmationcontainer2, confirmationcontainer3;

	@FXML
	Label containerlabeltitle1, containerlabelmessage1, containerlabeltitle2, containerlabelmessage2,
			containerlabeltitle3, containerlabelmessage3;

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

	public void getContracttype(String contracttype) {
		this.contracttype = contracttype;
	}

	public void cancelledContract() {

		if (this.contracttype.equals("Noob")) {
			confirmationcontainer1.setVisible(true);
			containerlabelmessage1.setVisible(true);
			containerlabeltitle1.setVisible(true);

			new java.util.Timer().schedule(new java.util.TimerTask() {
				@Override
				public void run() {
					confirmationcontainer1.setVisible(false);
					containerlabelmessage1.setVisible(false);
					containerlabeltitle1.setVisible(false);
				}
			}, 5000);
		}
		if (this.contracttype.equals("Hardworker")) {
			confirmationcontainer2.setVisible(true);
			containerlabelmessage2.setVisible(true);
			containerlabeltitle2.setVisible(true);

			new java.util.Timer().schedule(new java.util.TimerTask() {
				@Override
				public void run() {
					confirmationcontainer2.setVisible(false);
					containerlabelmessage2.setVisible(false);
					containerlabeltitle2.setVisible(false);
				}
			}, 5000);
		}

		if (this.contracttype.equals("Arnold")) {
			confirmationcontainer3.setVisible(true);
			containerlabelmessage3.setVisible(true);
			containerlabeltitle3.setVisible(true);

			new java.util.Timer().schedule(new java.util.TimerTask() {
				@Override
				public void run() {
					confirmationcontainer3.setVisible(false);
					containerlabelmessage3.setVisible(false);
					containerlabeltitle3.setVisible(false);
				}
			}, 5000);
		}
	}
	
	public void pauseContract() {
		if (this.contracttype.equals("Noob")) {
			confirmationcontainer1.setVisible(true);
			containerlabelmessage1.setVisible(true);
			containerlabeltitle1.setVisible(true);
			containerlabelmessage1.setText("Ihr Vertrag wurde pausiert");

			new java.util.Timer().schedule(new java.util.TimerTask() {
				@Override
				public void run() {
					confirmationcontainer1.setVisible(false);
					containerlabelmessage1.setVisible(false);
					containerlabeltitle1.setVisible(false);
				}
			}, 5000);
		}
		if (this.contracttype.equals("Hardworker")) {
			confirmationcontainer2.setVisible(true);
			containerlabelmessage2.setVisible(true);
			containerlabeltitle2.setVisible(true);
			containerlabelmessage2.setText("Ihr Vertrag wurde pausiert");

			new java.util.Timer().schedule(new java.util.TimerTask() {
				@Override
				public void run() {
					confirmationcontainer2.setVisible(false);
					containerlabelmessage2.setVisible(false);
					containerlabeltitle2.setVisible(false);
				}
			}, 5000);
		}
		if (this.contracttype.equals("Arnold")) {
			confirmationcontainer3.setVisible(true);
			containerlabelmessage3.setVisible(true);
			containerlabeltitle3.setVisible(true);
			containerlabelmessage3.setText("Ihr Vertrag wurde pausiert");

			new java.util.Timer().schedule(new java.util.TimerTask() {
				@Override
				public void run() {
					confirmationcontainer3.setVisible(false);
					containerlabelmessage3.setVisible(false);
					containerlabeltitle3.setVisible(false);
				}
			}, 5000);
		}
	}
	
	public void editContract() {
		
	}

	public void closeOperation() {
		System.exit(0);
	}

}