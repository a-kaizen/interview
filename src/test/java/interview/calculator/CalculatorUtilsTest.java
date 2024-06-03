package interview.calculator;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorUtilsTest {

    @Nested
    class RpnTest {
        @ParameterizedTest
        @MethodSource("rpnNotationMethodSource")
        void shouldCalculateRpnNotations(String input, Double shouldEqual) {
            //given
            //when
            double res = CalculatorUtils.calculateRpn(input);

            //then
            assertEquals(shouldEqual, res);
        }

        @Test
        void shouldHandleMathAbsoluteOperator() {
            //given
            var input = "-1 A";

            //when
            double res = CalculatorUtils.calculateRpn(input);

            //then
            assertEquals(1d, res);
        }

        @Test
        void shouldHandleMaxOperator() {
            //given
            var input = "-1 -5 18 100 M";

            //when
            double res = CalculatorUtils.calculateRpn(input);

            //then
            assertEquals(100d, res);
        }

        @Test
        void shouldHandleDivideOperator() {
            //given
            var input = "2 10 /";

            //when
            double res = CalculatorUtils.calculateRpn(input);

            //then
            assertEquals(0.2d, res);
        }

        @Test
        void shouldHandleSubtractOperator() {
            //given
            var input = "2 10 -";

            //when
            double res = CalculatorUtils.calculateRpn(input);

            //then
            assertEquals(-8d, res);
        }

        @Test
        void shouldHandleAddOperator() {
            //given
            var input = "2 10 +";

            //when
            double res = CalculatorUtils.calculateRpn(input);

            //then
            assertEquals(12d, res);
        }

        static Stream<Arguments> rpnNotationMethodSource() {
            return Stream.of(
                    Arguments.of("12 2 3 4 x 10 5 / + x +", 40d),
                    Arguments.of("5 1 2 + 4 x + 3 -", 14d),
                    Arguments.of("2 7 + 3 / 14 3 - 4 x + 2 /", 23.5d)
            );
        }
    }

    @Nested
    class IsDigitTest {
        @ParameterizedTest
        @MethodSource("digitsOrNotMethodSource")
        void shouldCheckIfIsDigit(String input, boolean shouldEqual) {
            //given
            //when
            boolean res = CalculatorUtils.isDigit(input);

            //then
            assertEquals(shouldEqual, res);
        }

        static Stream<Arguments> digitsOrNotMethodSource() {
            return Stream.of(
                    Arguments.of("12", true),
                    Arguments.of("-12", true),
                    Arguments.of("1", true),
                    Arguments.of("0", true),
                    Arguments.of("809809", true),
                    Arguments.of("-", false),
                    Arguments.of("/", false),
                    Arguments.of("-", false)
            );
        }
    }
}
