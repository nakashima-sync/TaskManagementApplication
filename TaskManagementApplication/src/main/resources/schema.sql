CREATE TABLE user(
    user_id int NOT NULL AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE project(
    project_id int NOT NULL AUTO_INCREMENT,
    name varchar(1000) NOT NULL,
    PRIMARY KEY (project_id)
);

CREATE TABLE task(
    task_id int NOT NULL AUTO_INCREMENT,
    name varchar(1000) NOT NULL,
    contents varchar(10000) NOT NULL,
    date_limit date NOT NULL,
    `check` int NOT NULL,
    user_id int NOT NULL,
    project_id int NOT NULL,
    PRIMARY KEY (task_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (project_id) REFERENCES project(project_id)
);
