--liquibase formatted sql
--changeset KartikNirav:1
CREATE SEQUENCE todo_seq;

CREATE TABLE todo (id bigint NOT NULL DEFAULT NEXTVAL ('todo_seq'), status int DEFAULT NULL, title varchar(255) DEFAULT NULL, PRIMARY KEY (id));