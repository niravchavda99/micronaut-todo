--liquibase formatted sql
--changeset KartikNirav:1
CREATE TABLE todo (id bigint(20) NOT NULL AUTO_INCREMENT, status int(11) DEFAULT NULL, title varchar(255) DEFAULT NULL, PRIMARY KEY (id));