-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 08, 2019 at 04:18 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `myproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminaddc`
--

CREATE TABLE `adminaddc` (
  `SerialNo` int(10) NOT NULL,
  `CourseTitle` varchar(50) NOT NULL,
  `CourseCode` varchar(10) NOT NULL,
  `Batch` int(10) NOT NULL,
  `Credit` int(10) NOT NULL,
  `Section` varchar(10) NOT NULL,
  `Seat` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adminaddc`
--

INSERT INTO `adminaddc` (`SerialNo`, `CourseTitle`, `CourseCode`, `Batch`, `Credit`, `Section`, `Seat`) VALUES
(3, 'Programming C', 'CSC 183', 2019, 3, 'A', 45),
(4, 'Programming C++', 'CSC 283', 2018, 3, 'E', 45),
(5, 'Programming java', 'CSC 383', 2017, 3, 'G', 45),
(6, 'Basic English', 'ENG 101', 2019, 3, 'B', 10),
(7, 'Public Speaking', 'ENG 250', 2018, 3, 'M', 5),
(8, 'Numerical Analysis', 'MAT 157', 2019, 3, 'D', 3),
(10, 'Visual Programming', 'CSC 439', 2017, 3, 'C', 3),
(11, 'Operating System', 'CSC 307', 2018, 3, 'E', 3),
(12, 'Logic Design', 'CSC 329', 2017, 3, 'Q', 3),
(13, 'Educational Planning', 'ART 101', 2019, 3, 'I', 3),
(14, 'Psychology', 'PSY 105', 2018, 3, 'P', 3),
(16, 'Database Management', 'CSC 490', 2017, 3, 'A', 3);

-- --------------------------------------------------------

--
-- Table structure for table `adminadds`
--

CREATE TABLE `adminadds` (
  `SerialNo` int(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `ID` int(10) NOT NULL,
  `Batch` int(10) NOT NULL,
  `Department` varchar(10) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adminadds`
--

INSERT INTO `adminadds` (`SerialNo`, `Name`, `ID`, `Batch`, `Department`, `Password`) VALUES
(50, 'Albert', 17103001, 2017, 'CSE', 'Albert'),
(51, 'Brown', 17103002, 2017, 'CSE', 'Brown'),
(52, 'Charmie', 17103003, 2017, 'CSE', 'Charmie'),
(53, 'Daniel', 17103004, 2017, 'CSE', 'Daniel'),
(54, 'Emily', 17103005, 2017, 'CSE', 'Emily'),
(55, 'Annie', 18103001, 2018, 'CSE', 'Annie'),
(56, 'Bingo', 18103002, 2018, 'CSE', 'Bingo'),
(57, 'Cicielia', 18103003, 2018, 'CSE', 'Cicielia'),
(58, 'Dobby', 18103004, 2018, 'CSE', 'Dobby'),
(59, 'Elsa', 18103005, 2018, 'CSE', 'Elsa'),
(60, 'Aphrodite', 19103001, 2019, 'CSE', 'Aphrodite'),
(61, 'Bruno', 19103002, 2019, 'CSE', 'Bruno'),
(62, 'Catherine', 19103003, 2019, 'CSE', 'Catherine'),
(63, 'Dacia', 19103004, 2019, 'CSE', 'Dacia'),
(64, 'Ellie', 19103005, 2019, 'CSE', 'Ellie');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `Name` varchar(10) NOT NULL,
  `Password` varchar(10) NOT NULL,
  `Role` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`Name`, `Password`, `Role`) VALUES
('Admin', 'Admin', 1),
('17103001', 'Albert', 2),
('17103002', 'Brown', 2),
('17103003', 'Charmie', 2),
('17103004', 'Daniel', 2),
('17103005', 'Emily', 2),
('18103001', 'Annie', 2),
('18103002', 'Bingo', 2),
('18103003', 'Cicielia', 2),
('18103004', 'Dobby', 2),
('18103005', 'Elsa', 2),
('19103001', 'Aphrodite', 2),
('19103002', 'Bruno', 2),
('19103003', 'Catherine', 2),
('19103004', 'Dacia', 2),
('19103005', 'Ellie', 2);

-- --------------------------------------------------------

--
-- Table structure for table `studentaddc`
--

CREATE TABLE `studentaddc` (
  `SerialNo` int(10) NOT NULL,
  `CourseTitle` varchar(30) NOT NULL,
  `CourseCode` varchar(10) NOT NULL,
  `Section` varchar(10) NOT NULL,
  `Batch` int(10) NOT NULL,
  `Seat` int(10) NOT NULL,
  `StudentID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adminaddc`
--
ALTER TABLE `adminaddc`
  ADD PRIMARY KEY (`SerialNo`);

--
-- Indexes for table `adminadds`
--
ALTER TABLE `adminadds`
  ADD PRIMARY KEY (`SerialNo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adminaddc`
--
ALTER TABLE `adminaddc`
  MODIFY `SerialNo` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `adminadds`
--
ALTER TABLE `adminadds`
  MODIFY `SerialNo` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
