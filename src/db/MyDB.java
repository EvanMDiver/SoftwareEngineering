package db;
/**
 * 
 * @author mehra
 * MYSQL database schema :coursedatabase
 * user :coursedatabase_admin
 * pass :Test1234
 * 
 */
public interface MyDB {

	String USER="project";
	String PASS="project";
	String CONN_URL="jdbc:mysql://127.0.0.1:3306/coursedatabase";
	
	
}
/**
CREATE TABLE  `customer` (
  `userId` CHAR(20) NOT NULL,
  `password` CHAR(10) NOT NULL,
  `name` CHAR(20) NOT NULL );
 
CREATE TABLE  `driver` (
  `userId` CHAR(20) NOT NULL,
  `password` CHAR(10) NOT NULL,
  `name` CHAR(20) NOT NULL);
 
CREATE TABLE `ride` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `customerId` CHAR(20) NOT NULL,
  `startX` INT NOT NULL,
  `startY` INT NOT NULL,
  `endX` INT NOT NULL,
  `endY` INT NOT NULL,
  `time` VARCHAR(60) NOT NULL,
  `driverId` CHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)ride
  );


jdbc:mysql://127.0.0.1:3306/coursedatabase?user=coursedatabase_admin

*/