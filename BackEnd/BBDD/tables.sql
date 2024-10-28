create database notesApp;
use notesApp;

create table `user`(
	id int primary key not null auto_increment,
    username varchar(35) not null,
    password varchar(255) not null,
    creationDate datetime default current_timestamp
);

create table `history`(
	id int primary key not null auto_increment,
    id_user int not null,
    foreign key(id_user)references `user`(id),
);

create table `note`(
	id int primary key not null auto_increment,
    id_history int not null,
    foreign key(id_history) references `history`(id),
    title varchar(60) not null,
    content text not null,
    creationDate datetime default current_timestamp
);
