-- insert default user record
INSERT INTO tb_user (id, created_on, updated_on, "version", ref_no, latest, status, "name", email, phone_num, "password") VALUES (REPLACE(uuid_generate_v4()::varchar, '-', ''), now(), now(), 1, 'USER-21060001', TRUE, TRUE, 'admin', 'admin@admin.com', '11111111111', 'password');
