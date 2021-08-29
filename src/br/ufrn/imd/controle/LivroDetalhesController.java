package br.ufrn.imd.controle;

import br.ufrn.imd.dao.AutorDAO;
import br.ufrn.imd.dao.CategoriaDAO;
import br.ufrn.imd.dao.EmprestimoDAO;
import br.ufrn.imd.dao.LivroDAO;
import br.ufrn.imd.modelo.Autor;
import br.ufrn.imd.modelo.Categoria;
import br.ufrn.imd.modelo.Emprestimo;
import br.ufrn.imd.modelo.Livro;
import br.ufrn.imd.modelo.Usuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class LivroDetalhesController {

  private Stage localStage;

  LivroDAO dbLivro;
  EmprestimoDAO dbEmprestimo;
  CategoriaDAO dbCategoria;
  AutorDAO dbAutor;

  Livro livro;

  @FXML
  private TableView<Emprestimo> tableEmprestimos;

  @FXML
  private TableColumn<Usuario, String> colUsuario;

  @FXML
  private TableColumn<Emprestimo, String> colEmprestimo;

  @FXML
  private TableColumn<Emprestimo, String> colDevolucao;

  @FXML
  private TextField fieldTitulo;

  @FXML
  private ChoiceBox<Categoria> choiceCategoria;

  @FXML
  private ChoiceBox<Autor> choiceAutor;

  @FXML
  private DatePicker dateLancamento;

  //

  private ObservableList<Emprestimo> emprestimos = FXCollections.observableArrayList();

  private ObservableList<Categoria> categorias = FXCollections.observableArrayList();
  private ObservableList<Autor> autores = FXCollections.observableArrayList();

  //

  public void setStage(Stage stage) {
    this.localStage = stage;
  }

  public void setItem(Livro livro) {
    this.livro = livro;
  }

  @FXML
  void sair(ActionEvent event) {
    this.localStage.close();
  }

  @FXML
  public void initialize() {
    this.listar();
  }

  //

  @FXML
  public void salvar() {

    livro.setTitulo(fieldTitulo.getText());
    livro.setCategoria(choiceCategoria.getSelectionModel().getSelectedItem());
    livro.setAutor(choiceAutor.getSelectionModel().getSelectedItem());
    livro.setLancamento(dateLancamento.getValue());

    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Sucesso");
    alert.setHeaderText("Livro alterado");

    alert.showAndWait();
  }

  @FXML
  public void remover() {
    dbLivro.remover(livro);

    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Sucesso");
    alert.setHeaderText("Livro removido");
    alert.showAndWait();
    this.localStage.close();
  }

  void carregar() {
    dbCategoria = CategoriaDAO.getInstance();
    dbAutor = AutorDAO.getInstance();

    categorias.setAll(dbCategoria.listar());
    autores.setAll(dbAutor.listar());

    choiceCategoria.setItems(categorias);
    choiceAutor.setItems(autores);

    //

    dbLivro = LivroDAO.getInstance();

    fieldTitulo.setText(livro.getTitulo());
    choiceCategoria.setValue(livro.getCategoria());
    choiceAutor.setValue(livro.getAutor());
    dateLancamento.setValue(livro.getLancamento());

    //

    dbEmprestimo = EmprestimoDAO.getInstance();
    emprestimos.setAll(dbEmprestimo.pesquisar(livro));
  }

  void listar() {
    colUsuario.setCellValueFactory(new PropertyValueFactory<>("Usuario"));
    colEmprestimo.setCellValueFactory(new PropertyValueFactory<>("Emprestimo"));
    colDevolucao.setCellValueFactory(new PropertyValueFactory<>("Devolucao"));

    tableEmprestimos.setItems(emprestimos);
  }

}
