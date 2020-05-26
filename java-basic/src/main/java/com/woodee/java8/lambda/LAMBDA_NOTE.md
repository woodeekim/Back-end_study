람다
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
