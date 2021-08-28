package br.ufrn.imd.controle;

import java.io.IOException;

import br.ufrn.imd.dao.EmprestimoDAO;
import br.ufrn.imd.dao.LivroDAO;
import br.ufrn.imd.dao.UsuarioDAO;
import br.ufrn.imd.modelo.Emprestimo;
import br.ufrn.imd.modelo.Livro;
import br.ufrn.imd.modelo.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PrincipalController {

  EmprestimoDAO dbEmprestimo;

  @FXML
  private TableView<Emprestimo> tableEmprestimo;

  @FXML
  private TableColumn<Livro, String> colLivro;

  @FXML
  private TableColumn<Usuario, String> colUsuario;

  @FXML
  private TableColumn<Emprestimo, String> colDevolucao;

  //

  private ObservableList<Emprestimo> emprestimos = FXCollections.observableArrayList();

  //

  @FXML
  private MenuItem menuSair;

  @FXML
  private MenuItem menuUsuarioInserir;

  @FXML
  private MenuItem menuUsuarioPesquisar;

  //

  @FXML
  private Label labelUsuarios;

  @FXML
  private Label labelLivros;

  @FXML
  private Label labelEmprestimos;

  //

  @FXML
  public void initialize() {
    this.loadData();
  }

  @FXML
  void usuarioInserir(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(UsuarioInserirController.class.getResource("/br/ufrn/imd/visao/UsuarioInserir.fxml"));
    AnchorPane page = (AnchorPane) loader.load();
    Stage newStage = new Stage();
    newStage.setTitle("Inserir Usuário");
    newStage.setResizable(false);
    Scene scene = new Scene(page);
    newStage.setScene(scene);
    UsuarioInserirController controller = loader.getController();
    controller.setStage(newStage);
    newStage.showAndWait();
    loadData();
  }

  @FXML
  void usuarioPesquisar(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(UsuarioPesquisarController.class.getResource("/br/ufrn/imd/visao/UsuarioPesquisar.fxml"));
    AnchorPane page = (AnchorPane) loader.load();
    Stage newStage = new Stage();
    newStage.setTitle("Pesquisar Usuário");
    newStage.setResizable(false);
    Scene scene = new Scene(page);
    newStage.setScene(scene);
    UsuarioPesquisarController controller = loader.getController();
    controller.setStage(newStage);
    newStage.showAndWait();
    loadData();
  }

  //

  @FXML
  void autorInserir(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(AutorInserirController.class.getResource("/br/ufrn/imd/visao/AutorInserir.fxml"));
    AnchorPane page = (AnchorPane) loader.load();
    Stage newStage = new Stage();
    newStage.setTitle("Inserir Usuário");
    newStage.setResizable(false);
    Scene scene = new Scene(page);
    newStage.setScene(scene);
    AutorInserirController controller = loader.getController();
    controller.setStage(newStage);
    newStage.showAndWait();
    loadData();
  }

  @FXML
  void autorPesquisar(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(AutorPesquisarController.class.getResource("/br/ufrn/imd/visao/AutorPesquisar.fxml"));
    AnchorPane page = (AnchorPane) loader.load();
    Stage newStage = new Stage();
    newStage.setTitle("Pesquisar Usuário");
    newStage.setResizable(false);
    Scene scene = new Scene(page);
    newStage.setScene(scene);
    AutorPesquisarController controller = loader.getController();
    controller.setStage(newStage);
    newStage.showAndWait();
    loadData();
  }

  //

  @FXML
  void livroInserir(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(LivroInserirController.class.getResource("/br/ufrn/imd/visao/LivroInserir.fxml"));
    AnchorPane page = (AnchorPane) loader.load();
    Stage newStage = new Stage();
    newStage.setTitle("Inserir Usuário");
    newStage.setResizable(false);
    Scene scene = new Scene(page);
    newStage.setScene(scene);
    LivroInserirController controller = loader.getController();
    controller.setStage(newStage);
    newStage.showAndWait();
    loadData();
  }

  @FXML
  void livroPesquisar(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(LivroPesquisarController.class.getResource("/br/ufrn/imd/visao/LivroPesquisar.fxml"));
    AnchorPane page = (AnchorPane) loader.load();
    Stage newStage = new Stage();
    newStage.setTitle("Pesquisar Usuário");
    newStage.setResizable(false);
    Scene scene = new Scene(page);
    newStage.setScene(scene);
    LivroPesquisarController controller = loader.getController();
    controller.setStage(newStage);
    newStage.showAndWait();
    loadData();
  }

  //

  @FXML
  void emprestimoInserir(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(EmprestimoInserirController.class.getResource("/br/ufrn/imd/visao/EmprestimoInserir.fxml"));
    AnchorPane page = (AnchorPane) loader.load();
    Stage newStage = new Stage();
    newStage.setTitle("Inserir Empréstimo");
    newStage.setResizable(false);
    Scene scene = new Scene(page);
    newStage.setScene(scene);
    EmprestimoInserirController controller = loader.getController();
    controller.setStage(newStage);
    newStage.showAndWait();
    loadData();
  }

  @FXML
  void emprestimoPesquisar(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(EmprestimoPesquisarController.class.getResource("/br/ufrn/imd/visao/EmprestimoPesquisar.fxml"));
    AnchorPane page = (AnchorPane) loader.load();
    Stage newStage = new Stage();
    newStage.setTitle("Pesquisar Empréstimo");
    newStage.setResizable(false);
    Scene scene = new Scene(page);
    newStage.setScene(scene);
    EmprestimoPesquisarController controller = loader.getController();
    controller.setStage(newStage);
    newStage.showAndWait();
    loadData();
  }

  //

  @FXML
  void sobre(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(SobreController.class.getResource("/br/ufrn/imd/visao/Sobre.fxml"));
    AnchorPane page = (AnchorPane) loader.load();
    Stage newStage = new Stage();
    newStage.setTitle("Sobre");
    newStage.setResizable(false);
    Scene scene = new Scene(page);
    newStage.setScene(scene);
    SobreController controller = loader.getController();
    controller.setStage(newStage);
    newStage.showAndWait();
    loadData();
  }

  @FXML
  void sair(ActionEvent event) {
    System.exit(0);
  }

  void loadData() {
    UsuarioDAO dbUsuario = UsuarioDAO.getInstance();
    labelUsuarios.setText("" + dbUsuario.getSize());
    LivroDAO dbLivro = LivroDAO.getInstance();
    labelLivros.setText("" + dbLivro.getSize());
    EmprestimoDAO dbEmprestimo = EmprestimoDAO.getInstance();
    labelEmprestimos.setText("" + dbEmprestimo.getSize());

    //

    colLivro.setCellValueFactory(new PropertyValueFactory<>("Livro"));
    colUsuario.setCellValueFactory(new PropertyValueFactory<>("Usuario"));
    colDevolucao.setCellValueFactory(new PropertyValueFactory<>("Devolucao"));

    tableEmprestimo.setItems(emprestimos);

    dbEmprestimo = EmprestimoDAO.getInstance();
    emprestimos.setAll(dbEmprestimo.listar());
  }

}
