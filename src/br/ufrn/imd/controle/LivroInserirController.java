package br.ufrn.imd.controle;

import br.ufrn.imd.dao.AutorDAO;
import br.ufrn.imd.dao.CategoriaDAO;
import br.ufrn.imd.dao.LivroDAO;
import br.ufrn.imd.modelo.Autor;
import br.ufrn.imd.modelo.Categoria;
import br.ufrn.imd.modelo.Livro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LivroInserirController {

  private Stage localStage;

  LivroDAO dbLivro;
  CategoriaDAO dbCategoria;
  AutorDAO dbAutor;

  @FXML
  private TextField fieldTitulo;

  @FXML
  private ChoiceBox<Categoria> choiceCategoria;

  @FXML
  private ChoiceBox<Autor> choiceAutor;

  @FXML
  private DatePicker dateLancamento;

  private ObservableList<Categoria> categorias = FXCollections.observableArrayList();
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
  void inserir(ActionEvent event) {

    dbLivro = LivroDAO.getInstance();
    int id = dbLivro.generateId();
    Livro item = new Livro();
    item.setId(id);

    item.setTitulo(fieldTitulo.getText());
    item.setCategoria(choiceCategoria.getSelectionModel().getSelectedItem());
    item.setAutor(choiceAutor.getSelectionModel().getSelectedItem());
    item.setLancamento(dateLancamento.getValue());

    dbLivro.inserir(item);
    localStage.close();
  }

  @FXML
  public void initialize() {
    this.carregar();
  }

  //

  void carregar() {
    dbCategoria = CategoriaDAO.getInstance();
    dbAutor = AutorDAO.getInstance();

    categorias.setAll(dbCategoria.listar());
    autores.setAll(dbAutor.listar());

    choiceCategoria.setItems(categorias);
    choiceAutor.setItems(autores);
  }

}
