package interview.calculator;

import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubtractOperatorTest {

    @ParameterizedTest
    @MethodSource("subtractSource")
    void shouldSubtract(DoubleArrayStack stack, double expectedResult) {
        //given
        //when
        new SubtractOperator().apply(stack);

        //then
        assertEquals(expectedResult, stack.pop(), 0.0001);
        assertTrue(stack.isEmpty());
    }

    static Stream<Arguments> subtractSource() {
        return Stream.of(
                Arguments.of(DoubleArrayStack.newStackWith(5, 2), 3d),
                Arguments.of(DoubleArrayStack.newStackWith(3, 7), -4d),
                Arguments.of(DoubleArrayStack.newStackWith(0, 10), -10d),
                Arguments.of(DoubleArrayStack.newStackWith(-2, -3), 1d),
                Arguments.of(DoubleArrayStack.newStackWith(1.5, 0.5), 1d)
        );
    }
}
