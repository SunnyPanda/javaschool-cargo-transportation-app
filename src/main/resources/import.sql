insert into orders (id, unique_number, status) values (1, 1, 0);
insert into orders (id, unique_number, status) values (2, 2, 1);
insert into orders (id, unique_number, status) values (3, 3, 1);
insert into orders (id, unique_number, status) values (4, 4, 1);
insert into orders (id, unique_number, status) values (5, 5, 1);

insert into cities (id, city_name) values (1, 'Arkhangelsk, Arkhangelsk Oblast');
insert into cities (id, city_name) values (2, 'Chelyabinsk, Chelyabinsk Oblast');
insert into cities (id, city_name) values (3, 'Chita, Zabaykalsky Krai');
insert into cities (id, city_name) values (4, 'Ekaterinburg');
insert into cities (id, city_name) values (5, 'Irkutsk, Irkutsk Oblast');
insert into cities (id, city_name) values (6, 'Kaliningrad, Kaliningrad Oblast');
insert into cities (id, city_name) values (7, 'Krasnodar, Krasnodar Krai');
insert into cities (id, city_name) values (8, 'Krasnoyarsk, Krasnoyarsk Krai');
insert into cities (id, city_name) values (9, 'Moscow');
insert into cities (id, city_name) values (10, 'Murmansk, Murmansk Oblast');
insert into cities (id, city_name) values (11, 'Nizhny Novgorod, Nizhny Novgorod Oblast');
insert into cities (id, city_name) values (12, 'Novosibirsk, Novosibirsk Oblast');
insert into cities (id, city_name) values (13, 'Perm, Perm Krai');
insert into cities (id, city_name) values (14, 'Petrozavodsk, Republic of Karelia');
insert into cities (id, city_name) values (15, 'Pskov, Pskov Oblast');
insert into cities (id, city_name) values (16, 'Rostov-on-Don, Rostov Oblast');
insert into cities (id, city_name) values (17, 'Samara, Samara Oblast');
insert into cities (id, city_name) values (18, 'Saratov, Saratov Oblast');
insert into cities (id, city_name) values (19, 'St Petersburg');
insert into cities (id, city_name) values (20, 'Tolyatti, Samara Oblast');
insert into cities (id, city_name) values (21, 'Tyumen, Tyumen Oblast');
insert into cities (id, city_name) values (22, 'Ufa, Republic of Bashkortostan');
insert into cities (id, city_name) values (23, 'Ulyanovsk, Ulyanovsk Oblast');
insert into cities (id, city_name) values (24, 'Veliky Novgorod, Novgorod Oblast');
insert into cities (id, city_name) values (25, 'Vladivostok');
insert into cities (id, city_name) values (26, 'Volgograd, Volgograd Oblast');

