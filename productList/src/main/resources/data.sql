DROP TABLE IF EXISTS product;
CREATE TABLE product ( id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(25) NOT NULL, quantity number(200)NOT NULL, price decimal(30,2) NOT NULL);  
INSERT INTO product (name, quantity,price) VALUES
('Apple', 100,8000),
  ('Orange', 250, 5000),
  ('Grapes', 425,7000),
('Mango',250,90),
('Spinach',10,100),
('Cabbage',12,250),
('Lemon',12,120),
('Phone',10,1000),
('Laptop',10,120);