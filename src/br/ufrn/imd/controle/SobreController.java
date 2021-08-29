package br.ufrn.imd.controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class SobreController {

  private Stage localStage;

  public void setStage(Stage stage) {
    this.localStage = stage;
  }

  @FXML
  void sair(ActionEvent event) {
    this.localStage.close();
  }

}
