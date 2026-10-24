import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.oxelen.Circle;
import ru.oxelen.Figure;
import ru.oxelen.Rectangle;
import ru.oxelen.Triangle;

public class CalculateFiguresTest {
    @Test
    public void getCirclePerimeterTest() {
        double radius = 5d;

        Figure circle = new Circle(radius);

        Assertions.assertEquals(2 * Math.PI * radius, circle.getPerimeter());
    }

    @Test
    public void getCircleAreaTest() {
        double radius = 5d;

        Figure circle = new Circle(radius);
        Assertions.assertEquals(Math.PI * radius * radius, circle.getArea());
    }

    @Test
    public void getRectanglePerimeterTest() {
        double a = 5;
        double b = 10;

        Figure rectangle = new Rectangle(a, b);
        Assertions.assertEquals(2 * (a + b), rectangle.getPerimeter());
    }

    @Test
    public void getRectangleAreaTest() {
        double a = 5;
        double b = 10;


        Figure rectangle = new Rectangle(a, b);
        Assertions.assertEquals(a * b, rectangle.getArea());
    }

    @Test
    public void getTrianglePerimeterTest() {
        double a = 4;
        double b = 5;
        double c = 6;


        Figure triangle = new Triangle(a, b, c);
        Assertions.assertEquals(a + b + c, triangle.getPerimeter());
    }

    @Test
    public void getTriangleAreaTest() {
        double a = 4;
        double b = 5;
        double c = 6;

        Figure triangle = new Triangle(a, b, c);
        double halfPerimeter = triangle.getPerimeter() / 2;
        double targetArea = Math
                .sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));

        Assertions.assertEquals(targetArea, triangle.getArea());
    }
}
