DROP TABLE IF EXISTS items;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 10000;

CREATE TABLE items (
  id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  title     VARCHAR(45) NOT NULL,
  delivery  TIMESTAMP DEFAULT now(),
  quantity  INTEGER NOT NULL,
  enabled   BOOLEAN DEFAULT FALSE
);

CREATE UNIQUE INDEX items_unique_title_delivery_idx ON items(title, delivery);