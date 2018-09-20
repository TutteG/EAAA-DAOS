use BankDB
select * from bankkunde
-- 17.1
drop proc if exists myproc

create proc myProc
as
select bk.navn, k.kontonr, k.saldo 
from konto k
join bankkunde bk
on bk.cpr = k.kontoejer

exec myProc

--17.2
drop proc if exists myProc2

create proc myProc2 
@cpr char(10)
as
select bk.navn, k.kontonr, k.saldo 
from konto k
join bankkunde bk
on bk.cpr = k.kontoejer
where bk.cpr = @cpr

exec myProc2 '12'


--17.3
drop proc if exists myProc3

create proc myProc3 
@cpr char(10)
as
select SUM(k.saldo) as saldo
from bankkunde bk
join konto k
on bk.cpr = k.kontoejer
where bk.cpr = @cpr


exec myProc3 '12'



--17.4
drop proc if exists myProc4

create proc myProc4 
@cpr char(10), @antal int output
as
select @antal = SUM(k.saldo)
from bankkunde bk
join konto k
on bk.cpr = k.kontoejer
where bk.cpr = @cpr

declare @x int
exec myProc4 '12', @x output
select @x as saldo

--17.5
drop proc if exists myProc5

create proc myProc5
@kontonr int, @beloeb decimal
as
insert into postering values(@kontonr, GETDATE(), @beloeb)
update konto set saldo = saldo + @beloeb
where konto.kontonr = @kontonr

exec myProc5 1001, 200
exec myProc2 '12'

--17.6
drop proc if exists myProc6

create proc myProc6
@cpr char(10)
as
delete postering 
where kontonr in(
select konto.kontonr 
from konto
where konto.kontoejer = @cpr)
delete konto
where konto.kontoejer = @cpr
delete bankkunde
where bankkunde.cpr = @cpr 

exec myProc2 '13'
exec myProc6 '13'
