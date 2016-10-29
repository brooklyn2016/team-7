create table users (
  id                      int          auto_increment primary key,
  username 				        varchar(50)  not null unique,
	password 				        varchar(100) not null,
	firstname 				      varchar(50)  not null,
	lastname 				        varchar(50)  not null,
	email 					        varchar(100) not null unique,
	account_non_expired		  boolean      not null default true,
	account_non_locked		  boolean      not null default true,
	credentials_non_expired	boolean      not null default true,
	enabled					        boolean      not null default true
);

CREATE TABLE groups (
  id                      int         auto_increment PRIMARY KEY,
  name                    VARCHAR(50) NOT NULL
);

CREATE TABLE users_groups (
  id                      int         auto_increment PRIMARY KEY,
  user_id                 int         NOT  NULL,
  group_id                int         NOT NULL,
  CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(id),
  CONSTRAINT fk_group_id FOREIGN KEY (group_id) REFERENCES groups(id)
);