package ru.oxelen.geometry.utils;

import ru.oxelen.Figure;
import ru.oxelen.geometry.utils.exception.validation.UnitValidationException;

public class GeometryUtils {
    public static boolean isAreaEquals(Figure f1, Figure f2) {
        return f1.getArea() == f2.getArea();
    }

    public static boolean isPerimeterEquals(Figure f1, Figure f2) {
        return f1.getPerimeter() == f2.getPerimeter();
    }

    public static double convert(double value, Units inputUnit, Units outputUnit) {
        if (value < 0) {
            throw new UnitValidationException("Value can't be negative, actual value:  " + value);
        }

        return value * inputUnit.getToMeters() / outputUnit.getToMeters();
    }
}
