## 컬렉션 프레임워크(Collections Framework)
- JDK1.2 부터 컬렉션 프레임워크가 등장하면서 다양한 종류의 컬렉션 클래스가 추가되고 모든 컬렉션 클래스를 표준화된 방식으로 다룰 수 있다.
- 컬렉션 프레임워크는 컬렉션, 다수의 데이터를 다루는 데 필요한 다양한 클래스를 제공한다.
- 재사용성

Collection 인터페이스
- List와 Set의 조상인 Collection인터페이스
- Collection인터페이스는 컬렉션 클래스에 저장된 데이터를 읽고 추가 및 삭제 등 컬렉션을 다루는데 필요한 메서드를 정의
- 
List
- 순서가 있는 데이터의 집합
- 데이터의 중복을 허용
- 구현 클래스 : ArrayList, LinkedList, Stack, Vector
Set
- 순서를 유지하지 않는 데이터의 집합
- 데이터의 중복을 허용하지 않음
- 구현 클래스 : HashSet, TreeSet
Map
- key와 value의 쌍으로 이루어진 데이터의 집합
- 순서는 유지되지 않음
- 키는 중복을 허용하지 않고 값은 중복을 허용
- 구현 클래스 : HashMap, TreeMap, Hasttable, Properties

### ArrayList
- ArrayList는 컬렉션 프레임워크에서 가장 많이 사용되는 컬렉셔 클래스다.
- List 인터페이스를 구현하기 때문에 다음과 같은 장점이 있다.
    - 1.데이터의 저장순서가 유지된다.
    - 2.중복을 허용한다.
- ArrayList는 Object배열을 이용해서 데이터를 순차적으로 저장한다.
