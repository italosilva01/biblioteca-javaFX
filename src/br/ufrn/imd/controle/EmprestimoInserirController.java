package br.ufrn.imd.controle;

import br.ufrn.imd.dao.EmprestimoDAO;
import br.ufrn.imd.dao.LivroDAO;
import br.ufrn.imd.dao.UsuarioDAO;
import br.ufrn.imd.modelo.Livro;
import br.ufrn.imd.modelo.Emprestimo;
import br.ufrn.imd.modelo.Usuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class EmprestimoInserirController {

  private Stage localStage;

  EmprestimoDAO dbEmprestimo;
  UsuarioDAO dbUsuario;
  LivroDAO dbLivro;

  @FXML
  private ChoiceBox<Usuario> choiceUsuario;

  @FXML
  private ChoiceBox<Livro> choiceLivro;

  @FXML
  private DatePicker dateEmprestimo;

  @FXML
  private DatePicker dateDevolucao;

  @FXML
  private PasswordField fieldSenha;

  private ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
  private ObservableList<Livro> livros = FXCollections.observableArrayList();

  public void setStage(Stage stage) {
    this.localStage = stage;
  }

  @FXML
  void sair(ActionEvent event) {
    this.localStage.close();
  }

  @FXML
  void inserir(ActionEvent event) {

    dbEmprestimo = EmprestimoDAO.getInstance();
    int id = dbEmprestimo.generateId();
    Emprestimo item = new Emprestimo();
    item.setId(id);

    item.setUsuario(choiceUsuario.getSelectionModel().getSelectedItem());
    item.setLivro(choiceLivro.getSelectionModel().getSelectedItem());
    item.setDevolucao(dateDevolucao.getValue());
    item.setEmprestimo(dateEmprestimo.getValue());

    System.out.println("Senha: " + fieldSenha.getText() + " Usuario: "
        + choiceUsuario.getSelectionModel().getSelectedItem().getSenha());

    if (choiceUsuario.getSelectionModel().getSelectedItem() == null) {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Erro");
      alert.setHeaderText("Usuario invalido");
      alert.showAndWait();
      return;
    }

    if (!choiceUsuario.getSelectionModel().getSelectedItem().getSenha().equals(fieldSenha.getText())) {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Erro");
      alert.setHeaderText("Senha invalida");
      alert.showAndWait();
      return;
    }

    dbEmprestimo.inserir(item);
    localStage.close();
  }

  //

  @FXML
  public void initialize() {
    this.carregar();
  }

  //

  void carregar() {
    dbUsuario = UsuarioDAO.getInstance();
    dbLivro = LivroDAO.getInstance();

    usuarios.setAll(dbUsuario.listar());
    livros.setAll(dbLivro.listar());

    choiceUsuario.setItems(usuarios);
    choiceLivro.setItems(livros);
  }

}
