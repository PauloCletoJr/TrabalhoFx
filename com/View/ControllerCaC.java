package com.View;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.DAO.CaCDAO;

import com.Entity.CaC;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerCaC extends Application implements Initializable {
	CaCDAO dao = new CaCDAO();
	
	List<CaC> listaCaC = new ArrayList<CaC>();

	@FXML
	private TextField textFieldNome;

	@FXML
	private TextField textFieldValor;

	@FXML
	private TextField textFieldArma;

	@FXML
	private TextField textFieldCR;

	@FXML
	private TextArea textAreaCac;

	@FXML
	private TextField textField_ID;
	@FXML
	private Label labelTextId;

	@FXML
	private Label labelTextIdInserted;
	@FXML
	private Label qtd;

	@FXML
	private Label labelQtd;
	

	@FXML
	void ExcluirCac(ActionEvent event) {
    	String busca= textField_ID.getText();
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Deletar CAC");
    	alert.setHeaderText("Deletar");
    	alert.setContentText("Tem certeza que deseja deletar?");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
            dao.Deletar(busca, listaCaC);
        	limpaCampos();
        	listarCac();
    	}
    	
	}

	@FXML
	void PesquisarCacID(ActionEvent event) {
		String buscar= textField_ID.getText();
    	CaC cac = null;
    	if (!buscar.equals("")) {
			try {
			cac = new CaCDAO().findByModelo(buscar, listaCaC);
			} catch (Exception e) {
			}
			if (cac != null) { 
				labelTextId.setVisible(true);
				labelTextIdInserted.setVisible(true);
				labelTextIdInserted.setText(cac.getNome());
				textFieldArma.setText(cac.getArma());
				textFieldNome.setText(cac.getNome());
				textFieldCR.setText(cac.getCR() + "");
				textFieldValor.setText(cac.getValor() + "");
			}
		}

	}

	@FXML
	void alterarCac(ActionEvent event) {
		CaC cac = pegaCac();
    	String busca = textField_ID.getText();
    	textFieldArma.setText(cac.getArma());
		textFieldNome.setText(cac.getNome());
		textFieldCR.setText(cac.getCR() +"") ;
		textFieldValor.setText(cac.getValor() +"");
    	dao.Alterar(cac,busca, listaCaC );
    	listarCac();
	}

	private void limpaCampos() {
		textFieldArma.clear();
		textFieldNome.clear();
		textFieldCR.clear();
		textFieldValor.clear();
		textFieldNome.requestFocus();
		labelTextId.setVisible(false);
		labelTextIdInserted.setVisible(false);
		labelTextIdInserted.setText("");

	}

	private CaC pegaCac() {
		return new CaC(textFieldNome.getText(), textFieldArma.getText(), Integer.valueOf(textFieldCR.getText()),
				Float.valueOf(textFieldValor.getText()));
	}

	public void execute() {
		launch();
	}


	@FXML
	void inserirCac(ActionEvent event) {
    	CaC cac = pegaCac();
    	listaCaC.add(cac);
		limpaCampos();
		listarCac();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		listarCac();
	}

	private void listarCac() {

		textAreaCac.clear();
		listaCaC.forEach(cac -> {
			textAreaCac.appendText(cac.toString() + "\n");
		});

	}
	   @FXML
	    void Sair(ActionEvent event) {
		  	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Sair da Aplicação");
	    	alert.setContentText("Saindo da aplicação !!!");
	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == ButtonType.OK){           
	    		System.exit(0);
	    	}
	    }

	@Override
	public void start(Stage stage) {
		try {
			AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Cac.fxml"));
			Scene sc = new Scene(pane);
			stage.setScene(sc);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

