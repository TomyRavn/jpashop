package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

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

        try{

            /** 객체지향스럽지 못하다 => 관계형 DB에 맞춘 설계
            * em.find(Order.class, 1L);
            * Long memberId = order.getMemberId();
            *
            * em.find(Member.class, memberId);
             */

            /**
             *  Member member = order.getMember();
             *  와 같은 형식으로 바로 받을 수 있어야 객체지향
             */

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
