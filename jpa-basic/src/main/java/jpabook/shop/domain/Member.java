
/*
   getter 같은 경우 만들어주면 상관없지만 setter 같은 경우에느 고민해 볼 필요가 있다.
   - 현재 예제기 때문에 setter 를 만든다.
   - setter 를 만들때 문제점은 아직 잘 모르겠다. 나중에 정확히 이해하고 있자.
    - setter 를 만들게 되면 어디서든 setter 를 할 수 있으니까 코드 추적과 유지보수에 힘들다.
    -> 가능하면 생성자에서 값을 다 셋팅하고 세터에 사용을 최소로 하는게 유지보수 하는데 낫다.

   _(언더스코어) 방식과 캐멀케이스 방식에 대한 얘기
    - 데이터베이스는 대부분 MEMBER_ID or member_id 로 한다.
    - java 는 memberId 와 같이 캐말케이스로 하는데 스프링부트로 jpa를 실행하게 되면 재밌는게 기본 값이
      자바의 캐멀케이스를 읽어서 언더스코어로 바꿔준다.

   데이터 중심 설계의 문제점(꽤 중요한 내용이기에 나중에 한번 더 보자. 16강_24:56 참고)
    - 현재 방식은 객체 설계를 테이블 설에 맞춘 방식
    - 테이블의 외래키를 객체로 그대로 가져옴 (참조값을 그대로 가져와야 된다. Memberid가 아닌 Member 객체 그 자체)
    - 객체 그래프 탐색이 불가능
    - 참조가 없으므로 UML 도 잘못됨
 */

/*
package jpabook.shop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Member  {

    // @GeneratedValue(strategy = GenerationType.AUTO) 기본값이 Auto 이다.
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zip;

    @OneToMany( mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    public Member() {
     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}

*/
