package ru.oxelen.shapes;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = false)
@Getter
public class Cuboid extends ThreeDimensionalShape {
    private double width;
    private double height;
    private double depth;

    public Cuboid(double width, double height, double depth) {
        checkSides(width, height, depth);

        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public void setWidth(double width) {
        checkSide(width);
        this.width = width;
    }

    public void setHeight(double height) {
        checkSide(height);
        this.height = height;
    }

    public void setDepth(double depth) {
        checkSide(depth);
        this.depth = depth;
    }

    @Override
    public double getVolume() {
        return width * height * depth;
    }

    @Override
    public double getArea() {
        return width * height * 2 + width * depth * 2 + height * depth * 2;
    }

    private void checkSides(double width, double height, double depth) {
        checkSide(width);
        checkSide(height);
        checkSide(depth);
    }

    private void checkSide(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be positive");
        }
    }
}
