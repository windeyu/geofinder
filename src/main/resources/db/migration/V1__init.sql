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
	PRIMARY KEY (id),
	account_id bigint references account(id)
);

CREATE TABLE location (
	id bigint NOT NULL,
	longitude varchar(50),
	latitude varchar(50),
	PRIMARY KEY (id),
	device_id bigint references device(id)
);

INSERT INTO account VALUES (0, 'tester', 'tester', true);
INSERT INTO device VALUES (0, 'MyDevice2');
INSERT INTO location VALUES (0, 'x', 'y', 0);

