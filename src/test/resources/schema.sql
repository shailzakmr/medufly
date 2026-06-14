CREATE TABLE countries (
  country_id INT PRIMARY KEY,
  name VARCHAR(200) NOT NULL,
  code CHAR(2) NOT NULL,
  total_fees INT,
  duration INT,
  language VARCHAR(100),
  nmc_approved TINYINT DEFAULT 0,
  neet_required TINYINT DEFAULT 0,
  intake VARCHAR(200)
);

CREATE TABLE universities (
  university_id INT PRIMARY KEY,
  name VARCHAR(200) NOT NULL,
  location VARCHAR(200) NOT NULL,
  image_url TEXT,
  description TEXT,
  country_id INT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (country_id) REFERENCES countries(country_id)
);

CREATE TABLE fees (
  fee_id INT AUTO_INCREMENT PRIMARY KEY,
  country_code CHAR(2) NOT NULL,
  year_number INT NOT NULL,
  tuition INT NOT NULL,
  hostel INT NOT NULL,
  total INT NOT NULL,
  UNIQUE (country_code, year_number)
);

