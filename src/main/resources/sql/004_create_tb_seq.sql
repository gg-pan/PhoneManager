-- Drop table

-- DROP TABLE public.tb_seq;

CREATE TABLE public.tb_seq (
	id varchar(32) NOT NULL,
	"module" varchar(10) NULL,
	prefix varchar(10) NULL,
	seq_num int2 NULL,
	updated_on timestamp(0) NULL,
	CONSTRAINT tb_seq_pk PRIMARY KEY (id)
);
