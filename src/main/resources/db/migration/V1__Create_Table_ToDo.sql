drop table if exists to_do ;

create table to_do (
	id SERIAL PRIMARY KEY,	
	title VARCHAR(100) NOT NULL,
	description VARCHAR(255),
	category VARCHAR(50) DEFAULT 'other',
	finished BOOLEAN DEFAULT false
);
