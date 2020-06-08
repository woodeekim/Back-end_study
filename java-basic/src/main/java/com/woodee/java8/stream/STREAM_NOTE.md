### 스트림(Stream)
- 스트림은 데이터소스를 추상화하고, 데이터를 다루는데 자주 사용되는 메서드들을 정의해 놓았다.
    - 데이터 소스를 추상화하였다는건 데이터 소스가 무엇이던 간에 같은 방식으로 다룰 수 있다는 말이다.(재사용성이 높아짐)
- 스트림을 이용하면, 배열이나 컬렉션뿐만 아니라 파일에 저장된 데이터도 모두 같은 방식으로 다룰 수 있다.
```java
// 리스트
String[] strArr = { "aaa", "bbb", "ccc"};
List<String> strList = Arrays.asList(strArr);

// 스트림 생성
Stream<String> strStream1 = strList.stream();
Stream<String> strStream2 = Arrays.stream(strArr);

// 스트림으로 데어터 소스를 읽고 화면에 출력
strStream1.sorted().forEach(System.out::println);
strStream2.sorted().forEach(System.out::println);

// 스트림을 사용하지 않을 경우
Arrays.sort(strArr);
Collection.sort(strList);

for (String str : strArr) {
    System.out.println(str);
}
for (String str : strList) {
    System.out.println(str);
}
```
- 스트림을 사용한 코드가 간결하고 이해하기 쉬우며 재사용성도 높다.

스트림은 데이터 소스를 변경하지 않는다.
- 스트림은 데이터 소스로 부터 데이터를 읽기만할 뿐, 데이터 소스를 변경하지 않는다는 차이가 있다.
- 필요하면 정렬된 결과를 컬렉션이나 배열에 담아서 반환할 수 있다.
```java
// 정렬된 결과를 새로운 List에 담아서 반환
List<String> sortedList = strStream2.sorted().collect(Collectors.toList());
```
스트림은 일회용이다.
- 스트림은 Iterator 처럼 일회용이다.
    - Iterator로 컬렉션의 요소를 모두 읽고 나면 다시 사용할 수 없는 것처럼, 스트림도 한번 사용하면 닫혀서 사용 할 수 없다.
```java
strStream1.sorted().forEach(System.out::println);
int numOfstr = strStream1.count(); // 스트림이 이미 닫혀서 에러
```
스트림은 작업을 내부 반복으로 처리한다.
- 스트림을 이용한 작업이 간결한 이유는 '내부 반복'이기 때문이다.
    - 내부 반복이라는건 반복문을 메서드의 내부에 숨길 수 있다는 걸 의미한다.
- forEach()는 스트림에 정의된 메서드 중의 하나로 매개변수에 대입된 람다식을 데이터 소스의 모든 요소에 적용한다.
```java
// 기존
for (String str : strList) {
    System.out.println(str);
}
// 스트림
stream.forEach(System.out::println);
```

스트림의 연산
- 스트림이 제공하는 다양한 연산을 이용해서 복잡한 작업들을 간단히 처리할 수 있다.
- 스트림이 제공하는 연산은 중간 연산과 최종 연산으로 분류할 수 있다.
    - 중간 연산은 연산결과를 스트림으로 반환하기 때문에 중간 연산을 연속해서 연결할 수 있다.
    - 최종 연산은 스트림의 요소를 소모하면서 연산을 수행하므로 단 한번만 연산이 가능하다.
```java
stream.distict().limit(5).sorted().forEach(System.out::println);
     중간 연산   중간 연산   중간 연산  최종 연산
```
- 중간 연산은 map() 과 flatMap(), 최종 연산은 reduce() 와 collect()가 핵심이다.
지연된 연산
- 스트림 연산에서 한가지 중요한 점은 최종 연산이 수행되기 전까지는 중간 연산이 수행되지 않는다.
- 중간연산인 distinct()나 sort()같은 중간 연산을 호출해도 즉각적인 연산이 수행되는 것은 아니다.
- 중간 연산을 호출하는 것은 단지 어떤 작업이 수행되어야하는지를 지정해주는 것이다.
- 최종 연산이 수행되어야 비로소 스트림의 요소들이 중간 연산을 거쳐 최종 연산에서 소모된다.

