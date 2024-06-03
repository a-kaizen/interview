package interview.calculator;

import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddOperatorTest {

    @ParameterizedTest
    @MethodSource("addSource")
    void shouldAdd(DoubleArrayStack stack, double expectedResult) {
        //given
        //when
        new AddOperator().apply(stack);

        //then
        assertEquals(expectedResult, stack.pop(), 0.0001);
        assertTrue(stack.isEmpty());
    }

    static Stream<Arguments> addSource() {
        return Stream.of(
                Arguments.of(DoubleArrayStack.newStackWith(1, 2), 3d),
                Arguments.of(DoubleArrayStack.newStackWith(-5, 3), -2d),
                Arguments.of(DoubleArrayStack.newStackWith(10, -7), 3d),
                Arguments.of(DoubleArrayStack.newStackWith(0, 0), 0d)
        );
    }
}
