create schema db_construcaoprova;


use db_construcaoprova;

create table veiculo(
    ano int(11) not null,
    placa varchar(10) not null primary key unique);


    select * from veiculo;

    INSERT INTO `db_construcaoprova`.`veiculo`
        (`ano`,`placa`)

VALUES("3000 ","AAA-9999");


create table onibus(

	assentos int not null


);

 INSERT INTO `db_construcaoprova`.`onibus`
        (`assentos`)

        VALUES("28");



create table caminhao(

	eixos int(9)

);

	INSERT INTO `db_construcaoprova`.`caminhao`
    (`eixos`)
	VALUES("9")


