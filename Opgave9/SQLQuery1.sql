use eksempeldb


--9.1
select avg(person.loen)
from person

--9.2
select avg(person.loen), postnummer.postnr 
from postnummer join person
on person.postnr = postnummer.postnr
group by postnummer.postnr

--9.3
select person.stilling, count( person.stilling) as Antal 
from person 
group by person.stilling

--9.4
select avg(loen) 
from person 
group by person.stilling
having count(person.stilling) > 1

--9.5
select person.navn 
from person
where person.cpr NOT IN (select ansati.cpr from ansati)

--9.6
select postnummer.postnr from postnummer
where postnummer.postnr NOT IN (select person.postnr from person)
AND postnummer.postnr NOT IN (select firma.postnr from firma)

--9.7
select p.navn, p.loen
from person p
where p.loen > (select AVG(loen) from person)

--9.8
select f.firmanavn 
from firma f
where f.firmanr not in (select ansati.firmanr from ansati)