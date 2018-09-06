use Opgave7_Cykelrytter

go

-- 7.1
select rytter.init, placering.aarstal, placering.plac from rytter join placering
on rytter.init = placering.init where placering.plac is not null


--7.2
select rytter.init, rytter.rytternavn, placering.aarstal, placering.plac from rytter join placering
on rytter.init = placering.init where placering.plac is not null

--7.3 
select rytter.init, rytter.rytternavn, placering.aarstal, placering.plac, vm.bynavn, vm.land
 from rytter join placering
on rytter.init = placering.init join vm 
on vm.aarstal = placering.aarstal
where placering.plac is not null

--7.4
select rytter.rytternavn, placering.plac, placering.aarstal from rytter join placering
on rytter.init = placering.init join vm
on vm.aarstal = placering.aarstal
where placering.plac is not null
order by placering.plac asc, placering.aarstal asc

--7.5
select distinct rytter.rytternavn from rytter join placering
on rytter.init = placering.init where placering.plac is not null


--7.6
select distinct rytter.rytternavn from rytter join placering
on rytter.init = placering.init join vm 
on placering.aarstal = vm.aarstal
where placering.plac is null and vm.land = 'Italien'


--7.7
select distinct rytter.rytternavn from rytter join placering
on rytter.init = placering.init where placering.plac < 4

--7.8
select max(placering.plac) as 'Dårligste Placering' from placering
where placering.plac is not null

--7.9
select count(placering.plac) from placering join rytter
on placering.init = rytter.init
where rytter.init = 'AJ' and placering.plac is not null

--7.10
select count(*) - count(placering.plac) as 'ikke gennemført' from placering join rytter
on placering.init = rytter.init
where rytter.init = 'AJ'

select (count(placering.plac)*1.0/count(*))*100.0 as 'fuldeførelsesprocent' from placering
