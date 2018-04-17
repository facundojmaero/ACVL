CREATE SEQUENCE id_family;
CREATE SEQUENCE id_enfant;
CREATE SEQUENCE id_regime;
CREATE SEQUENCE id_account;
CREATE SEQUENCE id_activity;
CREATE SEQUENCE id_schedule_activity_enfant;
CREATE SEQUENCE id_animator;
CREATE SEQUENCE id_administrator;
CREATE SEQUENCE id_day;
CREATE SEQUENCE id_activity_list;
CREATE SEQUENCE id_timetable_activity;
CREATE SEQUENCE id_invoice;
CREATE SEQUENCE id_school_level;
CREATE SEQUENCE id_period;

CREATE TABLE family (
  id NUMBER(10) DEFAULT id_family.nextval PRIMARY KEY,
  name_family nvarchar2(100) NOT NULL,
  phone nvarchar2(100) NOT NULL,
  address nvarchar2(100) NOT NULL,
  id_account NUMBER(10) NOT NULL
);

CREATE TABLE enfant (
  id NUMBER(10) DEFAULT id_enfant.nextval PRIMARY KEY,
  id_family NUMBER(10) NOT NULL,
  name nvarchar2(100) NOT NULL,
  surname nvarchar2(100) NOT NULL,
  gender CHAR(1) NOT NULL,
  date_of_birth DATE NOT NULL,
  id_regime NUMBER(10) NOT NULL,
  level_id NUMBER(3) NOT NULL,
  id_period NUMBER(10) NOT NULL
);

CREATE TABLE regime (
  id NUMBER(10) DEFAULT id_regime.nextval PRIMARY KEY,
  description nvarchar2(100) DEFAULT NULL
);

CREATE TABLE account (
  id NUMBER(10) DEFAULT id_account.nextval PRIMARY KEY,
  username nvarchar2(100) NOT NULL,
  password nvarchar2(100) NOT NULL,
  account_type nvarchar2(100) DEFAULT 'family'
);
		
CREATE TABLE activity (
  id NUMBER(10) DEFAULT id_activity.nextval PRIMARY KEY,
  description nvarchar2(100) DEFAULT NULL,
  id_period NUMBER(10) NOT NULL,
  tariff NUMBER(10) NOT NULL
);
		
CREATE TABLE schedule_activity_enfant (
  id NUMBER(10) DEFAULT id_schedule_activity_enfant.nextval PRIMARY KEY,
  id_enfant NUMBER(10) NOT NULL,
  attendance CHAR(1) NOT NULL,
  id_timetable_activity NUMBER(10) NOT NULL
);

CREATE TABLE animator (
  id NUMBER(10) DEFAULT id_animator.nextval PRIMARY KEY,
  name nvarchar2(100) NOT NULL,
  surname nvarchar2(100) NOT NULL,
  phone nvarchar2(100) NOT NULL
);

CREATE TABLE administrator (
  id NUMBER(10) DEFAULT id_administrator.nextval PRIMARY KEY,
  id_account NUMBER(10) NOT NULL,
  name nvarchar2(100) NOT NULL,
  surname nvarchar2(100) NOT NULL,
  phone nvarchar2(100) NOT NULL,
  address nvarchar2(100) NOT NULL,
  date_of_birth DATE NOT NULL,
  gender CHAR(1) NOT NULL
);

CREATE TABLE day (
  id NUMBER(10) DEFAULT id_day.nextval PRIMARY KEY,
  day nvarchar2(100) NOT NULL
);

CREATE TABLE activity_list (
  id NUMBER(10) DEFAULT id_activity_list.nextval PRIMARY KEY,
  id_day NUMBER(10) NOT NULL,
  id_activity NUMBER(10) NOT NULL,
  hour number(10) NOT NULL,
  student_quota NUMBER(10) NOT NULL,
  duration NUMBER(10) NOT NULL,
  id_animator NUMBER(10) DEFAULT NULL,
  level_id NUMBER(10) NOT NULL
);
		
CREATE TABLE timetable_activity (
  id NUMBER(10) DEFAULT id_timetable_activity.nextval PRIMARY KEY,
  id_activity_list NUMBER(10) NOT NULL,
  date_activity DATE NOT NULL
);
		
