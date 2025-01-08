-- Создаем таблицу users
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

-- Создаем таблицу webinars
CREATE TABLE IF NOT EXISTS webinars (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    date TIMESTAMP NOT NULL,
    lector_id INT NOT NULL,
    visitors INT NOT NULL,
    CONSTRAINT fk_lector FOREIGN KEY (lector_id) REFERENCES users(id) ON DELETE CASCADE
);