-- Categorías
INSERT INTO category (id, title, slug, meta_title, content) VALUES
(1, 'Tecnología', 'tecnologia', 'Tecnología meta', 'Todo sobre tecnología');

-- Subcategorías
INSERT INTO sub_category (id, categoryid, description) VALUES
(1, 1, 'Accesorios para PC');

-- Productos
INSERT INTO product (id, title, summary, content, created_at, updated_at, categoryid, subcategoryid) VALUES
(1, 'UltraSoft Pillow', 'Almohada premium', 'A luxurious pillow made with the finest down feathers.', NOW(), NOW(), 1, 1),
(2, 'EcoSmart LED Bulb', 'Ampolleta eficiente', 'An energy-saving LED bulb with a lifespan of 25,000 hours.', NOW(), NOW(), 1, 1);