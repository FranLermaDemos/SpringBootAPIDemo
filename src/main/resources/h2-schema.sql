-- Tabla de productos
CREATE TABLE products (
    product_id BIGINT NOT NULL PRIMARY KEY,
    product_description VARCHAR(255) NOT NULL
);

-- Tabla de regiones
CREATE TABLE regions (
    region_id BIGINT NOT NULL PRIMARY KEY,
    region_code VARCHAR(255) NOT NULL UNIQUE
);

-- Tabla de tiendas
CREATE TABLE stores (
    store_id BIGINT NOT NULL PRIMARY KEY,
    address VARCHAR(255) NOT NULL
);

-- Tabla de precios de las tiendas
CREATE TABLE store_prices (
    id BIGINT NOT NULL PRIMARY KEY,
    price DECIMAL(10, 2) NOT NULL,
    product_id BIGINT NOT NULL,
    store_id BIGINT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE,
    FOREIGN KEY (store_id) REFERENCES stores(store_id) ON DELETE CASCADE
);

-- Tabla de impuestos por región
CREATE TABLE region_taxes (
    tax_id BIGINT NOT NULL PRIMARY KEY,
    tax_type VARCHAR(255) NOT NULL,
    tax_percentage DECIMAL(5, 2) NOT NULL,
    product_id BIGINT NOT NULL,
    region_id BIGINT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE,
    FOREIGN KEY (region_id) REFERENCES regions(region_id) ON DELETE CASCADE
);