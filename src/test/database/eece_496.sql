-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 15, 2013 at 02:22 AM
-- Server version: 5.5.29
-- PHP Version: 5.3.10-1ubuntu3.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `eece_496`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_manages_courses`
--

CREATE TABLE IF NOT EXISTS `admin_manages_courses` (
  `user_id` int(10) unsigned NOT NULL,
  `course_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`user_id`,`course_id`),
  KEY `course_id` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_manages_courses`
--

INSERT INTO `admin_manages_courses` (`user_id`, `course_id`) VALUES
(1, 1),
(1, 3),
(1, 4),
(1, 5);

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE IF NOT EXISTS `courses` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `course_name` varchar(30) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`id`, `course_name`, `start_date`, `end_date`) VALUES
(1, 'EECE 253 T1', NULL, NULL),
(3, 'EECE 253 T2', NULL, NULL),
(4, 'EECE 261 T1', NULL, NULL),
(5, 'EECE 261 T2', NULL, NULL),
(6, 'GEOG 122 T2', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `section_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `subsection_id` (`section_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `groups`
--

INSERT INTO `groups` (`id`, `section_id`) VALUES
(1, 1),
(2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `hold_dates`
--

CREATE TABLE IF NOT EXISTS `hold_dates` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `ta_id` int(10) unsigned DEFAULT NULL,
  `student_id` int(10) unsigned DEFAULT NULL,
  `absent_student_id` int(10) unsigned DEFAULT NULL,
  `subsection_id` int(10) unsigned NOT NULL,
  `student_absent` tinyint(1) NOT NULL,
  `approved_absent` tinyint(1) NOT NULL DEFAULT '0',
  `question` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `subsection_id` (`subsection_id`),
  KEY `ta_id` (`ta_id`),
  KEY `absent_student_id` (`absent_student_id`),
  KEY `student_id` (`student_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Dumping data for table `hold_dates`
--

INSERT INTO `hold_dates` (`id`, `date`, `ta_id`, `student_id`, `absent_student_id`, `subsection_id`, `student_absent`, `approved_absent`, `question`) VALUES
(1, '2013-01-20', 2, 6, 8, 2, 1, 0, NULL),
(2, '2013-02-18', 4, 8, NULL, 2, 0, 0, NULL),
(17, '2013-01-28', NULL, 6, NULL, 2, 0, 0, NULL),
(18, '2013-02-02', 5, 6, NULL, 2, 0, 0, NULL),
(19, '2013-01-09', 5, 6, NULL, 3, 0, 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

CREATE TABLE IF NOT EXISTS `marks` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `mark` int(11) NOT NULL,
  `student_id` int(10) unsigned NOT NULL,
  `hold_date_id` int(10) unsigned DEFAULT NULL,
  `is_individual_mark` tinyint(1) NOT NULL COMMENT 'group mark if false',
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  KEY `hold_date_id` (`hold_date_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=32 ;

--
-- Dumping data for table `marks`
--

INSERT INTO `marks` (`id`, `mark`, `student_id`, `hold_date_id`, `is_individual_mark`) VALUES
(1, 75, 6, 1, 1),
(2, 85, 8, 2, 1),
(3, 72, 3, 1, 0),
(4, 77, 7, 1, 0),
(5, 60, 9, 1, 0),
(18, 90, 9, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `sections`
--

CREATE TABLE IF NOT EXISTS `sections` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `room` varchar(30) NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `course_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `course_id` (`course_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `sections`
--

INSERT INTO `sections` (`id`, `room`, `start_time`, `end_time`, `course_id`) VALUES
(1, 'Kaiser 2020', '13:00:00', '14:00:00', 1),
(2, 'Kaiser 4050', '14:00:00', '15:00:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE IF NOT EXISTS `students` (
  `id` int(10) unsigned NOT NULL,
  `student_number` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_number` (`student_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `student_number`) VALUES
(3, '40383092'),
(6, '40383096'),
(7, '40383097'),
(8, '40383098'),
(9, '40383099');

-- --------------------------------------------------------

--
-- Table structure for table `students_in_groups`
--

CREATE TABLE IF NOT EXISTS `students_in_groups` (
  `user_id` int(10) unsigned NOT NULL,
  `group_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`user_id`,`group_id`),
  KEY `group_id` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students_in_groups`
--

INSERT INTO `students_in_groups` (`user_id`, `group_id`) VALUES
(3, 1),
(6, 1),
(7, 2),
(8, 2),
(9, 2);

-- --------------------------------------------------------

--
-- Table structure for table `students_register_courses`
--

CREATE TABLE IF NOT EXISTS `students_register_courses` (
  `user_id` int(10) unsigned NOT NULL,
  `course_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`user_id`,`course_id`),
  KEY `course_id` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students_register_courses`
--

INSERT INTO `students_register_courses` (`user_id`, `course_id`) VALUES
(3, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(7, 3),
(9, 3);

-- --------------------------------------------------------

--
-- Table structure for table `subsections`
--

CREATE TABLE IF NOT EXISTS `subsections` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `section_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `section_id` (`section_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Dumping data for table `subsections`
--

INSERT INTO `subsections` (`id`, `start_time`, `end_time`, `section_id`) VALUES
(2, '13:00:00', '13:00:00', 1),
(3, '13:30:00', '14:00:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `ta`
--

CREATE TABLE IF NOT EXISTS `ta` (
  `id` int(10) unsigned NOT NULL,
  `student_number` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_number` (`student_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ta`
--

INSERT INTO `ta` (`id`, `student_number`) VALUES
(2, '40383091'),
(4, '40383094'),
(5, '40383095');

-- --------------------------------------------------------

--
-- Table structure for table `ta_marks_course`
--

CREATE TABLE IF NOT EXISTS `ta_marks_course` (
  `user_id` int(10) unsigned NOT NULL,
  `course_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`user_id`,`course_id`),
  UNIQUE KEY `user_id` (`user_id`),
  KEY `course_id` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ta_marks_course`
--

INSERT INTO `ta_marks_course` (`user_id`, `course_id`) VALUES
(2, 1),
(4, 1),
(5, 4);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL,
  `first_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `last_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `authorization` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=151 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `first_name`, `last_name`, `authorization`) VALUES
(1, 'TestAdmin', '8c69a97f7d1556931da6b5f5c6cdc97ebb48c673', 'Test', 'Admin', 1),
(2, 'TestTa', 'e9c02d4e031ef07dad39cef7ec29360be86a5e60', 'Test', 'TA', 2),
(3, 'TestStudent', 'a4c4ef4d677a8c65f4906061b68bc8e3734c1a6c', 'Test', 'Student', 3),
(4, 'testta2', '163acab2b0e2a1e066ee2adfbb6760b2bede9813', 'Ta2', 'Test', 2),
(5, 'testta3', '25e87de944ccf137cea04cb769d5cd2a334967c6', 'Ta2', 'Test', 2),
(6, 'teststudent2', '85f8d422fb7474461a14b5636db5889b8dd15a5b', 'Student2', 'Test', 3),
(7, 'teststudent3', '0468549298e8cbb449bd1e924c8cbbc5496e7c08', 'Student3', 'Test', 3),
(8, 'teststudent4', 'a3cbf04a49f881daf4ff80cb25423d722e76b7ca', 'Student4', 'Test', 3),
(9, 'teststudent5', 'f112f4ff6e2e795a5fe6968fc6f1de90dd91869c', 'Student5', 'Test', 3);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin_manages_courses`
--
ALTER TABLE `admin_manages_courses`
  ADD CONSTRAINT `admin_manages_courses_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `admin_manages_courses_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `groups`
--
ALTER TABLE `groups`
  ADD CONSTRAINT `groups_ibfk_1` FOREIGN KEY (`section_id`) REFERENCES `sections` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hold_dates`
--
ALTER TABLE `hold_dates`
  ADD CONSTRAINT `hold_dates_ibfk_1` FOREIGN KEY (`subsection_id`) REFERENCES `subsections` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `hold_dates_ibfk_5` FOREIGN KEY (`ta_id`) REFERENCES `ta` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `hold_dates_ibfk_6` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `hold_dates_ibfk_7` FOREIGN KEY (`absent_student_id`) REFERENCES `students` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `marks`
--
ALTER TABLE `marks`
  ADD CONSTRAINT `marks_ibfk_3` FOREIGN KEY (`hold_date_id`) REFERENCES `hold_dates` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `marks_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `sections`
--
ALTER TABLE `sections`
  ADD CONSTRAINT `sections_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `students_in_groups`
--
ALTER TABLE `students_in_groups`
  ADD CONSTRAINT `students_in_groups_ibfk_2` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `students_in_groups_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `students` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `students_register_courses`
--
ALTER TABLE `students_register_courses`
  ADD CONSTRAINT `students_register_courses_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `students_register_courses_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `students` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `subsections`
--
ALTER TABLE `subsections`
  ADD CONSTRAINT `subsections_ibfk_1` FOREIGN KEY (`section_id`) REFERENCES `sections` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ta`
--
ALTER TABLE `ta`
  ADD CONSTRAINT `ta_ibfk_1` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ta_marks_course`
--
ALTER TABLE `ta_marks_course`
  ADD CONSTRAINT `ta_marks_course_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `ta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ta_marks_course_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
