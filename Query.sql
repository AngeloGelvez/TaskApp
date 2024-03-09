CREATE TABLE users(
	user_id SERIAL CONSTRAINT pk_user PRIMARY KEY,
	nombre VARCHAR(45) NOT NULL,
	email VARCHAR(45) NOT NULL,
	contra VARCHAR(45) NOT NULL,
	fecha_registro DATE NOT NULL,
	telefono VARCHAR(10)
);

CREATE TABLE projects(
	project_id SERIAL CONSTRAINT pk_project PRIMARY KEY,
	nombre VARCHAR(45) NOT NULL,
	descripcion VARCHAR(400) NOT NULL,
	fecha_inicio DATE NOT NULL,
	fecha_fin DATE NOT NULL,
	etiqueta VARCHAR(45) NOT NULL,
	color VARCHAR(45) NOT NULL,
	user_id INT NOT NULL,
	CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE tasks(
	task_id SERIAL CONSTRAINT pk_task PRIMARY KEY,
	nombre VARCHAR(45) NOT NULL,
	descripcion VARCHAR(300) NOT NULL, 
	fecha_inicio DATE NOT NULL,
	fecha_fin DATE NOT NULL CONSTRAINT fecha_f CHECK(fecha_fin > fecha_inicio),
	prioridad VARCHAR(45) NOT NULL CONSTRAINT prioridad_task CHECK(LOWER(prioridad) IN('baja','mediana','alta')),
	estado VARCHAR(45) NOT NULL CONSTRAINT estado_task CHECK(LOWER(estado) IN('pendiente','en progreso', 'completado')),
	project_id INT NOT NULL,
	CONSTRAINT fk_project_id FOREIGN KEY(project_id) REFERENCES projects(project_id)
);


