package ru.oxelen.shapes;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper=false)
@Getter
public class Sphere extends ThreeDimensionalShape {
    private double radius;

    public Sphere(double radius) {
        checkRadius(radius);

        this.radius = radius;
    }

    public void setRadius(double radius) {
        checkRadius(radius);

        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (double) (4 / 3) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    private void checkRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
    }
}
