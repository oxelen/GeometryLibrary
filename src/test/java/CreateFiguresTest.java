import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.oxelen.Circle;
import ru.oxelen.Rectangle;
import ru.oxelen.Triangle;
import ru.oxelen.exception.NotValidFigureParametersException;

import java.util.stream.Stream;

public class CreateFiguresTest {
    @Test
    public void createCircleTest() {
        Assertions.assertDoesNotThrow(() -> new Circle(10d));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-10d, 0d})
    public void createCircleWithInvalidRadius(double radius) {
        Assertions.assertThrows(NotValidFigureParametersException.class, () -> new Circle(radius));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1d, 0d})
    public void setInvalidRadius(double radius) {
            Circle circle = new Circle(1d);
            Assertions.assertThrows(NotValidFigureParametersException.class, () -> circle.setRadius(radius));
    }

    @Test
    public void createRectangleTest() {
        Assertions.assertDoesNotThrow(() -> new Rectangle(10d, 10d));
    }

    @ParameterizedTest
    @MethodSource("rectangleInvalidParameters")
    public void createRectangleWithNegativeParameters(double[] params) {
        Assertions.assertThrows(NotValidFigureParametersException.class, () -> new Rectangle(params[0], params[1]));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1d, 0d})
    public void setInvalidRectangleSides(double side) {
            Rectangle rectangle = new Rectangle(1d, 1d);
            Assertions.assertThrows(NotValidFigureParametersException.class, () -> rectangle.setA(side));
            Assertions.assertThrows(NotValidFigureParametersException.class, () -> rectangle.setB(side));
    }

    @Test
    public void createTriangleTest() {
        Assertions.assertDoesNotThrow(() -> new Triangle(10d, 10d, 10d));
    }

    @ParameterizedTest
    @MethodSource("triangleValidParameters")
    public void createTriangleWithValidParameters(double[] params) {
        Assertions.assertThrows(
                NotValidFigureParametersException.class,
                () -> new Triangle(params[0], params[1], params[2])
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1d, 0d})
    public void setInvalidTriangleSides(double side) {
            Triangle triangle = new Triangle(2d, 3d, 4d);

            Assertions.assertThrows(NotValidFigureParametersException.class, () -> triangle.setA(side));
            Assertions.assertThrows(NotValidFigureParametersException.class, () -> triangle.setB(side));
            Assertions.assertThrows(NotValidFigureParametersException.class, () -> triangle.setC(side));

            Assertions.assertThrows(NotValidFigureParametersException.class, () -> triangle.setC(1d));
    }

    @Test
    public void squareTest() {
        Rectangle rectangle = new Rectangle(10d, 10d);
        Assertions.assertTrue(rectangle.isSquare());

        rectangle.setA(1d);
        Assertions.assertFalse(rectangle.isSquare());
    }


    private static Stream<double[]> rectangleInvalidParameters() {
        return Stream.of(
                new double[]{0d, 0d},
                new double[]{-1d, 1d},
                new double[]{1d, -1d},
                new double[]{-1d, -1d},
                new double[]{0d, 1d},
                new double[]{1d, 0d}
        );
    }

    private static Stream<double[]> triangleValidParameters() {
        return Stream.of(
                new double[]{0d, 0d, 0d},
                new double[]{-1d, -1d, -1d},
                new double[]{-1d, 0d, 1d},
                new double[]{1d, -1d, 0d},
                new double[]{5, 4, 10}
        );
    }
}
