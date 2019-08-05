drop table song cascade constraint;

drop table singer cascade constraint;

drop table users cascade constraint;

drop table song_user_mapping cascade constraint;

drop table new_song cascade constraint;

drop table popular_chart cascade constraint;


create table singer(
	singer_id number(5) primary key,
	singer_name varchar2(100) not null
);

create table song(
	song_id number(5) primary key,
	song_name varchar2(100) not null,
	singer_id number(5) not null, -- fk
	release_date varchar2(10) not null,
	popularity varchar2(4) not null
);

create table users(
	user_id number(5) primary key,
	user_name varchar2(20) not null,
	user_password varchar2(4) not null
);

create table song_user_mapping (
	song_id number(5) not null, -- song fk
	user_id number(5) not null -- user fk
);

create table new_song (
	song_id number(5) not null -- song fk
);

create table popular_chart (
	song_id number(5) not null -- song fk
);

alter table song add foreign key (singer_id) references singer (singer_id) on delete cascade; 
alter table song_user_mapping add foreign key (song_id) references song (song_id) on delete cascade;
alter table song_user_mapping add foreign key (user_id) references users (user_id) on delete cascade;
alter table new_song add foreign key (song_id) references song (song_id) on delete cascade;
alter table popular_chart add foreign key (song_id) references song (song_id) on delete cascade;