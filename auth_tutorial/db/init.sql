create table product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    brand VARCHAR(50) NOT NULL,
    acquisition_date DATE NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);
