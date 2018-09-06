use Lektion02_Madklub

go 
insert into medlem values ('Henrik', 1, 1, 0)
insert into medlem values ('Jacob', 1, 2, 0)
insert into medlem values ('Martin', 1, 3, 0)
insert into medlem values ('Peter', 1, 4, 0)
insert into medlem values ('Torben', 1, 5, 0)
select * from medlem

insert into madaften values ('2018-08-18', 'Temafest', 0.0, 1)
select * from madaften

insert into tilmelding values (1, '2018-08-18')
select * from tilmelding

insert into transaktion values (500.75, 1)
select * from transaktion