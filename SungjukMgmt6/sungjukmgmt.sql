/* 학생 */
CREATE TABLE scott.Student (
	hakbun CHAR(7) NOT NULL, /* 학번 */
	name VARCHAR2(20) NOT NULL, /* 이름 */
	kor NUMBER(3) DEFAULT 0 NOT NULL, /* 국어 */
	eng NUMBER(3) DEFAULT 0 NOT NULL, /* 영어 */
	mat NUMBER(3) DEFAULT 0, /* 수학 */
	tot NUMBER(3), /* 총점 */
	avg NUMBER(5,2), /* 평균 */
	grade CHAR(1) /* 평 */
);

COMMENT ON TABLE scott.Student IS '학생';

COMMENT ON COLUMN scott.Student.hakbun IS '학번';

COMMENT ON COLUMN scott.Student.name IS '이름';

COMMENT ON COLUMN scott.Student.kor IS '국어';

COMMENT ON COLUMN scott.Student.eng IS '영어';

COMMENT ON COLUMN scott.Student.mat IS '수학';

COMMENT ON COLUMN scott.Student.tot IS '총점';

COMMENT ON COLUMN scott.Student.avg IS '평균';

COMMENT ON COLUMN scott.Student.grade IS '평';

CREATE UNIQUE INDEX scott.PK_Student
	ON scott.Student (
		hakbun ASC
	);

ALTER TABLE scott.Student
	ADD
		CONSTRAINT PK_Student
		PRIMARY KEY (
			hakbun
		);