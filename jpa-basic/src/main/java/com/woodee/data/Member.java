package com.woodee.data;

import com.woodee.RoleType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@SequenceGenerator(
        name= "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SQL", // 맵핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 1
)
public class Member {

    //만약 요구 사항이 있다면
    /*
     * 1. 회원은 일반 회원과 관리자로 구분해야 한다.
     * 2. 회원 가입일과 수정일이 있어야 한다.
     * 3. 회원을 설명할 수 있는 필드가 있어야 한다. 길이 제한 없음
     */


    /*
    * 기본키 맵핑
    * - 기본 키 제약 조건
    *   - null 아니어야 한다.
    *   - 유일해야한다.
    *   - 변하면 안된다.
    * => 권장하는 식별자 전략
    *   - Long형 + 대체키(시퀀스 or uuid) + 키 생성전략 사용
    * - @Id : 직접 할당
    * - @GeneragtedValue : 자동 생성
    *       - @GeneratedValue(strategy = GenerationType.IDENTITY) :
    *           - IDENTITY 는 나는 모르겠고 DB 야 너가 알아서 넣어! 방언을 mysql 로 사용하면 AUTO_INCREAMENT
    *           - IDENTITY 는 id 값을 넣지 않고 db insert 를 하는데 db 에서 null 로 insert 쿼리가 날라오면 그때 db에서 셋팅해준다
    *           - 뭐가 문제냐면 id 값을 알 수 있는 시점이 db 에 들어가야지만 알 수 있다.
    *             JPA 는 영속성컨텍스트에서 관리되려면 무조건 pk 값일 있어야 되는데 IDENTITY 를 하게 되면 db 에 들어가야 안다.
    *           - 영속 상태가 됐다는 건 영속성 컨텍스트 안에 1차 캐시가 있다는 뜻이다. 1차 캐시 안에 @Id 인 PK 값이 있는데
    *             IDENTITY는 DB에 넣기 전까지 모른다. 그래서 JPA 입장에서는 울며겨자먹기로 em.persist() 를 호출하는 시점에 바로 데이터베이스에
    *             insert 쿼리를 날린다. (보통 커밋하는 시점에 insert 쿼리가 날라간다. )
    *           - 정리하면 IDENTITY 전략에서는 기존에 쿼리를 모아서 db 에 넣는 방법을 쓰지 못한다.
    *- 테이블 맵핑 전력이 있는데 잘 안쓴다. 일단 알고만 있자.
     */
    // pk로 맵핑
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "MEMBER_SEQ_GENERATOR" )
    private Long id;

    /*
    * @Colmun
    * - insertable, upadtable 은 기본이 true
    * - nullable = false 로 하면 Not null 제약조건이 걸린다. (자주 사용된다.)
    * - unique 제약조건은 컬럼에서 걸게되면 이름이 랜덤값으로 나와서 식별하기 힘들다. 그래서 @Table 에서 주로 걸어서 사용한다.
    * - columnDefinition
    * - legnth
    */

    // 객체에는 username, db에는 name 으로 쓰고 싶을때 name 이라는 속성을 사용하면 된다.
    @Column(name = "name")
    private String username;

    private Integer age;

    // db 에는 enum type 이 없는데 @Enumerated 어노테이션을 사용하면 된다.
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    /*
    * - EnumType.ORIDNARY 는 enum 의 순서를 db 에 넣는다. (사용X) / Integer type 으로 0부터 생성되는데 내가 원하는 순서대로 안 들어간다.
    * - EnumType.ORIDNARY 는 이름을 db 에 넣는다.
    * */


    /*
    *  - Java 8 이 오면서 날짜 타입중에 LocalDate, LocalDateTime이 생겼고 사용하면 @Temporal 을 생략 가능
    * */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    // 년월
    private LocalDate testLocalDate1;
    // 년월일
    private LocalDateTime testLocalDate2;

    // db 에 varchar 보다 더 큰 수를 넣고 싶을때 Lob 을 사용하면 된다.
    // 문자타입이면 알아서 clob(씨랍)으로 생성된다.
    @Lob
    private String description;

    // @Transient느 db에 관계없이 메모리에서만 저장하고 싶을 때 사용한다.
    @Transient
    private int temp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
