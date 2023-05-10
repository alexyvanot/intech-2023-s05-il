package jardin;

import jardin.flore.Etat;
import jardin.flore.Vegetal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VegetalTest {

    @Test
    public void testExistingEnumEtat() {
        Etat[] etat = Etat.values();
        int length = etat.length;
        Etat[] expected = { Etat.GRAINE, Etat.GERME, Etat.TIGE, Etat.FEUILLE, Etat.FLEUR, Etat.MORT };

        assertEquals(6, length);
        for (int i = 0; i < length; i++) {
            assertEquals(expected[i], etat[i]);
        }

    }

    @Test
    public void testGrandir() {
        Vegetal vegetal = new Vegetal(){};

        assertEquals(Etat.GRAINE, vegetal.getEtat());

        vegetal.grandir();

        assertEquals(Etat.GERME, vegetal.getEtat());

        vegetal.grandir(2);

        assertEquals(Etat.FEUILLE, vegetal.getEtat());
    }

    @Test
    public void testGetVeg() {
        	Vegetal vegetal = new Vegetal() {};
        	Emplacement emplacement = new Emplacement(vegetal);

        	assertEquals(vegetal, emplacement.getVeg());
    }

}
