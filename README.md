# cafe-ordering-system

## 프로젝트 소개
- 디자인 패턴을 적용해 카페 주문 시스템을 주제로 토이 프로젝트를 완성합니다.
- 언어는 Java를 이용하며, 아래 패턴을 적용할 예정입니다.
    - 반복자 패턴
    - 데코레이터 패턴
    - 템플릿 메소드 패턴
    - Null Object 패턴

<br/>

> 여러 디자인 패턴을 공부하며 정리한 자료는 [링크](https://github.com/2dongyeop/design-pattern)를 통해 확인 수 있습니다.

<br/>

### 진행 상황
#### 💡 22/10/09
- `NoCommand` 클래스를 만들어 `Null Object 패턴`을 적용하여, 안정성을 높입니다.
- 음료의 옵션과 사이즈에 대한 데코레이터 및 팩토리를 구현하였습니다.
- 

<br/>

#### 💡 22/10/08
- 카페 주문 시스템의 기본 로직을 설계합니다.
- 메뉴를 주문하기 전, [인증 과정](https://github.com/2dongyeop/cafe-ordering-system/blob/main/src/userInterface/userAuthentication/AuthProcess.java)을 추가하였습니다.
  - 현재 로그인을 이용한 회원 주문과 비회원 주문을 구현하였습니다.
  - 로그인 과정 중 발생하는 예외는 [사용자 예외](https://github.com/2dongyeop/cafe-ordering-system/tree/main/src/userInterface/applicationException)를 만들어 사용합니다.