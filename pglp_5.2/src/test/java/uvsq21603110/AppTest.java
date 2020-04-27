package uvsq21603110;

import org.junit.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

/** Unit test for simple App. */
public class AppTest {
  @Test
  public void testInitperso() {
    Personnel personnel = new Personnel.Builder("Test", "Test", "Testeur").build();
    assertEquals("Test", personnel.getNom());
    assertEquals("Test", personnel.getPrenom());
    assertEquals("Testeur", personnel.getFonction());
  }

  @Test
  public void testAddtel() {
    String Tel = "0130333909";
    Personnel personnel = new Personnel.Builder("Test", "Test", "Testeur").addTel(Tel).build();
    assertEquals(personnel.getTel().get(0), Tel);
  }

  @Test
  public void testAddnaissance() {
    LocalDate naissance = LocalDate.now();
    Personnel personnel =
        new Personnel.Builder("Test", "Test", "Testeur").addNaissance(naissance).build();
    assertEquals(personnel.getNaissance(), naissance);
  }

  @Test
  public void testInitGroupe() {
    Groupe g = new Groupe();
    Personnel p = new Personnel.Builder("Test", "Test", "Testeur").build();
    g.add2Groupe(p);
    assertTrue(g != null);
  }

  @Test
  public void testADDGroupe() {
    Groupe g = new Groupe();
    Personnel p = new Personnel.Builder("Test", "Test", "Testeur").build();
    g.add2Groupe(p);
    assertEquals(g.getListPerso().size(), 1);
  }

  @Test
  public void persoSerializable() {

    Groupe g = new Groupe();
    Personnel p = new Personnel.Builder("Test", "Test", "Testeur").build();
    g.add2Groupe(p);
    assertEquals(g.getListPerso().size(), 1);

    try (ObjectOutputStream out =
        new ObjectOutputStream(
            new BufferedOutputStream(
                new FileOutputStream("fileperso")))) {
      out.writeObject(g);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (ObjectInputStream in =
        new ObjectInputStream(
            new BufferedInputStream(
                new FileInputStream("fileperso")))) {
      Groupe g1 = (Groupe) in.readObject();
      for (Personnel p1 : g1.getListPerso()) {
        System.out.println(p1.getNom());
        System.out.println(p1.getPrenom());
        System.out.println(p1.getFonction());
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testDAOpersonnel() {

    DAOFactory dao = new DAOFactory();
    DAO daopersonnel = new DAOpersonnel();
    Personnel p = new Personnel.Builder("Test", "Test", "Testeur").build();
    daopersonnel.create(p);
    Personnel p1 = (Personnel) daopersonnel.find("personnel");
    assertEquals("Test", p1.getNom());
  }

  @Test
  public void testDAOgroupe() {

    DAOFactory dao = new DAOFactory();
    DAO daogroupe = new DAOGroupe();
    Personnel p = new Personnel.Builder("Test", "Test", "Testeur").build();
    Groupe g= new Groupe();
    daogroupe.create(g);
    Groupe g1 = (Groupe) daogroupe.find("personnel");
    assertNotNull(g1.getListGroup());
  }
}
