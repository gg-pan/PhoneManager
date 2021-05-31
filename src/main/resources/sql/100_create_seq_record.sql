-- insert seq record
INSERT INTO tb_seq (id, "module", prefix, seq_num) VALUES (REPLACE(uuid_generate_v4()::varchar, '-', ''), 'user', 'USER', 1);
INSERT INTO tb_seq (id, "module", prefix, seq_num) VALUES (REPLACE(uuid_generate_v4()::varchar, '-', ''), 'phone', 'PHONE', 1);
