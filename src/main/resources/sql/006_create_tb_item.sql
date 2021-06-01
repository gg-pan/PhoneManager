-- Drop table

-- DROP TABLE public.tb_item;

CREATE TABLE public.tb_item (
	id varchar(32) NOT NULL,
	created_on timestamp(0) NULL,
	updated_on timestamp(0) NULL,
	"version" int4 NULL,
	ref_no varchar(20) NULL,
	latest bool NULL,
	phone_id varchar(32) NULL,
	in_time timestamp(0) NULL,
	out_time timestamp(0) NULL,
	in_price numeric(5,2) NULL,
	out_price numeric(5,2) NULL,
	vendor_name varchar(20) NULL,
	vendor_phone varchar(15) NULL,
	vendor_id_card varchar(18) NULL,
	vendor_address varchar(100) NULL,
	customer_name varchar(20) NULL,
	customer_phone varchar(15) NULL,
	customer_id_card varchar(18) NULL,
	customer_address varchar(100) NULL,
	mortgage bool NULL,
	mortgage_name varchar(20) NULL,
	mortgage_phone varchar(15) NULL,
	mortgage_id_card varchar(18) NULL,
	mortgage_address varchar(100) NULL,
	mortgaged_on timestamp(0) NULL,
	mortgaged_time int4 NULL,
	mortgage_price numeric(5,2) NULL,
	remark varchar(500) NULL,
	CONSTRAINT tb_item_pk PRIMARY KEY (id)
);
