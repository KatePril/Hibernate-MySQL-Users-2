CREATE DATABASE hibernate_db;

CREATE TABLE IF NOT EXISTS users
( id INTEGER NOT NULL AUTO_INCREMENT,
    username VARCHAR(128) NOT NULL,
    first_name VARCHAR(128) NOT NULL,
    last_name VARCHAR(128) NOT NULL,
    birth_date DATE NOT NULL,
    email VARCHAR(128) NOT NULL,
    phone VARCHAR(32) NOT NULL,
    PRIMARY KEY (id)
)

INSERT INTO User (username, first_name, last_name, birth_date, email, phone) VALUES (:username, :first_name, :last_name, :birth_date, :email, :phone)

FROM User

UPDATE User SET email = :email WHERE id = :id

DELETE FROM User WHERE id = :id