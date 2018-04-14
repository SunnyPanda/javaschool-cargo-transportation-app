insert into cities (id, city_name) values (1, 'Астрахань');
insert into cities (id, city_name) values (2, 'Москва');
insert into cities (id, city_name) values (3, 'Санкт-Петрбург');
insert into cities (id, city_name) values (4, 'Воронеж');
insert into cities (id, city_name) values (5, 'Казань');
insert into cities (id, city_name) values (6, 'Иркутск');

insert into trucks (id, reg_number, shift_size, capacity, state) values (1, 'GHHGGGG', '2', '35', 0);
insert into trucks (id, reg_number, shift_size, capacity, state) values (2, 'FE78430', '1', '100', 0);
insert into trucks (id, reg_number, shift_size, capacity, state) values (3, 'BJ50984', '2', '3', 1);
insert into trucks (id, reg_number, shift_size, capacity, state) values (4, 'YU74801', '3', '76', 1);
insert into trucks (id, reg_number, shift_size, capacity, state) values (5, 'SG87048', '2', '200', 0);

insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id) values (1, '34098753', 'Аркадий', 'Исааков', 23, 1, 2);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id) values (2, '56084545', 'Вениамин', 'Пунктуальный', 46, 2, 2);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id) values (3, '49853098', 'Варвара', 'Полякова', 123, 0, 1);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id) values (4, '69384023', 'Клюква', 'Песочная', 45, 2, 5);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id) values (5, '50948503', 'Елена', 'Парная', 15, 1, 3);

