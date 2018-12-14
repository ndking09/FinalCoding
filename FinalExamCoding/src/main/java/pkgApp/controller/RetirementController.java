package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {


	private RetirementApp mainApp = null;


	@FXML
	private Label LbLSaveEachMonth;
	@FXML
	private TextField txtAnnualReturnWorking;
	@FXML
	private Label LbLWhatYouNeedSaved;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtAnnualReturnRetired;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;
	@FXML
	private TextField txtYearsToWork;


	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}

	@FXML
	public void btnClear(ActionEvent event) {
		LbLSaveEachMonth.setText("");
		txtYearsToWork.setText("");;
		txtAnnualReturnWorking.setText("");
		LbLWhatYouNeedSaved.setText("");
		txtYearsRetired.setText("");
		txtAnnualReturnRetired.setText("");
		txtRequiredIncome.setText("");
		txtMonthlySSI.setText("");
		System.out.println("Clear pressed");

		//	TODO: Clear all the text inputs
	}

	@FXML
	public void btnCalculate(ActionEvent event) {
		try {
		int iYearsToWork = Integer.parseInt(txtYearsToWork.getText());
		double dAnnualReturnWorking = Double.parseDouble(txtAnnualReturnWorking.getText());
		int iYearsRetired = Integer.parseInt(txtYearsRetired.getText());
		double dAnnualReturnRetired = Double.parseDouble(txtAnnualReturnRetired.getText());
		double dMonthlySSI = Double.parseDouble(txtMonthlySSI.getText());
		double dRequiredIncome = Double.parseDouble(txtRequiredIncome.getText());
		
		Retirement Retired = new Retirement(iYearsToWork,dAnnualReturnWorking,iYearsRetired,dAnnualReturnRetired,dRequiredIncome,dMonthlySSI);
	

		LbLSaveEachMonth.setText(String.format("%d",Retired.AmountToSave()));
		LbLWhatYouNeedSaved.setText(String.format("%d", Retired.TotalAmountSaved()*-1));
	}catch(NumberFormatException e) {
		LbLSaveEachMonth.setText("Not a #");
		LbLWhatYouNeedSaved.setText("Not a #");
	}catch(Exception e) {
		LbLSaveEachMonth.setText("Error");
		LbLWhatYouNeedSaved.setText("Error");  
	}
		//	TODO: Call AmountToSave and TotalAmountSaved and populate 

	}

}
