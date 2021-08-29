package br.ufrn.imd.controle;

import br.ufrn.imd.dao.AutorDAO;
import br.ufrn.imd.dao.LivroDAO;
import br.ufrn.imd.modelo.Autor;
import br.ufrn.imd.modelo.Livro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AutorDetalhesController {

  private Stage localStage;

  AutorDAO dbAutor;
  LivroDAO dbLivro;

  Autor autor;

  @FXML
  private ListView<Livro> listLivros;

  @FXML
  private TextField fieldNome;

  //

  private ObservableList<Livro> livros = FXCollections.observableArrayList();

  //

  public void setStage(Stage stage) {
    this.localStage = stage;
  }

  public void setItem(Autor autor) {
    this.autor = autor;
  }

  @FXML
  void sair(ActionEvent event) {
    this.localStage.close();
  }

  //

  @FXML
  public void salvar() {

    autor.setNome(fieldNome.getText());

    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Sucesso");
    alert.setHeaderText("Autor alterado");

    alert.showAndWait();
  }

  @FXML
  public void remover() {
    dbAutor.remover(autor);

    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Sucesso");
    alert.setHeaderText("Autor removido");
    alert.showAndWait();
    this.localStage.close();
  }

  void carregar() {
    dbAutor = AutorDAO.getInstance();

    fieldNome.setText(autor.getNome());

    dbLivro = LivroDAO.getInstance();
    livros.setAll(dbLivro.pesquisar(autor));
    listLivros.setItems(livros);
  }

}
