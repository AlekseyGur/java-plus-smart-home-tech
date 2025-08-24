create table if not exists products
(
    id               uuid default gen_random_uuid() primary key,
    name             varchar(200) not null,
    description      varchar(1000) not null,
    image_src        varchar(1000),
    rating           integer,
    price            double precision,
    quantity_state   varchar(50) not null,
    product_state    varchar(50) not null,
    product_category varchar(50) not null,
);