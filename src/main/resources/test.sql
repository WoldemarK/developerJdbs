-- вывести все по developer,specialty,skill
select d.firstName as First_Name_Dev,
       d.lastName  as Last_Name_Dev,
       sp.name     as specialty,
       sk.name     as Skill
from developer d join specialty sp on d.specialtyid = sp.id, skill sk, developer_skill ds
where ds.developerid = d.id and ds.skillid = sk.id;

-- найти по имени все данные developer,specialty,skill
select d.firstName as First_Name_Dev,
       d.lastName  as Last_Name_Dev,
       sp.name     as specialty,
       sk.name     as Skill
from developer d
         join specialty sp on d.specialtyid = sp.id,
     skill sk,
     developer_skill ds
where ds.developerid = d.id
  and ds.skillid = sk.id and d.firstname = 'Tom' group by d.firstName, d.lastName, sp.name, sk.name;




