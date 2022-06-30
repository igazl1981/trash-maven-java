create table schools
(
    id      serial
        constraint schools_pk
            primary key,
    name    varchar(255) not null,
    address text
);

alter table schools
    owner to postgres;

create table students
(
    school_id  integer      not null,
    student_id uuid         not null,
    firstname  varchar(255) not null,
    lastname   varchar(255),
    address    text,
    constraint students_pk
        primary key (school_id, student_id)
);

alter table students
    owner to postgres;


INSERT INTO public.schools (id, name, address) VALUES (1, 'School 1', 'Address 1');
INSERT INTO public.schools (id, name, address) VALUES (2, 'School 2', null);
INSERT INTO public.schools (id, name, address) VALUES (3, 'School 3', null);
INSERT INTO public.schools (id, name, address) VALUES (4, 'School 4', 'Address 4');

INSERT INTO public.students (school_id, student_id, firstname, lastname, address) VALUES (2, '760d5d61-3ee2-4b59-990f-f2d3303c316f', 'Jhon 1', 'Smith 1', 'Address 1');
INSERT INTO public.students (school_id, student_id, firstname, lastname, address) VALUES (1, '6ec4ae17-f814-4a9d-a314-9ed8f6a46731', 'Firstname 0', 'Lastname 0', 'Address 0');
INSERT INTO public.students (school_id, student_id, firstname, lastname, address) VALUES (1, '9b369a8f-4e02-4df5-a2c5-76a603ae924a', 'Firstname 1', 'Lastname 1', 'Address 1');
INSERT INTO public.students (school_id, student_id, firstname, lastname, address) VALUES (1, '59ddc9f3-95ed-4f71-aaae-b54108209127', 'Firstname 2', 'Lastname 2', 'Address 2');
INSERT INTO public.students (school_id, student_id, firstname, lastname, address) VALUES (1, 'e6ef3db9-8b24-4192-9440-1f67363b8992', 'Firstname 3', 'Lastname 3', 'Address 3');
INSERT INTO public.students (school_id, student_id, firstname, lastname, address) VALUES (1, '63531a5b-759b-4901-b265-5556162dabda', 'Firstname 4', 'Lastname 4', 'Address 4');
INSERT INTO public.students (school_id, student_id, firstname, lastname, address) VALUES (1, '4426524b-7f8d-4bb1-8e9e-b5756b96e7a1', 'Firstname 5', 'Lastname 5', 'Address 5');
INSERT INTO public.students (school_id, student_id, firstname, lastname, address) VALUES (1, '1fbb30d6-9812-444b-b826-89c51582f521', 'Firstname 0', 'Lastname 0', 'Address 0');
INSERT INTO public.students (school_id, student_id, firstname, lastname, address) VALUES (1, 'ddece989-681e-4a4f-9989-00a4ea9c938a', 'Firstname 1', 'Lastname 1', 'Address 1');
INSERT INTO public.students (school_id, student_id, firstname, lastname, address) VALUES (1, '54e161df-2d21-4570-a2a5-d57dfb291e5c', 'Firstname 2', 'Lastname 2', 'Address 2');
INSERT INTO public.students (school_id, student_id, firstname, lastname, address) VALUES (1, '7301c364-587b-46ac-85ea-d7e476f8f78d', 'Firstname 3', 'Lastname 3', 'Address 3');
