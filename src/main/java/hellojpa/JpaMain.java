package hellojpa;

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
//            플러시: 영속성 컨텍스트의 변경 내용을 DB에 반영(=영속성 컨텍스트에 쌓인 쿼리를 DB에 날려주는 과정)
//            플러시 발생
//            변경 감지 / 수정된 엔티티 쓰기 지연 SQL 저장소에 등록 / 쓰기 지연 SQL 저장소의 쿼리를 데이터베이스에 전송(CUD쿼리)
//            영속성 컨텍스트를 플러시 하는 방법: 1. 직접호출-em.flush() / 2. 트랜잭션 커밋-플러시 자동 호출 / 3. JPQL 쿼리 실행-플러시 자동 호출
//                Member member = new Member(220L, "User200");
//                em.persist(member);
//                커밋 이전에 flush를 이용해서 DB에 쿼리를 날려준다. 그럼 출력문 사이에 insert문이 실행되게 된다.
//                System.out.println("flush 이전---------------");
//                em.flush(); //flush를 해도 1차 캐시는 유지가 된다
//                System.out.println("flush 이후---------------");

//                플러시는 1. 영속성 컨텍스트를 비우지 않음 2.영속성 컨텍스트의 변경내용을 DB에 동기화 3. 트랜잭션이라는 작업 단위가 중요 => 커밋직전에만 동기화하면됨


//            준영속 상태
//            영속 => 준영속 / 영속상태의 엔티티가 영속성 컨텍스트에서 분리(detached) / 영속성 컨텍스트가 제공하는 기능을 사용 못함
//              Member member = em.find(Member.class, 220L);
//              member.setName("AAAA");
//              em.detach(member); //준영속 상태(=영속성 컨텍스트에서 분리) 되기 때문에 커밋을 할때 update쿼리가 실행되지 않는다.(특정 엔티티만 준영속 상태로 만듦)
//              em.clear(); //엔티티매니저에 있는 영속성 컨텍스트의 엔티티를 다 지워버린다.
//              em.close(); //영속성 컨텍스트를 종료해버림
//              System.out.println("준영속상태 실행");
//
//
//                tx.commit();
//        트랜잭션을 커밋할때 쿼리가 날라간다. 이때 쿼리가 콘솔창에 찍히게 되는것이다.
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

















    }
}
