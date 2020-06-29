DROP TABLE IF EXISTS cart;
CREATE TABLE cart ( id INT AUTO_INCREMENT PRIMARY KEY, productname VARCHAR(25) NOT NULL, quantity number(200)NOT NULL, price decimal(30,4) NOT NULL);  
INSERT INTO cart (productname, quantity,price) VALUES
('Apple', 100,8000),
  ('Orange', 250, 5000);