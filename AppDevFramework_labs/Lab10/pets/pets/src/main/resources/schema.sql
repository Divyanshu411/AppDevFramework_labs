CREATE TABLE household (
       eircode VARCHAR(8) PRIMARY KEY,
       number_of_occupants INT NOT NULL,
       max_number_of_occupants INT NOT NULL,
       owner_occupied BIT NOT NULL
);

CREATE TABLE pets (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(255) NOT NULL,
      animal_type VARCHAR(255) NOT NULL,
      breed VARCHAR(255) NOT NULL,
      age INT NOT NULL,
      household_eircode VARCHAR(8),
      CONSTRAINT fk_household FOREIGN KEY (household_eircode) REFERENCES household(eircode)
);

CREATE TABLE users (
    email VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    locked BOOLEAN NOT NULL DEFAULT FALSE,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    county VARCHAR(10) NOT NULL
);
