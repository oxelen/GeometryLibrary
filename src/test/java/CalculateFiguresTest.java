import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.oxelen.Circle;
import ru.oxelen.Figure;
import ru.oxelen.Rectangle;
import ru.oxelen.Triangle;
import ru.oxelen.exception.NotValidFigureParametersException;

public class CalculateFiguresTest {
    @Test
    public void getCirclePerimeterTest() {
        double radius = 5d;

        try {
            Figure circle = new Circle(radius);

            Assertions.assertEquals(2 * Math.PI * radius, circle.getPerimeter());
        } catch (NotValidFigureParametersException e) {
            throw new RuntimeException("Wrong test data: " + e.getMessage());
        }
    }

    @Test
    public void getCircleAreaTest() {
        double radius = 5d;

        try {
            Figure circle = new Circle(radius);
            Assertions.assertEquals(Math.PI * radius * radius, circle.getArea());
        } catch (NotValidFigureParametersException e) {
            throw new RuntimeException("Wrong test data: " + e.getMessage());
        }
    }

    @Test
    public void getRectanglePerimeterTest() {
        double a = 5;
        double b = 10;

        try {
            Figure rectangle = new Rectangle(a, b);
            Assertions.assertEquals(2 * (a + b), rectangle.getPerimeter());
        } catch (NotValidFigureParametersException e) {
            throw new RuntimeException("Wrong test data: " + e.getMessage());
        }
    }

    @Test
    public void getRectangleAreaTest() {
        double a = 5;
        double b = 10;

        try {
            Figure rectangle = new Rectangle(a, b);
            Assertions.assertEquals(a * b, rectangle.getArea());
        } catch (NotValidFigureParametersException e) {
            throw new RuntimeException("Wrong test data: " + e.getMessage());
        }
    }

    @Test
    public void getTrianglePerimeterTest() {
        double a = 4;
        double b = 5;
        double c = 6;

        try {
            Figure triangle = new Triangle(a, b, c);
            Assertions.assertEquals(a + b + c, triangle.getPerimeter());
        } catch (NotValidFigureParametersException e) {
            throw new RuntimeException("Wrong test data: " + e.getMessage());
        }
    }

    @Test
    public void getTriangleAreaTest() {
        double a = 4;
        double b = 5;
        double c = 6;

        try {
            Figure triangle = new Triangle(a, b, c);
            double halfPerimeter = triangle.getPerimeter() / 2;
            double targetArea = Math
                    .sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));

            Assertions.assertEquals(targetArea, triangle.getArea());
        } catch (NotValidFigureParametersException e) {
            throw new RuntimeException("Wrong test data: " + e.getMessage());
        }
    }
}
