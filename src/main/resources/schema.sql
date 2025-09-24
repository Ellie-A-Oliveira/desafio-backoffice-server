CREATE TABLE transaction (
    transaction_id UUID PRIMARY KEY,
    account_id UUID NOT NULL,
    customer_id UUID NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    description VARCHAR(255),
    transaction_type VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    channel VARCHAR(255) NOT NULL
);

CREATE TABLE staff_member (
    staff_id UUID PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL
);