insert into user_details(id, name, birth_date) values (100, 'User 1', current_date());
insert into user_details(id, name, birth_date) values (200, 'User 2', current_date());
insert into user_details(id, name, birth_date) values (300, 'User 3', current_date());

insert into post(id, description, user_id) values (100, 'Post 1', 100);
insert into post(id, description, user_id) values (200, 'Post 2', 100);
insert into post(id, description, user_id) values (300, 'Post 3', 200);
insert into post(id, description, user_id) values (400, 'Post 4', 200);