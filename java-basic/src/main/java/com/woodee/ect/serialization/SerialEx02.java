package com.woodee.ect.serialization;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

// 역직렬화
public class SerialEx02 {
    public static void main(String[] args) {
        try {
            String fileName = "UserInfo.ser";
            FileInputStream fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);

            ObjectInputStream in = new ObjectInputStream(bis);

            // 객체를 읽을 때는 출력한 순서와 일치해야한다.
            UserInfo u1 = (UserInfo)in.readObject();
            UserInfo u2 = (UserInfo)in.readObject();
            ArrayList list = (ArrayList)in.readObject();

            System.out.println(u1);
            System.out.println(u2);
            System.out.println(list);
        } catch (Exception e) {

        }
    }
}

/*
    - 객체를 역직렬화 할 때는 직렬화할 때의 순서와 일치해야한다.
    - 직렬화할 객체가 많을 때는 각 객체를 개별적으로 직렬화하는 것보다 ArrayList와 같은 컬렉션에 저장해서 직렬화하는 것이 좋다.
 */
