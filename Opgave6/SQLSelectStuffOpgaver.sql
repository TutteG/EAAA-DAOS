use eksempeldb
-- Opgave 6

-- 6.1 Find cpr på alle personer
select cpr from person
where stilling = 'systemudvikler'

-- 6.2 Find navn, løn og arbejdsmarkedsbidrag for alle personer
select navn, loen, (loen/100)*8 as arbejdsmarkedsbidrag from person 

-- 6.3 Find alle postnumre hvor der bor personer
select * from postnummer join person
on person.postnr = postnummer.postnr

-- 6.4 find alle personer med løn under 400000
select * from person 
where loen > 400000

-- 6.5 Find navne på de personer der bor i Aarhus C
select navn, postdistrikt from person join postnummer
on postnummer.postnr = person.postnr where postnummer.postdistrikt = 'Århus C'

--6.6 Find postdistrikter hvor der er personer der tjener mere end 400000
select postdistrikt from postnummer join person
on postnummer.postnr = person.postnr where person.loen > 400000


-- 6.7 Find de firmaer, der bor i ’Risskov’
select * from firma join postnummer
on firma.postnr = postnummer.postnr where postdistrikt = 'Risskov'

-- 6.8
select person.navn, firma.firmanavn from person join ansati
on person.cpr = ansati.cpr join firma on firma.firmanr = ansati.firmanr


-- 6.9
select person.navn, firma.firmanavn from person join ansati
on person.cpr = ansati.cpr join firma on firma.firmanr = ansati.firmanr 
where firma.firmanavn = 'Kommunedata'
