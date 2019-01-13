create table book
(
	book_id serial not null
		constraint book_pk
			primary key,
	bookname varchar(250),
	cost integer,
	warehouse varchar(250),
	count integer
);

alter table book owner to postgres;

