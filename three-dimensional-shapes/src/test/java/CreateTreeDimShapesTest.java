import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.oxelen.shapes.Cube;
import ru.oxelen.shapes.Cuboid;
import ru.oxelen.shapes.Sphere;

import java.util.stream.Stream;

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

    @Test
    public void createCuboid() {
        Assertions.assertDoesNotThrow(() -> new Cuboid(1, 2, 3));
    }

    @ParameterizedTest
    @MethodSource("getInvalidCuboidArguments")
    public void createInvalidCuboid(double[] sides) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Cuboid(sides[0], sides[1], sides[2]));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 0})
    public void setInvalidCuboidSides(double side) {
        Cuboid cuboid = new Cuboid(1, 2, 3);
        Assertions.assertThrows(IllegalArgumentException.class, () -> cuboid.setWidth(side));
        Assertions.assertThrows(IllegalArgumentException.class, () -> cuboid.setHeight(side));
        Assertions.assertThrows(IllegalArgumentException.class, () -> cuboid.setDepth(side));
    }

    private static Stream<double[]> getInvalidCuboidArguments() {
        return Stream.of(
                new double[]{0, -1, 1},
                new double[]{1, 0, -1},
                new double[]{-1, 1, 0}
        );
    }
}
