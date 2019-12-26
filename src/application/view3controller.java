package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class view3controller {
	
	@FXML
	private Label Contracttype;
	
	public void setContracttype(String Contracttype) {
		this.Contracttype.setText(Contracttype);
	}
	
	public void closeOperation() {
		System.exit(0);
	}

}
