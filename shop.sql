create table shop
(
	shop_id serial not null
		constraint shop_pk
			primary key,
	name varchar(250),
	district varchar(250),
	commissions integer
);

alter table shop owner to postgres;

