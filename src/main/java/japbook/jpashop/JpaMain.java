package japbook.jpashop;


import japbook.jpashop.domain.Book;
import japbook.jpashop.domain.Member;
import japbook.jpashop.domain.Order;
import japbook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    private EntityManager em;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("sims");

            em.persist(book);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        // 엔티티 메니저를 꼭 닫아주어야 한다 .. 사실은 이런 코드가 없어질 것이다 스프링이 다 관리해주어서


        //code 코드를 항상 닫아 주어야 한다. 실제로 디비에 저장하는 트랜젝션은 ?? 디비 컬렉션을 얻어서 일관적인 엔티티 메니저를
        // 꼭 만들어 줘야한다.

        emf.close();


    }
}
