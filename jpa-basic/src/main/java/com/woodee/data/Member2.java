package com.woodee.data;

import javax.persistence.*;

@Entity
public class Member2 {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String username;

/*    @Column(name = "TEAM_ID")
    private Long teamid;*/

    // 하나의 팀에 여러 멤버가 소속되니까 팀이 1이고 멤버가 n이다.
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team2 team;

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

    public Team2 getTeam() {
        return team;
    }

    public void setTeam(Team2 team) {
        this.team = team;
    }

    //기존 setteam() -> chagneteam() 으로 바꿈
    //김영한님은 기존 getter, setter 관계인 이름으로 쓰는게 아니라 jpa 상태나 값이 변하면 changexxx 로 사용한다.
    public void changeTeam(Team2 team) {
        this.team = team;
        team.getMembers().add(this); //연관관계 편의 메서드
    }
}
