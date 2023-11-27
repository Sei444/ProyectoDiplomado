-- Tabla de Usuario
CREATE TABLE "user" (
                      id BIGINT PRIMARY KEY,
                      username VARCHAR(150) NOT NULL,
                      password VARCHAR(150) NOT NULL,
                      email VARCHAR(150) NOT NULL,
                      created_at TIMESTAMP NOT NULL
);

-- Tabla de Rol
CREATE TABLE rol (
                     id INT PRIMARY KEY,
                     name VARCHAR(100) NOT NULL
);

-- Tabla de Detalles de Usuario
CREATE TABLE user_detail (
                             id BIGINT PRIMARY KEY,
                             first_name VARCHAR(100) NOT NULL,
                             last_name VARCHAR(100) NOT NULL,
                             age INT,
                             birth_day DATE,
                             user_id BIGINT,
                             FOREIGN KEY (user_id) REFERENCES "user"(id)
);

-- Tabla de Relación Usuario-Rol
CREATE TABLE user_rol (
                          id INT PRIMARY KEY,
                          active BOOLEAN NOT NULL,
                          created_at TIMESTAMP NOT NULL,
                          user_id BIGINT,
                          rol_id INT,
                          FOREIGN KEY (user_id) REFERENCES "user"(id),
                          FOREIGN KEY (rol_id) REFERENCES rol(id)
);