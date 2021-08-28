package br.ufrn.imd.controle;

import br.ufrn.imd.dao.AutorDAO;
import br.ufrn.imd.modelo.Autor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AutorInserirController {

  private Stage localStage;

  AutorDAO dbAutor;

  @FXML
  private TextField fieldNome;

  public void setStage(Stage stage) {
    this.localStage = stage;
  }

  @FXML
  void sair(ActionEvent event) {
    this.localStage.close();
  }

  @FXML
  void inserir(ActionEvent event) {

    dbAutor = AutorDAO.getInstance();
    int id = dbAutor.generateId();
    Autor item = new Autor();
    item.setId(id);

    item.setNome(fieldNome.getText());

    dbAutor.inserir(item);
    localStage.close();
  }

}
