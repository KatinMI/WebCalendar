CREATE TABLE IF NOT EXISTS users(
                                    id BIGINT PRIMARY KEY,
                                    login VARCHAR(50) NOT NULL UNIQUE ,
                                    name VARCHAR(200) NOT NULL ,
                                    password VARCHAR(32) NOT NULL
);
CREATE SEQUENCE user_id_seq START WITH 2 INCREMENT BY 1;