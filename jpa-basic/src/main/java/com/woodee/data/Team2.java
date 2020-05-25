package com.woodee.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team2 {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    //양방향 관계를 맺기위해 추가
    //new ArrayList() 로 초기화하는게 관례다. (add 할 때 null 안뜬다.)
    //mappedBy는 반대편에 걸려있는 변수를 적어준다.
    //=> 이렇게 해야만 반대로 탐색을 할 수 있다.

    /*
        연관관계의 주인과 mappedBy *조금 어려운 부분*
        - mappedBy = JPA 의 멘탈붕괴 난이도이다.
        - mappedBy는 처음에는 이해하기 어렵다.
        - 객체와 테이블간에 연관관계를 맺는 차이를 이해해야 한다.
        -> 객체와 테이블이 관계를 맺는 차이는?
            - 객체는 연관관계의 키포인트가 2개가 있다.
                - 회원에서 팀으로 가는 연관관계 1개 (단방향)
                - 팀에서 회원으로 가는 연관관계 1개 (단방향)
                -> 객체의 양방향 관계는 사실 양방향 관계가 아니라 서로 다른 단방향 관계 2개다.
                -> 객체를 양방향으로 참조하려면 단방향 연관관계를 2개 만들어야 한다.
            - 테이블의 연관관계는 1개다.
                - MEMBER 의 TEAM_ID (FK) 로 TEAM 의 TEAM_ID (PK) 로 조인을 하면
                  멤버가 어느팀 소속인지 알 수 있다.
                - 팀입장에서도 우리팀에 어떤 멤버가 있는지 알 수 있다
                -> 즉 TEAM_ID (FK) 하나로 양쪽의 연관관계를 알 수 있다.
                -> 테이블 연관관계에서는 FK 하나로 연관관계로 알 수 있지만
                   반대로 객체 세상은 참조가 양쪽에 있다. (차이를 알고 있자.)
       - 연관관계의 주인 (양방향 매핑 규칙)
            - 객체의 두 관계(MEMBER 와 TEAM)중 하나를 연관관계의 주인으로 지정한다.
            - 연관관계의 주인만이 외래 키를 관리(등록, 수정)
            - 주인이 아닌쪽은 읽기만 가능
            - 주인은 mappedBy 속성을 사용하지 않는다. (그럼 여기서는 MEMBER2 가 주인이겠다.)
            - 주인이 아니면 mappedBy 속성으로 주인을 지정한다. (TEAM2)
            -> 그러면 누구를 주인으로 정해야하나?
                - 외래 키가 있는 곳을 주인으로 정하면 된다. *중요*
                -> @ManyToOne N 인쪽이 무조건 연관관계 주인이 된다.
                -> 자동차와 바퀴를 예로 들 때 바퀴를 주인을 잡아야한다.

    */
    @OneToMany(mappedBy = "team")
    private List<Member2> members = new ArrayList<>();

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

    public List<Member2> getMembers() {
        return members;
    }

    public void setMembers(List<Member2> members) {
        this.members = members;
    }
}

