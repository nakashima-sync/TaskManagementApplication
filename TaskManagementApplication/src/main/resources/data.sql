-- Insert data into the `user` table
INSERT INTO `user` (user_name) VALUES 
('Alice'),
('Bob'),
('Charlie'),
('David'),
('Eve');

-- Insert data into the `project` table
INSERT INTO `project` (project_name) VALUES 
('Project Alpha'),
('Project Beta'),
('Project Gamma'),
('Project Delta'),
('Project Epsilon');

-- Insert data into the `depart` table
INSERT INTO `depart` (user_id, project_id) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(1,2),
(1,4),
(2,1),
(3,1),
(5,1);

-- Insert data into the `task` table
INSERT INTO `task` (task_name, depart_id, task_contents, task_limit, task_checked) VALUES 
('Design Database Schema', 1, 'Create the initial database schema for Project Alpha', '2024-06-15', 0),
('Implement User Authentication', 2, 'Develop the authentication module for Project Beta', '2024-06-20', 0),
('Set Up CI/CD Pipeline', 3, 'Establish the CI/CD pipeline for Project Gamma', '2024-06-25', 0),
('Develop REST API', 4, 'Build the REST API for Project Delta', '2024-06-30', 0),
('Create Frontend Layout', 5, 'Design and implement the frontend layout for Project Epsilon', '2024-07-05', 0),
('Write Unit Tests', 6, 'Write unit tests for Project Zeta', '2024-07-10', 0),
('Optimize Database Queries', 7, 'Optimize SQL queries for Project Eta', '2024-07-15', 0),
('Conduct Security Audit', 8, 'Perform a security audit for Project Theta', '2024-07-20', 0),
('Prepare Documentation', 9, 'Prepare the project documentation for Project Iota', '2024-07-25', 0),
('Deploy to Production', 10, 'Deploy Project Kappa to the production environment', '2024-07-30', 0);
