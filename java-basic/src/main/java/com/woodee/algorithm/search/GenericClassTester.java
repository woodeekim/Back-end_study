package com.woodee.algorithm.search;
// 제네릭 클래스
public class GenericClassTester {
    static class GenericClass<T> {
        private T xyz;

        public GenericClass(T xyz) {
            this.xyz = xyz;
        }

        public T getXyz() {
            return xyz;
        }
    }

    public static void main(String[] args) {
        // 다음과 같이 파라미터에 String을 넘길 수도 있고 Integer를 넘길 수도 있다.
        GenericClass<String> string = new GenericClass<>("ABC");
        GenericClass<Integer> number = new GenericClass<>(15);

        System.out.println(string.getXyz());
        System.out.println(number.getXyz());

    }
}
