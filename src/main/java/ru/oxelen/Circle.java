package ru.oxelen;

import lombok.*;
import ru.oxelen.exception.NotValidFigureParametersException;

@EqualsAndHashCode(callSuper = false)
@Getter
public class Circle extends Figure {
    private double radius;

    public Circle(double radius) throws NotValidFigureParametersException {
        checkRadius(radius);
        this.radius = radius;
    }

    public void setRadius(double radius) throws NotValidFigureParametersException {
        checkRadius(radius);
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    private void checkRadius(double radius) throws NotValidFigureParametersException {
        if (radius <= 0) {
            throw new NotValidFigureParametersException("Radius cannot be negative");
        }
    }
}
