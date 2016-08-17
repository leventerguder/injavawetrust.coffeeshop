CREATE TABLE IF NOT EXISTS Product (
  id INTEGER PRIMARY KEY,
  name VARCHAR(50),
  description  VARCHAR(50),
  price NUMERIC,
  isCondiment BOOLEAN,
  category  VARCHAR(50)
);