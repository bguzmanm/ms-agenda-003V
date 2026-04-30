create table agendas (
    id bigint not null auto_increment,
    doctor_id bigint not null,
    patient_id bigint not null,
    date date not null,

    primary key (id)
);

insert into agendas (doctor_id, patient_id, date) values
(1, 1, '2024-07-01'),
(2, 2, '2024-07-02'),
(3, 3, '2024-07-03'),
(4, 4, '2024-07-04'),
(5, 1, '2024-07-05');