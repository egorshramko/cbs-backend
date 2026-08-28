-- Создание справочника городов

CREATE SEQUENCE IF NOT EXISTS city_pkey_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS city (
    id BIGINT NOT NULL,
    created_at TIMESTAMP(6),
    actual BOOLEAN,
    name_ VARCHAR(255),
    PRIMARY KEY (id)
);

-- Создание таблицы кинотеатров

CREATE SEQUENCE IF NOT EXISTS cinema_pkey_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS cinema (
    id BIGINT NOT NULL,
    created_at TIMESTAMP(6),
    actual BOOLEAN,
    name_ VARCHAR(255),
    city BIGINT,
    address_ VARCHAR(255),
    has_parking BOOLEAN,
    photo_filename VARCHAR(1023),
    PRIMARY KEY (id),
    FOREIGN KEY (city) REFERENCES city(id) ON DELETE CASCADE
);

-- Создание таблицы залов кинотеатров

CREATE SEQUENCE IF NOT EXISTS hall_pkey_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS hall (
    id BIGINT NOT NULL,
    created_at TIMESTAMP(6),
    cinema BIGINT,
    name_ VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (cinema) REFERENCES cinema(id) ON DELETE CASCADE
);

-- Создание таблицы для связи форматов видео и зала

CREATE TABLE IF NOT EXISTS hall_movie_format (
    hall BIGINT NOT NULL,
    movie_format VARCHAR(255) CHECK ((movie_format IN (
        '_2D',
        '_3D',
        'IMAX'
    ))),
    PRIMARY KEY (hall, movie_format),
    FOREIGN KEY (hall) REFERENCES hall(id) ON DELETE CASCADE
);

-- Создание таблицы сеансов

CREATE SEQUENCE IF NOT EXISTS session_pkey_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS session_ (
    id BIGINT NOT NULL,
    created_at TIMESTAMP(6),
    session_datetime TIMESTAMP(6),
    actual BOOLEAN,
    movie BIGINT NOT NULL,
    hall BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (movie) REFERENCES movie(id) ON DELETE CASCADE,
    FOREIGN KEY (hall) REFERENCES hall(id) ON DELETE CASCADE
);


