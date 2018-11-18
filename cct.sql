-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- 생성 시간: 18-11-18 23:57
-- 서버 버전: 10.1.36-MariaDB
-- PHP 버전: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 데이터베이스: `cct`
--

-- --------------------------------------------------------

--
-- 테이블 구조 `customer`
--

CREATE TABLE `customer` (
  `c_whos` text NOT NULL,
  `c_business_name` text NOT NULL,
  `c_representative` text NOT NULL,
  `c_address` text NOT NULL,
  `c_phone` int(11) NOT NULL,
  `c_c_number` int(11) NOT NULL,
  `c_c_category` text NOT NULL,
  `c_c_kind` text NOT NULL,
  `c_email` text NOT NULL,
  `c_date` date NOT NULL,
  `c_comment` text NOT NULL,
  `c_deleted` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 테이블의 덤프 데이터 `customer`
--

INSERT INTO `customer` (`c_whos`, `c_business_name`, `c_representative`, `c_address`, `c_phone`, `c_c_number`, `c_c_category`, `c_c_kind`, `c_email`, `c_date`, `c_comment`, `c_deleted`) VALUES
('김동현', '1', '', '', 0, 0, '', '', '', '2018-10-11', '', 0),
('김동현', '2', '', '', 0, 0, '', '', '', '2018-10-11', '', 0),
('kdhkdk89@naver.com', '한글로도 되나요', '나ㅑ나', '', 0, 0, '', '', '', '2018-10-12', '', 0),
('kdhkdk89@naver.com', '1111111111', '2', '', 0, 0, '', '', '', '2018-10-15', '', 0),
('kdhkdk89@naver.com', '3121', '2', '', 0, 0, '', '', '', '2018-10-15', '', 0),
('kdhkdk89@naver.com', '1231', '', '', 0, 0, '', '', '', '2018-10-15', '', 0),
('kdhkdk89@naver.com', '21', '', '', 0, 0, '', '', '', '2018-10-15', '', 0),
('kdhkdk89@naver.com', '44', '', '', 0, 0, '', '', '', '2018-10-15', '', 0),
('kdhkdk89@naver.com', '54', '', '', 0, 0, '', '', '', '2018-10-15', '', 0),
('kdhkdk89@naver.com', '1234', '', '', 0, 0, '', '', '', '2018-10-16', '', 0),
('kdhkdk89@naver.com', 'qwer', '', '', 0, 0, '', '', '', '2018-10-16', '', 0),
('kdhkdk89@naver.com', 'ewg', '', '', 0, 0, '', '', '', '2018-10-16', '', 0),
('kdhkdk89@naver.com', 'ewgf', '', '', 0, 0, '', '', '', '2018-10-16', '', 0),
('kdhkdk89@naver.com', 'werb v', '', '', 0, 0, '', '', '', '2018-10-16', '', 0),
('kdhkdk89@naver.com', 'er vb', '', '', 0, 0, '', '', '', '2018-10-16', '', 0),
('kdhkdk89@naver.com', 'sth', '', '', 0, 0, '', '', '', '2018-10-16', '', 0),
('kdhkdk89@naver.com', 's sd', '', '', 0, 0, '', '', '', '2018-10-16', '', 0),
('kdhkdk89@naver.com', 'fdn ', '', '', 0, 0, '', '', '', '2018-10-16', '', 0),
('kdhkdk89@naver.com', 'fdgn', '', '', 0, 0, '', '', '', '2018-10-16', '', 0),
('kdhkdk89@naver.com', 'fghm', '', '', 0, 0, '', '', '', '2018-10-16', '', 0),
('kdhkdk89@naver.com', 'xvbm', '', '', 0, 0, '', '', '', '2018-10-16', '', 0),
('kdhkdk89@naver.com', 'asfd', '', '', 0, 0, '', '', '', '2018-10-16', '', 0),
('kdhkdk89@naver.com', 'rthb ', '', '', 0, 0, '', '', '', '2018-10-16', '', 0),
('kdhkdk89@naver.com', '상호명', '대표자', '주소', 0, 0, '업태', '종목', '이메일', '2018-10-16', '기타', 0),
('kdhkdk89@naver.com', '상호', '대표', '주소', 10, 33, '어', '종', '이메', '2018-10-16', '기', 0);

-- --------------------------------------------------------

--
-- 테이블 구조 `item`
--

CREATE TABLE `item` (
  `i_id` int(11) NOT NULL,
  `i_whos` text NOT NULL,
  `i_name` text NOT NULL,
  `i_producer` text NOT NULL,
  `i_quality` int(11) NOT NULL,
  `i_quantity` int(11) NOT NULL,
  `i_purchased` text NOT NULL,
  `i_price` bigint(15) NOT NULL,
  `i_date` date NOT NULL,
  `i_deleted` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 테이블의 덤프 데이터 `item`
--

INSERT INTO `item` (`i_id`, `i_whos`, `i_name`, `i_producer`, `i_quality`, `i_quantity`, `i_purchased`, `i_price`, `i_date`, `i_deleted`) VALUES
(1, 'kdhkdk89@naver.com', '1', '1', 4, 1, '1', 0, '2018-10-16', 0),
(3, 'kdhkdk89@naver.com', '3246', '346', 4, 236, '326', 0, '2018-10-25', 0),
(4, 'temp@temp.com', '1', '1', 4, 1, '1', 0, '2018-10-25', 0),
(5, 'kdhkdk89@naver.com', '11', '2', 4, 3, '1', 0, '2018-10-29', 0),
(6, 'kdhkdk89@naver.com', '5555', '53', 4, 3, '3', 0, '2018-10-29', 0),
(7, 'kdhkdk89@naver.com', '22', '53', 4, 34, '24', 0, '2018-10-29', 0),
(8, 'kdhkdk89@naver.com', '1', '1', 4, 1, '1', 0, '2018-10-29', 0),
(9, 'kdhkdk89@naver.com', '245', '236', 4, 23, '2345', 0, '2018-10-30', 0),
(10, 'kdhkdk89@naver.com', '234512', '1234', 4, 236, '345', 0, '2018-10-30', 0),
(11, 'kdhkdk89@naver.com', '237458', '478', 4, 341, '13', 0, '2018-10-30', 0),
(12, 'kdhkdk89@naver.com', '347', '458', 4, 458, '4568', 0, '2018-10-30', 0),
(13, 'kdhkdk89@naver.com', '사람', '아', 4, 4, '2', 0, '2018-10-31', 0),
(14, 'kdhkdk89@naver.com', '수고', '수', 4, 4, '4', 0, '2018-11-08', 0),
(15, 'kdhkdk89@naver.com', '가맥', '맥주', 4, 3, '3', 0, '2018-11-08', 0),
(16, 'kdhkdk89@naver.com', '하루', 'day', 4, 3, '3', 0, '2018-11-08', 0),
(17, 'kdhkdk89@naver.com', '나뚜루', '어딜까', 3, 3, '사람', 3000, '2018-11-12', 0),
(18, 'kdhkdk89@naver.com', '싸람', '나', 0, 6, '어딜까', 2147483647, '2018-11-12', 0),
(19, 'kdhkdk89@naver.com', '포', '아', 2, 2, '1', 2147483647, '2018-11-12', 0),
(20, 'kdhkdk89@naver.com', '카약', '아', 3, 2, '1', 2147483647, '2018-11-12', 0),
(21, 'kdhkdk89@naver.com', '타조', '다', 3, 5, '3', 9223372036854775807, '2018-11-12', 0),
(22, 'kdhkdk89@naver.com', '0', '0', 4, 0, '0', 11, '2018-11-13', 0),
(23, 'kdhkdk89@naver.com', '1212', '3', 3, 3, '4', 4444444, '2018-11-13', 0),
(24, 'kdhkdk89@naver.com', '4', '2', 4, 0, '', 123, '2018-11-13', 0),
(25, 'kdhkdk89@naver.com', '1234', '1234', 4, 0, '', 1234, '2018-11-13', 0);

-- --------------------------------------------------------

--
-- 테이블 구조 `saled_item`
--

CREATE TABLE `saled_item` (
  `s_id` int(11) NOT NULL,
  `s_customer_number` int(11) NOT NULL,
  `s_quantity` int(11) NOT NULL,
  `s_each_price` int(11) NOT NULL,
  `s_sum` int(11) NOT NULL,
  `s_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 테이블 구조 `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_name` text NOT NULL,
  `user_email` text NOT NULL,
  `user_password` text NOT NULL,
  `user_age` int(11) NOT NULL,
  `user_mobile` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 테이블의 덤프 데이터 `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `user_email`, `user_password`, `user_age`, `user_mobile`) VALUES
(1, '김동현', 'kdhkdk89@naver.com', '5323a8f1cbf6ef18c526e5a9aef7679c', 30, 1098561506),
(2, '', '', 'd41d8cd98f00b204e9800998ecf8427e', 0, 0),
(3, 'temp', 'temp@temp.com', '3d801aa532c1cec3ee82d87a99fdf63f', 0, 10);

--
-- 덤프된 테이블의 인덱스
--

--
-- 테이블의 인덱스 `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`i_id`);

--
-- 테이블의 인덱스 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- 덤프된 테이블의 AUTO_INCREMENT
--

--
-- 테이블의 AUTO_INCREMENT `item`
--
ALTER TABLE `item`
  MODIFY `i_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- 테이블의 AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
