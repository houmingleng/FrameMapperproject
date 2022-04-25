CREATE TABLE dept
(
	deptId INT PRIMARY KEY,
	deptName VARCHAR(50) NOT NULL
);
INSERT INTO dept(deptId,deptName) VALUES(1,'成本部');
INSERT INTO dept(deptId,deptName) VALUES(2,'财务部');
INSERT INTO dept(deptId,deptName) VALUES(3,'人事部');

CREATE TABLE employee
(
	eid INT PRIMARY KEY AUTO_INCREMENT,
	ename VARCHAR(50) NOT NULL,
	egender VARCHAR(10) NOT NULL,
	eage INT NOT NULL,
	post VARCHAR(50) NOT NULL,
	tel VARCHAR(11) NOT NULL,
	address VARCHAR(200) NOT NULL,
	deptId INT REFERENCES dept(deptId)
);

INSERT INTO employee(ename,egender,eage,post,tel,address,deptId)
VALUES('张三','男',22,'程序员','13123123123','湖北武汉',1);

INSERT INTO employee(ename,egender,eage,post,tel,address,deptId)
VALUES('张三1','男',23,'程序员','13123123123','湖北武汉',2);

INSERT INTO employee(ename,egender,eage,post,tel,address,deptId)
VALUES('张三2','男',24,'程序员','13123123123','湖北武汉',3);

INSERT INTO employee(ename,egender,eage,post,tel,address,deptId)
VALUES('张三3','男',25,'程序员','13123123123','湖北武汉',1);

INSERT INTO employee(ename,egender,eage,post,tel,address,deptId)
VALUES('张三4','男',26,'程序员','13123123123','湖北武汉',3);

INSERT INTO employee(ename,egender,eage,post,tel,address,deptId)
VALUES('张三5','男',27,'程序员','13123123123','湖北武汉',2);

INSERT INTO employee(ename,egender,eage,post,tel,address,deptId)
VALUES('张三6','男',28,'程序员','13123123123','湖北武汉',1);

INSERT INTO employee(ename,egender,eage,post,tel,address,deptId)
VALUES('张三7','男',29,'程序员','13123123123','湖北武汉',2);

INSERT INTO employee(ename,egender,eage,post,tel,address,deptId)
VALUES('张三8','男',30,'程序员','13123123123','湖北武汉',3);
	

SELECT * FROM dept;
SELECT * FROM employee;


