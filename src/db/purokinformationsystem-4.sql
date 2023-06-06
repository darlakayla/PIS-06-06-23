-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 06, 2023 at 11:22 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `purokinformationsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `printreports`
--

CREATE TABLE `printreports` (
  `pr_id` int(10) NOT NULL,
  `hh_id` int(10) NOT NULL,
  `rr_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_householdrecords`
--

CREATE TABLE `tbl_householdrecords` (
  `hh_id` int(10) NOT NULL,
  `hh_houseno` varchar(50) NOT NULL,
  `hh_lastname` varchar(50) NOT NULL,
  `hh_firstname` varchar(50) NOT NULL,
  `hh_spouse` varchar(100) NOT NULL,
  `hh_gender` varchar(50) NOT NULL,
  `hh_status` varchar(20) NOT NULL,
  `hh_birthdate` varchar(50) NOT NULL,
  `hh_address` varchar(100) NOT NULL,
  `hh_occupation` varchar(100) NOT NULL,
  `hh_contact` varchar(50) NOT NULL,
  `hh_children` varchar(50) NOT NULL,
  `hh_image` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_householdrecords`
--

INSERT INTO `tbl_householdrecords` (`hh_id`, `hh_houseno`, `hh_lastname`, `hh_firstname`, `hh_spouse`, `hh_gender`, `hh_status`, `hh_birthdate`, `hh_address`, `hh_occupation`, `hh_contact`, `hh_children`, `hh_image`) VALUES
(12, '12154', 'Requinto', 'Berna', 'NA', 'Female', 'Divorced', 'May 20, 2001', 'Naga', 'NA', '0956541252', '0', ''),
(15, '58632', 'Ipon', 'Darla Kayla', 'NA', 'Female', 'Divorced', 'March 26, 2001', 'Naga', 'NA', '09453518696', '0', ''),
(20, '452158', 'Kendrick', 'Anna', 'Nelmar Kendrick', 'Female', 'Married', '10/29/2001', 'Naga', 'Teacher', '06851458963', '3', 'src/images/123713296_374694077186421_2521908196954077938_n.jpg'),
(21, '159635', 'Castino', 'Kant', 'Alie Kastino', 'Female', 'Married', '10/29/01', 'Naga', 'Architect', '09524841527', '1', 'src/images/280181015_5115356378532099_2284812740534979891_n.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_residentrecords`
--

CREATE TABLE `tbl_residentrecords` (
  `rr_id` int(10) NOT NULL,
  `rr_purokname` varchar(100) NOT NULL,
  `rr_lastname` varchar(50) NOT NULL,
  `rr_firstname` varchar(50) NOT NULL,
  `rr_address` varchar(100) NOT NULL,
  `rr_status` varchar(10) NOT NULL,
  `rr_gender` varchar(10) NOT NULL,
  `rr_contact` varchar(20) NOT NULL,
  `rr_email` varchar(50) NOT NULL,
  `rr_occupation` varchar(50) NOT NULL,
  `rr_image` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_residentrecords`
--

INSERT INTO `tbl_residentrecords` (`rr_id`, `rr_purokname`, `rr_lastname`, `rr_firstname`, `rr_address`, `rr_status`, `rr_gender`, `rr_contact`, `rr_email`, `rr_occupation`, `rr_image`) VALUES
(60, 'Centro', 'Nicooo', 'Robin', 'Naga	', 'Single', 'Female', '095845824', 'nicorobin@gmail.com', 'Archeologist', ''),
(63, 'Cambaje', 'Cassie', 'Trinidad', 'Naga	', 'Single', 'Female', '095244851422', 'miafe@gmail.com', 'NA', 'src/images/xz.jpg'),
(65, 'Argonex', 'Eric', 'John', 'Naga', 'Single', 'Male', '09526853654', 'ericjohn@gmail.com', 'Doctor', 'src/images/1.jpg'),
(66, 'Kapolinar', 'Shine', 'Ken', 'Naga', 'Male', 'Single', '09584521547', 'kenshine@gmail.com', 'Engineer', ''),
(67, 'Upper', 'Mark', 'Thompson', 'Naga', 'Male', 'Separated', '09632541258', 'thomp@gmail.com', 'Lawyer', 'src/images/2469d1220b7ca4d114d9f0e615c52a8b.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `user_db`
--

CREATE TABLE `user_db` (
  `u_id` int(10) NOT NULL,
  `u_firstname` varchar(100) NOT NULL,
  `u_lastname` varchar(100) NOT NULL,
  `u_username` varchar(100) NOT NULL,
  `u_email` varchar(100) NOT NULL,
  `u_password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_db`
--

INSERT INTO `user_db` (`u_id`, `u_firstname`, `u_lastname`, `u_username`, `u_email`, `u_password`) VALUES
(7, 'wew', 'wew', 'wew', 'wew', '240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9'),
(8, 'KAYLA', 'IPON', 'kaiii', 'kay@gmail.com', '5252c89628d11818beebbd12f6a5be4146045e7fafca6a41c2e7fe1e5e799d20'),
(9, 'darlakayla', 'ipon', 'kayla2001', 'darla@gmail.com', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92'),
(10, 'A', 'A', 'A', 'A', '559aead08264d5795d3909718cdd05abd49572e84fe55590eef31a88a08fdffd'),
(11, 'berna ', 'requinto', 'nadette', 'bernadetterequinto23@gmail.com', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `printreports`
--
ALTER TABLE `printreports`
  ADD PRIMARY KEY (`pr_id`),
  ADD KEY `household_reports` (`hh_id`),
  ADD KEY `resident_reports` (`rr_id`);

--
-- Indexes for table `tbl_householdrecords`
--
ALTER TABLE `tbl_householdrecords`
  ADD PRIMARY KEY (`hh_id`);

--
-- Indexes for table `tbl_residentrecords`
--
ALTER TABLE `tbl_residentrecords`
  ADD PRIMARY KEY (`rr_id`);

--
-- Indexes for table `user_db`
--
ALTER TABLE `user_db`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `printreports`
--
ALTER TABLE `printreports`
  MODIFY `pr_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_householdrecords`
--
ALTER TABLE `tbl_householdrecords`
  MODIFY `hh_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `tbl_residentrecords`
--
ALTER TABLE `tbl_residentrecords`
  MODIFY `rr_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;

--
-- AUTO_INCREMENT for table `user_db`
--
ALTER TABLE `user_db`
  MODIFY `u_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `printreports`
--
ALTER TABLE `printreports`
  ADD CONSTRAINT `household_reports` FOREIGN KEY (`hh_id`) REFERENCES `tbl_householdrecords` (`hh_id`),
  ADD CONSTRAINT `resident_reports` FOREIGN KEY (`rr_id`) REFERENCES `tbl_residentrecords` (`rr_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
