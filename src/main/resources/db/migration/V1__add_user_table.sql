create table "user" (
    "id" uuid not null default gen_random_uuid(),
    "name" varchar(255) not null unique,
    "password" varchar(255),
    "role" varchar(255),
    primary key ("id")
);