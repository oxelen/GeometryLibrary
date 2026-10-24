import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.oxelen.shapes.Cube;
import ru.oxelen.shapes.Sphere;
import ru.oxelen.shapes.ThreeDimensionalShape;

public class CalculateThreeDimShapesTest {
    @Test
    public void getCubeVolumeTest() {
        ThreeDimensionalShape cube = new Cube(2);

        Assertions.assertEquals(Math.pow(2, 3), cube.getVolume());
    }

    @Test
    public void getCubeAreaTest() {
        ThreeDimensionalShape cube = new Cube(2);
        Assertions.assertEquals(2 * 2 * 6, cube.getArea());
    }

    @Test
    public void getSphereVolumeTest() {
        ThreeDimensionalShape sphere = new Sphere(2);

        Assertions.assertEquals((double) (4 / 3) * Math.PI * Math.pow(2, 3), sphere.getVolume());
    }

    @Test
    public void getSphereAreaTest() {
        ThreeDimensionalShape sphere = new Sphere(2);

        Assertions.assertEquals(4 * Math.PI * Math.pow(2, 2), sphere.getArea());
    }
}
