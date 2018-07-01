DROP TABLE IF EXISTS contacts;
DROP SEQUENCE IF EXISTS contacts_seq;


CREATE SEQUENCE contacts_seq start 1000;

CREATE TABLE contacts(
  id INT PRIMARY KEY DEFAULT nextval('contacts_seq'),
  name VARCHAR(100) NOT NULL
);

