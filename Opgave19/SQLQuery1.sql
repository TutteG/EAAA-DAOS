use BankDB

select konto.kontoejer from konto

--opg. 19.1
go
create or alter trigger notNegTrigger
on konto
after insert, update
as
if exists (select * from inserted where saldo < 0)
begin
rollback tran
raiserror('Saldo kan ikke være negativ',16,1)
end

insert into konto values('12', GETDATE(), -100)

update konto 
set saldo = -100
where kontoejer = '12'




--opg. 19.2
go
create or alter trigger insertMoneyzTrigger
on postering
after insert
as 
if exists (select * from inserted)
begin 
update konto set saldo = saldo + (select beloeb from inserted)
where (select kontonr from inserted) = konto.kontonr
end

go
insert into postering values(1006, GETDATE(), 300)

select * from konto



--opg. 19.3
go
create or alter trigger insertMoneyzTrigger
on postering
after insert, update
as 
if exists (select * from inserted)
begin 
update konto set saldo = saldo + (select beloeb from inserted)
where (select kontonr from inserted) = konto.kontonr
end


go
create or alter trigger deleteMoneyzTrigger
on postering
after delete, update
as 
if exists (select * from deleted)
begin 
update konto set saldo = saldo - (select beloeb from deleted)
where (select kontonr from deleted) = konto.kontonr
end

insert into postering values(1006, GETDATE(), 600)

select * from postering

delete postering 
where postering.posteringsnr = 19

select * from konto




--opg 19.4
go
create or alter trigger noMoreThan4Trigger
on konto
after insert
as
if (select COUNT(*) from inserted join konto 
on inserted.kontoejer = konto.kontoejer) > 3
begin 
rollback tran
raiserror('Ikke mere end tre kontoer tak!', 16,1)
end

insert into konto values ('12', GETDATE(), 100)

select * from konto
order by kontoejer 