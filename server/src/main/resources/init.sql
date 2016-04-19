--
-- Structure de la table `Agency`
--

CREATE TABLE `Agency` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Agency`
--

INSERT INTO `Agency` (`id`, `name`) VALUES
(1, 'Apside TOP'),
(2, 'Apside Bordeaux');

-- --------------------------------------------------------

--
-- Structure de la table `Person`
--

CREATE TABLE `Person` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `agency_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Person`
--

INSERT INTO `Person` (`id`, `email`, `firstName`, `lastName`, `agency_id`) VALUES
(1, 'john.doe@apside.fr', 'John', 'Doe', 1),
(2, 'jane.doe@apside.fr', 'Jane', 'Doe', 2),
(3, 'jollivet@apside.fr', 'Christophe', 'Jollivet', 1),
(4, 'debonnaire@apside.fr', 'Mickael', 'Debonnaire', 1),
(5, 'DELETE_ME@apside.fr', 'DELETE_ME', 'DELETE_ME', 1);

-- --------------------------------------------------------

--
-- Structure de la table `Session`
--

CREATE TABLE `Session` (
  `id` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `training_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Session`
--

INSERT INTO `Session` (`id`, `date`, `location`, `training_id`) VALUES
(1, '2016-03-14 23:02:44', 'Tours', 1),
(2, '2016-03-14 23:02:44', 'Rennes', 1);

-- --------------------------------------------------------

--
-- Structure de la table `Session_Attendee`
--

CREATE TABLE `Session_Attendee` (
  `Session_ID` bigint(20) NOT NULL,
  `Attendee_ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Session_Attendee`
--

INSERT INTO `Session_Attendee` (`Session_ID`, `Attendee_ID`) VALUES
(1, 3),
(2, 4);

-- --------------------------------------------------------

--
-- Structure de la table `Session_Coach`
--

CREATE TABLE `Session_Coach` (
  `Session_ID` bigint(20) NOT NULL,
  `Coach_ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Session_Coach`
--

INSERT INTO `Session_Coach` (`Session_ID`, `Coach_ID`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `Training`
--

CREATE TABLE `Training` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `repositoryUrl` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Training`
--

INSERT INTO `Training` (`id`, `description`, `level`, `name`, `repositoryUrl`) VALUES
(1, '3 days training to AngularJS', 'BEGINNER', 'Angular JS', 'http://repo.apside.fr/angularjs'),
(2, '5 days basic training to Java for beginner', 'BEGINNER', 'Java', 'http://repo.apside.fr/javaBeginner'),
(3, '1 day training about unit Test in Java', 'INTERMEDIATE', 'Unit Test', 'http://repo.apside.fr/unitTest');

-- --------------------------------------------------------

--
-- Structure de la table `Training_Agency`
--

CREATE TABLE `Training_Agency` (
  `Agency_ID` bigint(20) NOT NULL,
  `Training_ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Training_Agency`
--

INSERT INTO `Training_Agency` (`Agency_ID`, `Training_ID`) VALUES
(1, 1),
(1, 2),
(2, 3);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Agency`
--
ALTER TABLE `Agency`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `Person`
--
ALTER TABLE `Person`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_205nvp1suv5bl2m1vb6vvked0` (`agency_id`);

--
-- Index pour la table `Session`
--
ALTER TABLE `Session`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_dh8bdsns8asceqlkpovae890u` (`training_id`);

--
-- Index pour la table `Session_Attendee`
--
ALTER TABLE `Session_Attendee`
  ADD KEY `FK_qmwa8b66rgxm4w27klrok88h8` (`Attendee_ID`),
  ADD KEY `FK_2ha5u4hrjiygyokqggy0sxlkq` (`Session_ID`);

--
-- Index pour la table `Session_Coach`
--
ALTER TABLE `Session_Coach`
  ADD PRIMARY KEY (`Session_ID`,`Coach_ID`),
  ADD KEY `FK_g0sf9tche2dj6ekqd4q1p24xy` (`Coach_ID`);

--
-- Index pour la table `Training`
--
ALTER TABLE `Training`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `Training_Agency`
--
ALTER TABLE `Training_Agency`
  ADD KEY `FK_9a14hitxvhsxp1rl89brbyt51` (`Training_ID`),
  ADD KEY `FK_snxlxynaw736p6j2wcrwttr5p` (`Agency_ID`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Agency`
--
ALTER TABLE `Agency`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Person`
--
ALTER TABLE `Person`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `Session`
--
ALTER TABLE `Session`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `Training`
--
ALTER TABLE `Training`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Person`
--
ALTER TABLE `Person`
  ADD CONSTRAINT `FK_205nvp1suv5bl2m1vb6vvked0` FOREIGN KEY (`agency_id`) REFERENCES `Agency` (`id`);

--
-- Contraintes pour la table `Session`
--
ALTER TABLE `Session`
  ADD CONSTRAINT `FK_dh8bdsns8asceqlkpovae890u` FOREIGN KEY (`training_id`) REFERENCES `Training` (`id`);

--
-- Contraintes pour la table `Session_Attendee`
--
ALTER TABLE `Session_Attendee`
  ADD CONSTRAINT `FK_2ha5u4hrjiygyokqggy0sxlkq` FOREIGN KEY (`Session_ID`) REFERENCES `Session` (`id`),
  ADD CONSTRAINT `FK_qmwa8b66rgxm4w27klrok88h8` FOREIGN KEY (`Attendee_ID`) REFERENCES `Person` (`id`);

--
-- Contraintes pour la table `Session_Coach`
--
ALTER TABLE `Session_Coach`
  ADD CONSTRAINT `FK_3li2ngvxo4m3olummphl7nrkh` FOREIGN KEY (`Session_ID`) REFERENCES `Session` (`id`),
  ADD CONSTRAINT `FK_g0sf9tche2dj6ekqd4q1p24xy` FOREIGN KEY (`Coach_ID`) REFERENCES `Person` (`id`);

--
-- Contraintes pour la table `Training_Agency`
--
ALTER TABLE `Training_Agency`
  ADD CONSTRAINT `FK_snxlxynaw736p6j2wcrwttr5p` FOREIGN KEY (`Agency_ID`) REFERENCES `Agency` (`id`),
  ADD CONSTRAINT `FK_9a14hitxvhsxp1rl89brbyt51` FOREIGN KEY (`Training_ID`) REFERENCES `Training` (`id`);
