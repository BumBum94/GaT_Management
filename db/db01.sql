/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : db02

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-06-13 13:00:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `gruppen`
-- ----------------------------
DROP TABLE IF EXISTS `gruppen`;
CREATE TABLE `gruppen` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) COLLATE latin1_german1_ci DEFAULT NULL,
  `tag` varchar(15) COLLATE latin1_german1_ci DEFAULT NULL,
  `anmerkung` varchar(500) COLLATE latin1_german1_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

-- ----------------------------
-- Records of gruppen
-- ----------------------------

-- ----------------------------
-- Table structure for `kunden`
-- ----------------------------
DROP TABLE IF EXISTS `kunden`;
CREATE TABLE `kunden` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` text COLLATE latin1_german1_ci NOT NULL,
  `vorname` text COLLATE latin1_german1_ci NOT NULL,
  `strasse` text COLLATE latin1_german1_ci NOT NULL,
  `hausnr` int(11) NOT NULL,
  `plz` int(11) NOT NULL,
  `ort` text COLLATE latin1_german1_ci NOT NULL,
  `telnr` int(11) NOT NULL,
  `email` text COLLATE latin1_german1_ci,
  `mutter` text COLLATE latin1_german1_ci,
  `vater` text COLLATE latin1_german1_ci,
  `geschlecht` text COLLATE latin1_german1_ci NOT NULL,
  `geburtstag` text COLLATE latin1_german1_ci,
  `anmerkung` text COLLATE latin1_german1_ci NOT NULL,
  `id_grp` int(5) DEFAULT NULL,
  `bild` text COLLATE latin1_german1_ci,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

-- ----------------------------
-- Records of kunden
-- ----------------------------

-- ----------------------------
-- Table structure for `mitarbeiter`
-- ----------------------------
DROP TABLE IF EXISTS `mitarbeiter`;
CREATE TABLE `mitarbeiter` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(35) COLLATE latin1_german1_ci DEFAULT NULL,
  `vorname` varchar(35) COLLATE latin1_german1_ci DEFAULT NULL,
  `strasse` varchar(50) COLLATE latin1_german1_ci DEFAULT NULL,
  `hausnr` int(5) DEFAULT NULL,
  `plz` int(7) DEFAULT NULL,
  `ort` varchar(50) COLLATE latin1_german1_ci DEFAULT NULL,
  `telnr` int(50) DEFAULT NULL,
  `email` varchar(50) COLLATE latin1_german1_ci DEFAULT NULL,
  `geschlecht` varchar(15) COLLATE latin1_german1_ci DEFAULT NULL,
  `bezeichnung` varchar(100) COLLATE latin1_german1_ci DEFAULT NULL,
  `geburtstag` varchar(10) COLLATE latin1_german1_ci DEFAULT NULL,
  `anmerkung` varchar(500) COLLATE latin1_german1_ci DEFAULT NULL,
  `bild` varchar(500) COLLATE latin1_german1_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

-- ----------------------------
-- Records of mitarbeiter
-- ----------------------------
