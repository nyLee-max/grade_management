grant all on grade.* to 'user_grade'@'localhost' identified by 'rootroot';

use grade2;

select user(), database();

insert into subject 
	values(1, '국어'), (2, '영어'), (3, '수학'), (4, '사회'), (5, '과학');

insert into ban
	values('A01'), ('A02');
	
insert into student (stdNo, classCode, stdName, enterDate)
	values (20001, 'A01', '박재선', 20160302),
			(20002, 'A01', '한동성', 20160302),
			(20003, 'A01', '정정일', 20160302),
			(20004, 'A01', '정명훈', 20160302),
			(20005, 'A01', '임정만', 20160302),
			(20006, 'A01', '임성준', 20160302),
			(20007, 'A01', '윤석수', 20160302),
			(20008, 'A01', '이준민', 20160302),
			(20009, 'A01', '이강길', 20160302),
			(20010, 'A01', '박철호', 20160302),
			(20011, 'A01', '여재일', 20170302),
			(20012, 'A01', '박상엽', 20170302),
			(20013, 'A01', '간효상', 20170302),
			(20014, 'A01', '형동훈', 20170302),
			(20015, 'A01', '진인우', 20170302),
			(20016, 'A02', '박운승', 20170302),
			(20017, 'A02', '김윤재', 20170302),
			(20018, 'A02', '황보동명',20170302),
			(20019, 'A02', '사대호', 20170302),
			(20020, 'A02', '박동수', 20170302),
			(20021, 'A02', '안추환', 20180302),
			(20022, 'A02', '정문식', 20180302),
			(20023, 'A02', '윤대건', 20180302),
			(20024, 'A02', '양우준', 20180302),
			(20025, 'A02', '서동윤', 20180302),
			(20026, 'A02', '송무길', 20180302),
			(20027, 'A02', '박영우', 20180302),
			(20028, 'A02', '신우석', 20180302),
			(20029, 'A02', '이보민', 20180302),
			(20030, 'A02', '조정우', 20180302);
			
select * from student;		

insert into score (stdNo, subNo, stdScore)
	values (20001, 1, 72),
		(20002, 1, 83),
	 (20003, 1, 88),
	 (20004, 1, 90),
	 (20005, 1, 78),
	 (20006, 1, 77),
	 (20007, 1, 71),
	 (20008, 1, 95),
	 (20009, 1, 97),
	 (20010, 1, 95),
	 (20011, 1, 96),
	 (20012, 1, 89),
	 (20013, 1, 73),
	 (20014, 1, 87),
	 (20015, 1, 94),
	 (20016, 1, 84),
	 (20017, 1, 77),
	 (20018, 1, 81),
	 (20019, 1, 71),
	 (20020, 1, 86),
	 (20021, 1, 98),
	 (20022, 1, 92),
	 (20023, 1, 87),
	 (20024, 1, 95),
	 (20025, 1, 95),
	 (20026, 1, 77),
	 (20027, 1, 84),
	 (20028, 1, 70),
	 (20029, 1, 100),
	 (20030, 1, 74),
	 (20001, 2, 73),
		(20002, 2, 72),
	 (20003, 2, 72),
	 (20004, 2, 70),
	 (20005, 2, 95),
	 (20006, 2, 95),
	 (20007, 2, 72),
	 (20008, 2, 94),
	 (20009, 2, 78),
	 (20010, 2, 78),
	 (20011, 2, 72),
	 (20012, 2, 93),
	 (20013, 2, 82),
	 (20014, 2, 90),
	 (20015, 2, 75),
	 (20016, 2, 97),
	 (20017, 2, 83),
	 (20018, 2, 90),
	 (20019, 2, 83),
	 (20020, 2, 98),
	 (20021, 2, 97),
	 (20022, 2, 80),
	 (20023, 2, 77),
	 (20024, 2, 84),
	 (20025, 2, 96),
	 (20026, 2, 80),
	 (20027, 2, 74),
	 (20028, 2, 78),
	 (20029, 2, 76),
	 (20030, 2, 78),
	(20001, 3, 90),
		(20002, 3, 83),
	 (20003, 3, 92),
	 (20004, 3, 82),
	 (20005, 3, 79),
	 (20006, 3, 87),
	 (20007, 3, 92),
	 (20008, 3, 93),
	 (20009, 3, 78),
	 (20010, 3, 80),
	 (20011, 3, 75),
	 (20012, 3, 100),
	 (20013, 3, 95),
	 (20014, 3, 92),
	 (20015, 3, 76),
	 (20016, 3, 88),
	 (20017, 3, 70),
	 (20018, 3, 74),
	 (20019, 3, 79),
	 (20020, 3, 92),
	 (20021, 3, 93),
	 (20022, 3, 75),
	 (20023, 3, 85),
	 (20024, 3, 73),
	 (20025, 3, 98),
	 (20026, 3, 78),
	 (20027, 3, 95),
	 (20028, 3, 77),
	 (20029, 3, 96),
	 (20030, 3, 93),
	 (20001, 4, 72),
	(20002, 4, 90),
	 (20003,4, 88),
	 (20004,4, 93),
	 (20005,4, 79),
	 (20006,4, 81),
	 (20007,4, 91),
	 (20008,4, 88),
	 (20009,4, 90),
	 (20010,4, 92),
	 (20011,4, 81),
	 (20012,4, 88),
	 (20013,4, 76),
	 (20014,4, 96),
	 (20015,4, 97),
	 (20016,4, 87),
	 (20017,4, 98),
	 (20018,4, 73),
	 (20019,4, 99),
	 (20020,4, 81),
	 (20021,4, 90),
	 (20022,4, 81),
	 (20023,4, 78),
	 (20024,4, 76),
	 (20025,4, 100),
	 (20026,4, 99),
	 (20027,4, 76),
	 (20028,4, 97),
	 (20029,4, 75),
	 (20030,4, 83),
	 (20001, 5, 84),
	(20002, 5, 91),
	 (20003, 5, 99),
	 (20004, 5, 98),
	 (20005, 5, 97),
	 (20006, 5, 85),
	 (20007, 5,96),
	 (20008, 5,100),
	 (20009, 5,73),
	 (20010, 5,72),
	 (20011, 5,81),
	 (20012, 5,83),
	 (20013, 5,90),
	 (20014, 5,73),
	 (20015, 5,75),
	 (20016, 5,85),
	 (20017, 5,88),
	 (20018, 5,73),
	 (20019, 5,83),
	 (20020, 5,73),
	 (20021, 5,71),
	 (20022, 5,100),
	 (20023, 5,78),
	 (20024, 5,84),
	 (20025, 5,77),
	 (20026, 5,82),
	 (20027, 5,96),
	 (20028, 5,71),
	 (20029, 5,87),
	 (20030, 5,73);
	 
select * from ban;
select * from score where stdNo = 20001;
select * from student WHERE stdNo = 4545;
select * from subject;
 
select stdNo, stdName, classCode, 국어, 영어, 수학, 사회, 과학, 평균 from vw_student_table where classCode = 'A01';