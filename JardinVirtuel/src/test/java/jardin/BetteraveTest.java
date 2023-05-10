package jardin;


import jardin.flore.Betterave;
import jardin.flore.Etat;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class BetteraveTest {

    private static final Jardin jardin = new Jardin(3, 5);

    @Test
    public void testSeDupliquer() {
        Betterave betterave = new Betterave();
        betterave.grandir();
        int longueur = 3;
        int largeur = 1;
        AbstractMap.SimpleEntry<Integer, Integer> map = betterave.seDupliquer(longueur, largeur);
        assertEquals(betterave.getEtat(), Etat.GRAINE);
        assertTrue(map.getKey() < longueur && map.getKey() >= 0);
        assertTrue(map.getValue() < largeur && map.getValue() >= 0);

    }


}
