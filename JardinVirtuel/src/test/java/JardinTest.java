import jardin.Emplacement;
import jardin.Jardin;
import jardin.VegetalTest;
import jardin.flore.Ail;
import jardin.flore.Carotte;
import jardin.flore.Etat;
import jardin.flore.Vegetal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class JardinTest {

    private Jardin jardin;
    @BeforeEach
    public void init() {
        jardin = new Jardin(3, 5);
    }

    @Test
    public void testAjouterPanier() {
        jardin.ajouterPanier("Tomate", 5);
        jardin.ajouterPanier("Betterave", 3);
        jardin.ajouterPanier("Carotte", 4);
        jardin.ajouterPanier("Ail", 1);

        assertEquals(5, jardin.getPanier().get("Tomate"));
        assertEquals(3, jardin.getPanier().get("Betterave"));
        assertEquals(4, jardin.getPanier().get("Carotte"));
        assertEquals(1, jardin.getPanier().get("Ail"));

        assertNull(jardin.getPanier().get("Pomme"));
    }

    @Test
    public void testToString() {
        assertEquals("Voici notre jardin\nooooo\nooooo\nooooo\n\nEt notre panier contient :", jardin.toString());
    }

    @Test
    public void testPasserSaisonSuivante() {
        Vegetal carotte = new Carotte();
        assertEquals(0, carotte.getEtat().ordinal());
        jardin.getEmplacement()[0][0] = new Emplacement(carotte);
        for (int i = 1; i < Etat.values().length; i++) {
            assertNotNull(jardin.getEmplacement()[0][0]);
            jardin.passerSaisonSuivante();
            assertEquals(i, carotte.getEtat().ordinal());
        }
        jardin.passerSaisonSuivante();
        assertNull(jardin.getEmplacement()[0][0]);
    }

    @Test
    public void testSemer() {
        String input = "0 0 1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        jardin.ajouterPanier("Ail", 5);

        jardin.semer();

        assertEquals(4, jardin.getPanier().get("Ail"));
        assertTrue(jardin.getEmplacement()[0][0].getVeg() instanceof Ail);
    }


}
