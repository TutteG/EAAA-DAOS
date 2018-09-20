--
-- views
--
create view mitview1
as
-- SELECT - query

use cykeldb
go
create view fuldførte
as
select * 
from placering
where plac is not null
go
select * from fuldførte
go
drop view fuldførtemedalt
go
create view fuldførtemedalt
as
select rytternavn,p.aarstal as aar,plac,bynavn,land
from rytter r join placering p on r.init = p.init
              join vm on p.aarstal=vm.aarstal
where plac is not null
go
select * from fuldførtemedalt
order by aar desc
--
--
-- Stored procedures
--
create proc myproc
as
-- T-SQL
go
create proc myproc
as
select distinct aarstal
from placering
where plac is null
go
exec myproc
go
create proc myproc2 
@init char(3)
as
select distinct aarstal
from placering
where plac is null and init = @init
go
exec myproc2 'JS'
go
create proc myproc3 (@init char(3),@before int)
as
select distinct aarstal
from placering
where plac is null and init = @init
and aarstal < @before
go
exec myproc3 'JS',1996
go
create proc myproc4  (@init char(3),@antal int output) 
as
select @antal=count(*)
from placering
where plac is null and init = @init
go
declare @x int
exec myproc4 'JS',@x output
select @x
go

create proc myproc5  (@init char(3)) 
as
select count(*)
from placering
where plac is null and init = @init

exec myproc5 'JS'