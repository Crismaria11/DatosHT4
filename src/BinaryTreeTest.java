import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void revisarSiHayTraduccion() {
        BinaryTree tree = new BinaryTree(new Association<>("party", "fiesta"));
        String ingles = "party";

        String espera = "fiesta";
        String verdadero = tree.revisarSiHayTraduccion(ingles);
        assertEquals(espera, verdadero);

    }
}