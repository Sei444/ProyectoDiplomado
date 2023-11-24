CREATE TABLE User (
                      id BIGINT PRIMARY KEY,
                      username VARCHAR(150) NOT NULL,
                      password VARCHAR(150) NOT NULL,
                      email VARCHAR(150) NOT NULL,
                      created_at TIMESTAMP NOT NULL
);

CREATE TABLE User_Rol (
                          id INT PRIMARY KEY,
                          active BOOLEAN NOT NULL,
                          created_at TIMESTAMP NOT NULL,
                          user_id BIGINT REFERENCES User(id),
                          rol_id INTEGER REFERENCES Rol(id)
);

CREATE TABLE User_Detail (
                             id BIGINT PRIMARY KEY,
                             first_name VARCHAR(100) NOT NULL,
                             last_name VARCHAR(100) NOT NULL,
                             age INTEGER,
                             birth_day DATE,
                             user_id BIGINT REFERENCES User(id)
);
