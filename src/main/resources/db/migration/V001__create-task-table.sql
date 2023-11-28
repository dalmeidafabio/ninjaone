create table task (
	id bigint not null auto_increment, 
	name varchar(100) not null, 
	description varchar(250) not null, 
	
	primary key (id)
) engine=InnoDB;