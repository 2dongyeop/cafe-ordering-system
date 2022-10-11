# cafe-ordering-system

## 프로젝트 소개
- 디자인 패턴을 적용해 카페 주문 시스템을 주제로 토이 프로젝트를 완성합니다.
- 언어는 Java를 이용하며, 아래 패턴을 적용할 예정입니다.
    - 반복자 패턴
    - 데코레이터 패턴
    - 템플릿 메소드 패턴
    - Null Object 패턴

<br/>

> 여러 디자인 패턴을 공부하며 정리한 자료는 [링크](https://github.com/2dongyeop/design-pattern)를 통해 확인하실 수 있습니다.

<br/>

<br/>

### 트랜잭션 과정 및 클래스 다이어그램
<details>
<summary> 이미지 보기 </summary>
<div markdown="1">       

- 트랜잭션 과정

  <img src="https://github.com/2dongyeop/cafe-ordering-system/blob/main/image/transaction-diagram.png" width = 500/>

<br/>

<br/>

- 클래스 다이어그램

  <img src="https://github.com/2dongyeop/cafe-ordering-system/blob/main/image/class-diagram.png" width = 500/>


</div>
</details>


<br/>

<br/>

### 진행 상황
#### 💡 22/10/11
- 메뉴를 추천해주는 기능을 구현하였습니다.
  - 추천 메뉴는 누적 판매량을 기준으로 하지 않고, 랜덤으로 메뉴를 고르도록 하였습니다.

<br/>

#### 💡 22/10/10 
- 트랜잭션 및 클래스 다이어그램을 그려 첨부하였습니다.

<br/>

#### 💡 22/10/09
- `NoCommand` 클래스를 만들어 `Null Object 패턴`을 적용하여, 안정성을 높였습니다.
- 코드를 객체지향에 맞게 수정하기 위해 [메뉴 선택 과정](https://github.com/2dongyeop/cafe-ordering-system/blob/main/src/userInterface/orderProcess/OrderProcess.java)을 MainUI로부터 분리하였습니다.
  - 선택이 이루어질 경우마다 **데코레이터 및 팩토리**를 이용해 음료를 구현하였습니다.
- 여러 음료들의 주문 결과를 출력할 때 **반복자 패턴**을 이용합니다.

<br/>

#### 💡 22/10/08
- 카페 주문 시스템의 기본 로직을 설계합니다.
  - **템플릿 메소드 패턴**을 이용하여 메뉴 선택 과정을 일련의 메소드로 묶었습니다.
- 메뉴를 주문하기 전, [인증 과정](https://github.com/2dongyeop/cafe-ordering-system/blob/main/src/userInterface/userAuthentication/AuthProcess.java)을 추가하였습니다.
  - 현재 로그인을 이용한 회원 주문과 비회원 주문을 구현하였습니다.
  - 로그인 과정 중 발생하는 예외는 [사용자 예외](https://github.com/2dongyeop/cafe-ordering-system/tree/main/src/userInterface/applicationException)를 만들어 사용합니다.