create table users(
id bigint PRIMARY KEY auto_increment not null,
username VARCHAR(100) not null unique,
password VARCHAR(100) not null,

plan_type_id INT default 0,

is_active tinyint default 1,
is_activated tinyint default 0,
activation_code VARCHAR(255) unique,
recovery_code VARCHAR(255) unique,
recovery_code_expiration DATETIME,

name VARCHAR(100) not null,
lastname VARCHAR(100) not null,
birthday DATE,
email VARCHAR(100) not null unique,
phone VARCHAR(100) unique,

profile_picture VARCHAR(255),
bio TEXT,
social_media_links TEXT,

street VARCHAR(100),
district VARCHAR(100),
city VARCHAR(100),
numeration VARCHAR(20),
complement VARCHAR(100),
FOREIGN KEY (plan_type_id) REFERENCES plan_types (id)
);

CREATE INDEX idx_users_username ON users (username);
CREATE INDEX idx_users_email ON users (email);
CREATE INDEX idx_plan_type ON users (plan_type_id);

