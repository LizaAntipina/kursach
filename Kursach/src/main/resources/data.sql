INSERT INTO public.account(
	 name, last_name, login, password, telephone, email, role,status)
	VALUES ( 'Ivan', 'Ivanov', 'user', '1234', '+375123456','user@user.com', 'USER','ACTIVE');

	INSERT INTO public.account(
name, last_name, login, password, telephone, email, role,status)
VALUES ( 'Shasha', 'Shasha', 'expert1', '1234', '+7386572929','rvasdzf@fh.com', 'EXPERT','ACTIVE');

 INSERT INTO public.account(
 	 name, last_name, login, password, telephone, email, role,status)
 	VALUES ( 'Liza', 'Antipina', 'admin', '1234', '+375299377373','admin@Admin.com', 'ADMIN','ACTIVE');

INSERT INTO public.account(
name, last_name, login, password, telephone, email, role,status)
VALUES ( 'Vova', 'Petrov', 'expert', '1234', '+7389022929','petrov@fh.com', 'EXPERT','ACTIVE');

INSERT INTO public.task(
	 name,  cost, status)
	VALUES ( 'Task1',  '78','ACTIVE');

INSERT INTO public.task(
    	 name, cost, status)
    	VALUES ( 'Task3', '378','ACTIVE');

INSERT INTO public.task(
        name, cost, status)
        VALUES ( 'Task2',  '79','ACTIVE');