CREATE TABLE invoice (
  id NUMBER(10) DEFAULT id_invoice.nextval PRIMARY KEY,
  amount BINARY_DOUBLE NOT NULL,
  date_of_issue DATE NOT NULL,
  expiration DATE NOT NULL,
  id_family NUMBER(10) NOT NULL,
  payed  CHAR(1) DEFAULT 'N',
  payment_date DATE DEFAULT NULL
);
		
CREATE TABLE school_level (
  id NUMBER(10) DEFAULT id_school_level.nextval PRIMARY KEY,
  level_name nvarchar2(100) NOT NULL,
  description nvarchar2(100) NOT NULL,
  initial_age NUMBER(10) NOT NULL,
  final_age NUMBER(10) NOT NULL
);

CREATE TABLE period (
  id NUMBER(10) DEFAULT id_period.nextval PRIMARY KEY,
  period_name nvarchar2(100) NOT NULL,
  period_year NUMBER(4) NOT NULL,
  month_initial NUMBER(2) NOT NULL,
  duration NUMBER(2) NOT NULL
);

ALTER TABLE family ADD FOREIGN KEY (id_account) REFERENCES account (id);
ALTER TABLE enfant ADD FOREIGN KEY (id_family) REFERENCES family (id);
ALTER TABLE enfant ADD FOREIGN KEY (id_regime) REFERENCES regime (id);
ALTER TABLE enfant ADD FOREIGN KEY (level_id) REFERENCES school_level (id);
ALTER TABLE enfant ADD FOREIGN KEY (id_period) REFERENCES period (id);
ALTER TABLE activity ADD FOREIGN KEY (id_period) REFERENCES period (id);
ALTER TABLE schedule_activity_enfant ADD FOREIGN KEY (id_enfant) REFERENCES enfant (id);
ALTER TABLE schedule_activity_enfant ADD FOREIGN KEY (id_timetable_activity) REFERENCES timetable_activity (id);
ALTER TABLE administrator ADD FOREIGN KEY (id_account) REFERENCES account (id);
ALTER TABLE activity_list ADD FOREIGN KEY (id_day) REFERENCES day (id);
ALTER TABLE activity_list ADD FOREIGN KEY (id_activity) REFERENCES activity (id);
ALTER TABLE activity_list ADD FOREIGN KEY (id_animator) REFERENCES animator (id);
ALTER TABLE activity_list ADD FOREIGN KEY (level_id) REFERENCES school_level (id);
ALTER TABLE timetable_activity ADD FOREIGN KEY (id_activity_list) REFERENCES activity_list (id);
ALTER TABLE invoice ADD FOREIGN KEY (id_family) REFERENCES family (id);

-- ---
-- Test Data
-- ---

INSERT INTO day (day) VALUES ('monday');
INSERT INTO day (day) VALUES ('tuesday');
INSERT INTO day (day) VALUES ('wednesday');
INSERT INTO day (day) VALUES ('thursday');
INSERT INTO day (day) VALUES ('friday');

INSERT INTO school_level (level_name,description,initial_age,final_age) VALUES 
('PS','Petite Section',2,4);
INSERT INTO school_level (level_name,description,initial_age,final_age) VALUES 
('MS','Moyenne Section',4,5);
INSERT INTO school_level (level_name,description,initial_age,final_age) VALUES 
('GS','Grande Section',5,6);
INSERT INTO school_level (level_name,description,initial_age,final_age) VALUES 
('CP','Cours Preparatoire',6,7);
INSERT INTO school_level (level_name,description,initial_age,final_age) VALUES 
('CE1','Cours Elementaire Premiere Annee',7,8);
INSERT INTO school_level (level_name,description,initial_age,final_age) VALUES 
('CE2','Cours Elementaire Deuxieme Annee',8,9);
INSERT INTO school_level (level_name,description,initial_age,final_age) VALUES 
('CM1','Cours Moyen Premiere Annee',9,10);
INSERT INTO school_level (level_name,description,initial_age,final_age) VALUES 
('CM2','Cours Moyen Deuxieme Annee',10,11);

