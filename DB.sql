USE my_db;

CREATE TABLE tutorials (
  id int NOT NULL AUTO_INCREMENT,
  title varchar(15),
  description varchar(25),
  published boolean,
  PRIMARY KEY (id)
) ;

INSERT INTO my_db.tutorials (title, description, publishedStatus)
VALUES
	('AbayZholy', 'Poem', 'published'),
	('AkOrda', 'History', 'published'),
	('Kulager', 'Poem', 'published');

