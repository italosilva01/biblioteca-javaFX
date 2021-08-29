package br.ufrn.imd.controle;

import java.util.ArrayList;
import java.io.IOException;

import br.ufrn.imd.dao.LivroDAO;
import br.ufrn.imd.modelo.Autor;
import br.ufrn.imd.modelo.Categoria;
import br.ufrn.imd.modelo.Livro;

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

public class LivroPesquisarController {

  private Stage localStage;

  LivroDAO dbLivro;

  @FXML
  private TableView<Livro> tableLivro;

  @FXML
  private TableColumn<Livro, String> colTitulo;

  @FXML
  private TableColumn<Autor, String> colAutor;

  @FXML
  private TableColumn<Categoria, String> colCategoria;

  @FXML
  private TextField fieldPesquisa;

  @FXML
  private Label labelResultado;

  //

  private ObservableList<Livro> livros = FXCollections.observableArrayList();

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
    tableLivro.setRowFactory(tv -> {
      TableRow<Livro> row = new TableRow<>();
      row.setOnMouseClicked(event -> {
        if (event.getClickCount() == 2 && (!row.isEmpty())) {
          Livro rowData = row.getItem();
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
  private void detalhes(Livro item) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(LivroDetalhesController.class.getResource("/br/ufrn/imd/visao/LivroDetalhes.fxml"));
    AnchorPane page = (AnchorPane) loader.load();
    Stage newStage = new Stage();
    newStage.setTitle("Detalhes Livro");
    newStage.setResizable(false);
    Scene scene = new Scene(page);
    newStage.setScene(scene);
    LivroDetalhesController controller = loader.getController();
    controller.setStage(newStage);
    controller.setItem(item);
    controller.carregar();
    newStage.showAndWait();

    livros.setAll(dbLivro.listar());
    fieldPesquisa.setText("");
    String stringResultado = "Resultado: " + dbLivro.getSize();
    labelResultado.setText(stringResultado);
  }

  @FXML
  public void pesquisar() {
    ArrayList<Livro> resultadoPesquisa = dbLivro.pesquisar(fieldPesquisa.getText());
    livros.setAll(resultadoPesquisa);
    String stringResultado = "Resultado: " + resultadoPesquisa.size();
    labelResultado.setText(stringResultado);
  }

  void listar() {
    colTitulo.setCellValueFactory(new PropertyValueFactory<>("Titulo"));
    colAutor.setCellValueFactory(new PropertyValueFactory<>("Autor"));
    colCategoria.setCellValueFactory(new PropertyValueFactory<>("Categoria"));

    tableLivro.setItems(livros);

    dbLivro = LivroDAO.getInstance();
    livros.setAll(dbLivro.listar());

    String stringResultado = "Resultado: " + dbLivro.getSize();
    labelResultado.setText(stringResultado);
  }

}