Stream<Integer>와 IntStream
- 일반적으로 Stream<Integer> 대신 IntStream 을 사용하는 것이 더 효율적이다.

병렬 스트림
- 스트림으로 데이터를 다룰 때의 장점 중 하나가 바로 병렬 처리가 쉽다.
```java
int sum = strStream.parallel() // strStream을 병렬 스트림으로 전환
                    .mapToInt(s -> s.length() )
                    .sum();
```

컬렉션
- 컬렉션의 최고 조상인 Collection 에 stream() 이 정의되어 있다.
    - 그래서 자손인 List 와 Set 을 구현한 컬렉션 클래스들은 모두 이 메서드로 스트림을 생성할 수 있다.
    - stream() 은 해당 컬렉션을 소스로 하는 스트림을 반환한다.
```java
Stream<T> Collection.stream();
```
```java
// List 로부터 스트림을 생성하는 코드
List<Integer> list = Arrays.asList(1,2,3,4); // 가변 인자
Stream<Integer> intStream = list.stream(); // list를 소스로 하는 컬렉션 생성

// 스트림의 모든 요소를 화면에 출력
intStream.forEach(System.out::println); // 스트림의 모든 요소를 출력
intStream.forEach(System.out::println); // 에러. 스트림이 이미 닫힘
```

배열
- 배열을 소스로 하는 스트림을 생성하는 메서드는 Stream()과 Arrays 에 static 메서드로 정의되어 있다
```java
Stream<String> strStream = Stream.of("a", "b", "c"); 
Stream<String> strStream = Stream.of(new String[]{"a","b","c"})
```

특정 범위의 정수
```java
IntStream intStream = IntStream.range(1,5); // 1,2,3,4
IntStream intStream = IntStream.rangeClosed(1,5) // 1,2,3,4,5
```

임의의 수
- 난수를 생성하는데 사용하는 Random 클래스에는 인스턴스 메서드들이 포함되어 있다.

람다식 - iterate(), generate()
- Stream 클래스의 iterate() 와 generate() 는 람다식을 매개변수로 받아서, 람다식에 의해 계산되는 값들을 요소로 하는 무한 스트림을 생성한다.
```java
Stream<Integer> evenStream = Stream.iterate(0, n->n+2); // 0,2,4,6 ...
Stream<Double> randomStream = Stream.generate(Math::random); 
```

파일
- java.nio.file.Files 는 파일을 다루는데 유용한 메서드들을 제공한다.
- list() 는 지정된 디텍토리에 있는 파일의 목록을 소스로 하는 스트림을 생성해서 반환한다.
빈스트림
```java
Stream emptyStream = Stream.empty(); // empty() 는 빈스트림을 생성해서 반환
long count = emptyStream.count(); //count의 값은 00
```

두 스트림의 연결
```java
String[] str1 = {"123","456"};
String[] str1 = {"789","101112"};
Stream<String> strs1 = Stream.of(str1);
Stream<String> strs2 = Stream.of(str2);
Strema<String> strs3 = Stream.concat(strs1, strs2); // 두 스트림을 하나로 연결
```

스트림 자르기 - skip(), limit()
- skik(3)은 처음 3개의 요소를 건너뛰고, limit(5)는 스트림의 요소를 5개로 제한한다.
```java
IntStream intStream = IntStream.rangeClosed(1,10); // 1~10의 요소를 가진 스트림
intStream.skip(3).limit(5).forEach(System.out::println); // 45678
```    

스트림의 요소 걸러내기 - filter(), distinct()
- distinct()는 스트림에서 중복된 요소들을 제거하고, filter()는 주어진 조건에 맞지 않는 요소를 걸러낸다.
```java
// distinct()
IntStream intStream = IntStream.of(1,2,2,3,3,3,4,5,5,6);
intStream.distinct().forEach(System.out::println); // 123456

// filter()
IntStream intStream = IntStream.rangeClosed(1,10); // 1~10
intStream.filter( i -> i%2 == 0).forEach(System.out::print); //246810
```

