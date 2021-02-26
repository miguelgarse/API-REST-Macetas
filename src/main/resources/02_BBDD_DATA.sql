/*Cargamos Tipo Sensores*/
INSERT INTO sensor_type(id,descripcion,nombre) values (nextval('public."sensor_type_id_seq"'),'Sensor detector de agua', 'Detector de Agua');
INSERT INTO sensor_type(id,descripcion,nombre) values (nextval('public."sensor_type_id_seq"'),'Sensor de peso', 'Sensor Peso');
INSERT INTO sensor_type(id,descripcion,nombre) values (nextval('public."sensor_type_id_seq"'),'Sensor de humedad de la tierra', 'Humedad Superficie');
INSERT INTO sensor_type(id,descripcion,nombre) values (nextval('public."sensor_type_id_seq"'),'Sonda de temperatura de la tierra', 'Temperatura Superficie');
INSERT INTO sensor_type(id,descripcion,nombre) values (nextval('public."sensor_type_id_seq"'),'Sensor de humedad ambiental', 'Humedad Ambiental');
INSERT INTO sensor_type(id,descripcion,nombre) values (nextval('public."sensor_type_id_seq"'),'Sensor de luminosidad ambiental', 'Luminosidad');
INSERT INTO sensor_type(id,descripcion,nombre) values (nextval('public."sensor_type_id_seq"'),'Sensor de temperatura ambiental', 'Temperatura Ambiental');
INSERT INTO sensor_type(id,descripcion,nombre) values (nextval('public."sensor_type_id_seq"'),'Sensor de Co2', 'Co2');
/* Carga de las acciones*/
INSERT INTO action(id,action_desc) values (nextval('public."action_id_seq"'),'abrir el riego');
INSERT INTO action(id,action_desc) values (nextval('public."action_id_seq"'),'cerrar el riego');
INSERT INTO action(id,action_desc) values (nextval('public."action_id_seq"'),'mover la tierra');
INSERT INTO action(id,action_desc) values (nextval('public."action_id_seq"'),'echar alimento');
INSERT INTO action(id,action_desc) values (nextval('public."action_id_seq"'),'cambiar parámetros de configuración');
INSERT INTO action(id,action_desc) values (nextval('public."action_id_seq"'),'mandar aviso');

