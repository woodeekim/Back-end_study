### 람다(Lambda)
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
### java.util.function 패키지
- 일반적으로 자주 쓰이는 형식의 메서드를 함수형 인터페이스로 미리 정의해 놓았다.
- 가장 기본적인 함수형 인터페이스
```java
//java.lang.Runnable 
void run()

//Supplier<T>
T get()

//Consumer<T>
void accept(T t)

//Function<T,R>
R apply(T t)

//Predicate<T>
boolean test(T t)
```
Predicate(조건식의 표현에 사용)
- Function의 변형으로 Predicate가 있는데, 반환값이 boolean이라는 것만 제외하면 Function과 동일하다.
```java

Predicate<String> isEmptyStr = s => s.length == 0;
String s = "";
//if (s.length() == 0)
if (isEmptyStr.test(s)) {
    System.out.println("This is an empty String");
}
```
매개변수가 두 개인 함수형 인터페이스
- 매개변수의 개수가 2개인 함수형 인터페이스는 이름 앞에 접두사 Bi가 붙는다.
UnaryOperator와 BinaryOperator
- Function의 또 다른 변형으로 UnaryOperator와 BinaryOperator가 있다.
컬렉션 프레임웍과 함수형 인터페이스
- LambdaEx4.java
- LambdaEx5.java
기본형을 사용하는 함수형 인터페이스
- LambdaEx6.java
Function의 합성과 Predicate의 결합
- LambdaEx7.java
메서드 참조
- 람다식으로 메서드를 간결하게 표현할 수 있다.
- 람다식이 하나의 메서드만 호출하는 경우에 메서드 참조라는 방법으로 더 간략하게 할 수 있다.
- 하나의 메서드만 호출하는 람다식은 '클래스이름::메서드이름' 또는 '참조변수::메서드이름' 으로 바꿀 수 있다.
```java
//메서드 참조전
Function<String, Integer> f = (String s) -> Integer.parseInt(s);
//메서드 참조후
Function<String, Integer> f = Integer::parseInt;

//메서드 참조전
BiFunction<String, String, Boolean> f = (s1, s2) -> s1.equlas(s2);
//메버스 참조후
BiFunction<String, String, Boolean> f = String::equlas;

//메서드 참조전
MyClass obj = new MyClass();
Function<String, Boolean> f = (x) -> obj.equlas(x);
//메서드 참조후
Function<String, Boolean> f2 = obj::equlas;

```
생성자의 메서드 참조
```java
//메서드 참조전
Supplier<MyClass> s = () -> new MyClass();
//메서드 참조후
Supplier<MyClass> s2 = () -> MyClass::new;

//메서드 참조전
Function<Integer, MyClass> f = (i) -> new MyClass(i);
//메서드 참조후
Function<Integer, MyClass> f2 = MyClass::new;

//메서드 참조전
BiFunction<Integer, String, MyClass> bf = (i, s) -> new MyClass(i, s);
//메서드 참조후
BiFunction<Integer, String, MyClass> bf2 = MyClass::new;

//메서드 참조전
Function<Integer, int[]> f = x -> new int[x];
//메서드 참조후
Function<Integer, int[]> f2 = int[]::new;
```


