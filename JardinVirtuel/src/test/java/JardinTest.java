import jardin.Emplacement;
import jardin.InputReader;
import jardin.Jardin;
import jardin.flore.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.util.AbstractMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// mockito

@ExtendWith(MockitoExtension.class)
public class JardinTest {

    @Mock
    private InputReader inputReaderMock;

    @Mock
    private Betterave betteraveMock;

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
        //String input = "0 0 1";
        //System.setIn(new ByteArrayInputStream(input.getBytes()));
        jardin.setInputReader(inputReaderMock);

        when(inputReaderMock.readIntValue()).thenReturn(1);
        jardin.ajouterPanier("Ail", 4);

        jardin.semer();

        verify(inputReaderMock, times(3)).readIntValue();

        assertEquals(3, jardin.getPanier().get("Ail"));
        assertTrue(jardin.getEmplacement()[1][1].getVeg() instanceof Ail);
    }

    @Test
    public void testRecolterEnFleurEtOGM() {
        when(betteraveMock.getEtat()).thenReturn(Etat.FLEUR);
        AbstractMap.SimpleEntry<Integer, Integer> loc = new AbstractMap.SimpleEntry<>(1, 1);
        when(betteraveMock.seDupliquer(3, 5)).thenReturn(loc);

        jardin.getEmplacement()[0][0] = new Emplacement(betteraveMock);

        jardin.recolter();

        verify(betteraveMock).getEtat();
        verify(betteraveMock).seDupliquer(3, 5);

        assertNull(jardin.getEmplacement()[0][0]);
        assertNotNull(jardin.getEmplacement()[1][1]);


    }

}
