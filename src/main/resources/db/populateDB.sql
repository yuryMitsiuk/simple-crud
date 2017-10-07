DELETE FROM items;
ALTER SEQUENCE global_seq RESTART WITH 10000;

INSERT INTO items (title, delivery, quantity) VALUES ('Item1', '2017-10-05 09:00:00', 75);
INSERT INTO items (title, delivery, quantity) VALUES ('Item2', '2017-10-06 13:00:00', 175);
INSERT INTO items (title, delivery, quantity) VALUES ('Item3', '2017-10-07 19:00:00', 35);
INSERT INTO items (title, delivery, quantity) VALUES ('Item4', '2017-10-08 09:35:00', 90);
INSERT INTO items (title, delivery, quantity) VALUES ('Item5', '2017-10-09 14:20:00', 12);
INSERT INTO items (title, delivery, quantity) VALUES ('Item6', '2017-10-10 20:45:00', 215);