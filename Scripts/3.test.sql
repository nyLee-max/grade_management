create view vw_student_table as
select s.stdNo as stdNo, stdName,classCode ,enterDate , PhotoName , stdPhoto ,
       max(if(sco.subNo = 1, sub.subNo , null))as 'subj4',max(if(sco.subNo = 1, sub.subName, null))as 'subj국어',max(if (sco.subNo = 1, sco.stdScore, 0))as '국어',
       max(if(sco.subNo = 2, sub.subNo , null))as 'subj5',max(if(sco.subNo = 2, sub.subName , null))as 'subj영어',max(if (sco.subNo = 2, sco.stdScore , 0))as '영어',
       max(if(sco.subNo = 3, sub.subNo , null))as 'subj6',max(if(sco.subNo = 3, sub.subName, null))as 'subj수학',max(if (sco.subNo = 3, sco.stdScore, 0))as '수학',
       max(if(sco.subNo = 4, sub.subNo , null))as 'subj7',max(if(sco.subNo = 4, sub.subName, null))as 'subj사회',max(if (sco.subNo = 4, sco.stdScore, 0))as '사회',
       max(if(sco.subNo = 5, sub.subNo , null))as 'subj8',max(if(sco.subNo = 5, sub.subName, null))as 'subj과학',max(if (sco.subNo = 5, sco.stdScore, 0))as '과학',
       sum(stdScore)as'합계',round(avg(stdScore),1)as'평균'
   FROM student s
        JOIN Score sco ON s.stdNo = sco.stdNo
        JOIN Subject sub ON sco.subNo = sub.subNo
   group by s.stdNo;
   
 select * from vw_student_table;
 
select stdNo, 국어, 영어, 수학, 사회, 과학 from vw_student_table where stdNo = 20001;

select * from score where stdNo = 6565;
select * from student where stdNo = 6565;
select * from subject;
select * from score where stdNo = 20001;

delete from score where no = 220


select * from score where stdNo = 20031;

delete from score where stdNo = 20031;