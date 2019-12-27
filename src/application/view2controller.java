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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class view2controller {

	private String id;
	private double xOffset = 0;
	private double yOffset = 0;

	@FXML
	private AnchorPane anchorpane;

	@FXML
	private Label formlabel;

	@FXML
	private Button redirect, applybutton;

	@FXML
	private TextField username, password, prename, name, birthdate;

	@FXML
	public void register() {
		if (formlabel.getText() == "Register") {
			formlabel.setText("Login");
			formlabel.setLayoutY(147);
			username.setLayoutY(258);
			password.setLayoutY(299);
			redirect.setLayoutY(333);
			redirect.setText("oder registrieren");
			prename.setVisible(false);
			name.setVisible(false);
			birthdate.setVisible(false);
			applybutton.setLayoutY(333);
			applybutton.setText("Einloggen ➠");
		} else {
			formlabel.setText("Register");
			formlabel.setLayoutY(121);
			prename.setLayoutY(228);
			prename.setVisible(true);
			name.setLayoutY(270);
			name.setVisible(true);
			username.setLayoutY(312);
			username.setVisible(true);
			birthdate.setLayoutY(354);
			birthdate.setVisible(true);
			password.setLayoutY(396);
			redirect.setLayoutY(430);
			redirect.setText("oder einloggen");
			applybutton.setLayoutY(430);
			applybutton.setText("Registrieren ➠");
		}
	}

	@FXML
	protected void loginregister(ActionEvent event) {

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

		v3.setContracttype(getButton());

	}

	public void closeOperation() {
		view1controller v1 = new view1controller();
		v1.closeOperation();
	}

	public void setButton(String id) {
		this.id = id;
	}

	public String getButton() {
		return this.id;
	}
}