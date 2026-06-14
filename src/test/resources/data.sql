INSERT INTO countries(country_id, name, code, total_fees, duration, language, nmc_approved, neet_required, intake)
VALUES (1, 'India', 'IN', 300000, 4, 'English', 1, 1, 'August, January');

INSERT INTO countries(country_id, name, code, total_fees, duration, language, nmc_approved, neet_required, intake)
VALUES (2, 'United Kingdom', 'UK', 450000, 3, 'English', 0, 0, 'September, January');

INSERT INTO universities(university_id, name, location, country_id) VALUES (100, 'IIT Delhi', 'New Delhi', 1);
INSERT INTO universities(university_id, name, location, country_id) VALUES (101, 'IISc', 'Bengaluru', 1);
INSERT INTO universities(university_id, name, location, country_id) VALUES (102, 'JNU', 'New Delhi', 1);

INSERT INTO universities(university_id, name, location, country_id) VALUES (200, 'University of Oxford', 'Oxford', 2);
INSERT INTO universities(university_id, name, location, country_id) VALUES (201, 'University of Cambridge', 'Cambridge', 2);

-- Fees for India (IN)
INSERT INTO fees(country_code, year_number, tuition, hostel, total) VALUES ('IN', 1, 30000, 20000, 50000);
INSERT INTO fees(country_code, year_number, tuition, hostel, total) VALUES ('IN', 2, 32000, 20000, 52000);
INSERT INTO fees(country_code, year_number, tuition, hostel, total) VALUES ('IN', 3, 34000, 20000, 54000);
INSERT INTO fees(country_code, year_number, tuition, hostel, total) VALUES ('IN', 4, 36000, 20000, 56000);
INSERT INTO fees(country_code, year_number, tuition, hostel, total) VALUES ('IN', 5, 38000, 20000, 58000);
INSERT INTO fees(country_code, year_number, tuition, hostel, total) VALUES ('IN', 6, 40000, 20000, 60000);

-- Fees for United Kingdom (UK)
INSERT INTO fees(country_code, year_number, tuition, hostel, total) VALUES ('UK', 1, 75000, 38000, 113000);
INSERT INTO fees(country_code, year_number, tuition, hostel, total) VALUES ('UK', 2, 75000, 38000, 113000);
INSERT INTO fees(country_code, year_number, tuition, hostel, total) VALUES ('UK', 3, 75000, 38000, 113000);