정렬 - sorted()
- 스트림을 정렬할 때는 sorted() 를 사용
```java
Stream<String> strStream = Stream.of("dd", "aaa", "cc", "CC", "b");
strStream.sorted().forEach(System.out::print); //CCaaabccdd
```
- sorted() 는 지정된 Comparator 로 스트림을 정렬한다.
- Comparator 의 default 메서드
- Comparator 의 static 메서드
- 정렬에 사용되는 메서드의 개수가 많지만, 가장 기본적인 메서드는 comparing() 이다.

```java
// 학생 스트림을 반별, 성적순, 이름순으로 정렬하여 출력
studentStream.sorted(Comparator.comparing(Student::getBan)
                        .thenComparing(Student::getTotalScore)
                        .thenComparing(Student::getName))
                        .forEach(System.out::println);

// StreamEx1.java 참고
```

변환 - map()
- 스트림의 요소에 저장된 값 중에서 원하는 필드만 뽑아내거나 특정 형태로 변환해야 할 때 map() 을 사용한다.
```java
// File 의 스트림에서 파일의 이름만 뽑아서 출력하고 싶을 때
Stream<File> fileStream = Stream.of(New file("Ex.java"), new File("Ex1"),
                           new File("Ex.bak"), new File("Ex.java"), new File("Ex.txt"));

// map() 으로 Stream<File> 을 Stream<String> 으로 변환
Stream<String> filenameStream = fileStream.map(File::getName);
filenameStream.forEach(System.out::println); // 스트림의 모든 파일이름을 출력
```
- map() 도 중간 연산이므로, 연산결과는 String 을 요소로 하는 스트림이다.
- map() 으로 Stream<File> 을 Stream<String> 으로 변환했다.
- map() 도 filter() 처럼 하나의 스트림에 여러 번 적용할 수 있다.

```java
// File 의 스트림에서 파일의 확장자만을 뽑은 다음 중복을 제거해 출력
fileStream.map(FIle::getName) // Stream<File> -> Stream<String>
            .filter(s -> s.indexOf('.')!=-1) // 확장자가 없는 것은 제외
            .map(s -> s.substring(s.substring(s.indexOf('.')+1))) //Stream<String> -> Stream<String>
            .map(String::toUpperCase) // 모두 대문자로 변환
            .distinct() // 중복 제거
            .forEach(System.out::print);
```

조회 - peek()
- 연산과 연산 사이에 올바르게 처리되었는지 확인하고 싶다면 peek() 를 사용
- forEach() 와 달리 스트림의 요소를 소모하지 않으므로 연산 사이에 여러 번 끼워 넣어도 문제가 되지 않는다.
```java
fileStream.map(File::getName)   // Stream<File> -> Stream<String>
            .filter(s -> s.indexOf('.')!==-1)    // 확장자가 없는 것은 제외
            .peek(s -> System.out.println("filename = %s%n", s)) // 파일명을 출력
            .map(s -> s.substring(s.indexOf('.')+1))
            .peek(s -> System.out.printf("extension = %s%n", s)) // 확장자를 출력
            .forEach(System.out::println);
```
- filter() 나 map() 의 결과를 확인할 때 유용하게 사용될 수 있다
- StreamEx2.java 참고

mapToInt(), mapToLong(), mapToDouble()
- map() 은 연산의 결과로 Stream<T>타입의 스트림을 반환하는데, 스트림의 요소를 숫자로 변환하는 경우 IntStream 과 같은 기본형 스트림으로 변환하는 것이 더 유용할 수 있다.
- count() 메서드만 지원하는 Stream<T> 와 달리 IntStream 과 같은 기본형 스트림은 숫자를 다루는데 편리한 메서드들을 제공한다.
```java
int sum() // 스트림의 모든 요소의 총합
OptionalDouble average() // sum() / (double)count()
OptionalInt max() // 스트림의 요소 중 제일 큰 값
OptionalInt min() // 스트림의 요소 중 제일 작은 값
```
