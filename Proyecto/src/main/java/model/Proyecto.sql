
create table tbRol(
idRol int primary key not null,
descripcionRol varchar(10) not null);

create table tbUsuario( 
idUsuario varchar (30) primary key not null,
clave varchar (8) not null,
nombre varchar(30) not null,
telefono varchar (9) unique,
correo varchar(30) unique,
idRol_FK int default 1 not null,
foreign key (idRol_FK) references tbRol (idRol));

create table tbSugerencia(
idSugerencia int GENERATED ALWAYS AS IDENTITY
(START WITH 1, INCREMENT BY 1) primary key,
asunto varchar(30) not null,
descripcionSu varchar(100) not null,
idUsuario_FK varchar(30),
foreign key (idUsuario_FK) references tbUsuario (idUsuario));

create table tbCategoria(
idCategoria int primary Key not null,
nombreCategoria varchar(20));

create table tbProveedor(
idProveedor int GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1) primary key ,
nombreProveedor varchar (20) not null,
direccionProveedor varchar (20) not null,
telefonoProveedor varchar(9) unique,
correoProveedor varchar(30) unique);

insert into tbProveedor (nombreProveedor,direccionProveedor,telefonoProveedor,correoProveedor)values ('Intcomex','San Jos�','2222-2222','intcomex@gmail.com');
insert into tbProveedor (nombreProveedor,direccionProveedor,telefonoProveedor,correoProveedor)values ('Tecnologia','Cartago','3333-3333','Tecnologia@gmail.com');
insert into tbProveedor (nombreProveedor,direccionProveedor,telefonoProveedor,correoProveedor)values ('Tecno','Heredia','4444-4444','Tecno@gmail.com');



create table tbProducto(
idProducto int GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1) primary Key ,
nombreProducto varchar(30) not null,
descripcionProducto varchar(30) not null,
precio int not null,
cantidad int not null,
idCategoria_FK int not null,
idProveedor_FK int not null,
idUsuario_FK varchar (30) not null,
foreign key (idCategoria_FK) references tbCategoria (idCategoria),
foreign key (idProveedor_FK) references tbProveedor (idProveedor),
foreign key (idUsuario_FK) references tbUsuario (idUsuario));


create table tbFavorito(
idFavorito int GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1) primary Key not null,
idProducto_FK int not null,
foreign key (idProducto_FK) references tbProducto (idProducto));

create table tbCarrito(
idCarrito int GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1) primary Key not null,
cantidadCarrito int not null,
constraint cantidadCa check (cantidadCarrito<20),
idProducto_FK int not null,
foreign key (idProducto_FK) references tbProducto (idProducto));

create table tbFormaPago(
idPago int primary key not null,
nombreFormaPago varchar(20) not null);

create table tbFactura (
idFactura int GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1) primary Key not null,
fecha date not null,
idCarrito_FK int  not null,
idPago_FK int not null,
foreign key (idCarrito_FK) references tbCarrito (idCarrito),
foreign key (idPago_FK) references tbFormaPago (idPago));


insert into tbRol(idRol,descripcionRol)
values (1,'Cliente'), (2,'Admin'),(3,'Reportes');

insert into tbUsuario(idUsuario,clave,nombre,telefono,correo,idRol_FK) values('AleF','Ad123456','Alejandro Fallas','8888-8888','correo@gmail.com',2);

update tbUsuario set clave='Ad123456' where idUsuario='AleF';

insert into tbCategoria (idCategoria,nombreCategoria) values (2,'Computadoras');
insert into tbCategoria (idCategoria,nombreCategoria) values (3,'Monitores');

insert into tbProducto (nombreProducto,descripcionProducto,precio,cantidad,idCategoria_FK,idProveedor_FK,idUsuario_FK)
values ('Laptop HP','4 GB RAM,COREi7',380000,5,2,2,'AleF')

