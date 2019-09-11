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


DROP TABLE IF EXISTS user_detail;
CREATE TABLE user_detail (
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(60),
	email VARCHAR(100),
	contact_number VARCHAR(15),	
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);

INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Virat', 'Kohli', 'ADMIN', true, 'admin', 'vk@gmail.com', '8888888888');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Ravindra', 'Jadeja', 'SUPPLIER', true, '12345', 'rj@gmail.com', '9999999999');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Ravichandra', 'Ashwin', 'SUPPLIER', true, '12345', 'ra@gmail.com', '7777777777');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Khozema', 'Nullwala', 'USER', true, '12345', 'kn@gmail.com', '7777777777');

DROP TABLE IF EXISTS product;
CREATE TABLE product (
	id IDENTITY,
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),	
);	



INSERT INTO product ( name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ( 'Fresho Tomato - Hybrid', 'Indian Farmers', 'Tomato Hybrids are high-quality fruits compared to desi, local tomatoes. They contain numerous edible seeds and are red in colour due to lycopene, an anti-oxidant.', 19, 50, true, 1, 1, 0, 0 );
INSERT INTO product ( name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ( 'Fresho Potato', 'Indian Farmers', 'Fresho Potatoes are nutrient-dense, non-fattening and have reasonable amount of calories.', 25, 50, true, 1, 1, 0, 0 );
INSERT INTO product ( name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('Fresho Banana - Robusta', 'Indian Farmers', 'Relish the soft, buttery texture of Robusta bananas that are light green and have a great fragrance and taste.',39, 50, true, 2, 2, 0, 0 );
INSERT INTO product ( name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES (' Amul Butter - Pasteurized', 'Amul', 'Amul is synonymous with Butter in India.', 450, 200, true, 3, 3, 0, 0 );
