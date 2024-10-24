-- Crear tabla roles
CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);
-- Crear tabla users
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    enable BOOLEAN NOT NULL
);

-- Crear tabla users_roles
CREATE TABLE users_roles (
    user_id BIGINT NOT NULL,
    roles_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, roles_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (roles_id) REFERENCES roles(id)
);

INSERT INTO roles ( name) VALUES ( 'ROLE_ADMIN');
INSERT INTO roles ( name) VALUES ( 'ROLE_USER');

INSERT INTO users ( username, password, enable) VALUES ('adminKata', '$2a$10$VeCwZdf81OhkUd9DIU6gXuEu9WVzTzMFVMy8hC8RnOc.kCt4.jOZa', true);

INSERT INTO users_roles (user_id, roles_id) VALUES (1, 1);

CREATE TABLE tasks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    completed BOOLEAN NOT NULL
);

INSERT INTO tasks (title, description, completed) VALUES ('Hacer pruebas unitarias', 'Con Junit', false);
