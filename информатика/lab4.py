import sqlite3
from sqlite3 import Error


def create_connection(path):
    connection = None
    try:
        connection = sqlite3.connect(path)
        print("Connection to SQLite DB successful")
    except Error as e:
        print(f"The error '{e}' occurred")
    return connection


def execute_query(connection, query):
    cursor = connection.cursor()
    try:
        cursor.execute(query)
        connection.commit()
        print("Query executed successfully")
    except Error as e:
        print(f"The error '{e}' occurred")

def execute_read_query(connection, query):
    cursor = connection.cursor()
    result = None
    try:
        cursor.execute(query)
        result = cursor.fetchall()
        return result
    except Error as e:
        print(f"The error '{e}' occurred")




connection = create_connection("C:\\Users\osink\OneDrive\Рабочий стол\ITMO\sm_app.sqlite")

create_transfer_table = """
CREATE TABLE IF NOT EXISTS transfer (
    id INTEGER PRIMARY KEY AUTOINCREMENT, 
    type TEXT NOT NULL, 
    delegation TEXT, 
    arriving TEXT NOT NULL,
    costs INTEGER NOT NULL 
);
"""

execute_query(connection, create_transfer_table)


create_delegations_table = """
CREATE TABLE IF NOT EXISTS delegations (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    region TEXT NOT NULL,
    status TEXT NOT NULL,
    members INTEGER NOT NULL,
    transfer_id INTEGER NOT NULL,
    FOREIGN KEY (transfer_id) REFERENCES transfer (id)
);
"""

execute_query(connection, create_delegations_table)

create_members_table = """
CREATE TABLE IF NOT EXISTS members (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    age INTEGER NOT NULL,
    gender TEXT NOT NULL,
    delegation_id INTEGER NOT NULL,
    transfer_id INTEGER NOT NULL,
    FOREIGN KEY (delegation_id) REFERENCES delegations (id) FOREIGN KEY (transfer_id) 
REFERENCES transfer (id)
);
"""

execute_query(connection, create_members_table)

create_money_table = """
CREATE TABLE IF NOT EXISTS money (
    member_id INTEGER NOT NULL, 
    transfer_id INTEGER NOT NULL, 
    living INTEGER NOT NULL,
    merch INTEGER NOT NULL,
    catering INTEGER NOT NULL, 
    FOREIGN KEY (member_id) REFERENCES members (id) FOREIGN KEY (transfer_id) REFERENCES transfer (id)
);
"""

execute_query(connection, create_money_table)

create_delegations = """
INSERT INTO
    delegations (region, status, members, transfer_id)
VALUES
    ('ЯНАО', 'Отправление', 12, 1),
    ('ХМАО', 'Прибыли', 15, 2),
    ('Республика Татарстан', 'Заселились в гостиницу', 38, 1),
    ('г. Санкт-Петербург', 'Обедают', 45, 2),
    ('Приморский край', 'Отправление', 11, 1);
"""
execute_query(connection, create_delegations)

create_members = """
INSERT INTO
 members (name, age, gender, delegation_id, transfer_id)
VALUES
    ('Лиза', 18, 'жен', 4, 4),
    ('Влад', 18, 'муж', 2, 2),
    ('Петя', 19, 'муж', 3, 1),
    ('Саша', 18, 'муж', 1, 5),
    ('Максим', 20, 'муж', 1, 5);
"""
execute_query(connection, create_members)

create_transfer = """
INSERT INTO
 transfer (type, delegation, arriving, costs)
VALUES
    ('Самолёт', 'Республика Татарстан', '8:14', 4000),
    ('Самолёт', 'Приморский край', '12:11', 12000),
    ('Поезд', 'ХМАО', '5:34', 3200),
    ('Поезд', 'г. Санкт-Петербург', '7:13', 2305),
    ('Самолёт', 'ЯНАО', '10:05', 10000);
"""
execute_query(connection, create_transfer)

create_money = """
INSERT INTO
 money (member_id, transfer_id, living, merch, catering)
VALUES
    (5, 1, 5000, 4500, 1200),
    (4, 1, 5000, 4500, 1200),
    (3, 1, 5000, 4500, 1200),
    (2, 2, 5000, 4500, 1200),
    (1, 2, 5000, 4500, 1200);
"""


# начинаются всякие выборы
# через select
execute_query(connection, create_money)

select_members = "SELECT * from transfer"
members = execute_read_query(connection, select_members)
for member in members:
    print(member)

# через join
select_members_transfer = """
SELECT
    members.transfer_id,
    members.name,
    transfer.type
FROM
    transfer
    INNER JOIN members ON members.transfer_id = transfer.id
"""

# через where
members_transfer = execute_read_query(connection, select_members_transfer)
for member_transfer in members_transfer:
    print(member_transfer)

select_member_money = """
SELECT
    name as members,
    type as transfer
FROM
    members,
    transfer
WHERE
    transfer.type = "Поезд"
GROUP BY 
    transfer.type
"""
member_money = execute_read_query(connection, select_member_money)
for member in member_money:
    print(member)

#вложенный запрос

variarity_select_members = """
SELECT *
FROM 
    delegations
WHERE 
    (SELECT COUNT(*) 
    FROM members 
    WHERE members.delegation_id = delegations.transfer_id) > 
    (SELECT AVG(members) 
    FROM (SELECT COUNT(*) as members 
        FROM members 
        GROUP BY delegation_id));
"""
members_group = execute_read_query(connection, variarity_select_members)
for member in members_group:
    print(member)

# с помощью юнион

union_thing = '''
    SELECT name
    FROM members
    UNION
    SELECT age
    FROM members;
'''
uniuni = execute_read_query(connection, union_thing)
for uni in uniuni:
    print(uni)

#distinct

select_distinct = """
SELECT DISTINCT age
FROM members;
"""
distinctic = execute_read_query(connection, select_distinct)
for d in distinctic:
    print(d)

#обновляемся
select_member_transfer = "SELECT transfer_id FROM members WHERE id = 2"
member_transfer = execute_read_query(connection, select_member_transfer)
for member in member_transfer:
    print(member)

update_member_transfer = """
UPDATE
    members
SET
    transfer_id = "4"
WHERE
 id = 2
"""
execute_query(connection, update_member_transfer)

select_member_transfer = "SELECT transfer_id FROM members WHERE id = 2"
member_transfer = execute_read_query(connection, select_member_transfer)
for member in member_transfer:
    print(member)


select_status_delegation = "SELECT status FROM delegations WHERE id = 4"
status_delegation = execute_read_query(connection, select_status_delegation)
for status in status_delegation:
    print(status)

update_status_delegation = """
UPDATE
    delegations
SET
    status = "Закончили обед"
WHERE
 id = 4
"""
execute_query(connection, update_status_delegation)

select_status_delegation = "SELECT status FROM delegations WHERE id = 4"
status_delegation = execute_read_query(connection, select_status_delegation)
for status in status_delegation:
    print(status)

delete_member = "DELETE FROM members WHERE id = 5"
execute_query(connection, delete_member)

select_members = "SELECT * from members"
members = execute_read_query(connection, select_members)
for member in members:
    print(member)

delete_money = "DELETE FROM money"
execute_query(connection, delete_money)

select_money = "SELECT * from money"
money = execute_read_query(connection, select_money)
for mon in money:
    print(money)
