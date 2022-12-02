# RentCarProject

<div align=center>
  <img src="https://capsule-render.vercel.app/api?type=waving&color=EE6983&height=200&section=header&text=RentCar&fontSize=90&fontColor=FFF5E4" />

  <h2> :star: 주제 :star: </h2>
  <h3> 렌트카 대여 서비스 </h3><br><br> 

<br> <br>

  <h2> :heavy_check_mark: Features :heavy_check_mark: </h2>
  <h4> 각 페이지 별 핵심 기능 </h4> <br><br>
  
  구분|기능 &nbsp;| 설명
  ---|--- |---
  [일반사용자] |회원가입| 각 입력에 따른 유효성 검사를 실시<br>비밀번호 확인이 틀리면 회원가입 실패하도록 처리
  &nbsp;|로그인/로그아웃| LoginDto를 이용해서 로그인 상태 유지 및 로그아웃 구현
  &nbsp;|아이디(운전면허증번호) 찾기| 이름과 전화번호를 입력해서 아이디(운전면허증번호) 찾기
  &nbsp;|비밀번호 찾기| 아이디(운전면허증번호)와 이메일을 입력해서 비밀번호 찾기
  &nbsp;|렌탈대여 | 대여 중이지 않은 렌트카의 목록을 보여주고 대여되도록 구현
  &nbsp;|렌탈반납| 사용자가 현재 대여 중인 렌트카의 목록을 보여주고 반납하도록 구현
  &nbsp;|내 정보 확인| 현재 로그인 중인 사용자의 정보 호출
  [관리자]|차량등록 | 새로운 차량을 등록
  &nbsp;|차량목록 조회| 전체 차량 목록 조회
  &nbsp;|대여현황 조회 | 현재 대여 중인 전체 차량 목록 조회
  &nbsp;|매출현황 | 매출현황을 가시적으로 한 눈에 볼 수 있도록 구현
  &nbsp;|차량삭제 | 등록되어 있는 차량 삭제 로직 구현
  
  <br><br>
  
  <h2> :calendar: 일정 계획 :calendar: </h2>
   <br>
   
   날짜 &nbsp; | 구현내용
  --- |---
  8/30| 프로젝트 생성 및 MVC 구조 틀 잡기
  8/31| 회원가입 구현 중
  9/1|	유효성 검사 구현 완료
  9/2|	회원가입 구현 완료 / 로그인 구현 완료 / 아이디 찾기 / 비밀번호 찾기  구현 완료
  9/5|	관리자의 차량등록 구현 완료 / 로그인 유지 / 로그아웃 구현 완료
  9/6|	렌탈대여 구현 완료 / 일반 사용자와 관리자 안내 메시지 및 메뉴 메소드로 구분
  9/7|	렌탈대여, 차량등록 테스트 및 피드백
  9/8|	차량DB수정(차량반납여부 컬럼 추가) 및 SQL문 수정/<br> 로그인 후 회원가입 선택 시 로그아웃할건지 물어보는 루트로 수정/ <br>대여 시, 대여상태 '대여중' 으로 insert/ <br>대여 시, 차량테이블에서 차량반납여부 대여중으로 변경
  9/10|	렌탈대여 전에 대여가능 차량 목록 조회 기능 추가
  9/11|	렌탈반납, 렌탈현황 조회 구현 완료
  9/13|	매출현황 기능 추가/ 대여하지 않은 사용자가 렌탈반납 누를 경우 안내 메시지 출력
  9/14|	내정보 구현 완료 / 차량삭제 구현 완료 / controller 유지보수
   
<br><br>

  <h2> :hammer: Tools :hammer:: </h2>
  <h4> <img src="https://img.shields.io/badge/IntelliJ-2C2255?style=flat-square&logo=IntelliJ&logoColor=white"/> <img src="https://img.shields.io/badge/git-24292F?style=flat-square&logo=github&logoColor=white"/> </h4> <br><br>
  
  <h2> :blossom: 사용한 Skill :blossom: </h2>
  <h4> <img src="https://img.shields.io/badge/JAVA-007396?style=flat-square&logo=java&logoColor=white"/> <img src="https://img.shields.io/badge/MySQL-4479a1?style=flat-square&logo=mysql&logoColor=white"/> </h4> <br><br>
  
  <h2> :round_pushpin: 추후 발전 방향 :round_pushpin: </h2>
  1. 세션 유지를 위해 static을 사용했지만, 추후에 반드시 보안 처리가 필요<br>
  2. 이번 Java Console 프로젝트는 개인 프로젝트라 규모를 축소해서 대여와 차량, 고객 DB에 집중하여 개발했는데,<br> 추후에는 프로젝트를 확장하여 결제와 보험 등의 DB도 활용할 수 있는 응용 프로그램을 개발하면 좋을 것 같다<br>
  3. Httpsession으로 세션 ID를 담고 있는 쿠키를 생성하고, 클라이언트에게 전달하는 방식으로 세션 유지를 하면 좋을 것 같다<br>
</div>
