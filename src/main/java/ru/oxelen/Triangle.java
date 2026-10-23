package ru.oxelen;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import ru.oxelen.exception.NotValidFigureParametersException;

@EqualsAndHashCode(callSuper = false)
@Getter
public class Triangle extends Figure {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        checkTriangle(a, b, c);

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setA(double a) {
        checkTriangle(a, this.b, this.c);

        this.a = a;
    }

    public void setB(double b) {
        checkTriangle(this.a, b, this.c);

        this.b = b;
    }

    public void setC(double c) {
        checkTriangle(this.a, this.b, c);

        this.c = c;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public double getArea() {
        double halfPerimeter = getPerimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    private void checkTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new NotValidFigureParametersException("Triangle parameters are invalid");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new NotValidFigureParametersException("Triangle out of bounds");
        }
    }
}
