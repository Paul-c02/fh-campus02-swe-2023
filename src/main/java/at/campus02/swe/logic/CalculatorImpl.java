package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.Random;
import java.util.Stack;

public class CalculatorImpl implements Calculator {

    private Stack<Double> stack_ = new Stack<Double>();

    @Override
    public double perform(Operation op) throws CalculatorException {

        Double b;
        Double a;

        switch (op) {
            case add:
                b = pop();
                a = pop();
                return a + b;
            case sub:
                b = pop();
                a = pop();
                return a - b;
            case div:
                b = pop();
                a = pop();
                double c = a / b;
                if (Double.isInfinite(c))
                    throw new CalculatorException("Division by zero");
                return c;
            case mul:
                b = pop();
                a = pop();
                return a * b;
            case sin:
                b = pop();
                return Math.sin(Math.toRadians(b));
            case cos:
                b = pop();
                return Math.cos(Math.toRadians(b));
            case mod:
                b = pop();
                a = pop();
                return a % b;
            case random:
                b = pop();
                a = pop();
                return  new Random(1234).nextInt(a.intValue(),b.intValue());
            case dot:
                return calculateDotProduct();
        }
        return 0;
    }

    @Override
    public double pop() throws CalculatorException {
        if (stack_.isEmpty())
            throw new CalculatorException();
        return stack_.pop();
    }

    @Override
    public void push(double v) {
        stack_.push(v);
    }

    @Override
    public void clear() {
        stack_.clear();
    }

    public static void main(String[] args) {
        System.out.println(new Random(12345).nextInt(4,7));
    }

    private int calculateDotProduct() throws CalculatorException{
        int product = 0;
        int len = (int)pop();
        int[] vec = new int[len];
        for (int i = 0; i < len; i++) {
            vec[i]=(int)pop();
        }
        for (int i = 0; i < len; i++) {
            product += (int)pop() * vec[i];
        }

        return product;
    }

}
