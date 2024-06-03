package interview.calculator;

import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;

class AbsoluteOperator implements Operator {

    @Override
    public char getOperatorCharacter() {
        return 'A';
    }

    @Override
    public void apply(DoubleArrayStack stack) {
        stack.push(Math.abs(stack.pop()));
    }
}
