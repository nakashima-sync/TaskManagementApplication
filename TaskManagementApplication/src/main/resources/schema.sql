CREATE TABLE `user` (
    user_id INT AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE `project` (
    project_id INT AUTO_INCREMENT,
    project_name VARCHAR(1000) NOT NULL,
    PRIMARY KEY (project_id)
);

CREATE TABLE `depart` (
    depart_id INT AUTO_INCREMENT,
    user_id INT NOT NULL,
    project_id INT NOT NULL,
    PRIMARY KEY (depart_id),
    FOREIGN KEY (user_id) REFERENCES `user`(user_id),
    FOREIGN KEY (project_id) REFERENCES `project`(project_id)
);

CREATE TABLE `task` (
    task_id INT AUTO_INCREMENT,
    task_name VARCHAR(1000) NOT NULL,
    depart_id INT NOT NULL,
    task_contents VARCHAR(10000) NOT NULL,
    task_limit DATE NOT NULL,
    task_checked INT NOT NULL,
    PRIMARY KEY (task_id),
    FOREIGN KEY (depart_id) REFERENCES `depart`(depart_id)
);
