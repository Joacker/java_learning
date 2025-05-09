CREATE TABLE category (
    id BIGINT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    slug VARCHAR(100) NOT NULL,
    meta_title VARCHAR(100) NOT NULL,
    content TEXT NOT NULL
);

CREATE TABLE sub_category (
    id BIGINT PRIMARY KEY,
    categoryid BIGINT NOT NULL,
    description TEXT NOT NULL,
    FOREIGN KEY (categoryid) REFERENCES category(id) ON DELETE CASCADE
);

CREATE TABLE product (
    id BIGINT PRIMARY KEY,
    title VARCHAR(75) NOT NULL,
    summary TINYTEXT,
    content TEXT,
    created_at DATETIME(6),
    updated_at DATETIME(6),
    categoryid BIGINT,
    subcategoryid BIGINT,
    FOREIGN KEY (categoryid) REFERENCES category(id) ON DELETE SET NULL,
    FOREIGN KEY (subcategoryid) REFERENCES sub_category(id) ON DELETE SET NULL
);