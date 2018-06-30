DROP TABLE IF EXISTS my_contacts;
DROP SEQUENCE IF EXISTS contact_seq;

CREATE SEQUENCE contact_seq START 100;

CREATE TABLE my_contacts(
  id INTEGER PRIMARY KEY DEFAULT nextval('contact_seq'),
  name VARCHAR(100) NOT NULL
);

INSERT INTO my_contacts (name) VALUES
  ('Allo'),
  ('Buba'),
  ('Vaha');
