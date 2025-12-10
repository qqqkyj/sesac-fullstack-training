-- 데이터 베이스(schema) 생성
-- 한글 깨짐 방지
CREATE DATABASE temp CHARACTER SET utf8mb4;

-- DROP DATABASE temp;
-- 모든 데이터 베이스 조회
SHOW DATABASES;

-- 데이터 베이스 사용
USE temp;

-- 테이블 생성
CREATE TABLE customer(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE orders (
	id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

-- 테이블 삭제
-- DROP TABLE customer;

-- 테이블 조회
DESC customer;
DESC orders;

-- 테이블 수정
-- 컬럼 추가
ALTER TABLE customer
ADD COLUMN phone VARCHAR(50);
-- 컬럼 수정
ALTER TABLE customer
MODIFY COLUMN phone VARCHAR(50) NOT NULL;
-- 컬럼 이름 변경
ALTER TABLE customer
CHANGE COLUMN phone phone_num VARCHAR(50) NOT NULL;
-- 컬럼 삭제
ALTER TABLE customer
DROP COLUMN phone_num;
-- 테이블 구조 유지, 데이터 모두 삭제
TRUNCATE TABLE customer;
DROP TABLE orders;