--创建用户
CREATE USER yh WITH PASSWORD 'yh';
--创建数据库
CREATE DATABASE yhmanager OWNER yh;
--授权
GRANT ALL PRIVILEGES ON DATABASE yhmanager TO yh;
