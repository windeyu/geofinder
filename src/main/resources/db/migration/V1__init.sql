CREATE TABLE account (
	id bigint NOT NULL,
	name varchar(100),
	password varchar(100),
	enabled boolean not null default true,
	PRIMARY KEY (id)
);

CREATE TABLE device (
	id bigint NOT NULL,
	name varchar(100),
	created timestamp with time zone NOT NULL DEFAULT now(),
	PRIMARY KEY (id),
	account_id bigint references account(id)
);

CREATE SEQUENCE location_seq;

CREATE TABLE location (
	id bigint NOT NULL,
	timestamp timestamp with time zone NOT NULL DEFAULT now(),
	longitude varchar(50),
	latitude varchar(50),
	PRIMARY KEY (id),
	device_id bigint references device(id)
);

INSERT INTO account VALUES (0, 'tester', 'tester', true);
INSERT INTO device (id, name, account_id) VALUES (0, 'iPhone 7', 0);
INSERT INTO device (id, name, account_id) VALUES (1, 'HTC U Ultra', 0);
-- INSERT INTO location VALUES (0, to_timestamp('2017-12-30 15:36:38 PST', 'YYYY-MM-DD hh24:mi:ss'), '1', '11', 0);
-- INSERT INTO location VALUES (1, to_timestamp('2017-12-30 16:36:38 PST', 'YYYY-MM-DD hh24:mi:ss'), '2', '22', 0);
-- INSERT INTO location VALUES (2, to_timestamp('2017-12-30 17:36:38 PST', 'YYYY-MM-DD hh24:mi:ss'), '3', '33', 0);
-- INSERT INTO location VALUES (3, to_timestamp('2017-12-30 18:36:38 PST', 'YYYY-MM-DD hh24:mi:ss'), '4', '44', 0);
-- INSERT INTO location VALUES (4, to_timestamp('2017-12-30 19:36:38 PST', 'YYYY-MM-DD hh24:mi:ss'), '5', '55', 0);

