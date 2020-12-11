CREATE TABLE IF NOT EXISTS account
(
	id int not null
			primary key,
	balance double precision default 0 not null
);