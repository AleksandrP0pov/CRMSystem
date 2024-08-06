
create table orders
(
    id bigserial not null
        primary key,
    number_order bigint
);


create table product_counter
(
    id bigserial not null
        primary key,
    product_id bigint,
    quantity   int not null,
    order_id bigint
);

alter table if exists product_counter
    add constraint product_counter_order_fk
    foreign key (order_id) references orders;



