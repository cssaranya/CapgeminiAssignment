insert into contact (CONTACT_ID, EMAIL_ID, HOME_PHONE, WORK_PHONE, ADDRESS1, ADDRESS2, CITY, STATE, ZIP, COUNTRY, CREATED_DATE, UPDATED_DATE)
values ('1', 'chasusan6@gmail.com', '1234', '5678', 'av clays', '90', 'brussels', 'brussels', '1030', 'belgium', to_date('11-07-2021', 'dd-mm-yyyy'), to_date('11-07-2021', 'dd-mm-yyyy'));

insert into contact (CONTACT_ID, EMAIL_ID, HOME_PHONE, WORK_PHONE, ADDRESS1, ADDRESS2, CITY, STATE, ZIP, COUNTRY, CREATED_DATE, UPDATED_DATE)
values ('2', 'suptasaranya@yahoo.co.in', '91011', '121314', 'av zenome', '50', 'schaerbeek', 'brussels', '1030', 'belgium', to_date('01-01-2021', 'dd-mm-yyyy'), to_date('01-01-2021', 'dd-mm-yyyy'));

insert into customer (CUSTOMER_ID, NAME, SURNAME, CREATED_DATE, UPDATED_DATE, CONTACT_ID)
values ('1', 'Saranya', 'CS', to_date('11-07-2021', 'dd-mm-yyyy'), to_date('11-07-2021', 'dd-mm-yyyy'),'1');

insert into customer (CUSTOMER_ID, NAME, SURNAME, CREATED_DATE, UPDATED_DATE, CONTACT_ID)
values ('2', 'Suptha', 'SC', to_date('01-01-2021', 'dd-mm-yyyy'), to_date('01-01-2021', 'dd-mm-yyyy'),'2');