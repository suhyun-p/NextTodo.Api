create table IF NOT EXISTS todo_main (id long generated by default as identity, text varchar(255), color varchar(255), checked boolean);