
use test;
create table t_order
(
    id  bigint primary key auto_increment,
    count long not null
);

create table t_count(
    id bigint primary key ,
    count long not null
);

insert into t_count (id,count) values (1,100);
