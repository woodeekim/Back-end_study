package com.woodee.data;

import com.woodee.RoleType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {

    //만약 요구 사항이 있다면
    /*
     * 1. 회원은 일반 회원과 관리자로 구분해야 한다.
     * 2. 회원 가입일과 수정일이 있어야 한다.
     * 3. 회원을 설명할 수 있는 필드가 있어야 한다. 길이 제한 없음
     */

    // pk로 맵핑
    @Id
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
    @Column(name = "name", unique = true)
    private String username;

    private Integer age;

    // db 에는 enum type 이 없는데 @Enumerated 어노테이션을 사용하면 된다.
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    /*
    * - EnumType.ORIDNARY 는 enum 의 순서를 db 에 넣는다. (사용X) / Integer type 으로 생성
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
