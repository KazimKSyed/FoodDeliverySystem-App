DROP TABLE IF EXISTS category;
CREATE TABLE category (
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	is_active BOOLEAN,
	CONSTRAINT pk_category_id PRIMARY KEY (id) 

);
INSERT INTO category (name, description,is_active) VALUES ('Vegetables', 'This is description for Vegetables category!',true);
INSERT INTO category (name, description,is_active) VALUES ('Fruits', 'This is description for Fruits category!',true);
INSERT INTO category (name, description,is_active) VALUES ('Dairy Foods', 'This is description for Dairy Products category!',true);