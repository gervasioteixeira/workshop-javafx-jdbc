package gui;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {

	// Itens de controle de tela para corresponder aos itens do menu
	@FXML
	private MenuItem menuItemSeller;
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAbout;

	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction");
	}

	@FXML
	public void onMenuItemDepartmentAction() {
		loadView("../gui/DepartmentList.fxml");
	}

	@FXML
	public void onMenuItemAboutAction() {
		loadView("../gui/About.fxml");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}
	
	//funcao para abrir outra tela
	//synchronized - garante que todo o processo do try NÃO será interrompido
	private synchronized void loadView(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			//método getRoot() pega o primeiro elemento da view >> ScrollPane
			//getContent() pega os elementos dentros do scrollPane >> VBox
			VBox mainVBox = (VBox)((ScrollPane)mainScene.getRoot()).getContent();
			
			//guardar referencia para o menu
			Node mainMenu = mainVBox.getChildren().get(0);//o primeiro filho do VBox é (hj) da janela principal >> mainMenu
			
			mainVBox.getChildren().clear();//limpa/zera todos os filhos do mainVBox
			
			//Adicionar o mainMenu e os filhos do newVBox
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());//a coleção é os filhos do newVBox
			
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erro carregamento página", e.getMessage(), AlertType.ERROR);
		}
		
	}

}
