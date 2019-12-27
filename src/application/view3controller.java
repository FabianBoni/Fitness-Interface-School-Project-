package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class view3controller {
	
	@FXML
	private Label contracttype, contractnumber;
	
	public void setContracttype(String Contracttype) {
		Contracttype = Character.toUpperCase(Contracttype.charAt(0)) + Contracttype.substring(1);
		this.contracttype.setText(Contracttype + " " + "-");
	}

	public void closeOperation() {
		System.exit(0);
	}

}
