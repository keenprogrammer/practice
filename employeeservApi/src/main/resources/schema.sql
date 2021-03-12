drop table if exists address;
create table address (
id Int primary key,
line1 varchar2(50),
line2 varchar2(50),
city varchar2(50),
state varchar2(50),
country varchar2(50),
zip_code int (6)
);


drop table if exists employee ;
create table employee (
id Int primary key,
first_name varchar2(50),
last_name varchar2(50),
dob Date,
foreign key(address_id) references address(address_id)
);

