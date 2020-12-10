/* �л� */
CREATE TABLE scott.Student (
	hakbun CHAR(7) NOT NULL, /* �й� */
	name VARCHAR2(20) NOT NULL, /* �̸� */
	kor NUMBER(3) DEFAULT 0 NOT NULL, /* ���� */
	eng NUMBER(3) DEFAULT 0 NOT NULL, /* ���� */
	mat NUMBER(3) DEFAULT 0, /* ���� */
	tot NUMBER(3), /* ���� */
	avg NUMBER(5,2), /* ��� */
	grade CHAR(1) /* �� */
);

COMMENT ON TABLE scott.Student IS '�л�';

COMMENT ON COLUMN scott.Student.hakbun IS '�й�';

COMMENT ON COLUMN scott.Student.name IS '�̸�';

COMMENT ON COLUMN scott.Student.kor IS '����';

COMMENT ON COLUMN scott.Student.eng IS '����';

COMMENT ON COLUMN scott.Student.mat IS '����';

COMMENT ON COLUMN scott.Student.tot IS '����';

COMMENT ON COLUMN scott.Student.avg IS '���';

COMMENT ON COLUMN scott.Student.grade IS '��';

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