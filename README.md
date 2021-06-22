# Portfolio

#### 스프링부트, JPA 를 활용한 게임정보 공유용 게시판
Link : https://bit.ly/3x2i2FQ

## skills
   * **Language** : Java, JavaScript, HTML5, CSS
   * **Framework** : Spring Boot
   * **Build Tool** : Gradle
   * **Database** : MySql, MariaDB
   * **Development Tool** : Eclipes(STS4)
   * **distribution** : AWS(EC2, RDS, S3, codeDeploy, IAM), TravisCI

### OS : MacOs

- **Plugins**
   - Spring Starter Project
     - Spring Boot DevTool
     - Lombok
     - Spring Data JPA
     - MySQL Driver
     - Spring Security
     - SpringWeb
     - mustache
     - OAuth2 (google login)
---
## DB
  - MySql(로컬환경), MariaDB(배포환경) 사용
  - JPA활용 DB 관리
  - 엔티티 클래스로 테이블 관리
  - JPA Repository 로 기본 CRUD메소드 및 추가 query 운용
  - Dto 클래스로 데이터 이동 관리
  - Service 단에서 트랜색션 관리

---

## 메인페이지
  - DB 에 있는 기본 게시물이 보이도록 구현 (기본 글 타이틀이 보이고 커서가 올라가면 작성자 이름이 나타나도록)
  - 게시물이 내림차순으로 정렬할수있도록 Repository 에 @Query 추가
  - index컨트롤러 에서 Model 로 받아와 출력
  - 오른쪽 상단에 메뉴페이지 에서 로그인, 포스팅 페이지로 이동가능
  - 로그인 페이지와 메인페이지 이외에는 로그인 필요 하도록 시큐리티 설정
  - Pageable 활용 페이징 처리 (게시물 6개 기준) 추가
  - JPA 쿼리 활용 키워드(제목, 내용) 검색 기능 추가 검색결과 페이지로 이동하여 검색 결과 출력
<img width="1139" alt="스크린샷 2021-06-22 16 27 51" src="https://user-images.githubusercontent.com/79429581/122882188-e49c9200-d376-11eb-8fd9-9a4387cd5bd3.png">
<img width="1159" alt="스크린샷 2021-06-22 16 29 19" src="https://user-images.githubusercontent.com/79429581/122882404-1ca3d500-d377-11eb-8c10-1ec55ef27b71.png">

## 로그인
  - OAuth2 활용 구글로그인 구현 로그인 아이디는 DB세션에 저장, 로그인중인 아이디는 메뉴페이지에서 확인 가능
  - 로그인 확인시 Enum 활용하여 유저에 사용자 Role 부여하여 시큐리티 통과가능
<img width="1036" alt="구글로그인1" src="https://user-images.githubusercontent.com/79429581/122020363-ae539580-cdff-11eb-9e1c-661402ed956c.png">
<img width="547" alt="구글로그인2" src="https://user-images.githubusercontent.com/79429581/122020380-b01d5900-cdff-11eb-866d-d16020a37ce9.png">


## 글 작성페이지
  - 글 작성시 작성자에 세션 아이디 자동 삽입
  - 글 제목, 내용으로 이루어져 있으며 저장버튼은 자바스크립트 연동 AJAX 활용 하여 POST 요청 으로 JSON데이터 DB 로 전송
  - 취소버튼 으로 메인페이지로 이동
<img width="1137" alt="글작성페이지" src="https://user-images.githubusercontent.com/79429581/122020405-b57aa380-cdff-11eb-92e7-59fb16c2ad7d.png">


## 글 상세페이지
  - 메인페이지에서 게시물을 클릭하면 글 상세보기 가능
  - 컨트롤러에서 Model 로 받아온 Posts 데이터 활용 글번호, 작성자, 조회수 표현
  - 조회수 기능 구현위해 Posts 엔티티에 컬럼추가, Repository 에 @Query 추가 서비스클래스에 구현 후
  - 컨트롤러에서 요청이 있을시 조회수 추가 기능 구현후 글상세 페이지에 진입 할수있도록 순서 신경써서 설정(조회후 조회수 카운팅으로 들어가면 첫 조회시 디폴트값 0부터 시작하기때문에)
  - Utterances 활용 댓글 시스템 구현
  - 댓글용 Repository 생성후 View 단에 스크립트 삽입 구현의 용이성, 데이터 관리 용이성 때문에 채택
  - Edit 버튼으로 수정페이지 진입가능
  - 작성자, 세션 유저이름을 기준으로 다른사람의 포스팅을 무단으로 수정할수 없도록 
  - 자바스크립트 활용 유저 체크 과정 구현 (관리자 아이디, 작성자 본인이 아니면 수정할수 없도록 구현)
<img width="1056" alt="글상세페이지" src="https://user-images.githubusercontent.com/79429581/122020455-bf040b80-cdff-11eb-9377-6c3895ecb952.png">
<img width="1048" alt="글수정보안" src="https://user-images.githubusercontent.com/79429581/122020504-c9260a00-cdff-11eb-8401-65e9cb569259.png">


## 글 수정 페이지
  - 컨트롤러 에서 받아오는 Model  데이터 활용 글번호, 작성자 자동삽입
  - 글 제목과 내용 수정 가능
  - 저장버튼 - 자바스크립트 활용 PUT 요청으로 DB 에 데이터 전송, 클릭실수 방지위해 alert 기능 활용 2차확인
  - 삭제버튼 - 자바스크립트 활용 DELETE 요청 으로 DB 데이터 삭제, 클릭실수 방지위해 alert 기능 활용 2차확인
  - 취소버튼 - 메인페이지 이동
  - 리셋버튼 - 현재페이지 새로고침
<img width="1054" alt="글수정페이지" src="https://user-images.githubusercontent.com/79429581/122020499-c6c3b000-cdff-11eb-8711-e4e0d9b6e1db.png">



