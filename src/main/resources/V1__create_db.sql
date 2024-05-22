CREATE TABLE client (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL
);

CREATE TABLE planet (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(500) NOT NULL
);

CREATE TABLE ticket (
    id INT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    client_id INT,
    from_planet_id VARCHAR(10),
    to_planet_id VARCHAR(10),
    CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client(id),
    CONSTRAINT fk_from_planet FOREIGN KEY (from_planet_id) REFERENCES planet(id),
    CONSTRAINT fk_to_planet FOREIGN KEY (to_planet_id) REFERENCES planet(id)
);
