package br.ufrn.imd.controle;

import br.ufrn.imd.dao.UsuarioDAO;
import br.ufrn.imd.modelo.Usuario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UsuarioInserirController {

  private Stage localStage;

  UsuarioDAO dbUsuario;

  @FXML
  private TextField fieldNome;

  @FXML
  private TextField fieldEmail;

  @FXML
  private TextField fieldTelefone;

  @FXML
  private TextField fieldSenha;

  public void setStage(Stage stage) {
    this.localStage = stage;
  }

  @FXML
  void sair(ActionEvent event) {
    this.localStage.close();
  }

  @FXML
  void inserir(ActionEvent event) {

    dbUsuario = UsuarioDAO.getInstance();
    int id = dbUsuario.generateId();
    Usuario item = new Usuario();
    item.setId(id);

    item.setNome(fieldNome.getText());
    item.setEmail(fieldEmail.getText());
    item.setTelefone(fieldTelefone.getText());
    item.setSenha(fieldSenha.getText());

    dbUsuario.inserir(item);
    localStage.close();
  }

}
