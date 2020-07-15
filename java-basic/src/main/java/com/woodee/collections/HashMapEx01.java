package com.woodee.collections;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx01 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("myId", "1234");
        map.put("asdf", "1111");
        // 키가 같은 결우 마지막으로 덮어씌어짐
        map.put("asdf","1234");

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("id와 password를 입력해주세요");
            System.out.print("id : ");
            String id = scanner.nextLine().trim();
            String password = scanner.nextLine().trim();
            System.out.println();

            if(!map.containsKey(id)){
                System.out.println("입력하신 id는 조잰하지 않습니다. 다시 입력해주세요.");
                continue;
            } else {
                if(!(map.get(id).equals(password))){
                    System.out.println("비밀번호가 일치하지 않습니다. 다시 입력주세요");
                } else {
                    System.out.println("id와 비밀번호가 일차합니다. ");
                    break;
                }
            }
        } //while
    }
}
/*
- 3개의 데이터 쌍을 저장했지만 실제로는 2개 밖에 저장되지 않은 이유는 중복된 키가 있기 때문이다
- Map의 값은 중복을 허용하지만 키는 중복을 허용하지 않기 때문에 저장하려는 두 데이터 중에서 어느 쪽은 키로 할 것인지를 잘 결정해야한다.
- Hashtable은 키나 값으로 null을 허용하지 않지만, HashMap은 허용한다. 그래서 map.put(null, null)이나 map.get(null) 과 같이 할 수 있다.
*/
