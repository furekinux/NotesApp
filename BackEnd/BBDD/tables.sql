create database notesApp;
use notesApp;

create table `user`(
	id int primary key not null auto_increment,
    username varchar(35) not null unique,
    password varchar(255) not null,
    creation_date datetime default current_timestamp
);

create table `note`(
	id int primary key not null auto_increment,
    id_user int not null,
    foreign key(id_user) references `user`(id),
    title varchar(60) not null,
    content text not null,
    creation_date datetime default current_timestamp
);

create table `history`(
	id int primary key not null auto_increment,
    action enum("UPDATE","CREATE","DELETE") not null,
	table_affected text not null,
    column_affected text,
    description text not null,
    date datetime default current_timestamp not null
);