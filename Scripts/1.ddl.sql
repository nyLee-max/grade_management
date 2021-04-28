-- 내 스키마
DROP SCHEMA IF EXISTS grade2;

-- 내 스키마
CREATE SCHEMA grade2;

-- 분반
CREATE TABLE grade2.Ban (
	classCode VARCHAR(50) NOT NULL COMMENT '분반' -- 분반
)
COMMENT '분반';

-- 분반
ALTER TABLE grade2.Ban
	ADD CONSTRAINT PK_Class -- 분반 기본키
		PRIMARY KEY (
			classCode -- 분반
		);

-- 점수
CREATE TABLE grade2.Score (
	No       INT(50) NOT NULL COMMENT '연번', -- 연번
	stdNo    INT(50) NULL     COMMENT '학번', -- 학번
	subNo    INT(50) NULL     COMMENT '과목번호', -- 과목번호
	stdScore INT(50) NULL     COMMENT '성적' -- 성적
)
COMMENT '점수';

-- 점수
ALTER TABLE grade2.Score
	ADD CONSTRAINT PK_Score -- 점수 기본키
		PRIMARY KEY (
			No -- 연번
		);

-- 과목
CREATE TABLE grade2.Subject (
	subNo   INT(50)  NOT NULL COMMENT '과목번호', -- 과목번호
	subName CHAR(50) NULL     COMMENT '과목이름' -- 과목이름
)
COMMENT '과목';

-- 과목
ALTER TABLE grade2.Subject
	ADD CONSTRAINT PK_Subject -- 과목 기본키
		PRIMARY KEY (
			subNo -- 과목번호
		);

-- 학생
CREATE TABLE grade2.Student (
	stdNo     INT(50)     NOT NULL COMMENT '학번', -- 학번
	classCode VARCHAR(50) NOT NULL COMMENT '분반', -- 분반
	stdName   CHAR(50)    NULL     COMMENT '이름', -- 이름
	enterDate DATE        NULL     COMMENT '입학날짜', -- 입학날짜
	PhotoName VARCHAR(50) NULL     COMMENT '파일명', -- 파일명
	stdPhoto  BLOB        NULL     COMMENT '사진' -- 사진
)
COMMENT '학생';

-- 학생
ALTER TABLE grade2.Student
	ADD CONSTRAINT PK_Student -- 학생 기본키
		PRIMARY KEY (
			stdNo -- 학번
		);

-- 점수
ALTER TABLE grade2.Score
	ADD CONSTRAINT FK_Subject_TO_Score -- 과목 -> 점수
		FOREIGN KEY (
			subNo -- 과목번호
		)
		REFERENCES grade2.Subject ( -- 과목
			subNo -- 과목번호
		);

-- 점수
ALTER TABLE grade2.Score
	ADD CONSTRAINT FK_Student_TO_Score -- 학생 -> 점수
		FOREIGN KEY (
			stdNo -- 학번
		)
		REFERENCES grade2.Student ( -- 학생
			stdNo -- 학번
		);
	
alter table grade2.score modify no int not null auto_increment;

-- 학생
ALTER TABLE grade2.Student
	ADD CONSTRAINT FK_Ban_TO_Student -- 분반 -> 학생
		FOREIGN KEY (
			classCode -- 분반
		)
		REFERENCES grade2.Ban ( -- 분반
			classCode -- 분반
		);

