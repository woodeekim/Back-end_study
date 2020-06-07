package com.woodee.example;

import com.woodee.RoleType;
import com.woodee.data.OldMember;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ExampleMapping {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            OldMember oldMember = new OldMember();
            oldMember.setUsername("허허");
            oldMember.setAge(28);
            oldMember.setRoleType(RoleType.GUEST);

            /*
            * 기본키 전략이 SEQUENCE 일 때 em.persist() 가 먼저 호출되지 않고 db 에서 id 값을 가져온 뒤 실행한다.
            * 밑에 결과를 보면 알 수 있음.
            * - 영속성 컨텍스트에 넣으려고 보니까, 어? 시퀀스 전략인네 하고 DB 에게 값 얻어와야겠네, 이후 member 에 id 값을 넣어준다.
            *   그리고 마지막에 영속성 컨텍스트에 저장한다. 그리고 실제 DB 에는 안들어가고 tx.commit 하는 시점에 DB 에 들어가게 된다.
            * ===============
            * (다음이 tx.commit 하는 시점)
            Hibernate:
                call next value for MEMBER_SQL
            member.getId : 5
            ===============
            Hibernate:
                insert com.woodee.data.Member
                    insert into Memer(~~
            *
            *
            *
            * */

            System.out.println("===============");
            em.persist(oldMember);

            //
            System.out.println("member.getId : "+ oldMember.getId());
            System.out.println("===============");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

}
