insert into account_type values (1,'asset');
insert into account_type values (2,'revenue');
insert into account_type values (3,'liability');
insert into account_type values (4,'equity');
insert into account_type values (5,'expense');
insert into account_type values (6,'contra asset');
insert into account_type values (7,'contra liability');
insert into account_type values (8,'loss');
insert into account_type values (9,'gain');




insert into sub_account_type values ( 1,'accounts payable' );
insert into sub_account_type values ( 2,'day to day' );
insert into debit_transaction values(1,1000,'food','2020-02-01T00:00:00Z',5,2);
insert into credit_transaction values(1,1000,'food','2020-02-01T00:00:00Z',5,2);
insert into credit_transaction values(2,1000,'book','2012-04-01T00:00:00Z',5,2);