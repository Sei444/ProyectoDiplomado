
-- Tabla de Usuario
CREATE TABLE public.user (
                      id integer PRIMARY KEY,
                      username VARCHAR(150) NOT NULL,
                      password VARCHAR(150) NOT NULL,
                      email VARCHAR(150) NOT NULL,
                      created_at TIMESTAMP NOT NULL
);
alter table public.user
    owner to postgres;

create sequence public.user_sequence as integer increment 1;
-- Tabla de Rol
CREATE TABLE public.rol (
                     id INT PRIMARY KEY,
                     name VARCHAR(100) NOT NULL
);

create sequence public.rol_sequence as integer increment 1;
-- Tabla de Detalles de Usuario
CREATE TABLE public.user_detail (
                             id integer PRIMARY KEY,
                             first_name VARCHAR(100) NOT NULL,
                             last_name VARCHAR(100) NOT NULL,
                             age INT,
                             birth_day DATE,
                             user_id BIGINT,
                             FOREIGN KEY (user_id) REFERENCES public.user(id)
);
create sequence public.user_detail_sequence as integer increment 1;
-- Tabla de Relación Usuario-Rol
CREATE TABLE public.user_rol (
                          id INT PRIMARY KEY,
                          active BOOLEAN NOT NULL,
                          created_at TIMESTAMP NOT NULL,
                          user_id BIGINT,
                          rol_id INT,
                          FOREIGN KEY (user_id) REFERENCES public.user(id),
                          FOREIGN KEY (rol_id) REFERENCES rol(id)
);
create sequence public.user_rol_sequence as integer increment 1;