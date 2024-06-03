package interview.calculator;

import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;

public interface Operator {
    char getOperatorCharacter();
    void apply(DoubleArrayStack stack);
}
