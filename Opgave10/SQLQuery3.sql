use Opgave7_Cykelrytter

select *
from rytter r join placering p
on r.init = p.init
order by p.aarstal


--10.1
select r.init , r.rytternavn
from rytter r
where r.init NOT IN 
(select p.init from placering p
where p.plac IS NOT NULL)

--10.2
select distinct r.init, r.rytternavn 
from rytter r
where r.init NOT IN
(select distinct p.init 
from placering p
where p.plac is null)

--10.3
select distinct r.init, r.rytternavn 
from rytter r join placering p
on r.init = p.init
where p.aarstal > 1970 and p.aarstal < 1980 and r.init NOT IN
(select distinct p.init 
from placering p
where p.plac is null)

--10.4
select * from vm
where vm.aarstal not in (select placering.aarstal from placering)

--10.5
-- jeg har overvejet det nu..