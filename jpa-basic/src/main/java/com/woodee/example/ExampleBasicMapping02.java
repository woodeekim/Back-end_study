package com.woodee.example;

import com.woodee.data.Member2;
import com.woodee.data.Team2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/*
연관관계 매핑 기초 - 양방향 연관관계와 연관관계의 주인 (주의점,정리)
- 현재 연관관계의 주인은 Member2 인데
- mappedBy 는 가짜맵핑으로 읽기 전용이며 jpa 에서 insert 및 update 할 때 이걸 전혀 안본다.
- 양방향 맵핑을 할 때 연관관계의 주인에 값을 안 넣으면 Member2 의 외래키값이 Null 나오니 주의
-> 양방향 맵핑을 할 때는 연관관계의 주인과 주인이 아닌 쪽인 양쪽에다가 값으 세팅해줘야 된다.
- 양방향 매핑시 무한루프를 조심
    - toString(), lombok, JSON 생성 라이브러리
    - 정답이 있는 방법
    -> lombok 에서는 toString()을 사용x
    -> Controller 에서는 Entity 를 절대 반환x
 */
public class ExampleBasicMapping02 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Team2 team2 = new Team2();
            team2.setName("첫번째팀");
            em.persist(team2);

            Member2 member2 = new Member2();
            member2.setUsername("첫번째 유저");
            member2.changeTeam(team2);
            em.persist(member2);
            // flush 와 clear 를 하면 1차 캐시에는 아무것도 없다.
            em.flush();
            em.clear();


            //Member2에서 Team2 을 셋팅하는 시점에 Member 인스턴스를 넣어준다.
            //어디로 넣어주냐면 Member2 클래스에서 setTeam() 을 해줄때 -> 연관관계 편의 메서드를 생성한다고 한다.
            Team2 findTeam = em.find(Team2.class, team2.getId()); // 1차 캐시에 있다.

            // 자동완성 inter , soutv
            System.out.println("============================");
            List<Member2> members = findTeam.getMembers();
            for (Member2 member : members) {
                System.out.println("member = " + member.getUsername());
            }
            System.out.println("============================");


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
