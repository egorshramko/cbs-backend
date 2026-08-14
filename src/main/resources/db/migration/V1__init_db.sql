CREATE SEQUENCE IF NOT EXISTS movie_pkey_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS movie (
    id BIGINT NOT NULL,
    created_at TIMESTAMP(6),
    name_ VARCHAR(255),
    actual BOOLEAN,
    duration BIGINT,
    release_date DATE,
    country VARCHAR(255),
    poster_filename VARCHAR(1023),
    age_limit VARCHAR(255) CHECK ((age_limit IN ('NO_LIMIT', 'OLDER_6', 'OLDER_12', 'OLDER_16', 'ADULT_ONLY'))),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS movie_genre (
    movie BIGINT NOT NULL,
    genre VARCHAR(255) CHECK ((genre IN (
        'DRAMA',
        'COMEDY',
        'MELODRAMA',
        'THRILLER',
        'ACTION',
        'CRIMINAL',
        'HORROR',
        'ADVENTURE',
        'FAMILY',
        'FANTASY',
        'SCIENCE_FICTION',
        'DOCUMENTARY',
        'SHORT_FILM',
        'MILITARY',
        'MUSICAL',
        'HISTORY',
        'BIOGRAPHY',
        'WESTERN',
        'CARTOON',
        'SPORT',
        'DETECTIVE',
        'ANIME',
        'EROTIC'
    ))),
    PRIMARY KEY (movie, genre),
    FOREIGN KEY (movie) REFERENCES movie(id) ON DELETE CASCADE
);