use Opgave7_Cykelrytter

go

select vm.aarstal from vm


--8.1
select distinct rytter.init, COUNT(*) from rytter join placering
on rytter.init = placering.init
group by rytter.init


--8.2
select distinct rytter.init, COUNT(placering.plac) from rytter join placering
on rytter.init = placering.init
group by rytter.init

--8.3
select distinct rytter.init, COUNT(placering.plac) as Placeringer,  MIN(placering.plac) as 'Bedste Placering', MAX(placering.plac) as 'Dårligste Placering' from rytter join placering
on rytter.init = placering.init
group by rytter.init
having count(placering.plac) > 1

--8.4
select distinct vm.aarstal, count(*) as 'Danmarks Drenge' from vm join placering
on vm.aarstal = placering.aarstal
group by vm.aarstal


--8.5
select distinct vm.aarstal, count(placering.plac) as 'Danmarks Drenge' from vm join placering
on vm.aarstal = placering.aarstal
group by vm.aarstal
having count(placering.plac) > 0


--8.6
select distinct vm.aarstal, count(*)-count(placering.plac) as 'Danmarks Drenge' 
from vm join placering
on vm.aarstal = placering.aarstal 
group by vm.aarstal
having COUNT(*)-COUNT(placering.plac) > 0

--8.7
select distinct vm.aarstal, MIN(placering.plac) as 'Danmarks Drenge bedste placering' 
from vm join placering
on vm.aarstal = placering.aarstal
group by vm.aarstal
having MIN(placering.plac) > 0

