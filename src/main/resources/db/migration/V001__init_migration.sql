CREATE SCHEMA IF NOT EXISTS my_store;

-- Создание последовательности
CREATE SEQUENCE IF NOT EXISTS my_store.my_store_id_seq;
-- Создание таблицы
CREATE TABLE IF NOT EXISTS my_store.product
(
    id               integer NOT NULL DEFAULT next-val('my_store.my_store_id_seq'),
    name             text NOT NULL,
    cost             double,
     PRIMARY KEY(id)
    );
-- Создание таблицы
CREATE TABLE IF NOT EXISTS my_store.order
(
    id               integer NOT NULL DEFAULT next-val('my_store.my_store_id_seq'),
    creation_date    date,
    cost             double,
    fk_products_id   integer constraint data_source_fk_product_id_fkey references my_store.product,
     PRIMARY KEY(id)