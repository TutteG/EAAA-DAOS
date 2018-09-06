use Opgave2

drop table if exists ordrevare
drop table if exists vare
drop table if exists varetype
drop table if exists lager
drop table if exists ordre
drop table if exists chauffoer
drop table if exists vognmand
drop table if exists kunde

go

create table kunde(
kundenr int primary key identity(1000,1),
kundefornavn varchar(25) not null,
kundeefternavn varchar(25) not null,
kundeadresse varchar(100),
kundetlf varchar(25)
)

create table vognmand(
senr varchar(50) primary key,
firmanavn varchar(180),
telefon varchar(25)
)

create table chauffoer(
chauffoernavn varchar(25),
mobilnr varchar(25),
chauffoerid int primary key,
senr varchar(50) foreign key references vognmand(senr)
)

create table ordre(
ordrenr varchar(50) primary key,
ordredato Date,
leveringspris int,
kundenr int foreign key references kunde(kundenr),
chauffoerid int foreign key references chauffoer(chauffoerid)
)

create table lager(
lagernr int primary key,
lageradresse varchar(100)
)

create table varetype(
varetypenr varchar(25) primary key,
betegnelse varchar(500),
lagernr int foreign key references lager(lagernr)
)

create table vare(
varenr varchar(25) primary key,
varenavn varchar(50),
pris int,
varetypenr varchar(25) foreign key references varetype(varetypenr)
)

create table ordrevare(
ordrenr varchar(50) constraint ordrenrforeign foreign key (ordrenr) references ordre(ordrenr),
varenr varchar(25) constraint varenrforeign foreign key (varenr) references vare(varenr),
antal int not null,
primary key(ordrenr, varenr)
)