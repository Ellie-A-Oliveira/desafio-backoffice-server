INSERT INTO transaction (transaction_id, account_id, customer_id, amount, currency, timestamp, description, transaction_type, status, channel)
VALUES
(UUID(), 'bfcda8c9-e0b3-4c8d-b15d-c15b3ec0731a', '4cd95392-6d8d-4b96-bb3d-c015e4a8d0e6', 500.00, 'USD', CURRENT_TIMESTAMP, 'Deposit from ATM', 'DEPOSIT', 'COMPLETED', 'ATM');

INSERT INTO transaction (transaction_id, account_id, customer_id, amount, currency, timestamp, description, transaction_type, status, channel)
VALUES
(UUID(), '1a3f7682-85d5-4ff0-9be6-dff3b084dd3a', '0d68e2b8-d222-48f9-9f35-f4d9b7eeb7b5', 200.00, 'USD', CURRENT_TIMESTAMP, 'Withdrawal at Branch', 'WITHDRAWAL', 'COMPLETED', 'BRANCH');

INSERT INTO transaction (transaction_id, account_id, customer_id, amount, currency, timestamp, description, transaction_type, status, channel)
VALUES
(UUID(), '2c0a88d5-f42f-4de1-b9c0-366a4d26c564', '7f8a68b8-bc31-48f1-b2ed-5cd4e820e3f7', 1500.00, 'EUR', CURRENT_TIMESTAMP, 'Online banking transfer', 'TRANSFER', 'PENDING', 'ONLINE_BANKING');

INSERT INTO transaction (transaction_id, account_id, customer_id, amount, currency, timestamp, description, transaction_type, status, channel)
VALUES
(UUID(), '36fa877d-cdfe-49f6-8fa1-77405251a6f2', 'cd73289b-8ec5-48fa-9716-3a759b1a1c0c', 250.00, 'GBP', CURRENT_TIMESTAMP, 'Payment for invoice', 'PAYMENT', 'COMPLETED', 'MOBILE_APP');

INSERT INTO transaction (transaction_id, account_id, customer_id, amount, currency, timestamp, description, transaction_type, status, channel)
VALUES
(UUID(), 'e81b317d-7a68-4a66-bbd4-3f60c2820a32', 'fea7754f-5a93-47d5-91d2-2ac93757b44c', 100.00, 'USD', CURRENT_TIMESTAMP, 'Transfer to external account', 'TRANSFER', 'REJECTED', 'ONLINE_BANKING');

INSERT INTO transaction (transaction_id, account_id, customer_id, amount, currency, timestamp, description, transaction_type, status, channel)
VALUES
(UUID(), '748a6d87-2f8a-4a73-8f89-ff0da62fa47e', '298c3a21-80d2-44ca-81d5-2db11cd9481d', 75.00, 'USD', CURRENT_TIMESTAMP, 'Deposit via ATM', 'DEPOSIT', 'COMPLETED', 'ATM');

INSERT INTO transaction (transaction_id, account_id, customer_id, amount, currency, timestamp, description, transaction_type, status, channel)
VALUES
(UUID(), 'bbcc1ea9-6747-4731-b08b-9f4439df5d56', 'f0ea1d5c-3f6f-4321-a55d-054d6a99e66c', 300.00, 'EUR', CURRENT_TIMESTAMP, 'Payment for services', 'PAYMENT', 'UNDER_REVIEW', 'MOBILE_APP');

INSERT INTO transaction (transaction_id, account_id, customer_id, amount, currency, timestamp, description, transaction_type, status, channel)
VALUES
(UUID(), 'c2a8879f-3407-4ae0-bf98-592d94bbd865', 'b9c9357c-4661-4b0e-8ac0-174299ee5c36', 700.00, 'USD', CURRENT_TIMESTAMP, 'ATM withdrawal', 'WITHDRAWAL', 'COMPLETED', 'ATM');

INSERT INTO transaction (transaction_id, account_id, customer_id, amount, currency, timestamp, description, transaction_type, status, channel)
VALUES
(UUID(), '559dfd89-d051-4f45-94c4-3e8de8d5e7f1', '44e7cc42-68d8-46b3-9f56-b8fba82cf3e7', 1200.00, 'USD', CURRENT_TIMESTAMP, 'Transfer from mobile app', 'TRANSFER', 'COMPLETED', 'MOBILE_APP');

INSERT INTO transaction (transaction_id, account_id, customer_id, amount, currency, timestamp, description, transaction_type, status, channel)
VALUES
(UUID(), '5d1cb5be-5374-49ba-a219-e57414be48f9', 'a8b93a9f-cb71-4639-9d85-dba46401c13e', 400.00, 'GBP', CURRENT_TIMESTAMP, 'Branch deposit', 'DEPOSIT', 'COMPLETED', 'BRANCH');