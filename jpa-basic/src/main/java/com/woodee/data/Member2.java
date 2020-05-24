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

    public Team2 getTeam(Member2 findMember) {
        return team;
    }

    public void setTeam(Team2 team) {
        this.team = team;
    }
}
