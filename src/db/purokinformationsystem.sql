-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 09, 2023 at 02:47 PM
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
  `purok_id` int(100) NOT NULL,
  `rr_id` int(100) NOT NULL,
  `h_num` int(100) NOT NULL,
  `fam_mem` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `printreports`
--

INSERT INTO `printreports` (`pr_id`, `purok_id`, `rr_id`, `h_num`, `fam_mem`) VALUES
(8, 21, 66, 2323, '3'),
(9, 20, 63, 123, '2'),
(10, 23, 63, 58963, '4'),
(11, 21, 63, 74185, '10'),
(12, 21, 66, 123456, '10');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_purokrecords`
--

CREATE TABLE `tbl_purokrecords` (
  `purok_id` int(100) NOT NULL,
  `purok` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_purokrecords`
--

INSERT INTO `tbl_purokrecords` (`purok_id`, `purok`) VALUES
(15, 'Upper'),
(20, 'Centro'),
(21, 'Cambaje'),
(22, 'Kapolinar'),
(23, 'Centro'),
(24, 'Argonex'),
(25, 'Tagbuag-tubig'),
(26, 'Ilaya');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_residentrecords`
--

CREATE TABLE `tbl_residentrecords` (
  `rr_id` int(100) NOT NULL,
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

INSERT INTO `tbl_residentrecords` (`rr_id`, `rr_lastname`, `rr_firstname`, `rr_address`, `rr_status`, `rr_gender`, `rr_contact`, `rr_email`, `rr_occupation`, `rr_image`) VALUES
(60, 'Nicooo', 'Robin', 'Naga	', 'Single', 'Female', '095845824', 'nicorobin@gmail.com', 'Archeologist', ''),
(63, 'Cassie', 'Trinidad', 'Naga	', 'Single', 'Female', '095244851422', 'miafe@gmail.com', 'NA', 'src/images/xz.jpg'),
(65, 'Eric', 'John', 'Naga', 'Single', 'Male', '09526853654', 'ericjohn@gmail.com', 'Doctor', 'src/images/1.jpg'),
(66, 'Ken', 'Sunshine', 'Naga', 'Single', 'Female', '09584521547', 'kenshine@gmail.com', 'Engineer', 'src/images/download (9).jpg'),
(68, 'Kyle', 'Isidoro', 'Talisay City Cebu', 'Single', 'Male', '09297830328', 'sdasdasd', 'web developer', 'src/images/zc2.jpg'),
(69, 'Perry', 'Katy', 'Naga', 'Married', 'Female', '09559636214', 'katy@gmail.com', 'Teacher', 'src/images/Sarah-In-The-Bible-1.jpg');

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
(11, 'berna ', 'requinto', 'nadette', 'bernadetterequinto23@gmail.com', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5'),
(12, 't', 't', 't', 't', 'e3b98a4da31a127d4bde6e43033f66ba274cab0eb7eb1c70ec41402bf6273dd8'),
(13, 's', '', 's', 's', '043a718774c572bd8a25adbeb1bfcd5c0256ae11cecf9f9c3f925d0e52beaf89');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `printreports`
--
ALTER TABLE `printreports`
  ADD PRIMARY KEY (`pr_id`),
  ADD KEY `household_reports` (`purok_id`),
  ADD KEY `resident_reports` (`rr_id`);

--
-- Indexes for table `tbl_purokrecords`
--
ALTER TABLE `tbl_purokrecords`
  ADD PRIMARY KEY (`purok_id`);

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
  MODIFY `pr_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `tbl_purokrecords`
--
ALTER TABLE `tbl_purokrecords`
  MODIFY `purok_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `tbl_residentrecords`
--
ALTER TABLE `tbl_residentrecords`
  MODIFY `rr_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT for table `user_db`
--
ALTER TABLE `user_db`
  MODIFY `u_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `printreports`
--
ALTER TABLE `printreports`
  ADD CONSTRAINT `household_reports` FOREIGN KEY (`purok_id`) REFERENCES `tbl_purokrecords` (`purok_id`),
  ADD CONSTRAINT `resident_reports` FOREIGN KEY (`rr_id`) REFERENCES `tbl_residentrecords` (`rr_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
