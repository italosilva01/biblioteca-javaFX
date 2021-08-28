package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

import java.time.LocalDate;
import java.util.ArrayList;

import br.ufrn.imd.controle.AutorDetalhesController;
import br.ufrn.imd.controle.AutorInserirController;
import br.ufrn.imd.controle.AutorPesquisarController;
import br.ufrn.imd.controle.PrincipalController;
import br.ufrn.imd.controle.UsuarioDetalhesController;
import br.ufrn.imd.controle.UsuarioInserirController;
import br.ufrn.imd.controle.UsuarioPesquisarController;
import br.ufrn.imd.dao.AutorDAO;
import br.ufrn.imd.dao.CategoriaDAO;
import br.ufrn.imd.dao.EmprestimoDAO;
import br.ufrn.imd.dao.LivroDAO;
import br.ufrn.imd.dao.UsuarioDAO;
import br.ufrn.imd.modelo.Autor;
import br.ufrn.imd.modelo.Categoria;
import br.ufrn.imd.modelo.Emprestimo;
import br.ufrn.imd.modelo.Livro;
import br.ufrn.imd.modelo.Pessoa;
import br.ufrn.imd.modelo.Usuario;

public class Main extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    try {

      load();

      Parent root = FXMLLoader.load(getClass().getResource("../br/ufrn/imd/visao/Principal.fxml"));
      Scene scene = new Scene(root);
      primaryStage.setScene(scene);
      primaryStage.setTitle("Gerenciador de Biblioteca v1.0");
      primaryStage.setResizable(false);
      primaryStage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void load() {
    UsuarioDAO bdUsuario = UsuarioDAO.getInstance();
    bdUsuario.inserir(new Usuario(1, "Jackson D", "jackson@email.com", "84 9 9999 9999", "1234"));
    bdUsuario.inserir(new Usuario(2, "Maria F", "maria@email.com", "84 9 9999 9999", "1234"));
    bdUsuario.inserir(new Usuario(3, "Felipe C", "felipe@email.com", "84 9 9999 9999", "1234"));

    AutorDAO bdAutor = AutorDAO.getInstance();
    bdAutor.inserir(new Autor(1, "JK Rowling", null));
    bdAutor.inserir(new Autor(2, "JRR Tolkien", null));

    LivroDAO bdLivro = LivroDAO.getInstance();
    CategoriaDAO bdCategoria = CategoriaDAO.getInstance();

    ArrayList<Categoria> categorias = bdCategoria.listar();
    ArrayList<Autor> autores = bdAutor.listar();

    bdLivro.inserir(new Livro(1, "Harry Potter", categorias.get(0), LocalDate.of(1999, 2, 9), autores.get(0)));
    bdLivro.inserir(new Livro(2, "Senhor dos Aneis", categorias.get(0), LocalDate.of(1999, 2, 9), autores.get(1)));
  }

  public static void main(String[] args) {
    launch(args);
  }
}
