import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.oxelen.shapes.Cube;
import ru.oxelen.shapes.Sphere;

import java.awt.*;

public class CreateTreeDimShapesTest {
    @Test
    public void createCube() {
        Assertions.assertDoesNotThrow(() -> new Cube(1));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 0})
    public void createInvalidCube(double side) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Cube(side));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 0})
    public void setInvalidCubeSide(double side) {
        Cube cube = new Cube(1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> cube.setSide(side));
    }

    @Test
    public void createSphere() {
        Assertions.assertDoesNotThrow(() -> new Sphere(1));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 0})
    public void createInvalidSphere(double radius) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Sphere(radius));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 0})
    public void setInvalidSphereRadius(double side) {
        Sphere sphere = new Sphere(1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> sphere.setRadius(side));
    }
}
