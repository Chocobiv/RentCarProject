# RentCarProject

<div align=center>
  <img src="https://capsule-render.vercel.app/api?type=waving&color=EE6983&height=200&section=header&text=RentCar&fontSize=90&fontColor=FFF5E4" />

  <h2> :star: 주제 :star: </h2>
  <h3> 렌트카 대여 서비스 </h3><br><br> 

<br> <br>

  <h2> :heavy_check_mark: Features :heavy_check_mark: </h2>
  <h4> 각 페이지 별 핵심 기능 </h4> <br><br>
  
  기능 &nbsp;| 설명
  --- |---
  회원가입| 각 입력에 따른 유효성 검사를 실시
  &nbsp;| 비밀번호 확인이 틀리면 회원가입 실패하도록 처리
  로그인/로그아웃| LoginDto를 이용해서 로그인 상태 유지 및 로그아웃 구현
  아이디(운전면허증번호) 찾기| 이름과 전화번호를 입력해서 아이디(운전면허증번호) 찾기
  비밀번호 찾기| 아이디(운전면허증번호)와 이메일을 입력해서 비밀번호 찾기
  &nbsp;| 로고 position: absolute 사용
  예약| javascript에서 시간과 날짜를 표현하는 객체를 사용하여 <br>배열과 객체 불러오기 이용
  &nbsp;| 4자리 년도
  &nbsp;| 월 [0~11] (※ 0 = 1월)
  메뉴| menupage.html|  flex | menu_content 하위요소 가로배치
  &nbsp;|&nbsp; |  justify-content | 하위요소 정렬 (가운데 일정하게 공간 만들어줌)
  &nbsp;|&nbsp; |  flex | 메뉴 리스트 가로배치
  &nbsp;|&nbsp; |  border | 글자 밑에 border 넣어서 밑줄 표현
  &nbsp;|&nbsp; |  outline, outline-offset | 메뉴판에 outline 과 outline-offset 사용한 경계선 넣어 넓어 보이게 표현
  &nbsp;|&nbsp; |  padding | 각 li에 padding 줘서 간격 부여
  
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
  1. 반응형 웹페이지로 업그레이드<br>
  2. js추가해서 유효성 검사<br>
  3. 회원가입/로그인/문의하기 백엔드 기능 추가<br>
  4. 실시간 챗봇 예약상담<br>
  5. 2단 레이아웃을 사용하여 공간을 활용하고 사용자의 편의성을 증가<br>
  6. 커스터마이징을 사용하여 서브메뉴 추가<br>
</div>
