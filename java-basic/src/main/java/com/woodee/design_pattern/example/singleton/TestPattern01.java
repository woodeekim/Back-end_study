package com.woodee.design_pattern.example.singleton;

public class TestPattern01 {
    public static void main(String[] args) {

/* 이렇게 하나씩 객체를 만들면 메모리에 큰 부담이 간다.
        Database d1 = new Database("1");
        Database d2 = new Database("2");
        Database d3 = new Database("3");
        Database d4 = new Database("4");
        Database d5 = new Database("5");
        Database d6 = new Database("6");*/

        Database database;
        database = Database.getInstance("첫 번째 Database");
        System.out.println("This is the " + database.getName());

        database = Database.getInstance("두 번째 Database");
        System.out.println("This is the " + database.getName()); // 결과는 첫 번째 데이터베이스가 출력된다.

        // Database를 싱글턴 패턴을 이용해서 만드는데
        // 다음같이 Database의 인스턴스르 만들수 있으면 안된다.
        // 그래서 기존 public Database(String name) {} 생성자의 접근제한자를
        // private으로 수정해야 한다.
        // private으로 하게 되면 외부에서 생성 할 수 없다. 오직 Database의 getInstance()를 통해서만 가능하다.
        // Database d1 = new Database("1");
    }
}
