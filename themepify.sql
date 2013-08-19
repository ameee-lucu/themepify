create database themepifydb;

create table uploader(
id bigint not null,
email character varying(200),
phone_no character varying(200),
name character varying(200),
status character varying(1),
social_media character varying(250),
token character varying(1024),
password character varying(1024),
virtual_id character varying(1024),
constraint pk_uploader_id primary key(id)
);

create table category(
id integer not null,
name character varying(200),
description character varying(1024),
constraint pk_category_id primary key(id)
);

create table product(
id bigint not null,
category_id integer not null,
uploader_id bigint not null,
name character varying(1024),
location_path character varying(1024),
icon character varying(1024),
price numeric(12,2),
description text, -- jika bisa isinya menggunakan markdown (bisa tag gambar, video dll)
constraint pk_product_id primary key(id),
constraint fk_product_category_id foreign key(category_id) references category(id),
constraint fk_product_uploader_id foreign key(uploader_id) references uploader(id)
);


create table tag(
id bigint not null,
tag character varying(1024),
product_id bigint not null,
constraint pk_tag_id primary key(id),
constraint fk_tag_product_id foreign key(product_id) references product(id)
);

create table product_love(
uploader_id bigint not null,
product_id bigint not null,
constraint pk_product_love_id primary key(uploader_id,product_id),
constraint fk_product_love_uploader_id foreign key(uploader_id) references uploader(id),
constraint fk_product_love_product_id foreign key(product_id) references product(id)
);


create table follow(
uploader_id bigint not null,
follower_id bigint not null,
constraint pk_follow_id primary key(uploader_id,follower_id),
constraint fk_follow_uploader_id foreign key(uploader_id) references uploader(id),
constraint fk_follow_follower_id foreign key(follower_id) references uploader(id)
);

create table product_log( -- setiap kali download harus masuk ke product log
id bigint not null,
logtime timestamp not null,
product_id bigint not null, 
uploader_id bigint not null,
constraint pk_product_log_id primary key(id),
constraint fk_product_log_uploader_id foreign key(uploader_id) references uploader(id),
constraint fk_product_log_product_id foreign key(product_id) references product(id)
);


create table partner(
id bigint not null,
name character varying(200),
email character varying(250),
token character varying(1024),
verify character varying(250),
notify character varying(250),
constraint pk_partner_id primary key(id)
);



create table partner_formula(
id bigint not null,
partner_id bigint not null,
fix_value numeric(12,2),
percentage numeric(3,2),
status character varying(1),
constraint pk_partner_formula_id primary key(id),
constraint fk_partner_formula_partner_id foreign key(partner_id) references partner(id)
);


create table transactions( -- hanya setiap transaksi pembelian template yang masuk ke sini.
id bigint not null,
product_id bigint not null,
uploader_id bigint not null,
status character varying(1),
transtime timestamp,
price numeric(12,2),
total_price numeric(12,2),
partner_comission numeric(12,2),
admin_comission numeric(12,2),
vat numeric(12,2),
fee_1 numeric(12,2),
fee_2 numeric(12,2),
channel character varying(1),
partner_formula_id bigint not null,
constraint pk_transactions_id primary key(id),
constraint fk_transactions_product_id foreign key(product_id) references product(id),
constraint fk_transactions_uploader_id foreign key(uploader_id) references uploader(id),
constraint fk_transactions_partner_formula_id foreign key(partner_formula_id) references partner_formula(id)
);


-- Table: userconnection

-- DROP TABLE userconnection;

CREATE TABLE userconnection
(
  userid character varying(255) NOT NULL,
  providerid character varying(255) NOT NULL,
  provideruserid character varying(255) NOT NULL,
  rank integer NOT NULL,
  displayname character varying(255),
  profileurl character varying(512),
  imageurl character varying(512),
  accesstoken character varying(255) NOT NULL,
  secret character varying(255),
  refreshtoken character varying(255),
  expiretime bigint,
  CONSTRAINT userconnection_pkey PRIMARY KEY (userid, providerid, provideruserid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE userconnection
  OWNER TO postgres;

-- Index: userconnectionrank

-- DROP INDEX userconnectionrank;

CREATE UNIQUE INDEX userconnectionrank
  ON userconnection
  USING btree
  (userid, providerid, rank);

-- untuk sequence, menu admin, user admin sama tetek bengek admin dibuat sendiri ya sal :p





