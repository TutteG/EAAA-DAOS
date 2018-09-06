use Lektion02_Madklub

drop table if exists transaktion
drop table if exists tilmelding
drop table if exists madaften
drop table if exists medlem

create table medlem(
medlemsnr int primary key identity,
navn varchar(50), 
gangnr int,
værelsesnr int,
tilgode decimal(6,2)
)

create table madaften(
dato date primary key,
beskrivelse varchar(180),
udgift decimal(6, 2),
madtjans int foreign key references medlem(medlemsnr) not null
)

create table tilmelding(
medlemsnr int foreign key references medlem(medlemsnr),
dato date foreign key references madaften(dato),
primary key(medlemsnr, dato)
)

create table transaktion(
transaktionsid int primary key identity,
beloeb decimal(6,2),
medlemsnr int foreign key references medlem(medlemsnr)
)