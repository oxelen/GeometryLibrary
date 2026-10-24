package ru.oxelen.geometry.utils;

import lombok.Getter;

//В параметре enum - кол-во единиц в метрах
public enum Units {
    MILLIMETER (0.001),
    CENTIMETER (0.01),
    METER (1),
    DECIMETER (10),
    KILOMETER (1000);

    @Getter
    private final double toMeters;

    Units(double toMeters) {
        this.toMeters = toMeters;
    }
}
