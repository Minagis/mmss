CREATE TABLE address
(
  id INTEGER PRIMARY KEY NOT NULL,
  country VARCHAR(50) NOT NULL,
  city VARCHAR(50) NOT NULL,
  postcode INTEGER NOT NULL,
  street VARCHAR(50) NOT NULL,
  house INTEGER NOT NULL,
  flat INTEGER NOT NULL,
  client_id INTEGER NOT NULL
);

CREATE TABLE category
(
  id INTEGER PRIMARY KEY NOT NULL,
  type VARCHAR(50) NOT NULL
);

CREATE TABLE client
(
  id INTEGER PRIMARY KEY NOT NULL,
  name VARCHAR(50) NOT NULL,
  surname VARCHAR(50) NOT NULL,
  birthday TIMESTAMP NOT NULL,
  email VARCHAR(50) NOT NULL,
  login VARCHAR(10) NOT NULL,
  password VARCHAR(10) NOT NULL
);

CREATE TABLE product
(
  id INTEGER PRIMARY KEY NOT NULL,
  title VARCHAR(50) NOT NULL,
  price NUMERIC NOT NULL,
  weight INTEGER NOT NULL,
  brand VARCHAR(50) NOT NULL,
  color VARCHAR(50) NOT NULL,
  description VARCHAR(1000) NOT NULL,
  amount INTEGER NOT NULL,
  category_id INTEGER NOT NULL
);

CREATE TABLE purchase
(
  id INTEGER PRIMARY KEY NOT NULL,
  delivery_method INTEGER NOT NULL,
  payment_status INTEGER NOT NULL,
  payment_method INTEGER NOT NULL,
  purchase_status INTEGER NOT NULL,
  client_id INTEGER NOT NULL,
  address_id INTEGER NOT NULL
);

CREATE TABLE purchase_product
(
  purchase_id INTEGER NOT NULL,
  product_id INTEGER NOT NULL
);

CREATE SEQUENCE address_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE category_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE client_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE product_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE purchase_sequence START WITH 1 INCREMENT BY 1;

ALTER TABLE address ADD CONSTRAINT address_client__fk FOREIGN KEY (client_id) REFERENCES client;
ALTER TABLE product ADD CONSTRAINT product_category__fk FOREIGN KEY (category_id) REFERENCES category;
ALTER TABLE purchase ADD CONSTRAINT purchase_client__fk FOREIGN KEY (client_id) REFERENCES client;
ALTER TABLE purchase ADD CONSTRAINT purchase_address__fk FOREIGN KEY (address_id) REFERENCES address;
ALTER TABLE purchase_product ADD CONSTRAINT purchase_product_purchase__fk FOREIGN KEY (purchase_id) REFERENCES purchase;
ALTER TABLE purchase_product ADD CONSTRAINT purchase_product_product__fk FOREIGN KEY (product_id) REFERENCES product;