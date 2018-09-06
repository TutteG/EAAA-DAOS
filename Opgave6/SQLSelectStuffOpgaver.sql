use eksempeldb
-- Opgave 6

-- 6.1 Find cpr p� alle personer
select cpr from person
where stilling = 'systemudvikler'

-- 6.2 Find navn, l�n og arbejdsmarkedsbidrag for alle personer
select navn, loen, (loen/100)*8 as arbejdsmarkedsbidrag from person 

-- 6.3 Find alle postnumre hvor der bor personer
select * from postnummer join person
on person.postnr = postnummer.postnr

select * from person 
where loen > 400000

-- 6.5 Find navne p� de personer der bor i Aarhus C
select navn, postdistrikt from person join postnummer
on postnummer.postnr = person.postnr where postnummer.postdistrikt = '�rhus C'