package br.ufrn.imd.controle;

import java.util.ArrayList;
import java.io.IOException;

import br.ufrn.imd.dao.EmprestimoDAO;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EmprestimoPesquisarController {

  private Stage localStage;

  EmprestimoDAO dbEmprestimo;

  @FXML
  private TableView<Emprestimo> tableEmprestimo;

  @FXML
  private TableColumn<Livro, String> colLivro;

  @FXML
  private TableColumn<Usuario, String> colUsuario;

  @FXML
  private TableColumn<Emprestimo, String> colEmprestimo;

  @FXML
  private TableColumn<Emprestimo, String> colDevolucao;

  @FXML
  private TextField fieldPesquisa;

  @FXML
  private Label labelResultado;

  //

  private ObservableList<Emprestimo> emprestimos = FXCollections.observableArrayList();

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
    tableEmprestimo.setRowFactory(tv -> {
      TableRow<Emprestimo> row = new TableRow<>();
      row.setOnMouseClicked(event -> {
        if (event.getClickCount() == 2 && (!row.isEmpty())) {
          Emprestimo rowData = row.getItem();
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
  private void detalhes(Emprestimo item) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(EmprestimoDetalhesController.class.getResource("/br/ufrn/imd/visao/EmprestimoDetalhes.fxml"));
    AnchorPane page = (AnchorPane) loader.load();
    Stage newStage = new Stage();
    newStage.setTitle("Detalhes Emprestimo");
    newStage.setResizable(false);
    Scene scene = new Scene(page);
    newStage.setScene(scene);
    EmprestimoDetalhesController controller = loader.getController();
    controller.setStage(newStage);
    controller.setItem(item);
    controller.carregar();
    newStage.showAndWait();

    emprestimos.setAll(dbEmprestimo.listar());
    fieldPesquisa.setText("");
    String stringResultado = "Resultado: " + dbEmprestimo.getSize();
    labelResultado.setText(stringResultado);
  }

  @FXML
  public void pesquisar() {
    ArrayList<Emprestimo> resultadoPesquisa = dbEmprestimo.pesquisar(fieldPesquisa.getText());
    emprestimos.setAll(resultadoPesquisa);

    String stringResultado = "Resultado: " + resultadoPesquisa.size();
    labelResultado.setText(stringResultado);
  }

  void listar() {
    dbEmprestimo = EmprestimoDAO.getInstance();
    colLivro.setCellValueFactory(new PropertyValueFactory<>("Livro"));
    colUsuario.setCellValueFactory(new PropertyValueFactory<>("Usuario"));
    colEmprestimo.setCellValueFactory(new PropertyValueFactory<>("Emprestimo"));
    colDevolucao.setCellValueFactory(new PropertyValueFactory<>("Devolucao"));
    tableEmprestimo.setItems(emprestimos);

    dbEmprestimo = EmprestimoDAO.getInstance();
    emprestimos.setAll(dbEmprestimo.listar());

    String stringResultado = "Resultado: " + dbEmprestimo.getSize();
    labelResultado.setText(stringResultado);
  }

}
