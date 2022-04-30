CREATE TABLE if not exists "account" (
id  bigserial primary key,
name varchar(100) not null,
last_name varchar(100) not null,
login varchar(20) unique not null,
password varchar(50) not null,
telephone varchar(20) not null,
email varchar(50),
role varchar(20) not null,
status varchar(20) default 'ACTIVE'
);

CREATE TABLE if not exists "task" (
id bigserial primary key,
name varchar(200) not null,
cost int not null,
status varchar(20) default 'ACTIVE'
);

CREATE TABLE account_task (
account_id bigint not null,
task_id bigint not null,

constraint task_id_fk foreign key (task_id) references "task"(id),
constraint account_id_fk foreign key (account_id) references "account" (id),
constraint task_account_pk PRIMARY KEY (task_id, account_id)
);


CREATE TABLE public.mark
(
	id bigserial PRIMARY KEY,
    account_id bigint NOT NULL,
    task_id bigint NOT NULL ,
	mark bigint NOT NULL,
    CONSTRAINT task_account_Fk FOREIGN KEY (account_id) REFERENCES public.account(id),
    CONSTRAINT task_id_fk FOREIGN KEY (task_id) REFERENCES public.task (id)
);