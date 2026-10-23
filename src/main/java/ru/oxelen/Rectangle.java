package ru.oxelen;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import ru.oxelen.exception.NotValidFigureParametersException;

@EqualsAndHashCode(callSuper = false)
@Getter
public class Rectangle extends Figure {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        checkRectangle(a, b);

        this.a = a;
        this.b = b;
    }

    public void setA(double a) {
        checkRectangle(a, this.b);
        this.a = a;
    }

    public void setB(double b) {
        checkRectangle(this.a, b);
        this.b = b;
    }

    @Override
    public double getPerimeter() {
        return 2 * (a + b);
    }

    @Override
    public double getArea() {
        return a * b;
    }

    private void checkRectangle(double a, double b) {
        if (a <= 0 || b <= 0) {
            throw new NotValidFigureParametersException("Rectangle parameters are invalid");
        }
    }
}
