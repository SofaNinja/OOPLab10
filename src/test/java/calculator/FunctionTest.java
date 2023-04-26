package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class FunctionTest {

    Function func;
    double EPS = 1e-5;
    @BeforeEach
    void setUp() {
        double a = 0;
        double b = 1;
        int h = 1_000_000;
        func = new Function(a, b, h, Math::cos);
    }

    @Test
    void calculateTest() {
        double expected = 0.84147;
        assertEquals(expected, func.calculate(), EPS);
    }
}