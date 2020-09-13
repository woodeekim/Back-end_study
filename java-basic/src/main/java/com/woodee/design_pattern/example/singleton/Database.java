package com.woodee.design_pattern.example.singleton;

public class Database {
    private static Database singleton;
    private String name;

    // 많은 싱글턴 패턴을 가지는 유틸리티 클래스들은 생성자를 private으로 만드는 예가 많다.
    private Database(String name) {
        //super();
        //this.name = name;
        try {
            // Database 접속을 하게 되면 시간이 소모되기 때문에 다음 같이 유사한 환경을 만들었다.
            Thread.sleep(100);
            this.name = name;
        } catch (Exception e) {
        }
    }

    public static Database getInstance(String name) {
        if (singleton == null) { // 최초는 null 때문에 Database 객체를 만든다.
            singleton = new Database(name);
        }
        return singleton; // 기존에 있기 때문에 바로 리턴
    }

    public String getName() {
        return name;
    }
}
