package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class view2controller {
	
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

		Stage stage;
		Parent root = null;

		stage = (Stage) anchorpane.getScene().getWindow();

		try {
			root = FXMLLoader.load(getClass().getResource("/application/view3.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void closeOperation() {
		view1controller v1c = new view1controller();
		v1c.closeOperation();
	}
}