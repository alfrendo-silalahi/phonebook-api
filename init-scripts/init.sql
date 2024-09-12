CREATE TABLE contact (
	id VARCHAR(36) PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	phone_number VARCHAR(20) NOT NULL,
	email VARCHAR(100),
	address TEXT,
	notes TEXT,
	created_at DATETIME,
	updated_at DATETIME
);