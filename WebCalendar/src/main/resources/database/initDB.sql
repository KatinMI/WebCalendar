CREATE TABLE IF NOT EXISTS users(
                                    id BIGINT PRIMARY KEY,
                                    login VARCHAR(50) NOT NULL UNIQUE ,
                                    name VARCHAR(200) NOT NULL ,
                                    password VARCHAR(32) NOT NULL
);
CREATE SEQUENCE user_id_seq START WITH 2 INCREMENT BY 1;
CREATE TABLE IF NOT EXISTS notes(
    id BIGSERIAL PRIMARY KEY,
    date TIMESTAMP NOT NULL,
    note TEXT NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
