DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS bookedDates;

CREATE TABLE users
(
    userId          INTEGER GENERATED ALWAYS AS IDENTITY,
    userName        varchar(255),
    userFullName    varchar(255),
    userEmail       varchar(255),
    userPhoneNumber varchar(255),
    userPassword    varchar(255),
    isAdmin         BOOLEAN,
    PRIMARY KEY (userId)
);

CREATE TABLE bookedDates
(
    bookingId  INTEGER GENERATED ALWAYS AS IDENTITY,
    userId     INTEGER,
    barber     varchar(255),
    bookedDate varchar(255),
    bookedTime varchar(255),
    FOREIGN KEY (userId)
        REFERENCES users (userId)
);