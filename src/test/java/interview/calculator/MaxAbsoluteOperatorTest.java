package interview.calculator;

import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaxAbsoluteOperatorTest {

    @ParameterizedTest
    @MethodSource("maxAbsoluteSource")
    void shouldFindMaxAbsolute(DoubleArrayStack stack, double expectedResult) {
        //given
        //when
        new MaxAbsoluteOperator().apply(stack);

        //then
        assertEquals(expectedResult, stack.pop(), 0.0001);
        assertTrue(stack.isEmpty());
    }

    static Stream<Arguments> maxAbsoluteSource() {
        return Stream.of(
                Arguments.of(DoubleArrayStack.newStackWith(1, 2, 3), 3d),
                Arguments.of(DoubleArrayStack.newStackWith(-5, 3, -8), 3d),
                Arguments.of(DoubleArrayStack.newStackWith(10, -7, 4), 10d),
                Arguments.of(DoubleArrayStack.newStackWith(0), 0d),
                Arguments.of(DoubleArrayStack.newStackWith(-2.5, 1.8, -4.2), 1.8)
        );
    }
}
