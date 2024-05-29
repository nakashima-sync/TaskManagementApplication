-- Insert into user table
INSERT INTO `user` (user_name) VALUES ('Alice');
INSERT INTO `user` (user_name) VALUES ('Bob');
INSERT INTO `user` (user_name) VALUES ('Charlie');
INSERT INTO `user` (user_name) VALUES ('David');
INSERT INTO `user` (user_name) VALUES ('Eve');

-- Insert into project table
INSERT INTO `project` (project_name) VALUES ('Project Alpha');
INSERT INTO `project` (project_name) VALUES ('Project Beta');
INSERT INTO `project` (project_name) VALUES ('Project Gamma');
INSERT INTO `project` (project_name) VALUES ('Project Delta');
INSERT INTO `project` (project_name) VALUES ('Project Epsilon');

-- Insert into depart table
INSERT INTO `depart` (user_id, project_id) VALUES (1, 1);
INSERT INTO `depart` (user_id, project_id) VALUES (2, 2);
INSERT INTO `depart` (user_id, project_id) VALUES (3, 3);
INSERT INTO `depart` (user_id, project_id) VALUES (4, 4);
INSERT INTO `depart` (user_id, project_id) VALUES (5, 5);

-- Insert into task table
INSERT INTO `task` (task_name, depart_id, contents, date_limit, checked) VALUES ('Task 1', 1, 'Contents for Task 1', '2024-06-30', 0);
INSERT INTO `task` (task_name, depart_id, contents, date_limit, checked) VALUES ('Task 2', 2, 'Contents for Task 2', '2024-07-15', 0);
INSERT INTO `task` (task_name, depart_id, contents, date_limit, checked) VALUES ('Task 3', 3, 'Contents for Task 3', '2024-08-01', 0);
INSERT INTO `task` (task_name, depart_id, contents, date_limit, checked) VALUES ('Task 4', 4, 'Contents for Task 4', '2024-08-20', 0);
INSERT INTO `task` (task_name, depart_id, contents, date_limit, checked) VALUES ('Task 5', 5, 'Contents for Task 5', '2024-09-10', 0);
