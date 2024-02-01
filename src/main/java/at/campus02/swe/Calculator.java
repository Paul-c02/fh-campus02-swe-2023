package at.campus02.swe;

public interface Calculator {

    enum Operation {
        add, sub, mul, div, mod, sin, cos, random, dot, store, load
    }

    void push(double value);

    double pop() throws CalculatorException;

    double perform(Operation op) throws CalculatorException;

    void clear();
    void store(double v);
    double load();

}
