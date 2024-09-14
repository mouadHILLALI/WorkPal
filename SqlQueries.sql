CREATE TABLE "users" (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255),
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) DEFAULT 'member',
    address VARCHAR(255),
    phone_number BIGINT,
    image VARCHAR(255)
);
