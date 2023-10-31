CREATE TABLE payments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id bigint NOT NULL,
    transaction_date DATETIME,
    payment_method VARCHAR(255),
    amount DECIMAL(10, 2),
    plan_type_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (plan_type_id) REFERENCES plan_types (id)
);

CREATE INDEX idx_payments_user_id ON payments (user_id);