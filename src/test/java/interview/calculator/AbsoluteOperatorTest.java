package interview.calculator;

import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AbsoluteOperatorTest {

    @ParameterizedTest
    @MethodSource("mathAbsoluteSource")
    void shouldMathAbsolute(DoubleArrayStack stack, double expectedResult) {
        //given
        //when
        new AbsoluteOperator().apply(stack);

        //then
        assertEquals(expectedResult, stack.pop(), 0.0001);
        assertTrue(stack.isEmpty());
    }

    static Stream<Arguments> mathAbsoluteSource() {
        return Stream.of(
                Arguments.of(DoubleArrayStack.newStackWith(1), 1d),
                Arguments.of(DoubleArrayStack.newStackWith(-12), 12d),
                Arguments.of(DoubleArrayStack.newStackWith(13), 13d)
        );
    }
}
