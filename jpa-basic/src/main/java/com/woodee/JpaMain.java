package com.woodee;

import com.woodee.data.Member;
import com.woodee.data.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            //Member member = new Member();
            //member.setUsername("새로운테스트");

            Movie movice = new Movie();
            movice.setActor("aaa");
            movice.setDirector("bbb");
            movice.setName("토이 스토리");
            movice.setPrice(10000);
            em.persist(movice);

            // 영속성 캐시 지우기
            em.flush();
            em.close();

            Movie findMovie = em.find(Movie.class, movice.getId());
            //soutv 쓰면 한번에 가져올 수 있다.
            System.out.println("findMovie = " + findMovie);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        em.close();;
    }
}
