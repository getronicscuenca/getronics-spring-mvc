insert into role (id, name) values (1, 'ROLE_USER'), (2, 'ROLE_MANAGER'), (3, 'ROLE_ADMIN'), (4, 'ROLE_SUPERUSER');

insert into privilege (id, name) values (1, 'EMPLOYEES_R'),(2, 'EMPLOYEES_W'), (3, 'USERS_R'),(4, 'USERS_W'), (5, 'DEPARTMENTS_R'), (6, 'DEPARTMENTS_W'),(7, 'TECHNOLOGIES_R'),(8, 'TECHNOLOGIES_W');

insert into roles_privileges(role_id, privilege_id) values (1, 3), (2, 1), (2, 2), (2, 3), (3, 1), (3, 2), (3, 3), (3, 4), (3, 7), (3, 8), (4, 1), (4, 2), (4, 3), (4, 4), (4, 5), (4, 6), (4, 7), (4, 8);

insert into users (user_id, username, password, enabled) values (1, 'user', 'user', true);
insert into users (user_id, username, password, enabled) values (2, 'manager', 'manager', true);
insert into users (user_id, username, password, enabled) values (3, 'admin', 'admin', true);
insert into users (user_id, username, password, enabled) values (4, 'superuser', 'superuser', true);

insert into users_roles(user_id, role_id) values (1, 1), (2, 1), (2, 2), (3, 1), (3, 2), (3, 3), (4, 1), (4, 2), (4, 3), (4, 4);