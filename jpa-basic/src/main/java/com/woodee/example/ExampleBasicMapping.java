package com.woodee.example;

import com.woodee.data.Member2;
import com.woodee.data.Team2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ExampleBasicMapping {
    public static void main(String[] args) {
        /* 2020-05-24 연관관 맵핑 기초 - 단방향 연관관계*/

        /*
            객체를 테이블에 맞추어 데이터 중심으로 모델하면, 협력 관계를 만들 수 없다.
            - 테이블은 외래 키로 조인을 사용해서 연관된 테이블을 찾는다.
            - 객체는 참조를 사용해서 연관된 객체를 찾는다.
            - 테이블과 객체 사이에는 이런 큰 간격이 있다.

            단방향 연관관계
        */

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();;
        try {
            Team2 team = new Team2();
            team.setName("TeamA");
            // 영속상태가 되면 무조건 pk 값이 세팅되고 영속상태가 된다
            em.persist(team);

            Member2 member = new Member2();
            member.setUsername("member1");
            //setTeamId 를 구하는건 객체지향스럽지 않다. setTeam() 이라고 해야 객체지향스럽다.
            // 기존 방식 member.setTeamid(team.getId());

            // jpa를 이용한 객체지향방식
            // team 을 넣어주면 jpa 가 알아서 team 의 pk 값을 꺼내 외래키로 사용을 한다.
            member.setTeam(team);
            em.persist(member);

            /*
                이 뒤로는 영속성 컨텍스트에서 가져오기 때문에 콘솔에 따로 select 창이 안 보인다. 보고 싶다면
                flush() 를 이용해 강제로 여기까지 db 에 데이터를 밀어놓고 이후 clear() 를 하면 볼 수 있다.
             */
            em.flush();
            em.clear();

            Member2 findMember = em.find(Member2.class, member.getId());
            //양방향 연관관계
            //사실 객체는 가급적이면 단방향이 좋다.
            List<Member2> members = findMember.getTeam().getMembers();

            System.out.println("===============================");
            for (Member2 m : members) {
                System.out.println("m = " + m.getUsername());
            }
            System.out.println("===============================");




            tx.commit();
        } catch (Exception  e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
