## 회원관리 웹 애플리케이션 요구사항 정리

### 기능 요구사항
> - 회원 도메인 생성
>   - 이름: username 나이: age
> - 회원 저장
> - 회원 목록 조회


#### 서블릿으로 회원 관리 웹애플리케이션 만들기
> - MemberFormServlet - 회원 등록 폼(http://localhost:8080/servlet/members/new-form)
>   - 단순하게 회원 정보를 입력할 수 있는 HTML Form을 만들어서 응답
> - MemberSaveServlet - 회원 저장(http://localhost:8080/servlet/members/new-form)
>   - 동작순서
>     - 1.파라미터를 조회해서 Member 객체 생성
>     - 2.Member 객체를 MemberRepository를 통해 저장
>     - 3.Member 객체를 사용해서 결과 화면용 HTML을 동적으로 만들어서 응답
> - MemberListServlet - 회원 목록(http://localhost:8080/servlet/members)
>   - 동작순서
>     - memberRepository.findAll() 을 통해 모든 회원을 조회
>     - 회원 목록 HTML을 for 루프를 통해서 회원 수 만큼 동적으로 생성하고 응답
> - 서블릿과 자바코드 만으로 Html을 만들게 될 경우 코드에서 볼 수 있듯이 매우 복잡하고 비효율적
> - HTML 문서에 동적으로 변경해야 하는 부분만 자바 코드를 넣을 수 있는 것이 효율이 좋음
> - 템플릿 엔진을 사용하면 HTML 문서에서 필요한 곳만 코드를 적용해서 동적으로 변경할 수 있음
> - (템플릿 엔진 종류 : JSP, Thymeleaf, Freemarker, Velocity 등)
