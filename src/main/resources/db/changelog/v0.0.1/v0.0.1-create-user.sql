create table users (
    id bigint generated by default as identity,
    firstname varchar(255),
    lastname varchar(255), primary key (id)
 );
