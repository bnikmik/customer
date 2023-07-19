-- liquibase formatted sql
-- changeset bnikmik:1

create table customer
(
    id           bigserial primary key,
    avatar       bytea,
    email        varchar(255),
    is_verified  boolean not null,
    phone_number varchar(255)
);