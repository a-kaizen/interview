package interview.calculator;

import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;

class AddOperator implements Operator {
    @Override
    public char getOperatorCharacter() {
        return '+';
    }

    @Override
    public void apply(DoubleArrayStack stack) {
        stack.push(stack.pop() + stack.pop());
    }
}
