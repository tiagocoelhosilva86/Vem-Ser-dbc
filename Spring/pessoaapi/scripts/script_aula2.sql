CREATE TABLE Professor (
  id_professor NUMBER NOT NULL,
  id_universidade NUMBER NOT NULL,
  nome varchar2(255),
  salario NUMBER(10,2),
  PRIMARY KEY(id_professor, id_universidade)
);