package interview.calculator;

import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;

class MaxAbsoluteOperator implements Operator {

    @Override
    public char getOperatorCharacter() {
        return 'M';
    }

    @Override
    public void apply(DoubleArrayStack stack) {
        double max = stack.pop();
        while (!stack.isEmpty()) {
            max = Math.max(max, stack.pop());
        }
        stack.push(max);
    }
}
