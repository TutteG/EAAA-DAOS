use Lektion02_Madklub

go 
insert into medlem values ('Henrik', 1, 1, 0)
insert into medlem values ('Jacob', 1, 2, 0)
insert into medlem values ('Martin', 1, 3, 0)
insert into medlem values ('Peter', 1, 4, 0)
insert into medlem values ('Torben', 1, 5, 0)
select * from medlem

insert into madaften values ('2018-08-18', 'Temafest', 0.0, 1)

insert into madaften values ('2018-08-19', 'En anden form for fest', 0.0, 1)
select * from madaften

insert into tilmelding values (1, '2018-08-18')
insert into tilmelding values (2, '2018-08-18')
insert into tilmelding values (3, '2018-08-18')
insert into tilmelding values (4, '2018-08-18')
insert into tilmelding values (5, '2018-08-19')

select * from tilmelding

select * from medlem, madaften
where medlem.medlemsnr = madaften.madtjans

select * from medlem, madaften, tilmelding
where medlem.medlemsnr = tilmelding.medlemsnr  and tilmelding.dato = '2018-08-19' and madaften.dato = '2018-08-19'

select * from medlem, madaften, tilmelding
where medlem.medlemsnr = tilmelding.medlemsnr and tilmelding.dato = madaften.dato

insert into transaktion values (500.75, 1)
select * from transaktion

