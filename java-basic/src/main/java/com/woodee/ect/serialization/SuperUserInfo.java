package com.woodee.ect.serialization;

public class SuperUserInfo {
    String name;
    String password;

    SuperUserInfo() {
        this("Unknown", "1111");
    }

    SuperUserInfo(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
