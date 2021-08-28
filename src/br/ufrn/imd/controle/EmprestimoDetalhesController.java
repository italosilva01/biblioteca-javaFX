package br.ufrn.imd.controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import br.ufrn.imd.dao.EmprestimoDAO;
import br.ufrn.imd.modelo.Emprestimo;

public class EmprestimoDetalhesController {

  private Stage localStage;

  EmprestimoDAO dbEmprestimo;

  Emprestimo emprestimo;

  @FXML
  private Label labelUsuario;

  @FXML
  private Label labelLivro;

  @FXML
  private DatePicker dateEmprestimo;

  @FXML
  private DatePicker dateDevolucao;

  //

  public void setStage(Stage stage) {
    this.localStage = stage;
  }

  public void setItem(Emprestimo emprestimo) {
    this.emprestimo = emprestimo;
  }

  @FXML
  void sair(ActionEvent event) {
    this.localStage.close();
  }

  @FXML
  public void initialize() {
  }

  //

  @FXML
  public void salvar() {
    emprestimo.setDevolucao(dateDevolucao.getValue());

    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Sucesso");
    alert.setHeaderText("Emprestimo alterado");

    alert.showAndWait();
  }

  @FXML
  public void remover() {
    dbEmprestimo.remover(emprestimo);

    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Sucesso");
    alert.setHeaderText("Emprestimo removido");
    alert.showAndWait();
    this.localStage.close();
  }

  void carregar() {
    dbEmprestimo = EmprestimoDAO.getInstance();

    labelUsuario.setText(emprestimo.getUsuario().getNome());
    labelLivro.setText(emprestimo.getLivro().getTitulo() + " - " + emprestimo.getLivro().getAutor().getNome());
    dateEmprestimo.setValue(emprestimo.getEmprestimo());

    if (emprestimo.getDevolucao() != null) {
      dateDevolucao.setValue(emprestimo.getDevolucao());
      dateDevolucao.setDisable(true);
    }
  }

}
