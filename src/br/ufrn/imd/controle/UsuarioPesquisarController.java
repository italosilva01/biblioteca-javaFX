package br.ufrn.imd.controle;

import java.util.ArrayList;
import java.io.IOException;

import br.ufrn.imd.dao.UsuarioDAO;
import br.ufrn.imd.modelo.Usuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UsuarioPesquisarController {

  private Stage localStage;

  UsuarioDAO dbUsuario;

  @FXML
  private TableView<Usuario> tableUsuario;

  @FXML
  private TableColumn<Usuario, String> colNome;

  @FXML
  private TableColumn<Usuario, String> colEmail;

  @FXML
  private TableColumn<Usuario, String> colTelefone;

  @FXML
  private TextField fieldPesquisa;

  @FXML
  private Label labelResultado;

  //

  private ObservableList<Usuario> usuarios = FXCollections.observableArrayList();

  //

  public void setStage(Stage stage) {
    this.localStage = stage;
  }

  @FXML
  void sair(ActionEvent event) {
    this.localStage.close();
  }

  @FXML
  public void initialize() {
    this.setupRowEvent();
    this.listar();
  }

  // //

  private void setupRowEvent() {
    tableUsuario.setRowFactory(tv -> {
      TableRow<Usuario> row = new TableRow<>();
      row.setOnMouseClicked(event -> {
        if (event.getClickCount() == 2 && (!row.isEmpty())) {
          Usuario rowData = row.getItem();
          try {
            this.detalhes(rowData);
          } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
          }
        }
      });
      return row;
    });
  }

  @FXML
  private void detalhes(Usuario item) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(UsuarioDetalhesController.class.getResource("/br/ufrn/imd/visao/UsuarioDetalhes.fxml"));
    AnchorPane page = (AnchorPane) loader.load();
    Stage newStage = new Stage();
    newStage.setTitle("Detalhes Usuário");
    newStage.setResizable(false);
    Scene scene = new Scene(page);
    newStage.setScene(scene);
    UsuarioDetalhesController controller = loader.getController();
    controller.setStage(newStage);
    controller.setItem(item);
    controller.carregar();
    newStage.showAndWait();

    usuarios.setAll(dbUsuario.listar());
    fieldPesquisa.setText("");
    String stringResultado = "Resultado: " + dbUsuario.getSize();
    labelResultado.setText(stringResultado);
  }

  @FXML
  public void pesquisar() {
    ArrayList<Usuario> resultadoPesquisa = dbUsuario.pesquisar(fieldPesquisa.getText());
    usuarios.setAll(resultadoPesquisa);
    String stringResultado = "Resultado: " + resultadoPesquisa.size();
    labelResultado.setText(stringResultado);
  }

  void listar() {
    dbUsuario = UsuarioDAO.getInstance();
    colNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
    colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
    colTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
    tableUsuario.setItems(usuarios);

    dbUsuario = UsuarioDAO.getInstance();
    usuarios.setAll(dbUsuario.listar());

    String stringResultado = "Resultado: " + dbUsuario.getSize();
    labelResultado.setText(stringResultado);
  }

}
