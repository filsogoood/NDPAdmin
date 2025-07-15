# NDP Spring Backend

Java 1.8과 MyBatis를 사용하는 Spring Boot 백엔드 프로젝트입니다.

## 기술 스택

- Java 1.8
- Spring Boot 2.7.18
- MyBatis 2.3.2
- MySQL 8.0.33
- H2 Database (개발/테스트용)
- Lombok
- Maven

## 프로젝트 구조

```
ndp_spring_back/
├── src/
│   ├── main/
│   │   ├── java/com/ndp/
│   │   │   ├── config/         # 설정 클래스
│   │   │   ├── controller/     # REST 컨트롤러
│   │   │   ├── mapper/         # MyBatis 매퍼 인터페이스
│   │   │   ├── model/          # 도메인 모델
│   │   │   ├── service/        # 비즈니스 로직
│   │   │   └── NdpSpringBackApplication.java
│   │   └── resources/
│   │       ├── mapper/         # MyBatis XML 매퍼 파일
│   │       ├── application.properties
│   │       └── schema.sql
│   └── test/
└── pom.xml
```

## 시작하기

### 필수 요구사항

- JDK 1.8
- Maven 3.6+
- MySQL 5.7+ (또는 8.0)

### 데이터베이스 설정

1. MySQL에서 데이터베이스 생성:
```sql
CREATE DATABASE ndp_db;
```

2. `src/main/resources/schema.sql` 파일을 실행하여 테이블 생성

3. `application.properties`에서 데이터베이스 연결 정보 수정:
```properties
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 실행 방법

1. 프로젝트 빌드:
```bash
mvn clean install
```

2. 애플리케이션 실행:
```bash
mvn spring-boot:run
```

3. 브라우저에서 확인:
- API 엔드포인트: http://localhost:8080/api/users
- H2 콘솔 (테스트 환경): http://localhost:8080/h2-console

## API 엔드포인트

| Method | URL | 설명 |
|--------|-----|------|
| GET | /api/users | 모든 사용자 조회 |
| GET | /api/users/{id} | ID로 사용자 조회 |
| GET | /api/users/username/{username} | 사용자명으로 조회 |
| POST | /api/users | 새 사용자 생성 |
| PUT | /api/users/{id} | 사용자 정보 수정 |
| DELETE | /api/users/{id} | 사용자 삭제 |

## 개발 가이드

### MyBatis 매퍼 추가하기

1. `com.ndp.mapper` 패키지에 인터페이스 생성
2. `src/main/resources/mapper/` 디렉토리에 XML 파일 생성
3. `@Mapper` 어노테이션 추가

### 새로운 엔티티 추가하기

1. `com.ndp.model` 패키지에 모델 클래스 생성
2. Lombok `@Data` 어노테이션 사용
3. 해당하는 Mapper, Service, Controller 생성

## 테스트

```bash
mvn test
```

## 문제 해결

- **MyBatis 매퍼를 찾을 수 없을 때**: `@MapperScan` 어노테이션 확인
- **데이터베이스 연결 오류**: application.properties의 연결 정보 확인
- **한글 깨짐 문제**: UTF-8 인코딩 설정 확인
