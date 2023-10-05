create table bakery.users
(
    id           bigint auto_increment
        primary key,
    name         varchar(32)  not null,
    login_token  varchar(256) not null,
    email        varchar(64)  null,
    sns_id       varchar(64)  null,
    phone_number varchar(32)  null,
    address      varchar(256) null
);

create table bakery.breads
(
    id                 bigint auto_increment
        primary key,
    title              varchar(32)                          not null,
    description        text                                 not null,
    remaining_quantity int      default 0                   not null,
    thumbnail_url      varchar(256)                         null,
    view_order         int      default 0                   not null,
    created_at         datetime default current_timestamp() not null,
    updated_at         datetime default current_timestamp() not null,
    created_by         varchar(32)                          null
);

create table bakery.carts
(
    id         bigint auto_increment
        primary key,
    user_id    bigint        not null,
    bread_id   bigint        not null,
    item_count int default 1 not null,
    constraint FK_breads_carts
        foreign key (bread_id) references bakery.breads (id)
            on update cascade on delete cascade,
    constraint FK_users_carts
        foreign key (user_id) references bakery.users (id)
            on update cascade on delete cascade
);

create table bakery.comments
(
    id          bigint auto_increment
        primary key,
    user_id     bigint                               not null,
    bread_id    bigint                               not null,
    description varchar(200)                         not null,
    created_at  datetime default current_timestamp() not null,
    updated_at  datetime default current_timestamp() not null,
    constraint FK_breads_comments
        foreign key (bread_id) references bakery.breads (id)
            on update cascade on delete cascade,
    constraint FK_users_comments
        foreign key (user_id) references bakery.users (id)
            on update cascade on delete cascade
);