-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 14, 2022 at 05:56 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ramcha`
--

-- --------------------------------------------------------

--
-- Table structure for table `article`
--

CREATE TABLE `article` (
  `idArticle` int(11) NOT NULL,
  `nomArticle` varchar(255) NOT NULL,
  `marqueArticle` varchar(255) DEFAULT NULL,
  `typeArticle` varchar(255) DEFAULT NULL,
  `disponibiliteArticle` varchar(255) DEFAULT NULL,
  `couleurArticle` varchar(255) DEFAULT NULL,
  `prixArticle` float DEFAULT NULL,
  `tailleArticle` varchar(255) DEFAULT NULL,
  `descriptionArticle` mediumtext DEFAULT NULL,
  `screenshot` varchar(255) DEFAULT NULL,
  `IdidMagasin` int(11) DEFAULT NULL,
  `idCategorieArticle` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `article`
--

INSERT INTO `article` (`idArticle`, `nomArticle`, `marqueArticle`, `typeArticle`, `disponibiliteArticle`, `couleurArticle`, `prixArticle`, `tailleArticle`, `descriptionArticle`, `screenshot`, `IdidMagasin`, `idCategorieArticle`) VALUES
(63, 'croustina', 'saida', 'biscuits', '1', '0xffff80ff', 800, 'mini', 'aaaaaaaaaaaaaaaaaaaaaaaaaa', 'C:UserschalgOneDriveBureau	est 1.jpg', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `avis`
--

CREATE TABLE `avis` (
  `idAvis` int(11) NOT NULL,
  `detailAvisService` varchar(255) NOT NULL,
  `noteService` int(11) NOT NULL,
  `idArticle` int(11) NOT NULL,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `aviscours`
--

CREATE TABLE `aviscours` (
  `IdAvisCours` int(11) NOT NULL,
  `rate` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL,
  `IdCours` int(11) NOT NULL,
  `commentaire` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `aviscours`
--

INSERT INTO `aviscours` (`IdAvisCours`, `rate`, `idUtilisateur`, `IdCours`, `commentaire`) VALUES
(1, 55, 1, 4, 'hello'),
(5, 3, 1, 0, 'uyhgubrgvf'),
(6, 3, 1, 0, 'bravo');

-- --------------------------------------------------------

--
-- Table structure for table `categoriearticle`
--

CREATE TABLE `categoriearticle` (
  `idCategorie` int(11) NOT NULL,
  `libelle` varchar(255) NOT NULL,
  `discription` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categoriearticle`
--

INSERT INTO `categoriearticle` (`idCategorie`, `libelle`, `discription`) VALUES
(1, 'Produits alimentaires', 'Vous trouverez ici tous les produits frais'),
(2, 'Legumes', 'produits frais');

-- --------------------------------------------------------

--
-- Table structure for table `categorieservice`
--

