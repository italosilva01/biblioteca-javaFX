package br.ufrn.imd.controle;

import br.ufrn.imd.dao.EmprestimoDAO;
import br.ufrn.imd.dao.UsuarioDAO;
import br.ufrn.imd.modelo.Emprestimo;
import br.ufrn.imd.modelo.Livro;
import br.ufrn.imd.modelo.Usuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class UsuarioDetalhesController {

  private Stage localStage;

  UsuarioDAO dbUsuario;
  EmprestimoDAO dbEmprestimo;

  Usuario usuario;

  @FXML
  private TableView<Emprestimo> tableEmprestimo;

  @FXML
  private TableColumn<Livro, String> colLivro;

  @FXML
  private TableColumn<Emprestimo, String> colEmprestimo;

  @FXML
  private TableColumn<Emprestimo, String> colDevolucao;

  @FXML
  private TextField fieldNome;

  @FXML
  private TextField fieldEmail;

  @FXML
  private TextField fieldTelefone;

  @FXML
  private TextField fieldSenha;

  //

  private ObservableList<Emprestimo> emprestimos = FXCollections.observableArrayList();

  //

  public void setStage(Stage stage) {
    this.localStage = stage;
  }

  public void setItem(Usuario usuario) {
    this.usuario = usuario;
  }

  @FXML
  void sair(ActionEvent event) {
    this.localStage.close();
  }

  //

  @FXML
  public void salvar() {

    usuario.setNome(fieldNome.getText());
    usuario.setTelefone(fieldTelefone.getText());
    usuario.setEmail(fieldEmail.getText());

    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Sucesso");
    alert.setHeaderText("Usuario alterado");

    alert.showAndWait();
  }

  @FXML
  public void salvarSenha() {
    usuario.setSenha(fieldSenha.getText());

    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Sucesso");
    alert.setHeaderText("Senha alterada");
    alert.showAndWait();
  }

  @FXML
  public void remover() {
    dbUsuario.remover(usuario);

    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Sucesso");
    alert.setHeaderText("Usuario removido");
    alert.showAndWait();
    this.localStage.close();
  }

  void carregar() {
    dbUsuario = UsuarioDAO.getInstance();

    fieldNome.setText(usuario.getNome());
    fieldTelefone.setText(usuario.getTelefone());
    fieldEmail.setText(usuario.getEmail());

    //

    colLivro.setCellValueFactory(new PropertyValueFactory<>("Livro"));
    colEmprestimo.setCellValueFactory(new PropertyValueFactory<>("Emprestimo"));
    colDevolucao.setCellValueFactory(new PropertyValueFactory<>("Devolucao"));

    tableEmprestimo.setItems(emprestimos);

    dbEmprestimo = EmprestimoDAO.getInstance();
    emprestimos.addAll(dbEmprestimo.pesquisar(usuario));
  }

}
