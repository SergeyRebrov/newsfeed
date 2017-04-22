DROP TABLE IF EXISTS news;

CREATE TABLE `news` (
  `id`               INT          NOT NULL         AUTO_INCREMENT,
  `heading`          VARCHAR(255) NOT NULL,
  `publication_date` TIMESTAMP    NOT NULL         DEFAULT CURRENT_TIMESTAMP,
  `news_body`        TEXT         NOT NULL,
  `image_url`              TEXT         NOT NULL,
  PRIMARY KEY (`id`)
);