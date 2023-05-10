package jardin;

import jardin.flore.Carotte;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarotteTest {

    private static final Jardin jardin = new Jardin(3, 5);

    @Test
    public void testSeRepoduire() {
        Carotte carotte = new Carotte();
        carotte.seReproduire(jardin.getPanier());
        assertEquals(3, jardin.getPanier().get("Carotte"));
    }
}
