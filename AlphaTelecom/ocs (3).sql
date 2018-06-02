-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 02, 2018 at 11:00 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ocs`
--

-- --------------------------------------------------------

--
-- Table structure for table `pitanje`
--

CREATE TABLE `pitanje` (
  `pitanje_id` int(11) NOT NULL,
  `tekst_pitanja` varchar(255) COLLATE utf8_slovenian_ci NOT NULL,
  `tacan_odg` varchar(255) COLLATE utf8_slovenian_ci NOT NULL,
  `broj_bodova` int(100) NOT NULL,
  `takmicenjeid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `pitanje`
--

INSERT INTO `pitanje` (`pitanje_id`, `tekst_pitanja`, `tacan_odg`, `broj_bodova`, `takmicenjeid`) VALUES
(43, 'jadks', 'nda,ms', 0, 3);

-- --------------------------------------------------------

--
-- Table structure for table `ponudjeni_odg`
--

CREATE TABLE `ponudjeni_odg` (
  `ponudjeni_odg_id` int(11) NOT NULL,
  `opcija_1` varchar(255) COLLATE utf8_slovenian_ci NOT NULL,
  `opcija_2` varchar(255) COLLATE utf8_slovenian_ci NOT NULL,
  `opcija_3` varchar(255) COLLATE utf8_slovenian_ci NOT NULL,
  `opcija_4` varchar(255) COLLATE utf8_slovenian_ci NOT NULL,
  `opcija_5` varchar(255) COLLATE utf8_slovenian_ci NOT NULL,
  `pitanjeid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pregledanje`
--

CREATE TABLE `pregledanje` (
  `pregledanje_id` int(11) NOT NULL,
  `odabrani_odg` varchar(255) COLLATE utf8_slovenian_ci NOT NULL,
  `userid` int(11) NOT NULL,
  `pitanjeid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `problem`
--

CREATE TABLE `problem` (
  `problem_id` int(11) NOT NULL,
  `incident` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `naziv_problema` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `text` varchar(500) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `userid` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `problem`
--

INSERT INTO `problem` (`problem_id`, `incident`, `naziv_problema`, `status`, `text`, `userid`) VALUES
(3, 'Spor internet', 'Problem1', 'Proslijedjeno visim pozicijama na razmatranje.', 'Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt, explicabo. Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est', NULL),
(4, 'Nedostaju kanali na kablovskoj', 'Problem 2', 'Sazvan timski sastanak u svrhu rjesavanja problema.', 'Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt, explicabo. Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est', NULL),
(5, 'Nestajanje mobilne mreze', 'Problem 3', 'Proslijedjeno visim pozicijama na razmatranje.', 'Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt, explicabo. Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est', NULL),
(6, 'Spor internet', 'Problem5', 'Na cekanju', 'Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt, explicabo. Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est', NULL),
(7, 'Nedostaju kanali na kablovskoj', 'Novi problem', 'Na cekanju', 'Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt, explicabo. Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `rezultati`
--

CREATE TABLE `rezultati` (
  `rezultati_id` int(11) NOT NULL,
  `ostvareni_bodovi` int(11) NOT NULL,
  `userid` int(100) NOT NULL,
  `takmicenjeid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role` varchar(20) COLLATE utf8_slovenian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role`) VALUES
(1, 'ADMIN'),
(2, 'KORISNIK');

-- --------------------------------------------------------

--
-- Table structure for table `takmicenje`
--

CREATE TABLE `takmicenje` (
  `takmicenje_id` int(11) NOT NULL,
  `naziv` varchar(255) COLLATE utf8_slovenian_ci NOT NULL,
  `trajanje` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `takmicenje`
--

INSERT INTO `takmicenje` (`takmicenje_id`, `naziv`, `trajanje`) VALUES
(3, 'Matematika', 1),
(4, 'Fizika', 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `ime` varchar(255) COLLATE utf8_slovenian_ci NOT NULL,
  `prezime` varchar(255) COLLATE utf8_slovenian_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_slovenian_ci NOT NULL,
  `password` varchar(60) COLLATE utf8_slovenian_ci NOT NULL,
  `username` varchar(255) COLLATE utf8_slovenian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `ime`, `prezime`, `email`, `password`, `username`) VALUES
(1, 'Sunita', 'Imamovic', 'simamovic@gmail.com', '$2a$04$1wwQ9.l8FKbh0N3voeXUNOug8JDa2IhHwDtDD0kU8vbRC5JTAiqdG', 'simamovic'),
(2, 'Sajra', 'Muratovic', 'smuratovic@hotmail.com', '$2a$04$1wwQ9.l8FKbh0N3voeXUNOug8JDa2IhHwDtDD0kU8vbRC5JTAiqdG', 'smuratovic');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `user_takmicenje`
--

CREATE TABLE `user_takmicenje` (
  `userid` int(11) NOT NULL,
  `takmicenjeid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user_usluge`
--

CREATE TABLE `user_usluge` (
  `userid` int(11) NOT NULL,
  `uslugaid` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `user_usluge`
--

INSERT INTO `user_usluge` (`userid`, `uslugaid`) VALUES
(2, 3),
(2, 4),
(2, 13);

-- --------------------------------------------------------

--
-- Table structure for table `usluga`
--

CREATE TABLE `usluga` (
  `usluga_id` int(11) NOT NULL,
  `naziv` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `opis` varchar(500) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `status` varchar(10) COLLATE utf8_slovenian_ci DEFAULT 'Neodobren'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `usluga`
--

INSERT INTO `usluga` (`usluga_id`, `naziv`, `opis`, `status`) VALUES
(13, 'Brzi internet', 'Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt, explicabo. Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est.', 'Odobren'),
(14, 'Kablovska televizija', 'Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt, explicabo. Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est.', 'Neodobren'),
(12, 'Studentski paket', 'Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt, explicabo. Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est', 'Neodobren'),
(15, 'Usluga 4', 'Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt, explicabo. Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est.', 'Neodobren');

-- --------------------------------------------------------

--
-- Table structure for table `zahtjev`
--

CREATE TABLE `zahtjev` (
  `zahtjev_id` int(11) NOT NULL,
  `naziv_zahtjeva` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `text` varchar(500) COLLATE utf8_slovenian_ci DEFAULT NULL,
  `userid` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci;

--
-- Dumping data for table `zahtjev`
--

INSERT INTO `zahtjev` (`zahtjev_id`, `naziv_zahtjeva`, `status`, `text`, `userid`) VALUES
(5, 'Zahtjev 1', 'Neodobren', 'Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt, explicabo. Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est', NULL),
(6, 'Zahtjev 2', 'Odobren', 'Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt, explicabo. Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est', NULL),
(7, 'Zahtjev 6', 'Neodobren', 'Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt, explicabo. Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est', NULL),
(8, 'Novi Zahtjev', 'Neodobren', 'Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt, explicabo. Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pitanje`
--
ALTER TABLE `pitanje`
  ADD PRIMARY KEY (`pitanje_id`),
  ADD KEY `takmicenjeid` (`takmicenjeid`);

--
-- Indexes for table `ponudjeni_odg`
--
ALTER TABLE `ponudjeni_odg`
  ADD PRIMARY KEY (`ponudjeni_odg_id`),
  ADD KEY `pitanjeid` (`pitanjeid`);

--
-- Indexes for table `pregledanje`
--
ALTER TABLE `pregledanje`
  ADD PRIMARY KEY (`pregledanje_id`),
  ADD KEY `userid` (`userid`),
  ADD KEY `pitanjeid` (`pitanjeid`);

--
-- Indexes for table `problem`
--
ALTER TABLE `problem`
  ADD PRIMARY KEY (`problem_id`),
  ADD KEY `FKbidp7mauad4ov3uvwbkgsmmqh` (`userid`);

--
-- Indexes for table `rezultati`
--
ALTER TABLE `rezultati`
  ADD PRIMARY KEY (`rezultati_id`),
  ADD KEY `userid` (`userid`),
  ADD KEY `takmicenjeid` (`takmicenjeid`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `takmicenje`
--
ALTER TABLE `takmicenje`
  ADD PRIMARY KEY (`takmicenje_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `user_id` (`user_id`),
  ADD KEY `role_id` (`role_id`);

--
-- Indexes for table `user_takmicenje`
--
ALTER TABLE `user_takmicenje`
  ADD KEY `userid` (`userid`),
  ADD KEY `takmicenjeid` (`takmicenjeid`);

--
-- Indexes for table `user_usluge`
--
ALTER TABLE `user_usluge`
  ADD PRIMARY KEY (`userid`,`uslugaid`),
  ADD KEY `FKlaig4158p0h2d0dd58d8lysv7` (`uslugaid`);

--
-- Indexes for table `usluga`
--
ALTER TABLE `usluga`
  ADD PRIMARY KEY (`usluga_id`);

--
-- Indexes for table `zahtjev`
--
ALTER TABLE `zahtjev`
  ADD PRIMARY KEY (`zahtjev_id`),
  ADD KEY `FK7rrpgksdg78okxa782t4v9td3` (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pitanje`
--
ALTER TABLE `pitanje`
  MODIFY `pitanje_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;
--
-- AUTO_INCREMENT for table `ponudjeni_odg`
--
ALTER TABLE `ponudjeni_odg`
  MODIFY `ponudjeni_odg_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pregledanje`
--
ALTER TABLE `pregledanje`
  MODIFY `pregledanje_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `problem`
--
ALTER TABLE `problem`
  MODIFY `problem_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `rezultati`
--
ALTER TABLE `rezultati`
  MODIFY `rezultati_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `takmicenje`
--
ALTER TABLE `takmicenje`
  MODIFY `takmicenje_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `usluga`
--
ALTER TABLE `usluga`
  MODIFY `usluga_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `zahtjev`
--
ALTER TABLE `zahtjev`
  MODIFY `zahtjev_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `pitanje`
--
ALTER TABLE `pitanje`
  ADD CONSTRAINT `FKd5sk5t89wudkr305f3tqqe4e0` FOREIGN KEY (`takmicenjeid`) REFERENCES `takmicenje` (`takmicenje_id`),
  ADD CONSTRAINT `pitanje_ibfk_1` FOREIGN KEY (`takmicenjeid`) REFERENCES `takmicenje` (`takmicenje_id`);

--
-- Constraints for table `ponudjeni_odg`
--
ALTER TABLE `ponudjeni_odg`
  ADD CONSTRAINT `FK49qmjnw9hxofcigmyfnx30ece` FOREIGN KEY (`pitanjeid`) REFERENCES `pitanje` (`pitanje_id`),
  ADD CONSTRAINT `ponudjeni_odg_ibfk_1` FOREIGN KEY (`pitanjeid`) REFERENCES `pitanje` (`pitanje_id`);

--
-- Constraints for table `pregledanje`
--
ALTER TABLE `pregledanje`
  ADD CONSTRAINT `FKbl3nircydxelhm404rep1an8m` FOREIGN KEY (`pitanjeid`) REFERENCES `pitanje` (`pitanje_id`),
  ADD CONSTRAINT `FKluwjyywja7jk9kbob8d32dm25` FOREIGN KEY (`userid`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `pregledanje_ibfk_1` FOREIGN KEY (`pitanjeid`) REFERENCES `pitanje` (`pitanje_id`),
  ADD CONSTRAINT `pregledanje_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `rezultati`
--
ALTER TABLE `rezultati`
  ADD CONSTRAINT `FK1pu670vxlo7sncfpximkhn6xo` FOREIGN KEY (`userid`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FKca3380xsx0yj510iiyahew9rl` FOREIGN KEY (`takmicenjeid`) REFERENCES `takmicenje` (`takmicenje_id`),
  ADD CONSTRAINT `rezultati_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `rezultati_ibfk_2` FOREIGN KEY (`takmicenjeid`) REFERENCES `takmicenje` (`takmicenje_id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  ADD CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);

--
-- Constraints for table `user_takmicenje`
--
ALTER TABLE `user_takmicenje`
  ADD CONSTRAINT `FKbrfgkx3l0b5tmkuf0f4ppscj3` FOREIGN KEY (`userid`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FKosxql1dua4esjp14usnyjcb7x` FOREIGN KEY (`takmicenjeid`) REFERENCES `takmicenje` (`takmicenje_id`),
  ADD CONSTRAINT `user_takmicenje_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `user_takmicenje_ibfk_2` FOREIGN KEY (`takmicenjeid`) REFERENCES `takmicenje` (`takmicenje_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
