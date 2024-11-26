-- Tabla de productos
INSERT INTO products (product_id, product_description) VALUES (1, 'Smartphone');
INSERT INTO products (product_id, product_description) VALUES (2, 'Laptop');
INSERT INTO products (product_id, product_description) VALUES (3, 'Tablet');
INSERT INTO products (product_id, product_description) VALUES (4, 'Smartwatch');
INSERT INTO products (product_id, product_description) VALUES (5, 'Headphones');
INSERT INTO products (product_id, product_description) VALUES (6, 'Keyboard');
INSERT INTO products (product_id, product_description) VALUES (7, 'Mouse');
INSERT INTO products (product_id, product_description) VALUES (8, 'Monitor');
INSERT INTO products (product_id, product_description) VALUES (9, 'External Hard Drive');
INSERT INTO products (product_id, product_description) VALUES (10, 'Router');
INSERT INTO products (product_id, product_description) VALUES (11, 'Speaker');
INSERT INTO products (product_id, product_description) VALUES (12, 'Camera');
INSERT INTO products (product_id, product_description) VALUES (13, 'Printer');
INSERT INTO products (product_id, product_description) VALUES (14, 'Projector');
INSERT INTO products (product_id, product_description) VALUES (15, 'Smart TV');
INSERT INTO products (product_id, product_description) VALUES (16, 'Air Conditioner');
INSERT INTO products (product_id, product_description) VALUES (17, 'Refrigerator');
INSERT INTO products (product_id, product_description) VALUES (18, 'Washing Machine');
INSERT INTO products (product_id, product_description) VALUES (19, 'Microwave');
INSERT INTO products (product_id, product_description) VALUES (20, 'Coffee Maker');

-- Tabla de regiones
INSERT INTO regions (region_id, region_code) VALUES (1, 'US');
INSERT INTO regions (region_id, region_code) VALUES (2, 'EU');
INSERT INTO regions (region_id, region_code) VALUES (3, 'AS');
INSERT INTO regions (region_id, region_code) VALUES (4, 'AF');
INSERT INTO regions (region_id, region_code) VALUES (5, 'LA');

-- Tabla de tiendas
INSERT INTO stores (store_id, address) VALUES (1, '123 Main St, New York, NY');
INSERT INTO stores (store_id, address) VALUES (2, '456 Oak St, London, UK');
INSERT INTO stores (store_id, address) VALUES (3, '789 Maple St, Tokyo, JP');
INSERT INTO stores (store_id, address) VALUES (4, '101 Pine St, Cape Town, ZA');
INSERT INTO stores (store_id, address) VALUES (5, '202 Elm St, Buenos Aires, AR');

-- Tabla de precios de productos en tiendas
INSERT INTO store_prices (id, price, product_id, store_id) VALUES (1, 499.99, 1, 1);  -- Smartphone en tienda 1
INSERT INTO store_prices (id, price, product_id, store_id) VALUES (2, 1099.99, 2, 1); -- Laptop en tienda 1
INSERT INTO store_prices (id, price, product_id, store_id) VALUES (3, 799.99, 3, 2);  -- Tablet en tienda 2
INSERT INTO store_prices (id, price, product_id, store_id) VALUES (4, 199.99, 4, 2);  -- Smartwatch en tienda 2
INSERT INTO store_prices (id, price, product_id, store_id) VALUES (5, 99.99, 5, 3);   -- Headphones en tienda 3
INSERT INTO store_prices (id, price, product_id, store_id) VALUES (6, 29.99, 6, 3);   -- Keyboard en tienda 3
INSERT INTO store_prices (id, price, product_id, store_id) VALUES (7, 49.99, 7, 4);   -- Mouse en tienda 4
INSERT INTO store_prices (id, price, product_id, store_id) VALUES (8, 179.99, 8, 4);  -- Monitor en tienda 4
INSERT INTO store_prices (id, price, product_id, store_id) VALUES (9, 59.99, 9, 5);   -- External Hard Drive en tienda 5
INSERT INTO store_prices (id, price, product_id, store_id) VALUES (10, 89.99, 10, 5);  -- Router en tienda 5
-- Agregar más precios para los demás productos según sea necesario.

-- Tabla de impuestos por región
-- Los impuestos se asignan por producto y región
INSERT INTO region_taxes (tax_id, tax_type, tax_percentage, product_id, region_id) VALUES (1, 'PERCENTAGE', 18.00, 1, 1);  -- Impuesto para Smartphone en US
INSERT INTO region_taxes (tax_id, tax_type, tax_percentage, product_id, region_id) VALUES (2, 'PERCENTAGE', 20.00, 2, 1);  -- Impuesto para Laptop en US
INSERT INTO region_taxes (tax_id, tax_type, tax_percentage, product_id, region_id) VALUES (3, 'PERCENTAGE', 15.00, 3, 2);  -- Impuesto para Tablet en EU
INSERT INTO region_taxes (tax_id, tax_type, tax_percentage, product_id, region_id) VALUES (4, 'PERCENTAGE', 18.00, 4, 2);  -- Impuesto para Smartwatch en EU
INSERT INTO region_taxes (tax_id, tax_type, tax_percentage, product_id, region_id) VALUES (5, 'PERCENTAGE', 10.00, 5, 3); -- Impuesto para Headphones en AS
INSERT INTO region_taxes (tax_id, tax_type, tax_percentage, product_id, region_id) VALUES (6, 'PERCENTAGE', 12.00, 6, 3); -- Impuesto para Keyboard en AS
INSERT INTO region_taxes (tax_id, tax_type, tax_percentage, product_id, region_id) VALUES (7, 'PERCENTAGE', 19.00, 7, 4);  -- Impuesto para Mouse en AF
INSERT INTO region_taxes (tax_id, tax_type, tax_percentage, product_id, region_id) VALUES (8, 'PERCENTAGE', 8.00, 8, 4);  -- Impuesto para Monitor en AF
INSERT INTO region_taxes (tax_id, tax_type, tax_percentage, product_id, region_id) VALUES (9, 'PERCENTAGE', 21.00, 9, 5);  -- Impuesto para External Hard Drive en LA
INSERT INTO region_taxes (tax_id, tax_type, tax_percentage, product_id, region_id) VALUES (10, 'PERCENTAGE', 10.00, 10, 5); -- Impuesto para Router en LA
-- Agregar más impuestos para los demás productos y regiones según sea necesario.