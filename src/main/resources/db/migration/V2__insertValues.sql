INSERT INTO "user" (id, username, password, email ,created_at ) VALUES
    (1, 'usuario1' , 'Passworduser1', 'user1@example.com', '2023-01-02 14:30:00' ),
    (2, 'usuario2' , 'Passworduser2', 'user2@example.com', '2023-01-03 14:30:00' );

INSERT INTO rol (id, name) VALUES
    (1, 'Admin'),
    (2, 'User');

INSERT INTO user_detail (id, first_name, last_name, age, birth_day, user_id) VALUES
    (1, 'Ana','Maria' ,28 , '1996-03-15 00:00:00', 1),
    (2, 'Pepe','Rios' ,30 , '1993-03-15 00:00:00', 2);

INSERT INTO user_rol (id, active, created_at, user_id, rol_id) VALUES
    (1, true, '2023-01-01 12:05:00', 1, 2),
    (2, true, '2023-01-02 14:35:00', 2, 2);

