package com.woodee.example;


import com.woodee.data.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ExampleFlush {
    /*public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Member member = new Member(5L,"member5");

            // 영속성 컨텍스트 안에 쿼리가 담긴다.
            em.persist(member);

            em.flush();
            // 플러시 를 이용하면 commit 하는 시점이 아니라 플러쉬를 하는 시점에 쿼리가 나간다.

            System.out.println("======================");

            //기본적으로 플러시를 하고 커밋을 한다.
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
            emf.close();


    }*/
}
