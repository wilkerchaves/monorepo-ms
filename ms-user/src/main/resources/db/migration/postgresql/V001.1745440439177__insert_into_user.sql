insert into tb_user(name, email, password) values ('Bob Sweet', 'bob@email.com', '$2a$10$Qo8Zkb5QhDEJzql7lRod8Ow2Dbnqc.j2tqU3cTyDh2qM6BesHKLsq');
insert into tb_user(name, email, password) values ('Tina Strong', 'tina@email.com', '$2a$10$CmFkjnnjbbmsLLFnMYyIpehmWMO93E0SZT8f12ZfB5KQC1jV3V4OG');

insert into tb_role (role_name) values ('ROLE_OPERATOR');
insert into tb_role (role_name) values ('ROLE_ADMIN');


insert into tb_user_role(user_id, roles_id) values (1, 1);
insert into tb_user_role(user_id, roles_id) values (1, 2);
insert into tb_user_role(user_id, roles_id) values (2, 2);