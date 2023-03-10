package hellojpa;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			// 회원 등록
			/*Member member = new Member();
			member.setId(1L);
			member.setUsername("HelloA");
			Member member2 = new Member();
			member2.setId(2L);
			member2.setUsername("HelloB");
			em.persist(member);
			em.persist(member2);

			// 회원 조회 및 수정
			Member findMember = em.find(Member.class, 1L);
			// System.out.println(findMember);
			findMember.setUsername("HelloJPA");

			// JPQL
			List<Member> result = em.createQuery("select m from Member m", Member.class)
				.setFirstResult(0)
				.setMaxResults(10)
				.getResultList();
			System.out.println(result);

			// 회원 삭제
			Member findMember2 = em.find(Member.class, 1L);
			em.remove(findMember2);*/



			// 엔티티를 생성한 상태 (비영속)
			/*Member member = new Member();
			member.setId(101L);
			member.setName("HelloJPA");

			// 엔티티를 영속 (DB에 저장되지 않는다. 쿼리가 여기서 나오지 않는다.)
			System.out.println("=== BEFORE ===");
			em.persist(member);
			System.out.println("=== AFTER ===");

			Member findMember = em.find(Member.class, 101L); // 1차 캐시에서 조회.
			System.out.println(findMember);

			Member findMember1 = em.find(Member.class, 101L); // 데이터베이스에 조회 -> 1차 캐시에 저장
			Member findMember2 = em.find(Member.class, 101L); // 1차 캐시에서 조회

			System.out.println(findMember1 == findMember2); // true, 영속 엔티티의 동일성 보장.

			// 쓰기 지연
			Member member1 = new Member(150L, "A");
			Member member2 = new Member(160L, "B");
			em.persist(member1);
			em.persist(member2);
			// 여기까지 INSERT SQL을 데이터베이스에 보내지 않는다.
			System.out.println("==========================");
			// 커밋하는 순간 데이터베이스에 INSERT SQL을 보낸다.

			// 변경 감지
			Member member = em.find(Member.class, 150L);
			member.setUsername("ZZZZZ");
			System.out.println("==========================");*/

			// 플러시
			/*
			Member member = new Member(200L, "member200");
			em.persist(member);
			em.flush();

			System.out.println("======================");
			 */

			// detach
			/*
			Member member = em.find(Member.class, 150L);
			member.setUsername("AAAAA");

			// em.detach(member);
			em.clear();
			Member member2 = em.find(Member.class, 150L);
			 */

			// MappingMain
			/*Member member = new Member();
			member.setId(1L);
			member.setUsername("A");
			member.setRoleType(RoleType.USER);
			em.persist(member);

			Member member2 = new Member();
			member2.setId(2L);
			member2.setUsername("B");
			member2.setRoleType(RoleType.ADMIN);
			em.persist(member2);*/

			// 	@Enumerated(EnumType.STRING) String 으로 써야 하는 이유.
			// Ordinal일 경우 새로 앞에 추가된 GUEST와 USER가 같은 0 값을 갖게 된다.
			// 그리고 전체적인 순서가 뒤죽박죽되어 데이터가 엉킬 수 있음.
			/*Member member3 = new Member();
			member3.setId(3L);
			member3.setUsername("C");
			member3.setRoleType(RoleType.GUEST);
			em.persist(member3);*/

			// 기본 키 매핑 전략
			// MEMBER 엔티티 변경 (간단히)
			/*Member member = new Member();
			member.setUsername("A");

			System.out.println("======================");

			em.persist(member);

			System.out.println(member);
			System.out.println("======================");*/

			/*Member member1 = new Member();
			member1.setUsername("A");

			Member member2 = new Member();
			member2.setUsername("B");

			Member member3 = new Member();
			member3.setUsername("C");

			System.out.println("======================");
			em.persist(member1);
			em.persist(member2);
			em.persist(member3);

			System.out.println(member1);
			System.out.println(member2);
			System.out.println(member3);
			System.out.println("======================");*/

			/*Team team = new Team();
			team.setName("TeamA");
			em.persist(team);

			Member member = new Member();
			member.setUsername("member1");
			// member.setTeamId(team.getId());
			// 단방향 연관관계 사용.
			member.setTeam(team);
			em.persist(member);

			em.flush();
			em.clear();

			Member findMember = em.find(Member.class, member.getId());
			// 객체를 테이블에 맞추어 데이터 중심 모델링으로 인한 문제점.
			// Long findTeamId = findMember.getTeamId();
			// Team findTeam = em.find(Team.class, findTeamId);

			// 단방향 연관관계 사용 조회
			// Team findTeam = findMember.getTeam();
			// System.out.println(findTeam);
			List<Member> members = findMember.getTeam().getMembers();
			for (Member m : members) {
				System.out.println("m = " + m.getUsername());
			}*/

			// 양방향 매핑시 가장 많이 하는 실수.
			// 연관관계의 주인에 값을 입력하지 않음.
			/*Member member = new Member();
			member.setUsername("member1");
			em.persist(member);

			Team team = new Team();
			team.setName("TeamA");
			team.getMembers().add(member);
			em.persist(team);*/
			/*Team team = new Team();
			team.setName("TeamA");
			em.persist(team);

			Member member = new Member();
			member.setUsername("member1");
			member.setTeam(team);
			em.persist(member);

			// team.getMembers().add(member);
			team.addMember(member);

			em.flush();
			em.clear();

			Team findTeam = em.find(Team.class, team.getId());
			List<Member> members = findTeam.getMembers();
			for (Member m : members) {
				System.out.println("m = " + m.getUsername());
			}*/

			/*Member member = new Member();
			member.setUsername("member1");

			em.persist(member);

			Team team = new Team();
			team.setName("teamA");
			team.getMembers().add(member);
			em.persist(team);*/

			/*Member member = new Member();
			member.setUsername("User1");
			member.setCreatedBy("KIM");
			member.setCreatedDate(LocalDateTime.now());
			em.persist(member);*/

			// 프록시
			/*Member member = new Member();
			member.setUsername("hello");

			em.persist(member);

			em.flush();
			em.clear();

			// Member findMember = em.find(Member.class, member.getId());
			Member findMember = em.getReference(Member.class, member.getId());
			*//*System.out.println("findMember = " + findMember.getClass());
			System.out.println("findMember.id = " + findMember.getId());
			System.out.println("findMember.userName = " + findMember.getUsername());
			System.out.println("findMember.userName = " + findMember.getUsername());*//* // 두 번째 호출시 select 쿼리가 나가지 않고 조회 가능

			System.out.println("before findMember = " + findMember.getClass());
			System.out.println("findMember.username = " + findMember.getUsername());
			System.out.println("after findMember = " + findMember.getClass()); // 변하지 않는다.*/

			/*Member member1 = new Member();
			member1.setUsername("member1");
			em.persist(member1);

			Member member2 = new Member();
			member2.setUsername("member2");
			em.persist(member2);

			em.flush();
			em.clear();

			Member m1 = em.find(Member.class, member1.getId());
			*//*Member m2 = em.find(Member.class, member2.getId());
			System.out.println("m1 == m2 :" + (m1.getClass() == m2.getClass())); *//*// true
			Member m2 = em.getReference(Member.class, member2.getId());
			System.out.println("m1 == m2 :" + (m1.getClass() == m2.getClass())); // false
			// 타입 비교는 == 이 아닌 instanceof 를 사용*/

			/*Member member = new Member();
			member.setUsername("member");
			em.persist(member);

			em.flush();
			em.clear();*/

			/*Member m1 = em.find(Member.class, member.getId());
			System.out.println("m1 = " + m1.getClass()); //m1 = class hellojpa.Member

			Member reference = em.getReference(Member.class, member.getId());
			System.out.println("reference.getClass() = " + reference.getClass()); // reference.getClass() = class hellojpa.Member
			// reference도 엔티티 반환
			System.out.println("m1 == reference : " + (m1 == reference)); // true*/

			/*Member m1 = em.getReference(Member.class, member.getId());
			System.out.println("m1.getClass() = " + m1.getClass());
			Member m2 = em.getReference(Member.class, member.getId());
			System.out.println("m2.getClass() = " + m2.getClass());

			System.out.println("(m1 == m2) = " + (m1 == m2)); // true*/


			/*Member refMember = em.getReference(Member.class, member.getId());
			System.out.println("refMember.getClass() = " + refMember.getClass());

			Member findMember = em.find(Member.class, member.getId()); // 프록시로 반환됨.. 위에서 프록시로 반환을 했기 때문에
			System.out.println("findMember.getClass() = " + findMember.getClass());

			System.out.println("(refMember == findMember) = " + (refMember == findMember));*/ // true

			/*Member refMember = em.getReference(Member.class, member.getId());
			System.out.println("refMember.getClass() = " + refMember.getClass());
			System.out.println("isLoaded=" + emf.getPersistenceUnitUtil().isLoaded(refMember)); // false
			// refMember.getUsername(); // 강제 초기화 무식한 방법.
			Hibernate.initialize(refMember); // 강제 초기화
			System.out.println("isLoaded=" + emf.getPersistenceUnitUtil().isLoaded(refMember)); // true

			// em.detach(refMember);
			em.clear();
			System.out.
			println("refMember.getUsername() = " + refMember.getUsername()); // could not initialize proxy*/

			/*Team team = new Team();
			team.setName("teamA");
			em.persist(team);
			Team teamB = new Team();
			teamB.setName("teamB");
			em.persist(teamB);

			Member member = new Member();
			member.setUsername("member1");
			member.setTeam(team);
			em.persist(member);

			Member member2 = new Member();
			member2.setUsername("member2");
			member2.setTeam(teamB);
			em.persist(member2);

			em.flush();
			em.clear();

			Member m = em.find(Member.class, member.getId());
			List<Order> orders = m.getOrders();
			System.out.println("orders = " + orders.getClass().getName());*/

			// 즉시 로딩일 때 N + 1 문제 발생.
			// List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class)
			// 	.getResultList();

			// 영속성 전이 (CASCADE) 예제 시작
			Child child1 = new Child();
			Child child2 = new Child();
			Parent parent = new Parent();
			parent.addChild(child1);
			parent.addChild(child2);

			// 영속성 전이 사용 전... persist()를 3번 호출해 주어야 한다.
			em.persist(parent);
			em.persist(child1);
			em.persist(child2);

			// 영속성 전이 사용 후
			// em.persist(parent);

			em.flush();
			em.clear();

			Parent findParent = em.find(Parent.class, parent.getId());
			// findParent.getChildList().remove(0);
			em.remove(findParent);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();
	}
}
