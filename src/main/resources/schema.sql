create table task-db (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(255),
    status VARCHAR(50) NOT NULL,
    create_at TIMESTAMP
)