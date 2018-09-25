use eksempeldb

drop view if exists personView
drop view if exists hoboView

go
create view hoboView
as
select p.navn, p.stilling, pn.postdistrikt, isnull(f.firmanavn, 'Ukendt') as firma
from person p
left join ansati a
on p.cpr = a.cpr
left join firma f
on f.firmanr = a.firmanr
join postnummer pn
on p.postnr = pn.postnr

go
select * from hoboView


go
create view personView
as
select p.navn, p.stilling, pn.postdistrikt, isnull(f.firmanavn, 'Ukendt') as firma, postnr.postdistrikt as firmapostdistrikt
from person p
join postnummer pn
on p.postnr = pn.postnr
left join ansati a
on p.cpr = a.cpr
left join firma f
on f.firmanr = a.firmanr
join postnummer postnr
on f.postnr = postnr.postnr
where p.stilling = 'Programmør'

go
select * from personView
