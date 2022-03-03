CREATE TABLE employees(
    id                   BIGSERIAL    NOT NULL PRIMARY KEY,
    name                 VARCHAR(255) NOT NULL,
    employee_category_id INTEGER      NOT NULL
);