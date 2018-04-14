insert into cities (id, city_name) values (1, 'Астрахань');
insert into cities (id, city_name) values (2, 'Москва');
insert into cities (id, city_name) values (3, 'Санкт-Петрбург');
insert into cities (id, city_name) values (4, 'Воронеж');
insert into cities (id, city_name) values (5, 'Казань');
insert into cities (id, city_name) values (6, 'Иркутск');

insert into cargo (id, cargo_number, cargo_name, weight, status) values (1, 1234, 'Коробочка', 34, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (2, 3456, 'Бутылки', 59, 1);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (3, 6789, 'Машинка', 200, 2);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (4, 2345, 'Стол', 30, 2);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (5, 7890, 'Пакет акций Apple', 10000, 1);

insert into waypoints (id, city_id, cargo_id, waypoint_type) values (1, 4, 1, 0);

insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (1, 'GHHGGGG', '2', '35', 0, 4);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (2, 'FE78430', '1', '100', 0, 1);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (3, 'BJ50984', '2', '3', 1, 3);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (4, 'YU74801', '3', '76', 1, 2);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (5, 'SG87048', '2', '200', 0, 5);

insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id) values (1, '34098753', 'Аркадий', 'Исааков', 23, 1, 2, 3);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id) values (2, '56084545', 'Вениамин', 'Пунктуальный', 46, 2, 2, 1);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id) values (3, '49853098', 'Варвара', 'Полякова', 123, 0, 1, 4);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id) values (4, '69384023', 'Клюква', 'Песочная', 45, 2, 5, 5);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id) values (5, '50948503', 'Елена', 'Парная', 15, 1, 3, 2);

