Spring boot 3일차
---

### 1. application properties 수정

```
spring.datasource.url=jdbc:mysql://localhost:3306/snsdb
spring.datasource.username=root
spring.datasource.password=mysql1234
spring.jpa.database=mysql
spring.jpa.hibernate.ddl-auto=create
```

기존에 파일에서 spring.jpa.database=mysql 이 부분 추가

이 뒤로 database 삭제 후 새로 만드는 등 오류에 대해 로그 검색 해서 수정 진행해서 겨우 연동 성공
(오류들에 대해서 기록 했어야 되는데 그냥 막 진행했다...)
---

### 2. 작동 test
testController와 testController Test 클래스를 통해
정상적으로 작동하는지 확인



