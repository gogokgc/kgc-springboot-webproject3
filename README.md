# kgc-springboot-webproject3

### IDE - Spring Tool Suite4

- GRADLE

### - Spring Starter Project
- Spring Boot DevTool
- Lombok
- Spring Data JPA
- MySQL Driver
- Spring Security
- SpringWeb
- mustache
- OAuth2 (google login)

### Distribute
- AWS
- EC2
- RDS
- S3
- CodeDeploy
- Travis CI

---------------------------

## Read
메인 페이지에 기본 Posts DB 테이블에 있는 데이터를 전부 표시할수있게 설정
<img width="2032" alt="스크린샷 2021-06-08 20 56 07" src="https://user-images.githubusercontent.com/79429581/121181153-a8f4c900-c89c-11eb-96a2-d9da86b5eeb4.png">

---------------------------

## Create
작성자 는 세션 에서 가져온 유저네임으로 수정불가 제목 과 내용(summernote 사용) 입력가능
save 버튼은 자바스크립트 연동하여 타이틀 or 내용이 공백일시 저장이 되지 않도록 구현 (조건문), ajax 이용 POST 로 데이터 전달 
글 저장을 위한 Posting 페이지로 이동하기 위해선 로그인을 거쳐야 가능하게 스프링 시큐리티로 제한
<img width="2032" alt="스크린샷 2021-06-08 20 57 05" src="https://user-images.githubusercontent.com/79429581/121181500-0ab53300-c89d-11eb-86f1-ea13fb8432f7.png">

---------------------------

## Update & Delete
수정 페이지로 이동하기위한 Edit 버튼도 보안을 위해 자바스크립트와 연동하여 현재 로그인해있는 세션 유저이름과 작성자 이름이 다를시 수정불가
<img width="2032" alt="스크린샷 2021-06-08 20 57 29" src="https://user-images.githubusercontent.com/79429581/121182076-acd51b00-c89d-11eb-8955-719e8520894b.png">

수정페이지에서 글번호 작성자 제오 수정가능 수정페이지 진입 자체에 유저이름을 이용한 보안이 있으므로 수정시 글 삭제 가능하게 구현
<img width="2032" alt="스크린샷 2021-06-08 20 57 41" src="https://user-images.githubusercontent.com/79429581/121182164-c6766280-c89d-11eb-9734-40b7b01c4105.png">

---------------------------
## OAuth2 for Login (Google)
OAuth2 를 활용한 구글 로그인 연동
<img width="2032" alt="스크린샷 2021-06-08 20 56 29" src="https://user-images.githubusercontent.com/79429581/121183798-67195200-c89f-11eb-8e3d-0c5569499e9a.png">

