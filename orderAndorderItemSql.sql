DROP TABLE IF EXISTS orders;

create table orders (
id bigserial not null
, order_number text not null
, user_id bigint not null
, status integer not null
, total_price integer not null
, order_date date not null
, delivery_name varchar(100)
, delivery_email varchar(100)
, delivery_zip_code varchar(8)
, delivery_address varchar(200)
, delivery_tel varchar(15)
, constraint orders_PKC primary key (id)
) ;

Drop table if exists order_items;

create table order_items (
id bigserial not null
, item_id bigint not null
, order_id bigint not null
, quantity integer not null
);