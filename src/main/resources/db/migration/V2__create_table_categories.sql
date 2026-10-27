CREATE TABLE categories (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT fk_categories_users FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);