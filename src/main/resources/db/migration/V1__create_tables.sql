
INSERT INTO rol (id, name) VALUES
                               (1, 'Admin'),
                               (2, 'User');

INSERT INTO user_detail (id, age, birth_day, first_name, last_name, user_id) VALUES
                               (1, 25, '1998-03-15 00:00:00', 'Ana', 'Maria', 1),
                               (2, 30, '1993-05-20 00:00:00', 'Alice', 'Johnson', 2);

INSERT INTO users (id, created_at, email, password, username) VALUES
    (1, '2023-01-01 12:00:00', 'admin@example.com', 'adminpass', 'admin_user'),
    (2, '2023-01-02 14:30:00', 'user1@example.com', 'userpass1', 'user1');


INSERT INTO user_rol (id, active, created_at, rol_id, user_id) VALUES
            (1, true, '2023-01-01 12:05:00', 1, 1),
            (2, true, '2023-01-02 14:35:00', 2, 2);

