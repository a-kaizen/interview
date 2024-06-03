package interview.calculator;

import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultiplyOperatorTest {

    @ParameterizedTest
    @MethodSource("multiplySource")
    void shouldMultiply(DoubleArrayStack stack, double expectedResult) {
        //given
        //when
        new MultiplyOperator().apply(stack);

        //then
        assertEquals(expectedResult, stack.pop(), 0.0001);
        assertTrue(stack.isEmpty());
    }

    static Stream<Arguments> multiplySource() {
        return Stream.of(
                Arguments.of(DoubleArrayStack.newStackWith(2, 3), 6d),
                Arguments.of(DoubleArrayStack.newStackWith(-4, 5), -20d),
                Arguments.of(DoubleArrayStack.newStackWith(0, 10), 0d),
                Arguments.of(DoubleArrayStack.newStackWith(-2, -3), 6d),
                Arguments.of(DoubleArrayStack.newStackWith(1.5, 2), 3d)
        );
    }
}
