# RentCarProject

<div align=center>
  <img src="https://capsule-render.vercel.app/api?type=waving&color=EE6983&height=200&section=header&text=RentCar&fontSize=90&fontColor=FFF5E4" />


DTO용도/사용이유
MVC구조
로그인 유지?? 


회원가입
유효성 검사
로그인/로그아웃
아이디 찾기, 비밀번호 찾기
대여가능 차량 목록 조회
렌탈대여/반납
내정보???
관리자페이지 - 차량등록, 렌탈현황 조회, 매출현황, 차량삭제

  <h2> :star: 주제 :star: </h2>
  <h3> 렌트카 대여 서비스 </h3><br><br> 

  <h2> :pushpin: Overview :pushpin: </h2>
  <h4> 첫째. 다양한 레이아웃을 이용한 페이지에 수업 시간에 배운 기능을 다양하게 활용해 볼 수 있을 것 같아서</h4>
  <h4> 둘째. SNS와 블로그로 식당 예약, 메뉴, 리뷰 등을 볼 수 있기는 하지만, <br> 홈페이지를 제작하여 이용자들의 접근성을 높이고
        예약과 메뉴를 한번에 볼 수 있도록 가시성을 높이기 위해서</h4>
  <h4> 셋째. 성장하는 한국의 외식 플랫폼을 만들어 보고싶다</h4>
  <h4> 넷째. 고급스러운 분위기의 웹페이지를 만들어 보고싶다</h4> <br>
</div>
<br> <br>


