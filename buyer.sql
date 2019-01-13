create table buyer
(
	buyer_id serial not null
		constraint buyer_pk
			primary key,
	first_name varchar(250),
	district varchar(250),
	sale integer
);

alter table buyer owner to postgres;

