package com.woodee.java8.lambda;

class Outer {
    int val = 10; //Outer.this.val

    class Inner {
        int val = 20; //this.val
        void method(int i) {
            int val = 30;
            System.out.println("1.method 들어옴");
            // 람다식을 담은 변수 f 가 바로 실행되는건가?
            // 궁금한건 method(int i) 호출 될 때 f 가 바로 실행되는지 궁금
            // -> 결과는 1 3 2
            Myfunction2 f = () -> {
                System.out.println("2. 람다를 담은 f가 바로 실행? ");
                //아! Myfunction 인터페이스의 추상메소드를 실행하는데 (Myfunction2) 를 생략하고 타입과 매개변수가 동일해서 그때 호출하는구나
                System.out.println("i = " + i);
                System.out.println("val = " + val);
                System.out.println("this.val = " + this.val);
                System.out.println("Outer.this.val = " + Outer.this.val);
            };
            System.out.println("3. f.myMethod()");
            f.myMethod();
        }
    } // end Inner
} // end Outer

public class LambdaEx3 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        //착각했다. 여기서 Inner 클래스안에 method()를 호출하지
        inner.method(100);
        /*
            1.method 들어옴
            3. f.myMethod()
            2. 람다를 담은 f가 바로 실행?
            i = 100
            val = 30
            this.val = 20
            Outer.this.val = 10
         */
    }
}
