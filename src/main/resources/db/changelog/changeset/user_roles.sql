-- liquibase formatted sql
-- changeset bnikmik:1

create table user_roles
(
    user_id bigint not null references customer,
    role    varchar(255)
);

