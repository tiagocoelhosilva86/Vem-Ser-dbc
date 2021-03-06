CREATE  TABLE Endere?o (
id_Endere?o NUMBER NOT NULL,
Nome VARCHAR2(200) NOT NULL,
Data_Nascimento DATE NOT NULL,
Nr_Matricula NUMBER(10) NOT NULL,
Ativo CHAR(1) NOT NULL
);

ALTER SEQUENCE seq_Estudante
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

INSERT INTO ESTUDANTE 
(Id_ESTUDANTE,NOME,DATA_NASCIMENTO,NR_MATRICULA,ATIVO)
VALUES(SEQ_ESTUDANTE.nextval,'Tiago',TO_DATE('03-02-1986','dd-mm-yyyy'),10,'N');

INSERT INTO ESTUDANTE 
(Id_ESTUDANTE,NOME,DATA_NASCIMENTO,NR_MATRICULA,ATIVO)
VALUES(SEQ_ESTUDANTE.nextval,'Diego',TO_DATE('01-02-1989','dd-mm-yyyy'),11,'N');

INSERT INTO ESTUDANTE 
(Id_ESTUDANTE,NOME,DATA_NASCIMENTO,NR_MATRICULA,ATIVO)
VALUES(SEQ_ESTUDANTE.nextval,'Miguel',TO_DATE('01-02-1988','dd-mm-yyyy'),12,'s');

INSERT INTO ESTUDANTE 
(Id_ESTUDANTE,NOME,DATA_NASCIMENTO,NR_MATRICULA,ATIVO)
VALUES(SEQ_ESTUDANTE.nextval,'Aline',TO_DATE('20-02-1989','dd-mm-yyyy'),13,'S');

INSERT INTO ESTUDANTE 
(Id_ESTUDANTE,NOME,DATA_NASCIMENTO,NR_MATRICULA,ATIVO)
VALUES(SEQ_ESTUDANTE.nextval,'Jo?o',TO_DATE('01-04-1989','dd-mm-yyyy'),14,'S');

INSERT INTO ESTUDANTE 
(Id_ESTUDANTE,NOME,DATA_NASCIMENTO,NR_MATRICULA,ATIVO)
VALUES(SEQ_ESTUDANTE.nextval,'Pedro',TO_DATE('01-02-1989','dd-mm-yyyy'),15,'N');

INSERT INTO ESTUDANTE 
(Id_ESTUDANTE,NOME,DATA_NASCIMENTO,NR_MATRICULA,ATIVO)
VALUES(SEQ_ESTUDANTE.nextval,'Luca',TO_DATE('01-02-1989','dd-mm-yyyy'),16,'N');

INSERT INTO ESTUDANTE 
(Id_ESTUDANTE,NOME,DATA_NASCIMENTO,NR_MATRICULA,ATIVO)
VALUES(SEQ_ESTUDANTE.nextval,'Dourado',TO_DATE('01-02-1989','dd-mm-yyyy'),17,'S');

INSERT INTO ESTUDANTE 
(Id_ESTUDANTE,NOME,DATA_NASCIMENTO,NR_MATRICULA,ATIVO)
VALUES(SEQ_ESTUDANTE.nextval,'Edinaldo',TO_DATE('01-02-1989','dd-mm-yyyy'),18,'S');

INSERT INTO ESTUDANTE 
(Id_ESTUDANTE,NOME,DATA_NASCIMENTO,NR_MATRICULA,ATIVO)
VALUES(SEQ_ESTUDANTE.nextval,'Hugo',TO_DATE('01-02-1989','dd-mm-yyyy'),19,'N');





SELECT* FROM ESTUDANTE

