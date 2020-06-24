package com.woodee.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
    HashMap의 개념에 대해서 다시 정리하자면
    - HashMap은 키(key)와 값(value)을 묶어서 하나의 데이터(entry)로 저장한다는 특징을 갖는다.
    - 해싱(hashing)을 사용하기 때문에 많은 양의 데이터를 검색하는데 있어서 뛰어난 성능을 보인다.
 */
/*
    HashMap은 데이터를 키와 값을 모두 Object타입으로 저장하기 때문에 HashMap의 값으로 HashMap을 다시 저장할 수 있다.
    이렇게 함으로써 하나의 키에 다시 복수의 데이터를 저장할 수 있다.
 */
public class HashMapEx03 {
    // phoneBook이라는 객체를 HashMap 타입으로 만든다. 아직 phoneBook에 대해서 정의 내린건 없음
    static HashMap phoneBook = new HashMap();

    public static void main(String[] args) {
        addPhoneNo("친구", "이자바", "010-111-1111");
        addPhoneNo("친구", "김자바", "010-222-2222");
        addPhoneNo("친구", "김자바", "010-333-3333");
        addPhoneNo("회사", "김대리", "010-444-4444");
        addPhoneNo("회사", "김대리", "010-555-5555");
        addPhoneNo("회사", "박대리", "010-666-6666");
        addPhoneNo("회사", "이과장", "010-777-7777");
        addPhoneNo("세탁",  "010-888-8888");

        printList();
    }

    // 그룹에 전화번호를 추가하는 메서드
    /*
    1. 그룹명
    2. 이름
    3. 전화번호
     */
    static void addPhoneNo(String groupName, String name, String phoneNumber){
        // 그룹명 추가 메서드
        addGroup(groupName);
        // 아! .get()을 하면 HashMap의 key를 가져오는데 Obejct기 때문에 HashMap으로 형변환 해야줘야함
        HashMap group = (HashMap)phoneBook.get(groupName);
        group.put(phoneNumber, name);   // 이름은 중복될 수 있으니 전화번호를 key로 지정
    }

    // 그룹을 추가하는 메서드
    static void addGroup(String groupName){
        // phoneBook의 그룹이 없으면 새로 추가
        if(!phoneBook.containsKey(groupName)){
            phoneBook.put(groupName, new HashMap()); // value에다가 HashMap 을 넣을 수 있는건 Object 때문
        }
    }
    // addPhoneNo 오버로딩(이름은 같지만 인자, 순서, 타입이 다름)
    static void addPhoneNo(String name, String phoneNumber){
        addPhoneNo("기타", name,phoneNumber);
    }

    // 전화번호부 전체를 출력하는 메서드
    static void printList() {
        /*
            entrySet() 메서드
            - key와 value를 Set으로 저장해서 리턴
            - Set은 Collection 중 하나이다.
                - Collection은 iterator() 를 사용해서 각각의 데이터를 뽑아 낼 수 있다.
         */
        Set set = phoneBook.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();

            // 아까 groupName, new HashMap 으로 값에다가 또 key와 value를 넣은거 기억
            Set subSet = ((HashMap)entry.getValue()).entrySet();
            Iterator subIterator = subSet.iterator();

            System.out.println(" * " + entry.getKey()+ "[" + subSet.size()+"]");

            while (subIterator.hasNext()){
                Map.Entry subEntry = (Map.Entry)subIterator.next();
                String telNo = (String)subEntry.getKey();
                String name = (String)subEntry.getValue();
                System.out.println(name + " " + telNo);
            }
        }
        System.out.println(set);
    }
}

