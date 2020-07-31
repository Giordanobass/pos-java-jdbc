package pos_java_jdbc.pos_java_jdbc;

import java.util.List;
import org.junit.Test;
import dao.UserPosDao;
import model.BeanUserFone;
import model.Telefone;
import model.UserPosJava;

public class TesteBancoJdbc {

  @Test
  public void initBanco() {
    UserPosDao userPosDao = new UserPosDao();
    UserPosJava userPosJava = new UserPosJava();

    userPosJava.setNome("Giordano teste");
    userPosJava.setEmail("giordano@gmail.com");

    userPosDao.salvar(userPosJava);
  }

  @Test
  public void initListar() {
    UserPosDao dao = new UserPosDao();
    try {
      List<UserPosJava> list = dao.listar();
      for (UserPosJava userPosJava : list) {
        System.out.println(userPosJava);
        System.out.println("----------------------------------");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void initBuscar() {
    UserPosDao dao = new UserPosDao();
    try {
      UserPosJava userPosJava = dao.buscar(6L);
      System.out.println(userPosJava);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void initAtualizar() {
    try {

      UserPosDao dao = new UserPosDao();
      UserPosJava objetoBanco = dao.buscar(5L);
      objetoBanco.setNome("Nome mudado com metodo atualizar");
      dao.aturalizar(objetoBanco);

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  public void initDeletar() {
    try {
      UserPosDao dao = new UserPosDao();
      dao.deletar(5L);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testeInsertTelefone() {
    Telefone telefone = new Telefone();
    telefone.setNumero("(87) 4445-4545");
    telefone.setTipo("Casa");
    telefone.setUsuario(7L);

    UserPosDao dao = new UserPosDao();
    dao.salvarTelefone(telefone);
  }

  @Test
  public void testeCarregarFonesUser() {

    UserPosDao dao = new UserPosDao();
    List<BeanUserFone> beanUserFones = dao.listaUserFone(7L);
    for (BeanUserFone beanUserFone : beanUserFones) {
      System.out.println(beanUserFone);
      System.out.println("----------------------------------");
    }
  }

  @Test
  public void testeDeleteUserFone() {
    UserPosDao dao = new UserPosDao();
    dao.deleteFonesPorUser(9L);
  }
}
