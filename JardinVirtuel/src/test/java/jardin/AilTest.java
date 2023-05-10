package jardin;

import jardin.flore.Ail;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AilTest {

    private static final Jardin jardin = new Jardin(3, 5);
    private static final Ail ail = new Ail();

    @Test
    public void testSeReproduire() {
        ail.seReproduire(jardin.getPanier());
        assertEquals(3, jardin.getPanier().get("Ail"));
    }
}