insert into cargo (id, cargo_number, cargo_name, weight, status) values (1, 1, 'Some box', 34, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (2, 2, 'Bottles of red wine', 13, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (3, 3, 'Small car', 3, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (4, 4, 'Table', 30, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (5, 5, 'Apple shareholding', 1, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (6, 6, 'Kitchen', 5, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (7, 7, 'Bookcase', 3, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (8, 8, 'A packet of chips', 5, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (9, 9, 'Elephant', 10, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (10, 10, 'Turtle', 50, 0);

insert into cargo (id, cargo_number, cargo_name, weight, status) values (11, 11, 'Elephant 1', 5, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (12, 12, 'Elephant 2', 10, 0);


insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (1, 1, 1, 1, 0);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (2, 2, 1, 1, 1);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (3, 2, 2, 2, 0);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (4, 3, 2, 2, 1);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (5, 3, 3, 3, 0);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (6, 4, 3, 3, 1);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (7, 4, 4, 4, 0);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (8, 5, 4, 4, 1);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (9, 3, 9, 1, 0);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (10, 2, 9, 1, 1);
insert into waypoints (id, city_id, cargo_id, waypoint_type) values (11, 5, 11, 0);
insert into waypoints (id, city_id, cargo_id, waypoint_type) values (12, 5, 11, 0);
insert into waypoints (id, city_id, cargo_id, waypoint_type) values (13, 12, 12, 0);
insert into waypoints (id, city_id, cargo_id, waypoint_type) values (14, 21, 11, 1);
insert into waypoints (id, city_id, cargo_id, waypoint_type) values (15, 21, 12, 0);
insert into waypoints (id, city_id, cargo_id, waypoint_type) values (16, 21, 12, 0);
insert into waypoints (id, city_id, cargo_id, waypoint_type) values (17, 21, 11, 0);
insert into waypoints (id, city_id, cargo_id, waypoint_type) values (18, 4, 12, 1);
insert into waypoints (id, city_id, cargo_id, waypoint_type) values (19, 4, 11, 1);
insert into waypoints (id, city_id, cargo_id, waypoint_type) values (20, 13, 12, 1);
insert into waypoints (id, city_id, cargo_id, waypoint_type) values (21, 23, 11, 1);
insert into waypoints (id, city_id, cargo_id, waypoint_type) values (22, 18, 12, 1);

insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id, order_id) values (1, 'AA11111', 2, 35, 0, 1, 1);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id, order_id) values (2, 'BB22222', 1, 100, 0, 2, 2);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id, order_id) values (3, 'CC33333', 1, 3, 0, 3, 3);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id, order_id) values (4, 'DD44444', 2, 76, 0, 4, 4);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (5, 'EE55555', 2, 40, 0, 5);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (6, 'FF66666', 3, 35, 0, 5);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (7, 'GG77777', 2, 40, 0, 5);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (8, 'HH88888', 1, 23, 0, 3);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (9, 'II99999', 3, 34, 0, 4);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (10, 'JJ00000', 3, 11, 0, 5);


insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id, order_id) values (1, 1, 'George', 'Clooney', 23, 1, 1, 1, 1);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id, order_id) values (2, 2, 'Sean', 'Bin', 46, 1, 1, 1, 1);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id, order_id) values (3, 3, 'Keanu', 'Reeves', 123, 1, 2, 2, 2);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id, order_id) values (4, 4, 'George', 'Martin', 45, 1, 3, 3, 3);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (5, 5, 'Freddie', 'Mercury', 15, 0, 4);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (6, 6, 'Paul', 'McCartney', 23, 0, 4);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (7, 7, 'Christina', 'Aguilera', 46, 0, 4);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (8, 8, 'John', 'Lennon', 123, 0, 4);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (9, 9, 'Barack', 'Obama', 45, 0, 4);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (10, 10, 'Kristen', 'Stewart', 170, 0, 5);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (11, 11, 'Ripe', 'Avocado', 76, 0, 5);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (12, 12, 'Yellow', 'Pineapple', 100, 0, 5);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (13, 13, 'Quentin', 'Quentin', 150, 0, 5);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (14, 14, 'Peter', 'Jackson', 45, 0, 1);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (15, 15, 'Bald', 'Brazzers', 15, 0, 2);

insert into users (id, username, password, role) values (1, 'user', '$2a$11$Aax9HOQhqLshWpLZPeoiYe.EMjj4/RaSf5PCO2zcfdxtnarufc28K', 'ROLE_USER');
insert into users (id, username, password, role, driver_id) values (2, 'driver1', '$2a$11$nmd5TT5fEkCiHaktsr5Gqe4L9bEiUa1Ektu7/dmp32FnRz.nZ/0Py', 'ROLE_DRIVER', 1);
insert into users (id, username, password, role, driver_id) values (3, 'driver2', '$2a$11$nmd5TT5fEkCiHaktsr5Gqe4L9bEiUa1Ektu7/dmp32FnRz.nZ/0Py', 'ROLE_DRIVER', 2);
insert into users (id, username, password, role, driver_id) values (4, 'driver3', '$2a$11$nmd5TT5fEkCiHaktsr5Gqe4L9bEiUa1Ektu7/dmp32FnRz.nZ/0Py', 'ROLE_DRIVER', 3);
insert into users (id, username, password, role, driver_id) values (5, 'driver11', '$2a$11$nmd5TT5fEkCiHaktsr5Gqe4L9bEiUa1Ektu7/dmp32FnRz.nZ/0Py', 'ROLE_DRIVER', 11);