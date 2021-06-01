-- Drop table

-- DROP TABLE public.tb_user;

CREATE TABLE public.tb_user (
	id varchar(32) NOT NULL,
	created_on timestamp(0) NULL,
	updated_on timestamp(0) NULL,
	"version" int4 NULL,
	ref_no varchar(20) NULL,
	latest bool NULL,
	status bool NULL,
	"name" varchar(20) NULL,
	email varchar(20) NULL,
	phone_num varchar(20) NULL,
	"password" varchar(20) NULL,
	CONSTRAINT tb_user_pk PRIMARY KEY (id)
);
