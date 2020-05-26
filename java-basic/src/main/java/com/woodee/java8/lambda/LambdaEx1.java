package com.woodee.java8.lambda;

@FunctionalInterface
interface Myfunction {
    void run(); // public abstract void run();
}

public class LambdaEx1 {

    // 매개변수의 타입이 MyFunction 인 메서드
    static void execute(Myfunction f) {
        f.run();
    }

    // 반환 타입이 MyFunction 인 메서드
    static Myfunction getMyFunction() {
        Myfunction f = () -> System.out.println("f3.run()");
        return f;
    }

    public static void main(String[] args) {
        // 람다식으로 Myfunction 의 run() 을 구현
        Myfunction f1 = () -> System.out.println("f1.run()");
        Myfunction f2 = new Myfunction() { // 익명클래스로 run() 을 구현
            @Override
            public void run() { // public 을 반드시 붙여야 함
                System.out.println("f2.run()");
            }
        };
    }
}
