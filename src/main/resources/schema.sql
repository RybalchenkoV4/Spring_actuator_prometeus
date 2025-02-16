CREATE TABLE taskdb (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    status VARCHAR(50) NOT NULL,
    create_at TIMESTAMP
);