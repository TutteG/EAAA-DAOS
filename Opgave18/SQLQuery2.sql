use BankDB
select * from bankkunde

--18.1
select * from
konto
where konto.saldo > 1000


--18.2
select * from postering p
order by p.dato


--18.3
select * from bankkunde b
where b.navn like '%a%'

--18.4
select b.navn, k.kontonr, k.saldo
from bankkunde b
join konto k
on b.cpr = k.kontoejer

--18.5
select b.navn, k.kontonr, k.saldo
from bankkunde b
join konto k
on b.cpr = k.kontoejer
where k.saldo < 0

--18.6
select b.navn from bankkunde b
join konto k
on b.cpr = k.kontoejer
where YEAR(k.oprettet) = YEAR(GETDATE())

--18.7
select distinct b.navn from bankkunde b
join konto k
on b.cpr = k.kontoejer
join postering p
on p.kontonr = k.kontonr
where YEAR(p.dato) = YEAR(GETDATE())

--18.8
select distinct b.navn from bankkunde b
join konto k
on b.cpr = k.kontoejer
join postering p
on p.kontonr = k.kontonr
where YEAR(p.dato) = YEAR(GETDATE()) 
or YEAR(p.dato) = YEAR(GETDATE())

--18.9
select SUM(k.saldo)
from konto k

--18.10
select SUM(k.saldo)
from konto k
where k.kontoejer = '12'

--18.11
select b.navn, SUM(k.saldo) as 'samlet indestående'
from konto k
join bankkunde b
on b.cpr = k.kontoejer
group by b.navn

--18.12
select b.navn, SUM(k.saldo) as samletindestående
from konto k
join bankkunde b
on b.cpr = k.kontoejer
group by b.navn
having SUM(k.saldo) < 0

--18.13
select * from bankkunde
where bankkunde.cpr not in (select konto.kontoejer from konto)

--18.14
select distinct b.navn from bankkunde b
join konto k
on k.kontoejer = b.cpr
where k.saldo in (select MAX(konto.saldo) from konto)