package com.woodee.java8.lambda;

@FunctionalInterface
interface Myfunction2 {
    void myMethod(); // public abstract void myMethod();
}

public class LambdaEx2 {
    public static void main(String[] args) {
        // Myfunction2 myfunction = (Myfunction2)(() -> {});
        Myfunction2 myfunction2 = () -> {};

        // Object 타입으로 형변환이 됨
        Object obj = (Myfunction2)() -> {};

        String str = ((Object)(Myfunction2)( () -> {})).toString();

        System.out.println("myfunction : " + myfunction2);
        System.out.println("obj : " + obj);
        System.out.println("str : " + str);

        /*
            myfunction : com.woodee.java8.lambda.LambdaEx2$$Lambda$14/0x0000000800066840@7dc36524
            obj : com.woodee.java8.lambda.LambdaEx2$$Lambda$15/0x0000000800066c40@35bbe5e8
            str : com.woodee.java8.lambda.LambdaEx2$$Lambda$16/0x0000000800066040@7d417077

            결과값을 보면 컴파일러는 람다식의 타입을 '외부클래스이름$$Lambda$번호' 와 같은 형식으로 만든다.
            <-> 일반적인 익명 객체라면 객체의 타입이 '외부클래스이름$번호'이다
         */
    }
}
