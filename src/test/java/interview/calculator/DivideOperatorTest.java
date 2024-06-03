package interview.calculator;

import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class DivideOperatorTest {

    @ParameterizedTest
    @MethodSource("divideSource")
    void shouldDivide(DoubleArrayStack stack, double expectedResult) {
        //given
        //when
        new DivideOperator().apply(stack);

        //then
        assertEquals(expectedResult, stack.pop(), 0.0001);
        assertTrue(stack.isEmpty());
    }

    static Stream<Arguments> divideSource() {
        return Stream.of(
                Arguments.of(DoubleArrayStack.newStackWith(6, 2), 3d),
                Arguments.of(DoubleArrayStack.newStackWith(-10, 2), -5d),
                Arguments.of(DoubleArrayStack.newStackWith(10, -2), -5d),
                Arguments.of(DoubleArrayStack.newStackWith(0, 5), 0d),
                Arguments.of(DoubleArrayStack.newStackWith(7.5, 1.5), 5d)
        );
    }

    @Test
    void shouldThrowExceptionWhenDividingByZero() {
        //given
        DoubleArrayStack stack = DoubleArrayStack.newStackWith(5, 0);

        //when
        //then
        assertThrows(IllegalMathOperationException.class, () -> new DivideOperator().apply(stack));
    }
}
