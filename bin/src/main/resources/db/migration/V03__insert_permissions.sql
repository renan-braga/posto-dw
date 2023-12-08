CREATE TABLE permission (
                              id BIGINT NOT NULL AUTO_INCREMENT,
                              description VARCHAR(255),
                              PRIMARY KEY (id)
);

CREATE TABLE user (
                        id BIGINT NOT NULL AUTO_INCREMENT,
                        name VARCHAR(50) NOT NULL,
                        email VARCHAR(255) NOT NULL,
                        password VARCHAR(150) NOT NULL,
                        age INT NOT NULL,
                        active BOOLEAN NOT NULL,
                        PRIMARY KEY (id),
                        UNIQUE KEY email_UNIQUE (email)
);

CREATE TABLE user_permission (
                                   id_user BIGINT NOT NULL,
                                   id_permission BIGINT NOT NULL,
                                   PRIMARY KEY (id_user, id_permission),
                                   FOREIGN KEY (id_user) REFERENCES user (id),
                                   FOREIGN KEY (id_permission) REFERENCES permission (id)
);

INSERT INTO user (id, name, email, password, age, active) values (1, 'Administrador', 'admin@ifsp.edu.br', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.', 47, 1);
INSERT INTO user (id, name, email, password, age, active) values (2, 'Frentista User', 'frentista@ifsp.edu.br', '$2a$10$X123ZPhQ4EaGNaYKt3n4SONjIv5zc.VMWdAahCuba7oLAL5IucK6.', 35, 1);
INSERT INTO user (id, name, email, password, age, active) values (3, 'Conveniencia User', 'conveniencia@ifsp.edu.br', '$2a$10$X234ZPhQ4EaGNaYKt3n4SONjIv5zc.VMWdAahCuba7oLAL5IucK7.', 32, 1);

-- roles
INSERT INTO permission (id, description) values (1, 'ROLE_ABASTECIMENTO');
INSERT INTO permission (id, description) values (2, 'ROLE_CONVENIENCIA');
INSERT INTO permission (id, description) values (3, 'ROLE_GERENCIA');

-- frentista
INSERT INTO user_permission (id_user, id_permission)
SELECT id, 1 FROM user WHERE email = 'frentista@ifsp.edu.br';

-- conveniencia
INSERT INTO user_permission (id_user, id_permission)
SELECT id, 2 FROM user WHERE email = 'conveniencia@ifsp.edu.br';

-- gerencia
INSERT INTO user_permission (id_user, id_permission) values (1, 1);
INSERT INTO user_permission (id_user, id_permission) values (1, 2);
INSERT INTO user_permission (id_user, id_permission) values (1, 3);
