package figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.oxelen.Circle;
import ru.oxelen.Figure;
import ru.oxelen.Rectangle;
import ru.oxelen.Triangle;
import ru.oxelen.geometry.utils.GeometryUtils;

import java.util.stream.Stream;

public class FiguresUtilsTest {
    @ParameterizedTest
    @MethodSource("getAreaTestArguments")
    public void circleAreaEqualsTest(Figure f1, Figure f2, boolean expected) {
        Assertions.assertEquals(expected, GeometryUtils.isAreaEquals(f1, f2));
    }

    @ParameterizedTest
    @MethodSource("getPerimeterTestArguments")
    public void figuresPerimeterTest(Figure f1, Figure f2, boolean expected) {
        Assertions.assertEquals(expected, GeometryUtils.isPerimeterEquals(f1, f2));
    }

    private static Stream<Arguments> getAreaTestArguments() {
        return Stream.of(
                Arguments.of(new Circle(5), new Circle(5), true),
                Arguments.of(new Triangle(5, 4, 3), new Triangle(3, 4, 5), true),
                Arguments.of(new Rectangle(5, 4), new Rectangle(10, 2), true),
                Arguments.of(new Triangle(3, 4, 5), new Rectangle(3, 2), true),
                Arguments.of(new Circle(5), new Circle(6), false)
        );
    }

    private static Stream<Arguments> getPerimeterTestArguments() {
        return Stream.of(
                Arguments.of(new Circle(5), new Circle(5), true),
                Arguments.of(new Triangle(2, 2, 3), new Triangle(2, 2, 3), true),
                Arguments.of(new Rectangle(3, 5), new Rectangle(4, 4), true),
                Arguments.of(new Triangle(3, 4, 5), new Rectangle(4, 2), true),
                Arguments.of(new Triangle(2, 3, 4), new Rectangle(10, 2), false)
        );
    }
}
