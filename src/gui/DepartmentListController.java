package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable {

	// criar referencias para os componentes da tela de departmentList
	@FXML
	private Button btNew;
	@FXML
	private TableView<Department> tableViewDepartment;
	@FXML
	private TableColumn<Department, Integer> tableCollumId;// primero parâmetro tipo da entidade; segundo tipo da coluna
	@FXML
	private TableColumn<Department, String> tableCollumName;

	// Tratamento de eventos
	@FXML
	public void onBtNewAction() {
		System.out.println("onBtNewAction");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	// iniciar o comportamento das colunas
	private void initializeNodes() {
		tableCollumId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableCollumName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		//Fazer tableView preencher toda a tela
		//Pega a referência para a janela da cena getWindow() que é um superclasse do Stage. Por isso o downcast
		Stage stage = (Stage)Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
		

	}

}
