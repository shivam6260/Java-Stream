package com.streams.lambda;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Divide implements MathOperation {

    @Override
    public int operate(int a, int b) {
        return a / b;
    }
}

public class LambdaExpression1 {
    public static void main(String[] args) {
        MathOperation Add = (int a, int b) -> {
            return a + b;
        };

        MathOperation Subtract = (int a, int b) -> {
            return a - b;
        };

        MathOperation Multiply = (int a, int b) -> {
            return a * b;
        };

        MathOperation Multiply2 = (a,b) -> a + b;


        Divide obj = new Divide();
        obj.operate(10, 2);

        MathOperation obj1 = new Divide();
        obj1.operate(10, 2);

        Add.operate(5, 5);
        Subtract.operate(10, 10);


        MathOperation ob = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return 0;
            }
        };

        // One Inbuild Functional Interface
        Predicate<Integer> isEven = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };
        System.out.println(isEven.test(4));

        // Holds the Condition
        Predicate<Integer> isOdd = x -> x % 2 != 0;
        System.out.println(isOdd.test(5));

        // Testing with Runnable Interface

        Runnable isRunning = () -> System.out.println("Shivam is running");
        isRunning.run();

        Runnable isWalking = () -> {
            System.out.println("Shweta is running");
            System.out.println("Everyone is walking");
        };

        isWalking.run();


    }
}

/*
🔍 What a Lambda Expression Does in Java
When you write a lambda like:

MathOperation Add = (int a, int b) -> {
    return a + b;
};

Internally:
Java creates an anonymous class or uses invokedynamic (Java 8+) to generate a class that implements the MathOperation interface.
The lambda provides an implementation of the operate() method.
The result is an instance of MathOperation.
You can think of it like this under the hood (simplified):

MathOperation Add = new MathOperation() {
    @Override
    public int operate(int a, int b) {
        return a + b;
    }
};
So, Java creates an anonymous class or uses a special bytecode instruction (invokedynamic)
to generate the implementation at runtime.

✅ Why Lambdas Work This Way
Lambdas work only with functional interfaces — interfaces with exactly one abstract method.
This allows Java to infer which method is being implemented (in your case, operate()).

When you write:

MathOperation Subtract = (int a, int b) -> a - b;

Java knows:
The target type is MathOperation.
The lambda body is implementing the operate() method.

🔄 Method Calls
Add.operate(5, 5);
It just calls the operate method implemented via the lambda.

So, this:

MathOperation Add = (a, b) -> a + b;
Add.operate(2, 3);
Is functionally the same as:

MathOperation Add = new MathOperation() {
    @Override
    public int operate(int a, int b) {
        return a + b;
    }
};
Add.operate(2, 3);
 */
