package figures.units;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import ru.oxelen.geometry.utils.GeometryUtils;
import ru.oxelen.geometry.utils.Units;
import ru.oxelen.geometry.utils.exception.validation.UnitValidationException;

import java.util.stream.Stream;

import static ru.oxelen.geometry.utils.Units.*;

public class ConvertUnitsTest {

    @ParameterizedTest
    @MethodSource("convertToMetersData")
    public void convertTest(double input, Units inputUnits, Units outputUnit, double expected) {
        Assertions.assertEquals(expected, GeometryUtils.convert(input, inputUnits, outputUnit));
    }

    @ParameterizedTest
    @EnumSource(value = Units.class)
    public void convertNotValidTest(Units unit) {
        Assertions.assertThrows(UnitValidationException.class, () -> GeometryUtils.convert(-1, unit, unit));
    }

    private static Stream<Arguments> convertToMetersData() {
        return Stream.of(
                Arguments.of(5, CENTIMETER, METER, 0.05),
                Arguments.of(1, KILOMETER, CENTIMETER, 100000),
                Arguments.of(1, METER, METER, 1),
                Arguments.of(0.5, METER, KILOMETER, 0.0005),
                Arguments.of(5, METER, MILLIMETER, 5000),
                Arguments.of(0, CENTIMETER, METER, 0)
        );
    }
}
