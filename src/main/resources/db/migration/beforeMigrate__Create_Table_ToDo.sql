drop table if exists to_do ;

create table to_do (
	id SERIAL PRIMARY KEY,	
	title VARCHAR(100) NOT NULL,
	description_short VARCHAR(100),
	description_long VARCHAR(512),
	category VARCHAR(30) DEFAULT 'other',
	finished BOOLEAN DEFAULT false
);
