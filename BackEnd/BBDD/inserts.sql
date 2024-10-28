use notesApp;

insert into `user`(id,username,password)values
(1,"furekinux","123");

insert into `note`(id,id_user,title,content)values
(1,1,"Recordatorio","Sacar la basura por que si no llegan los aliens a robar el salmòn que está secando en el tendedor.");

update `note`
set content="Sacar el perro para que se lo lleven los aliens."
where id=1;

select * from note;
select * from `history` where table_affected="note";