-- Добавляем тестовые данные в таблицу users
INSERT INTO users (name, email) VALUES
                                    ('John Doe', 'john.doe@example.com'), (
        'Jane Smith',
        'jane.smith@example.com'
    ), ('Alice Johnson', 'alice.johnson@example.com'), ('Bob Brown', 'bob.brown@example.com');

-- Добавляем тестовые данные в таблицу webinars
INSERT INTO webinars (name, description, date, lector_id, visitors)
VALUES ('Introduction to Spring Boot',
        'Learn the basics of Spring Boot development.', '2023-12-01 10:00:00',
        1, 50),
       ('Advanced Jakarta EE', 'Dive deep into advanced Jakarta EE topics.',
        '2023-12-05 14:00:00', 2, 75),
       ('H2 Database Tips & Tricks',
        'Explore useful tips for working with H2 database.',
        '2023-12-10 09:30:00', 3, 30),
       ('Resilience Patterns',
        'Implementing resilient applications using Resilience4j.',
        '2023-12-15 16:00:00', 4, 40);
