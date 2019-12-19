package application;

import javafx.fxml.FXML;
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
	private Button redirect;
	
	@FXML
	private TextField username, password, prename, name, birthdate;
	
	@FXML
	public void register() {
		if(formlabel.getText() == "Register") {
			formlabel.setText("Login");
			formlabel.setLayoutY(147);
			username.setLayoutY(258);
			password.setLayoutY(299);
			redirect.setText("oder registrieren");
		}else {		
			formlabel.setText("Register");
			formlabel.setLayoutY(121);
			anchorpane.getChildren().add(prename = new TextField());
			prename.setLayoutY(228);
			name = new TextField();
			name.setLayoutY(270);
			username.setLayoutY(312);
			birthdate = new TextField();
			password.setLayoutY(354);
			redirect.setText("oder einloggen");
		}
	}
	
	public void closeOperation() {
		view1controller v1c = new view1controller();
		v1c.closeOperation();
	}
}