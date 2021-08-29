package br.ufrn.imd.controle;

import java.util.ArrayList;
import java.io.IOException;

import br.ufrn.imd.dao.AutorDAO;
import br.ufrn.imd.modelo.Autor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AutorPesquisarController {

  private Stage localStage;

  AutorDAO dbAutor;

  @FXML
  private ListView<Autor> listAutor;

  @FXML
  private TextField fieldPesquisa;

  @FXML
  private Label labelResultado;

  //

  private ObservableList<Autor> autores = FXCollections.observableArrayList();

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

  //

  private void setupRowEvent() {
    listAutor.setOnMouseClicked(event -> {
      Autor selected = listAutor.getSelectionModel().getSelectedItem();
      if (event.getClickCount() == 2 && selected != null) {
        try {
          this.detalhes(selected);
        } catch (Exception e) {
          System.out.println(e.getMessage());
          e.printStackTrace();
        }
      }
    });
  }

  @FXML
  private void detalhes(Autor item) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(AutorDetalhesController.class.getResource("/br/ufrn/imd/visao/AutorDetalhes.fxml"));
    AnchorPane page = (AnchorPane) loader.load();
    Stage newStage = new Stage();
    newStage.setTitle("Detalhes Autor");
    newStage.setResizable(false);
    Scene scene = new Scene(page);
    newStage.setScene(scene);
    AutorDetalhesController controller = loader.getController();
    controller.setStage(newStage);
    controller.setItem(item);
    controller.carregar();
    newStage.showAndWait();

    autores.setAll(dbAutor.listar());
    fieldPesquisa.setText("");
    String stringResultado = "Resultado: " + dbAutor.getSize();
    labelResultado.setText(stringResultado);
  }

  @FXML
  public void pesquisar() {
    ArrayList<Autor> resultadoPesquisa = dbAutor.pesquisar(fieldPesquisa.getText());
    autores.setAll(resultadoPesquisa);
    String stringResultado = "Resultado: " + resultadoPesquisa.size();
    labelResultado.setText(stringResultado);
  }

  void listar() {
    dbAutor = AutorDAO.getInstance();
    autores.setAll(dbAutor.listar());

    listAutor.setItems(autores);

    String stringResultado = "Resultado: " + dbAutor.getSize();
    labelResultado.setText(stringResultado);
  }

}
