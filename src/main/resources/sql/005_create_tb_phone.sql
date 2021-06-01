-- Drop table

-- DROP TABLE public.tb_phone;

CREATE TABLE public.tb_phone (
	id varchar(32) NOT NULL,
	created_on timestamp(0) NULL,
	updated_on timestamp(0) NULL,
	"version" int4 NULL,
	ref_no varchar(20) NULL,
	latest bool NULL,
	status bool NULL,
	brand varchar(20) NULL,
	model varchar(20) NULL,
	new_phone bool NULL,
	serial_number varchar(20) NULL,
	CONSTRAINT tb_phone_pk PRIMARY KEY (id)
);
