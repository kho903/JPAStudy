# mappedBy는 언제 쓸까요?
- 연관관계의 주인인 아닌 곳에 mappedBy 속성으로 주인이 아님을 설정한다.
- 값으로는 연관관계의 주인 필드를 적어주면 된다.
- 연관관계의 주인만 DB 연관관계와 매핑되고 외래 키를 관리한다. 주인이 아닌 반대편에서는 읽기만 가능하고 외래 키 변경 불가.

# 연관관계의 주인은 어디있어야 할까요?
- 연관관계의 주인은 테이블에 외래 키가 있는 곳으로 정해야 한다. 여기서는 회원 테이블이 외래 키를 가지고 있으므로 Member.team이 주인이 된다. 주인이 아닌 Team.members 에는 mappedBy="team" 속성을 사용해 주인이 아님을 설정한다.
- 그리고 mappedBy 속성의 값으로는 연관관계의 주인인 team을 주면 된다. 여기서 mappedBy의 값으로 사용된 team은 연관관계의 주인인 Member 엔티티의 team 필드를 말함.

# 양방향 매핑시 무한루프에 빠지게 되는 경우에 대한 예를 말씀해 주세요.
- 예를들어 Member에서 team을 참조하고 team에서 member를 참조하는 예가 있다면 Member.toString()에서 getTeam(),
Team.toString()에서 getMember() 호출시 무한 루프에 빠지게 됩니다.
- 이런 문제는 보통 JSON 으로 변환시 자주 일어나는데, 어노테이션이나 기능들을 제공해서 방지할 수 있다.
