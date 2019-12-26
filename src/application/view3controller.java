package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class view3controller {
	
	@FXML
	private Label contracttype, contractnumber;
	
	public void getId(String id) {
		contracttype.setText(id);
	}
	
	public void setValue() {
		contractnumber.setText(("" + Math.random() * ((1000 - 1) + 1)) + 1);
		System.out.println(contractnumber.getText());
		System.out.println("text");
	}

}
