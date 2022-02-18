create table timebox(
	id bigint primary key auto_increment,
	description varchar(255),
	start timestamp,
	end timestamp
);