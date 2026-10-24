package figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.oxelen.Circle;
import ru.oxelen.Figure;
import ru.oxelen.Rectangle;
import ru.oxelen.Triangle;
import ru.oxelen.geometry.utils.GeometryUtils;

public class FiguresUtilsTest {
    @Test
    public void circleAreaEqualsTest() {
        Figure c1 = new Circle(5);
        Figure c2 = new Circle(5);

        Assertions.assertTrue(GeometryUtils.isAreaEquals(c1, c2));
    }

    @Test
    public void triangleAreaEqualsTest() {
        Figure t1 = new Triangle(5, 4, 3);
        Figure t2 = new Triangle(3, 4, 5);

        Assertions.assertTrue(GeometryUtils.isAreaEquals(t1, t2));
    }

    @Test
    public void rectangleAreaEqualsTest() {
        Figure r1 = new Rectangle(5, 4);
        Figure r2 = new Rectangle(10, 2);

        Assertions.assertTrue(GeometryUtils.isAreaEquals(r1, r2));
    }
}
