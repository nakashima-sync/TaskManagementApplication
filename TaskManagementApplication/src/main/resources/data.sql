-- userテーブルに対するINSERT文
INSERT INTO user (name) VALUES ('Alice');
INSERT INTO user (name) VALUES ('Bob');
INSERT INTO user (name) VALUES ('Charlie');
INSERT INTO user (name) VALUES ('David');
INSERT INTO user (name) VALUES ('Eve');

-- projectテーブルに対するINSERT文
INSERT INTO project (name) VALUES ('Project A');
INSERT INTO project (name) VALUES ('Project B');
INSERT INTO project (name) VALUES ('Project C');
INSERT INTO project (name) VALUES ('Project D');
INSERT INTO project (name) VALUES ('Project E');

-- taskテーブルに対するINSERT文
INSERT INTO task (name, contents, date_limit, `check`, user_id, project_id) VALUES ('Task 1', 'Content for task 1', '2024-06-01', 0, 1, 1);
INSERT INTO task (name, contents, date_limit, `check`, user_id, project_id) VALUES ('Task 2', 'Content for task 2', '2024-06-02', 0, 2, 2);
INSERT INTO task (name, contents, date_limit, `check`, user_id, project_id) VALUES ('Task 3', 'Content for task 3', '2024-06-03', 1, 3, 3);
INSERT INTO task (name, contents, date_limit, `check`, user_id, project_id) VALUES ('Task 4', 'Content for task 4', '2024-06-04', 0, 4, 4);
INSERT INTO task (name, contents, date_limit, `check`, user_id, project_id) VALUES ('Task 5', 'Content for task 5', '2024-06-05', 1, 5, 5);
