USE temp;

CREATE TABLE accounts(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    balance INT
);

INSERT INTO accounts (name, balance) VALUES('kim', 100000);
INSERT INTO accounts (name, balance) VALUES('kang', 2000000);

SELECT * FROM accounts;
-- 트랜잭션 시작
START TRANSACTION;
UPDATE accounts SET balance = balance + 10000 WHERE id = 1;
UPDATE accounts SET balance = balance - 10000 WHERE id = 2;
-- 커밋(트랜잭션의 모든 변경사항을 영구적으로 확정)
COMMIT;

-- 트랜잭션 시작
START TRANSACTION;
UPDATE accounts SET balance = balance + 10000 WHERE id = 1;
UPDATE accounts SET balance = balance - 10000 WHERE id = 2;
-- 롤백(트랜잭션의 모든 변경사항을 취소하고 원래 상태로 되돌기)
ROLLBACK;

-- 트랜잭션 시작
START TRANSACTION;
INSERT INTO accounts (name, balance) VALUES('hong', 0);
SAVEPOINT sp1;

INSERT INTO accounts (name, balance) VALUES('choi', 999999999);
SAVEPOINT sp2;

-- 부분 롤백(트랜잭션의 모든 변경사항을 취소하고 원래 상태로 되돌기)
ROLLBACK TO SAVEPOINT sp1; -- 'hong'까지만 저장
-- 커밋
COMMIT;

-- 자동 커밋 모드 (Autocommit)
SELECT * FROM accounts;
INSERT INTO accounts (name, balance) VALUES('choi', 0);

-- 자동 커밋 활성화 여부(1:활성화, 0:비활성화)
SELECT @@autocommit;
-- 비활성화
SET @@autocommit = 0;
INSERT INTO accounts (name, balance) VALUES('test', 0);
ROLLBACK;

-- DDL(CREATE, ALTER, DROP, TRUNCATE TABLE, RENAME TABLE)문은 암묵적으로 COMMIT 수행
-- 즉, ROLLBACK은 소용 없음!



