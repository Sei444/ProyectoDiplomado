INSERT INTO public.user (id, created_at, email, password ,username ) VALUES
    (1,'2023-01-02 14:30:00', 'user1@example.com','Passworduser1','usuario1' ),
    (2, '2023-01-03 14:30:00', 'user2@example.com' ,'Passworduser2','usuario2'  );

INSERT INTO public.rol (id, name) VALUES
                               (1, 'Admin'),
                               (2, 'User');

INSERT INTO public.user_detail (id, first_name, last_name, age, birth_day, user_id) VALUES
                                                                                 (1, 'Ana','Maria' ,28 , '1996-03-15 00:00:00', 1),
                                                                                 (2, 'Pepe','Rios' ,30 , '1993-03-15 00:00:00', 2);

INSERT INTO public.user_rol (id, active, created_at, user_id, rol_id) VALUES
                                                                   (1, true, '2023-01-01 12:05:00', 1, 2),
                                                                   (2, true, '2023-01-02 14:35:00', 2, 2);
