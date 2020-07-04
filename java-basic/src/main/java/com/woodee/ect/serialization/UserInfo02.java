package com.woodee.ect.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class UserInfo02 extends SuperUserInfo implements Serializable {
    int age;

    public UserInfo02() {
        this("Unknown", "1111", 0);
    }

    public UserInfo02(String name, String password, int age) {
        super(name, password);
        this.age = age;
    }

    public String toString() {
        return "(" + name + "," + password + "," + age + ")";
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeUTF(name);
        out.writeUTF(password);
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        password = in.readUTF();
        in.defaultReadObject();;
    }
}
