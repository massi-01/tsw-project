CREATE DATABASE IF NOT EXISTS tsw;
USE TSW;

CREATE TABLE users(
    username varchar(20) primary key,
    pwd varchar(20) not null,
    nome varchar(20) not null,
    cognome varchar(20) not null
);

CREATE TABLE viaggio(
    codice CHAR(6) primary key,
    nome varchar(20) not null,
    prezzo float not null,
    giorni int not null,
    citta varchar(20) not null,
    stato varchar(20) not null,
    descrizione varchar(255) not null,
    foto mediumblob not null
);
