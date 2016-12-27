CREATE DATABASE `UsrReg`;
USE UsrReg;
CREATE TABLE `usr_info` (
  `uID` varchar(10) CHARACTER SET utf8 NOT NULL,
  `pass` varchar(20) CHARACTER SET utf8 NOT NULL,
  `email` varchar(30) NOT NULL,
  `q0` varchar(140) NOT NULL,
  `a0` varchar(45) NOT NULL,
  `q1` varchar(140) NOT NULL,
  `a1` varchar(45) CHARACTER SET utf8 NOT NULL,
  `mnum` bigint(10) DEFAULT NULL,
  `add` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `aoi` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`uID`),
  UNIQUE KEY `usr_email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
