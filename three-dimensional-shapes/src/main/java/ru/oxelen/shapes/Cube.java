package ru.oxelen.shapes;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = false)
@Getter
public class Cube extends Cuboid {
    public Cube(double side) {
        super(side, side, side);
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setHeight(side);
        super.setDepth(side);
    }

    @Override
    public double getVolume() {
        return super.getVolume();
    }

    @Override
    public double getArea() {
        return super.getArea();
    }
}