<div align=center>
  <h2> :heavy_check_mark: Features :heavy_check_mark: </h2>
  <h4> 각 페이지 별 핵심 기능 </h4> <br><br>
  
  페이지명 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 파일명 | 핵심 기능 | 설명
  --- |---|---|---
  메인| 레스토랑소개.html | a | 로그인 / 회원가입 버튼 생성, 메인 , 예약, 메뉴, 팀원, 갤러리, 문의사항 버튼 생성
  &nbsp;| &nbsp;| 마우스 이벤트 | 헤더 메뉴들 hover시 이벤트 지정
  &nbsp;| &nbsp;| text-decoration: none | 링크 밑줄제거
  &nbsp;| &nbsp;| 웹 폰트 | 한글에 눈누, 영문에 구글폰트 사용
  &nbsp;| &nbsp;| position | 로고 position: absolute 사용
  예약| 팀프로젝트1_달력.html | new Date() | javascript에서 시간과 날짜를 표현하는 객체를 사용하여 <br>배열과 객체 불러오기 이용
  &nbsp;|&nbsp; |  new Date().getFullYear() | 4자리 년도
  &nbsp;| &nbsp;| new Date().getMonth() | 월 [0~11] (※ 0 = 1월)
  &nbsp;| &nbsp;| new Date().getDate() | 일
  &nbsp;| &nbsp;| new Date().getDay() | 요일[0~6] (※ 0 = 일요일)
  메뉴| menupage.html|  flex | menu_content 하위요소 가로배치
  &nbsp;|&nbsp; |  justify-content | 하위요소 정렬 (가운데 일정하게 공간 만들어줌)
  &nbsp;|&nbsp; |  flex | 메뉴 리스트 가로배치
  &nbsp;|&nbsp; |  border | 글자 밑에 border 넣어서 밑줄 표현
  &nbsp;|&nbsp; |  outline, outline-offset | 메뉴판에 outline 과 outline-offset 사용한 경계선 넣어 넓어 보이게 표현
  &nbsp;|&nbsp; |  padding | 각 li에 padding 줘서 간격 부여
  팀원| 팀원소개하기.html | a | 로그인 / 회원가입 페이지 이동 버튼 생성, 메인, 예약, 메뉴, 팀원, 갤러리, 문의사항 각 이동 페이지 메뉴버튼 생성
  &nbsp;|&nbsp; | border-radius | Exceutive Chef&Owner , Chef de Cuisine , Pastry Chef, General Manager , Sommelier 각 이미지 둥글게 표현
  &nbsp;| &nbsp;| shape-outside:circle() | 원형 이미지 형태에 맞춰 텍스트를 감싸며 배치  
  &nbsp;| &nbsp;| background-image | 이미지 삽입 
  &nbsp;| &nbsp;| background-repeat | 이미지 자동채우기 제거
  &nbsp;| &nbsp;| background-position | 이미지 배경 위치 설정
  &nbsp;| &nbsp;| text-decoration : none | a태그 링크 밑줄제거
  &nbsp;| &nbsp;| text-align | 팀원소개 헤더 가운데 배치
  &nbsp;| &nbsp;| shape-outside:circle() | 원형 이미지 형태에 맞춰 텍스트를 감싸며 배치 
  &nbsp;| &nbsp;| font-weight | 팀원 이름 폰트 굵게 설정
  &nbsp;| &nbsp;| line-height | 팀원 소개글 줄간격 설정
  갤러리| gallery.html | 아이콘 폰트 | 페이지네이션에 활용
  &nbsp;| &nbsp;| position | 이미지들어간 td에 position 설정해서 하위태그인 div에 absolute로 위치 조정
  &nbsp;| &nbsp;| 마우스 이벤트 | js에서 테이블에 마우스이벤트 설정해 img들어간 공간에 mouseover , mouseout 했을때 각각 div.style.display: block과 div.style.display: none 실행되도록 설정
  &nbsp;| &nbsp;| box-shadow | 각 이미지에 box-shadow 넣어 보더 넣지않고 경계 느껴지게 표현
  &nbsp;| &nbsp;| opacity | a 태그에 opacity 넣어 마우스 올리면 흐려지게 표현
  &nbsp;| &nbsp;| addEventListener | mouseout 이벤트 생성
  &nbsp;| &nbsp;| addEventListener | mouseover 이벤트 생성
  &nbsp;| &nbsp;| forEach | 이미지 js로 문서객체로 가져올때 forEach 사용해 인덱스 가져와 이미지의 인덱스와 div의 인덱스가 같을때 각각 .style.display: block과 div.style.display: none 이 실행되도록 설정
  문의사항| customer_re.html | document.getElementById | 문의사항 표에 있는 input에 입력한 데이터를 아래 표시되도록  기능 부여
  &nbsp;&nbsp;|&nbsp; | document.getElementById | 출력된 데이터 클릭하면 옆에 문의사항의 제목과 내용만 출력되도록 설정
  &nbsp;|&nbsp; | querySelector | html 요소 문서객체로 가져왔다
  &nbsp;|&nbsp; | &nbsp; | 버튼 누르면 입력된 값 저장 설정
  &nbsp;|&nbsp; | innerHTML | html에서 입력된 요소 화면 특정부분에 나오도록 설정
  &nbsp;|&nbsp; | &nbsp; | input 박스 사이즈 재설정
  &nbsp;|&nbsp; | border | 타이틀 글자 밑에 border로 밑줄 표현
  로그인| signin.html | flex | 하위요소 가로배치
  &nbsp;|&nbsp; |  justify-content | 하위요소 정렬
  &nbsp;| &nbsp;| 웹 폰트 | 한글에 눈누, 영문에 구글폰트 사용
  &nbsp;| &nbsp;| 가상요소 | 로고 배치
  &nbsp;| &nbsp;| 이중 테두리 | 이중 테두리로 박스 꾸미기
  &nbsp;| &nbsp;| box-shadow | 떠있는 느낌을 주기 위한 그림자 효과
  &nbsp;| &nbsp;| document.getElementById | 입력된 아이디와 비밀번호를 체크
  &nbsp;| &nbsp;| addEventListener | focus 또는 focusout되면 특정 이벤트 발생되도록 지정
  회원가입| signup.html | flex | 하위요소 가로배치
  &nbsp;|&nbsp; |  justify-content | 하위요소 정렬
  &nbsp;| &nbsp;| 웹 폰트 | 영문에 구글폰트 사용
  &nbsp;| &nbsp;| filter | 배경 이미지 어둡게 설정
  &nbsp;| &nbsp;| 아이콘 폰트 | 페이스북, 구글 등
  &nbsp;| &nbsp;| box-shadow | 떠있는 느낌을 주기 위한 그림자 효과
  &nbsp;| &nbsp;| 가상요소 | select의 아래 방향 화살표 아이콘 설정
  
  <br><br><h2> :raised_hands: 역할 분담 :raised_hands: </h2>
  <h4> 박수현 : GIT 통합 및 관리 </h4>
  메뉴 / 갤러리 / 게시판
   <br><br><br>
  
  <h2> :calendar: 일정 계획 :calendar: </h2>
  <h3> 08/24 </h3>
   공통 : 주제 선정 / 페이지 분류 / 페이지 분담 <br> <br> 
   
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
