-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 28, 2021 at 05:15 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javamp`
--

-- --------------------------------------------------------

--
-- Table structure for table `medical`
--

CREATE TABLE `medical` (
  `product id` int(11) NOT NULL,
  `Product Name` varchar(200) NOT NULL,
  `Available Quantity` int(20) NOT NULL,
  `Price` decimal(20,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medical`
--

INSERT INTO `medical` (`product id`, `Product Name`, `Available Quantity`, `Price`) VALUES
(1, 'Crocin', 200, '4'),
(2, 'Acetaminophen', 122, '220'),
(3, 'Adderall', 542, '320'),
(4, 'Alprazolam', 942, '520'),
(5, 'D powder', 123, '56'),
(6, '2', 3, '4'),
(7, '1', 256, '78'),
(8, 'ABC', 257, '20'),
(9, 'WQ', 240, '76'),
(10, 'XYZ', 1, '43'),
(11, 'uy', 55, '777'),
(12, 'AQ', 43, '556'),
(13, 'yy', 77, '9789'),
(14, 'TT', 78, '90'),
(15, 'Cipla', 60, '6');

-- --------------------------------------------------------

--
-- Table structure for table `medical_info`
--

CREATE TABLE `medical_info` (
  `medical_id` int(7) NOT NULL,
  `Medical_Name` varchar(60) NOT NULL,
  `Medical_Address` varchar(190) NOT NULL,
  `Medical_Mobile` int(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medical_info`
--

INSERT INTO `medical_info` (`medical_id`, `Medical_Name`, `Medical_Address`, `Medical_Mobile`) VALUES
(0, 'Unique', 'midc Ratnagiri', 976382);

-- --------------------------------------------------------

--
-- Table structure for table `sale`
--

CREATE TABLE `sale` (
  `cust_id` int(60) NOT NULL,
  `cust_Name` varchar(60) NOT NULL,
  `Product_Name` varchar(200) DEFAULT NULL,
  `Quantity` int(70) NOT NULL,
  `Price` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sale`
--

INSERT INTO `sale` (`cust_id`, `cust_Name`, `Product_Name`, `Quantity`, `Price`) VALUES
(1, '', 'Crocin', 2, '3'),
(2, '', 'Acetaminophen', 22, '33'),
(3, '', 'D powder', 7, '7'),
(4, '', '', 2, '3'),
(5, '', 'Crocin', 0, '1'),
(6, 'Arman', 'Crocin', 1, '2'),
(7, 'Arman N', 'Crocin', 5, '9'),
(8, 'Arman Nakhwa', 'Crocin', 5, '30');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `medical`
--
ALTER TABLE `medical`
  ADD PRIMARY KEY (`product id`);

--
-- Indexes for table `medical_info`
--
ALTER TABLE `medical_info`
  ADD PRIMARY KEY (`medical_id`);

--
-- Indexes for table `sale`
--
ALTER TABLE `sale`
  ADD PRIMARY KEY (`cust_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `medical`
--
ALTER TABLE `medical`
  MODIFY `product id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `sale`
--
ALTER TABLE `sale`
  MODIFY `cust_id` int(60) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
