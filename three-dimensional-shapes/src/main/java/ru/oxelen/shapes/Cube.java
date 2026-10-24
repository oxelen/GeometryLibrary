package ru.oxelen.shapes;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = false)
@Getter
public class Cube extends ThreeDimensionalShape {
    private double side;

    public Cube(double side) {
        checkSide(side);

        this.side = side;
    }

    public void setSide(double side) {
        checkSide(side);
        this.side = side;
    }

    @Override
    public double getVolume() {
        return Math.pow(side, 3);
    }

    @Override
    public double getArea() {
        return side * side * 6;
    }

    private void checkSide(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be positive");
        }
    }
}
