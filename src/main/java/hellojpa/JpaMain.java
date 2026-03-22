package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    //모든 jpa 변경은 트랜잭션 안에서 실행헤야함
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //이 사이에 code를 작성
        try {
//            Member findMember = em.find(Member.class, 1L);
//            List<Member> findMembers =
//                    em.createQuery("SELECT m from Member as m",Member.class)
//                            .setFirstResult(5)
//                            .setMaxResults(8)
//                            .getResultList();
//
//            for (int i = 0; i < findMembers.size(); i++) {
//                System.out.println(findMembers.get(i).getName());
//            }

            //비 영속 상태
            Member member = new Member();
            member.setId(4L);
            member.setName("HelloJpa");

            //영속 상태
            //객체가 영속성 컨텍스트에 들어가서 관리됨
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== After ===");

            Member find = em.find(Member.class, 4L);
            Member find2 = em.find(Member.class, 4L);
            //영속성 컨텍스트에 객체가 없는경우 db에서 조회한 뒤 영속성 컨텍스트에 저장
            System.out.println(find.getName());
            //영속성 컨텍스트에 있는 경우 그것을 가져옴(1차 캐시)
            System.out.println(find2.getName());
            //영속 엔티티의 동일성 보장
            System.out.println(find == find2);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
