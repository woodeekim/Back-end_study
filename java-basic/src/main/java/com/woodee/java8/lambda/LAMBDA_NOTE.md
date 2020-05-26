### 람다
- 람다식은 간단히 말해서 메서드를 하나의 식으로 표현한 것
- 함수를 간략하면서도 명확한 식으로 표현할 수 있게 해줌
- 메서드를 람다식으로 표현하면 메서드의 이름과 반환값이 없어지므로,
  익명 함수라고 함
- 람다식은 메서드의 매개변수로 전달되어지는 것이 가능하고, 메서드의 결과로
  반한될 수도 있다. (변수처럼 다루는 것이 가능)

```java
// 기존
int max(int a, int b) {
    return a > b ? a : b;
}
// 람다식
(a,b) -> a > b ? a : b

//기존
void printVar(String name, int i) {
    System.out.println(name+"="+i);
}
//람다식
(name,i) -> System.out.println(name+"="+i)

//기존
int square(int x){
    return x * x;
}
//람다식
x -> x * x;

//기존
int roll() {
    return (int)(Math.random() * 6);
}  
//람다식
() -> (int)(Math.random() * 6)

//기존
int sumArr(int[] arr) {
    int sum = 0;
    for (int i : arr) {
        sum += i;
    return sum;
    }
}
//람다식
(int[] arr) -> {
    int sum = 0;
    for (int i : arr) {
        sum += i;
    return sum;
    }
}
```

### 함수형 인터페이스(Functional interface)
- 람다식도 실제로는 익명 객체이고, 인터페이스를 구현한 익명 객체의 메서드와
  람다식의 매개변수의 타입과 개수, 반환값이 일치하기 때문이다.
- 람다식을 다루기 위한 인터페이스를 함수형 인터페이스라고 부른다.
- @Functional interface를 붙이면 컴파일러가 확인해준다.
- 함수형 인터페이스에는 오직 하나의 추상 메서드만 정의되어야 한다는 제약이 있다.
- 반면에 static과 default 메서드의 개수에는 제약이 없다.
- 람다식을 참조변수로 다룰 수 있다는 건 메서드를 통해 람다식을 주고 받을 수 있다는 의미다. (변수처럼 메서드를 주고받는 것이 가능)
```java
//기존
List<String> list = Arrays.asList("abc", "aaa", "bbb", "ddd");
Collection.sort(list, new Comparator<String>() {
    public int compare(String s1, String s2) {
        return s2.compareTo(s1);
    }
}
//람다식
List<String> list = Arrays.asList("abc", "aaa", "bbb", "ddd");
Collection.sort(list, (s1, s2) -> s2.compareTo(s1));
```
람다식의 타입과 형변환
- 함수형 인터페이스로 람다식을 참조할 수 있는 것일 뿐, 람다식의 타입이 함수형 인터페이스의 타입과
  일치하는 것은 아니다.
- 람다식은 익명 객체이고 익명 객체는 타입이 없다.
```java
Myfunction f = (Myfunction)( () -> {}); // 양변의 타입이 다르므로 형변환이 필요
Object obj = (Object)( () -> {}); // 에러. 함수형 인터페이스로만 형변화 가능

// Object 타입으로 형변환하려면, 함수형 인터페이스로 변환 후 Object 로 변환
Object obj = (Object)((Myfunction)( () -> {})).toString();
```
