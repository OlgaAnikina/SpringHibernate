create table buy
(
	buy_id serial not null
		constraint buy_pk
			primary key,
	saller integer
		constraint saller
			references shop,
	buyer integer
		constraint buy_buyer_id_fk
			references buyer,
	book integer
		constraint buy_book_id_fk
			references book,
	count integer,
	cost integer,
	datebuys date
);

alter table buy owner to postgres;

