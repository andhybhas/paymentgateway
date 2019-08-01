insert into Customer (id, name, email)
values (1, 'milan', 'milan@doku.com');

insert into Va_Account (id, va_number)
values (1, 3150000000003261);

insert into Va_Transaction (va_id, customer_id, acquirer_id, merchant_id, amount, transaction_timestamp)
values (1, 1, 1, 1, 205000, '2019/07/28');

insert into Merchant (merchant_id, merchant_name)
values (1, 'Tokopedia');

insert into Acquirer (acquirer_id, acquirer_name)
values (1, 'Permata');

insert into Percentage (id, merchant_id, merchant_percent, acquirer_id, acquirer_percent)
values (1, 1, 0.03, 1, 0.01);