INSERT INTO regime (description) VALUES ('no restriction');
INSERT INTO regime (description) VALUES ('vegetarian');
INSERT INTO regime (description) VALUES ('no gluten');

-- Datos fruta

INSERT INTO animator (name,surname,phone) VALUES
('Juan','Perez','1234');
INSERT INTO animator (name,surname,phone) VALUES
('Maria','Lopez','3333');

INSERT INTO period (period_name,period_year,month_initial, duration) VALUES
('1st Semester 2018',2018,01,6);
INSERT INTO period (period_name,period_year,month_initial, duration) VALUES
('2nd Semester 2018',2018,07,6);

INSERT INTO activity (description,id_period,tariff)
SELECT 'Tenis', period.id, 100
FROM period
WHERE period.period_year = 2018 and period.month_initial = 1;

INSERT INTO activity (description,id_period,tariff)
SELECT 'Tenis', period.id, 120
FROM period
WHERE period.period_year = 2018 and period.month_initial = 7;

INSERT INTO activity (description,id_period,tariff)
SELECT 'Basquet', period.id, 80
FROM period
WHERE period.period_year = 2018 and period.month_initial = 1;


INSERT INTO family (NAME_FAMILY, PHONE, ADDRESS, ID_ACCOUNT) 
SELECT 'maero2', '12345', 'calle falsa 1234', account.id
FROM    account
WHERE   account.username = 'family';

INSERT INTO ADMINISTRATOR (ID_ACCOUNT, NAME, SURNAME, PHONE, ADDRESS, DATE_OF_BIRTH, GENDER)
SELECT account.id, 'sapo2', 'pepe', '12345', 'calle sapo 123', date '2000-01-01', 'M'
FROM account
WHERE account.username = 'admin';

SELECT * FROM MAEROF.ADMINISTRATOR WHERE TO_CHAR(date_of_birth, 'MM') = 2;
SELECT * FROM MAEROF.ADMINISTRATOR WHERE TO_CHAR(date_of_birth, 'YYYY') = 1995;
SELECT TO_CHAR(date_of_birth, 'YYYY-MM-DD') FROM MAEROF.ADMINISTRATOR WHERE  extract(day from date_of_birth) = 22;

select to_char(to_date('1120', 'hhmi'), 'hh:mi') from dual;
select to_date(1130 + 29, 'hhmi') from dual;
-- para activity list pasar hora y duracion a otro formato

INSERT INTO activity_list (id_day,id_activity,hour,student_quota,duration,id_animator,level_id) 
select day.id, act.id_period, to_date(1120, 'hhmi'), 20, 30, anim.id, lvl.id
from day, activity act join period p on act.id_period = p.id , animator anim, school_level lvl
where   day.day = 'tuesday' 
        and act.description = 'Tenis' and p.period_year = 2018 and p.month_initial = 7
        and anim.name = 'Maria'
        and lvl.level_name = 'CM2';

INSERT INTO ENFANT (id_family, name, surname, gender, date_of_birth, id_regime, level_id, id_period)
SELECT fam.id, 'Pedrito', 'Garcia', 'M', date '2000-02-21', reg.id, lvl.id, per.id
FROM family fam, regime reg, school_level lvl, period per
WHERE   fam.NAME_FAMILY = 'maero'
        and reg.description = 'vegetarian'
        and lvl.LEVEL_NAME = 'CE2'
        and per.period_year = 2018 and per.month_initial = 1;

INSERT INTO timetable_activity (id_activity_list,DATE_ACTIVITY)
SELECT li.id, li.hour + 7 -- sumo de a 7 dias en java, es mas facil el loop que en sql
FROM ACTIVITY_LIST li
WHERE li.id = 1;

INSERT INTO schedule_activity_enfant (id_enfant,attendance,id_timetable_activity)
SELECT enf.id, 'Y', tt.id
FROM enfant enf, TIMETABLE_ACTIVITY tt
WHERE tt.id = 1;

INSERT INTO invoice (amount,date_of_issue,expiration,id_family)
SELECT '100', current_date, current_date + 30, fam.id
FROM family fam
WHERE fam.NAME_FAMILY = 'maero';