CREATE TABLE `categorieservice` (
  `idCategorieService` int(11) NOT NULL,
  `nomCategorieService` varchar(255) NOT NULL,
  `descriptionCategorieService` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categorieservice`
--

INSERT INTO `categorieservice` (`idCategorieService`, `nomCategorieService`, `descriptionCategorieService`) VALUES
(1, 'Travaux manuelles', 'Vos travaux à la maison, nous prenons soin d\'eux'),
(2, 'E-Shop', 'Achetez toutes vos fournitures, obtenez-les avec RAMCHA'),
(3, 'Garde d\'enfant', 'Faire garder tes enfants à domicile avec RAMCHA'),
(4, 'Ménage à domicile', 'Avec Ramcha , bénéficiez de l\'aide d\'un homme ou d\'une femme de ménage sans contraintes !');

-- --------------------------------------------------------

--
-- Table structure for table `chapitre`
--

CREATE TABLE `chapitre` (
  `IdChapitre` int(11) NOT NULL,
  `nomChapitre` varchar(255) NOT NULL,
  `langueChapitre` varchar(255) NOT NULL,
  `typeChapitre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `commandearticle`
--

CREATE TABLE `commandearticle` (
  `idCommande` int(11) NOT NULL,
  `modeLivraison` varchar(255) NOT NULL,
  `statusLivraison` varchar(255) NOT NULL,
  `dateCommande` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `commandearticle`
--

INSERT INTO `commandearticle` (`idCommande`, `modeLivraison`, `statusLivraison`, `dateCommande`) VALUES
(85, 'A domicile', 'Deja traité', '2022-10-26'),
(90, 'A domicile', 'En cours de livraison', '2022-10-27'),
(94, 'A domicile', 'En cours de traitement', '2022-10-28'),
(95, 'A domicile', 'Deja traité', '2022-10-28'),
(96, 'A domicile', 'Deja traité', '2022-10-28');

-- --------------------------------------------------------

--
-- Table structure for table `commandearticle_article_utilisateur`
--

CREATE TABLE `commandearticle_article_utilisateur` (
  `idCommande` int(11) NOT NULL,
  `idArticle` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `commandeservice`
--

CREATE TABLE `commandeservice` (
  `idCommandeService` int(11) NOT NULL,
  `dateRequis` date NOT NULL,
  `dateCommandeService` date NOT NULL DEFAULT current_timestamp(),
  `statusCommande` varchar(255) NOT NULL,
  `nbjour` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `commandeservice`
--

INSERT INTO `commandeservice` (`idCommandeService`, `dateRequis`, `dateCommandeService`, `statusCommande`, `nbjour`) VALUES
(80, '2022-11-06', '2022-10-26', 'en cours de traitement', 0),
(86, '2022-10-30', '2022-10-26', 'En cours de livraison', 2),
(87, '2022-10-30', '2022-10-26', 'Deja traité', 3),
(88, '2022-11-05', '2022-10-26', 'Deja traité', 3),
(91, '2022-10-29', '2022-10-26', 'En cours de livraison', 1),
(93, '2022-11-06', '2022-10-27', 'En cours de livraison', 3),
(94, '2022-11-05', '2022-10-27', 'En cours de livraison', 4),
(95, '2022-11-06', '2022-10-27', 'en cours de traitement', 3),
(97, '2022-12-02', '2022-10-27', 'en cours de traitement', 4),
(98, '2022-11-04', '2022-10-27', 'en cours de traitement', 5),
(100, '2022-11-05', '2022-10-28', 'en cours de traitement', 3);

-- --------------------------------------------------------

--
-- Table structure for table `commandeservice_service_utilisateur`
--

CREATE TABLE `commandeservice_service_utilisateur` (
  `idService` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL,
  `idCommandeService` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `commandeservice_service_utilisateur`
--

INSERT INTO `commandeservice_service_utilisateur` (`idService`, `idUtilisateur`, `idCommandeService`) VALUES
(4, 7, 100);

-- --------------------------------------------------------

--
-- Table structure for table `cours`
--

CREATE TABLE `cours` (
  `IdCours` int(11) NOT NULL,
  `nomCours` varchar(255) NOT NULL,
  `categorieCours` varchar(255) NOT NULL,
  `sujetCours` varchar(255) NOT NULL,
  `niveauCours` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `cours_chapitre`
--

CREATE TABLE `cours_chapitre` (
  `IdCours` int(11) NOT NULL,
  `IdChapitre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `devis`
--

CREATE TABLE `devis` (
  `idDevis` int(11) NOT NULL,
  `dateDevis` date NOT NULL DEFAULT current_timestamp(),
  `totalHT` float NOT NULL,
  `total` float NOT NULL,
  `idCommande` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `devis`
--

INSERT INTO `devis` (`idDevis`, `dateDevis`, `totalHT`, `total`, `idCommande`) VALUES
(15, '2022-10-20', 2032.1, 3048.15, 34);

-- --------------------------------------------------------

--
-- Table structure for table `devisservice`
--

CREATE TABLE `devisservice` (
  `idDevisService` int(11) NOT NULL,
  `dateDevis` date NOT NULL DEFAULT current_timestamp(),
  `total` float NOT NULL,
  `idCommandeSevice` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `devisservice`
--

INSERT INTO `devisservice` (`idDevisService`, `dateDevis`, `total`, `idCommandeSevice`) VALUES
(1, '2022-10-20', 60.4, 6),
(2, '2022-10-24', 241.6, 63),
(3, '2022-10-24', 241.6, 63),
(4, '2022-10-28', 207.6, 99),
(5, '2022-10-28', 136.5, 100);

-- --------------------------------------------------------

--
-- Table structure for table `facture`
--

CREATE TABLE `facture` (
  `idFacture` int(11) NOT NULL,
  `dateFacture` date NOT NULL DEFAULT current_timestamp(),
  `facturePDF` blob DEFAULT NULL,
  `idDevis` int(11) NOT NULL,
  `idCommande` int(11) NOT NULL,
  `total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `facture`
--

INSERT INTO `facture` (`idFacture`, `dateFacture`, `facturePDF`, `idDevis`, `idCommande`, `total`) VALUES
(8, '2022-10-20', 0x6e756c6c, 15, 34, 5),
(9, '2022-10-24', NULL, 15, 66, 2),
(10, '2022-10-24', NULL, 15, 67, 1),
(11, '2022-10-26', 0x6e756c6c, 15, 72, 3009.52),
(12, '2022-10-26', 0x6e756c6c, 15, 72, 3009.52),
(13, '2022-10-26', 0x6e756c6c, 15, 73, 3011.32),
(14, '2022-10-26', 0x6e756c6c, 15, 74, 4511.32),
(15, '2022-10-26', 0x6e756c6c, 15, 75, 2383),
(16, '2022-10-26', 0x6e756c6c, 15, 76, 3883),
(17, '2022-10-26', 0x6e756c6c, 15, 77, 6259),
(18, '2022-10-26', 0x6e756c6c, 15, 78, 1507),
(19, '2022-10-26', 0x6e756c6c, 15, 79, 2383),
(20, '2022-10-26', 0x6e756c6c, 15, 80, 8.8),
(21, '2022-10-26', 0x6e756c6c, 15, 81, 11.32),
(22, '2022-10-26', 0x6e756c6c, 15, 83, 1511.32),
(23, '2022-10-26', 0x6e756c6c, 15, 84, 1507),
(24, '2022-10-26', 0x6e756c6c, 15, 85, 1531),
(25, '2022-10-27', 0x6e756c6c, 15, 86, 33.52),
(26, '2022-10-27', 0x6e756c6c, 15, 87, 57.52),
(27, '2022-10-27', 0x6e756c6c, 15, 88, 57.52),
(28, '2022-10-27', 0x6e756c6c, 15, 89, 36.04),
(29, '2022-10-27', 0x6e756c6c, 15, 93, 4123.6),
(30, '2022-10-28', 0x6e756c6c, 15, 94, 1747),
(31, '2022-10-28', 0x6e756c6c, 15, 96, 3487);

-- --------------------------------------------------------

--
-- Table structure for table `factureservice`
--

CREATE TABLE `factureservice` (
  `idFactureService` int(11) NOT NULL,
  `factureServicePDF` longblob NOT NULL,
  `dateFacture` date NOT NULL DEFAULT current_timestamp(),
  `idCommandeService` int(11) NOT NULL,
  `idDevisService` int(11) NOT NULL,
  `total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `factureservice`
--

INSERT INTO `factureservice` (`idFactureService`, `factureServicePDF`, `dateFacture`, `idCommandeService`, `idDevisService`, `total`) VALUES
(5, 0x6e756c6c, '2022-10-20', 6, 1, 80),
(6, 0x636f6d2e69746578747064662e746578742e446f63756d656e74403530613733633438, '2022-10-24', 67, 3, 70),
(7, 0x636f6d2e69746578747064662e746578742e446f63756d656e74403363646131303535, '2022-10-25', 67, 3, 181.2),
(8, 0x636f6d2e69746578747064662e746578742e446f63756d656e74403232663731333333, '2022-10-26', 76, 3, 422.8),
(9, 0x636f6d2e69746578747064662e746578742e446f63756d656e74403232663731333333, '2022-10-26', 76, 3, 422.8),
(10, 0x636f6d2e69746578747064662e746578742e446f63756d656e74403232663731333333, '2022-10-26', 76, 3, 422.8),
(11, 0x636f6d2e69746578747064662e746578742e446f63756d656e74403232663731333333, '2022-10-26', 76, 3, 422.8),
(12, 0x636f6d2e69746578747064662e746578742e446f63756d656e74406232306631, '2022-10-26', 78, 3, 60.4),
(13, 0x636f6d2e69746578747064662e746578742e446f63756d656e74403561333235303864, '2022-10-26', 79, 3, 120.8),
(14, 0x636f6d2e69746578747064662e746578742e446f63756d656e74403561613132636165, '2022-10-26', 83, 3, 724.8),
(15, 0x636f6d2e69746578747064662e746578742e446f63756d656e74403630653030336430, '2022-10-26', 86, 3, 120.8),
(16, 0x636f6d2e69746578747064662e746578742e446f63756d656e74403531386438653535, '2022-10-26', 87, 3, 181.2),
(17, 0x636f6d2e69746578747064662e746578742e446f63756d656e74403561613062386233, '2022-10-26', 88, 3, 150.6),
(18, 0x636f6d2e69746578747064662e746578742e446f63756d656e74403466616231666266, '2022-10-26', 89, 3, 120.8),
(19, 0x636f6d2e69746578747064662e746578742e446f63756d656e74403337386662663432, '2022-10-26', 91, 3, 60.4),
(20, 0x636f6d2e69746578747064662e746578742e446f63756d656e74403430303863656331, '2022-10-27', 92, 3, 150.6),
(21, 0x636f6d2e69746578747064662e746578742e446f63756d656e74403463373464653131, '2022-10-27', 94, 3, 241.6),
(22, 0x636f6d2e69746578747064662e746578742e446f63756d656e74403439313735656363, '2022-10-28', 99, 4, 207.6),
(23, 0x636f6d2e69746578747064662e746578742e446f63756d656e74403438343536653436, '2022-10-28', 100, 5, 136.5);

-- --------------------------------------------------------

--
-- Table structure for table `magasin`
--

CREATE TABLE `magasin` (
  `IdMagasin` int(11) NOT NULL,
  `nomMagasin` varchar(255) NOT NULL,
  `adresseMagasin` varchar(255) NOT NULL,
  `emailMagasin` varchar(255) NOT NULL,
  `telMagasin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `magasin`
--

INSERT INTO `magasin` (`IdMagasin`, `nomMagasin`, `adresseMagasin`, `emailMagasin`, `telMagasin`) VALUES
(1, 'carrefour', 'Tunis ', 'carrefour@gamil.com', 71000000),
(2, 'Monoprix', 'Tunis', 'monoprix@gmail.com', 12345678);

-- --------------------------------------------------------

--
-- Table structure for table `reclamation`
--

CREATE TABLE `reclamation` (
  `idReclamation` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `screenshot` varchar(255) NOT NULL,
  `numero_mobile` int(11) NOT NULL,
  `date_creation` date NOT NULL,
  `date_traitement` date NOT NULL,
  `description` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `nomServcie` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reclamation`
--

INSERT INTO `reclamation` (`idReclamation`, `nom`, `prenom`, `email`, `screenshot`, `numero_mobile`, `date_creation`, `date_traitement`, `description`, `status`, `nomServcie`) VALUES
(3, 'kais', 'kais', 'kais@esprit.tn', 'file:/C:/Users/chalg/OneDrive/Bureau/test%201.jpg', 45453454, '2022-01-14', '3899-02-01', 'azezezrzererarazrazeaze', 'Tariteé', 'Aide aux personnes âgées'),
(4, 'ahmed', 'ahmed', 'ahmed@esprit.tn', 'screenshoot', 54545454, '3922-12-14', '3899-02-01', 'aaaaaaaaaaaa', 'Non traiter', 'Bricolage'),
(5, 'aaaa', 'aaaaa', 'aaaaaaaa', 'file:/C:/Users/chalg/OneDrive/Bureau/test%201.jpg', 1111, '2022-01-14', '2022-01-24', 'aaaaaa', 'Non traiter', 'Jardinage');

-- --------------------------------------------------------

--
-- Table structure for table `reponse`
--

CREATE TABLE `reponse` (
  `idReponse` int(11) NOT NULL,
  `Text` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `idReclamation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reponse`
--

INSERT INTO `reponse` (`idReponse`, `Text`, `status`, `idReclamation`) VALUES
(1, 'ok', 'Tariteé', 3);

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `idService` int(11) NOT NULL,
  `nomService` varchar(255) NOT NULL,
  `nbreOuvrier` int(11) DEFAULT NULL,
  `prixService` float NOT NULL,
  `descriptionService` text DEFAULT NULL,
  `dateDebutService` date DEFAULT NULL,
  `dateFinService` date DEFAULT NULL,
  `disponibiliteService` varchar(255) DEFAULT NULL,
  `idCategorieService` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`idService`, `nomService`, `nbreOuvrier`, `prixService`, `descriptionService`, `dateDebutService`, `dateFinService`, `disponibiliteService`, `idCategorieService`) VALUES
(4, 'Jardinage', 4, 45.5, 'Le jardinage exige du temps, du matériel et de maîtriser des techniques précises. Confiez-nous vos espaces verts et bénéficiez du savoir-faire Ramcha ! ', '2022-10-27', '2022-10-29', 'Disponnible', 1),
(5, 'Bricolage', 8, 39.5, 'Faites appel aux professionnels ramcha ! Aymen et  Achref  sont formés', '2022-11-02', '2022-11-16', 'Disponible', 1),
(6, 'Garde d\'enfants', 7, 69.2, 'C’est choisir pour vos enfants une méthode exclusive basée sur trois piliers : cultiver les liens intergénérationnels, cuisiner et partager, développer ses talents.', '2022-08-03', '2022-08-17', 'Non disponible ', 3),
(7, 'Aide aux personnes âgées', 2, 87.21, 'L’aide aux personnes âgées. Vous souhaitez rester vivre chez vous', '2022-11-03', '2022-10-09', 'Disponible', 1),
(9, 'eya', 5, 45, 'hhfhfh', '2022-11-12', '2022-11-29', 'Disponible', 3);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idUser` int(11) NOT NULL,
  `nomUser` varchar(255) NOT NULL,
  `prenomUser` varchar(255) NOT NULL,
  `adressUser` varchar(255) NOT NULL,
  `passwUser` varchar(255) NOT NULL,
  `numUser` varchar(255) NOT NULL,
  `ddnUser` date NOT NULL,
  `codePostalUser` int(11) NOT NULL,
  `cinUser` varchar(255) NOT NULL,
  `loginUser` varchar(255) NOT NULL,
  `libelleDemande` varchar(255) DEFAULT NULL,
  `dispoP` varchar(255) DEFAULT NULL,
  `experP` varchar(255) DEFAULT NULL,
  `diplomeP` varchar(255) DEFAULT NULL,
  `posteP` varchar(255) DEFAULT NULL,
  `salaireP` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT 'user',
  `image` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`idUser`, `nomUser`, `prenomUser`, `adressUser`, `passwUser`, `numUser`, `ddnUser`, `codePostalUser`, `cinUser`, `loginUser`, `libelleDemande`, `dispoP`, `experP`, `diplomeP`, `posteP`, `salaireP`, `role`, `image`) VALUES
(5, 'achref', 'zitoun', 'ben arous', '$2y$13$yT15IXu2o/T2VlaK8ruR/.uJ0o1yf6JKhNMaJ54UruMSiZn5HV.ry', '26977557', '1999-11-03', 2015, '07240679', 'ok@g.comm', NULL, NULL, NULL, NULL, NULL, NULL, 'admin', 'https://scontent.ftun16-1.fna.fbcdn.net/v/t39.30808-1/296001081_3444823325786931_3989494459895213201_n.jpg?stp=c0.0.240.240a_cp6_dst-jpg_p240x240&_nc_cat=110&ccb=1-7&_nc_sid=7206a8&_nc_ohc=ZIsrXo6_GKQAX82V5Ef&_nc_ht=scontent.ftun16-1.fna&oh=00_AfASmVZU9Ewe4AuvC-L_S1V0SBs_uq9FON4fpMP4K8320Q&oe=6360CE41'),
(7, 'shaima', 'hadjkacem', 'Mourouj', '$2y$13$qFAzJRp5tT6PJz88k/h5netfP17HDhGF.jBoDZqzEXPeKv/iJPEv2', '20542959', '2002-10-29', 1111, '12345678', 'chaima.hadjkacem@esprit.tn', NULL, NULL, NULL, NULL, NULL, NULL, 'user', ''),
(8, 'ghofrane', 'bens', 'hamemlif', '$2y$13$1JthKau3w59z2T.aaclgv.6VU/62gkGCG/H6sOVEgpkDUcNugr4eC', '65543265', '2010-10-15', 2154, '98765432', 'bensoltane.ghofrane@esprit.tn', 'produit', NULL, NULL, NULL, NULL, NULL, 'demandeur', ''),
(9, 'nour', 'salma', 'nabeul', '$2y$13$xxIub7ZrlXQdu8oivWYQ/Og9JO9.zn/gOUmIBDlhRrBPbDx8G74wO', '98874646', '2004-10-14', 9665, '36985', 'salma@gmail.com', NULL, 'Disponible', '2 ans ', 'technicien', 'responsable', '600', 'prestateur', ''),
(10, 'achref', 'zitoun', 'ben arous', '$2y$13$sfzONWmDFBYwYMsInGboneFyJwk28Nz7dH9hTCAMpdrU4mhFLauia', '26977557', '2001-11-06', 2013, '07240679', 'ok@g.com', NULL, NULL, NULL, NULL, NULL, NULL, 'user', ''),
(11, 'rym', 'rym', 'klibia', '$2y$13$8MbvILUFXoQvrpLVsW9q9exEenD7i42j./S1ajYiHkPitZzOhtbwW', '20253658', '2000-09-28', 9876, '98765432', 'rym@g.com', NULL, NULL, NULL, NULL, NULL, NULL, 'user', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`idArticle`);

--
-- Indexes for table `avis`
--
ALTER TABLE `avis`
  ADD PRIMARY KEY (`idAvis`);

--
-- Indexes for table `aviscours`
--
ALTER TABLE `aviscours`
  ADD PRIMARY KEY (`IdAvisCours`);

--
-- Indexes for table `categoriearticle`
--
ALTER TABLE `categoriearticle`
  ADD PRIMARY KEY (`idCategorie`);

--
-- Indexes for table `categorieservice`
--
ALTER TABLE `categorieservice`
  ADD PRIMARY KEY (`idCategorieService`);

--
-- Indexes for table `chapitre`
--
ALTER TABLE `chapitre`
  ADD PRIMARY KEY (`IdChapitre`);

--
-- Indexes for table `commandearticle`
--
ALTER TABLE `commandearticle`
  ADD PRIMARY KEY (`idCommande`);

--
-- Indexes for table `commandearticle_article_utilisateur`
--
ALTER TABLE `commandearticle_article_utilisateur`
  ADD PRIMARY KEY (`idCommande`,`idArticle`,`idUtilisateur`),
  ADD KEY `commandearticle_article_utilisateur_ibfk_3` (`idUtilisateur`),
  ADD KEY `commandearticle_article_utilisateur_ibfk_4` (`idArticle`),
  ADD KEY `commandearticle_article_utilisateur_ibfk_2` (`idCommande`);

--
-- Indexes for table `commandeservice`
--
ALTER TABLE `commandeservice`
  ADD PRIMARY KEY (`idCommandeService`);

--
-- Indexes for table `commandeservice_service_utilisateur`
--
ALTER TABLE `commandeservice_service_utilisateur`
  ADD PRIMARY KEY (`idService`,`idUtilisateur`,`idCommandeService`),
  ADD KEY `commandeservice_service_utilisateur_ibfk_3` (`idUtilisateur`),
  ADD KEY `idService` (`idService`),
  ADD KEY `idCommandeService` (`idCommandeService`);

--
-- Indexes for table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`IdCours`);

--
-- Indexes for table `cours_chapitre`
--
ALTER TABLE `cours_chapitre`
  ADD PRIMARY KEY (`IdCours`,`IdChapitre`),
  ADD KEY `IdChapitre` (`IdChapitre`);

--
-- Indexes for table `devis`
--
ALTER TABLE `devis`
  ADD PRIMARY KEY (`idDevis`);

--
-- Indexes for table `devisservice`
--
ALTER TABLE `devisservice`
  ADD PRIMARY KEY (`idDevisService`);

--
-- Indexes for table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`idFacture`);

--
-- Indexes for table `factureservice`
--
ALTER TABLE `factureservice`
  ADD PRIMARY KEY (`idFactureService`);

--
-- Indexes for table `magasin`
--
ALTER TABLE `magasin`
  ADD PRIMARY KEY (`IdMagasin`);

--
-- Indexes for table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`idReclamation`);

--
-- Indexes for table `reponse`
--
ALTER TABLE `reponse`
  ADD PRIMARY KEY (`idReponse`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`idService`),
  ADD KEY `3zedr3tyhuj` (`idCategorieService`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `article`
--
ALTER TABLE `article`
  MODIFY `idArticle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT for table `avis`
--
ALTER TABLE `avis`
  MODIFY `idAvis` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `aviscours`
--
ALTER TABLE `aviscours`
  MODIFY `IdAvisCours` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `categoriearticle`
--
ALTER TABLE `categoriearticle`
  MODIFY `idCategorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `categorieservice`
--
ALTER TABLE `categorieservice`
  MODIFY `idCategorieService` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `chapitre`
--
ALTER TABLE `chapitre`
  MODIFY `IdChapitre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `commandearticle`
--
ALTER TABLE `commandearticle`
  MODIFY `idCommande` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=97;

--
-- AUTO_INCREMENT for table `commandeservice`
--
ALTER TABLE `commandeservice`
  MODIFY `idCommandeService` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT for table `cours`
--
ALTER TABLE `cours`
  MODIFY `IdCours` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `devis`
--
ALTER TABLE `devis`
  MODIFY `idDevis` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `devisservice`
--
ALTER TABLE `devisservice`
  MODIFY `idDevisService` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `facture`
--
ALTER TABLE `facture`
  MODIFY `idFacture` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `factureservice`
--
ALTER TABLE `factureservice`
  MODIFY `idFactureService` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `magasin`
--
ALTER TABLE `magasin`
  MODIFY `IdMagasin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `idReclamation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `reponse`
--
ALTER TABLE `reponse`
  MODIFY `idReponse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `idService` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `commandearticle_article_utilisateur`
--
ALTER TABLE `commandearticle_article_utilisateur`
  ADD CONSTRAINT `commandearticle_article_utilisateur_ibfk_2` FOREIGN KEY (`idCommande`) REFERENCES `commandearticle` (`idCommande`) ON UPDATE CASCADE,
  ADD CONSTRAINT `commandearticle_article_utilisateur_ibfk_3` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `commandearticle_article_utilisateur_ibfk_4` FOREIGN KEY (`idArticle`) REFERENCES `article` (`idArticle`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `commandeservice_service_utilisateur`
--
ALTER TABLE `commandeservice_service_utilisateur`
  ADD CONSTRAINT `commandeservice_service_utilisateur_ibfk_3` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `commandeservice_service_utilisateur_ibfk_4` FOREIGN KEY (`idCommandeService`) REFERENCES `commandeservice` (`idCommandeService`),
  ADD CONSTRAINT `commandeservice_service_utilisateur_ibfk_5` FOREIGN KEY (`idService`) REFERENCES `service` (`idService`);

--
-- Constraints for table `cours_chapitre`
--
ALTER TABLE `cours_chapitre`
  ADD CONSTRAINT `cours_chapitre_ibfk_1` FOREIGN KEY (`IdChapitre`) REFERENCES `chapitre` (`IdChapitre`),
  ADD CONSTRAINT `cours_chapitre_ibfk_2` FOREIGN KEY (`IdCours`) REFERENCES `cours` (`IdCours`);

--
-- Constraints for table `service`
--
ALTER TABLE `service`
  ADD CONSTRAINT `3zedr3tyhuj` FOREIGN KEY (`idCategorieService`) REFERENCES `categorieservice` (`idCategorieService`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
