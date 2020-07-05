package jpabook.shop;

import jpabook.shop.domain.Book;

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
            //1.주문
            //Order order = new Order();
            //연관관계 메서드
            //order.addOrderItem(new OrderItem());

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김영한");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}

