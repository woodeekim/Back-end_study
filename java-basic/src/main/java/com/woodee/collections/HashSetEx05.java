package com.woodee.collections;

import java.util.HashSet;

public class HashSetEx05 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc");
        set.add(new Person2("David", 10));
        set.add(new Person2("David", 10));

        System.out.println(set);
    }
}

class Person2 {
    String name;
    int age;
    Person2(String name,int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        // 참조변수가 검사한 타입으로 형변환이 가능하다는 얘기
        if(obj instanceof Person2) {
            Person2 tmp = (Person2)obj;
            return name.equals(tmp.name) && age==tmp.age;
        }
        return false;
    }

    /*
    String 클래스는 문자열의 내용으로 해시코드를 만들어 내기 때문에 내용이 같은 문자열에 대한 hashCode() 호출은
    항상 동일한 해시코드를 반환하지만 Object 클래스는 객체의 주소로 해시코드를 만들어 내기 때문에 실행할 때마다
    해시 코드값이 달라질 수 있다.
     */
    @Override
    public int hashCode() {
        return (name+age).hashCode();
    }

    @Override
    public String toString() {
        return name + ":" + age;

    }
}
