package com.woodee.example;

import com.woodee.data.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ExampleCRUD {
    public static void main(String[] args) {
        // 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에 공유
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //persistence.xml > persistence-unit 이름
        // 엔티티 매니저는 쓰레드간에 공유 X (사용하고 버려야한다.)
        EntityManager em = emf.createEntityManager();
        // JPA의 모든 데이터 변경은 트랜젝션 안에서 실행해야 한다.
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {


            Member member1 = new Member();
            member1.setId(4L);
            member1.setUsername("KKK");


            //검색
            // Member findMember = em.find(Member.class, 4L); // 가장 단순한 조회 방법
            // <-> 검색, 조건이 필요한 경우 JPQL 이용

            //JPQL 테이블이 아닌 객체를 대상으로 하는 객체지향쿼리
            //대상이 테이블이 아니라 Member 객체를 대상으로 가져온다.
            //JPQL 을 이용하면 페이징처리도 쉽게 가능하다. .setFirstResult() .setMaxResults() 이용
            List<Member> resultList = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(10)
                    .getResultList();

            //iter~ 치면 자동으로 나온다.
            for (Member member : resultList) {
                System.out.println("member.name = " + member.getUsername());
            }


            //수정
            //findMember.setName("김근본");

            //삭제
            //em.remove(findMember);

            // em.persist(member);
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            //내부적으로 데이터베이스 커넥션을 물고 동작하기 때문에 닫아주는게 중요하다.
            //이게 정석적인 코드지만 스프링을 이용하면 알아서 스프링이 다 해준다.
            em.close();
        }
        emf.close();
    }
}
