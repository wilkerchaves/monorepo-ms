create table if not exists tb_user (
	id bigint generated by default as identity,
    email varchar(255),
    name varchar(255),
    password varchar(255),
    primary key (id)
);


create table if not exists tb_role (
	id bigint generated by default as identity,
    role_name varchar(255),
    primary key (id)
);

create table if not exists tb_user_role (
	user_id bigint not null,
	roles_id bigint not null,
	primary key (roles_id, user_id)
);

alter table if exists tb_user_role 
	add constraint role_id_constraint 
    foreign key (roles_id) 
    references tb_role;
    
alter table if exists tb_user_role 
	add constraint user_id_constraint 
    foreign key (user_id) 
    references tb_user;
