-- insert seq record
INSERT INTO tb_seq (id, "module", prefix, seq_num, updated_on) VALUES (REPLACE(uuid_generate_v4()::varchar, '-', ''), 'user', 'USER', 1, now());
INSERT INTO tb_seq (id, "module", prefix, seq_num, updated_on) VALUES (REPLACE(uuid_generate_v4()::varchar, '-', ''), 'phone', 'PHONE', 1, now());