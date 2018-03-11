CREATE TABLE adm
(
  gh   CHAR(8)     NOT NULL
    PRIMARY KEY,
  xm   VARCHAR(10) NULL,
  xb   CHAR(2)     NULL,
  csrq CHAR(10)    NULL,
  mima VARCHAR(12) NULL
)
  ENGINE = InnoDB;

CREATE TABLE crs
(
  kh CHAR(8)         NOT NULL
    PRIMARY KEY,
  km VARCHAR(16)     NULL,
  xf INT DEFAULT '4' NULL
)
  ENGINE = InnoDB;

CREATE TABLE elc
(
  xh CHAR(8)  NOT NULL,
  xq CHAR(14) NOT NULL,
  kh CHAR(8)  NOT NULL,
  gh CHAR(8)  NOT NULL,
  cj INT      NULL,
  PRIMARY KEY (xh, xq, kh, gh),
  CONSTRAINT elc_ibfk_2
  FOREIGN KEY (kh) REFERENCES crs (kh)
)
  ENGINE = InnoDB;

CREATE INDEX kh
  ON elc (kh);

CREATE INDEX gh
  ON elc (gh);

CREATE TABLE msg
(
  id      INT AUTO_INCREMENT
    PRIMARY KEY,
  sendId  INT          NOT NULL,
  recevId INT          NOT NULL,
  tittle  VARCHAR(128) NULL,
  content VARCHAR(512) NULL,
  date    DATETIME     NULL,
  CONSTRAINT msg_id_uindex
  UNIQUE (id)
)
  ENGINE = InnoDB;

CREATE TABLE opn
(
  xq   CHAR(14)    NOT NULL,
  kh   CHAR(8)     NOT NULL,
  gh   CHAR(8)     NOT NULL,
  sksj VARCHAR(11) NULL,
  PRIMARY KEY (xq, kh, gh),
  CONSTRAINT opn_ibfk_1
  FOREIGN KEY (kh) REFERENCES crs (kh)
)
  ENGINE = InnoDB;

CREATE INDEX kh
  ON opn (kh);

CREATE INDEX gh
  ON opn (gh);

CREATE TABLE stu
(
  xh   CHAR(8)     NOT NULL
    PRIMARY KEY,
  xm   VARCHAR(10) NOT NULL,
  xb   CHAR(2)     NULL,
  csrq CHAR(10)    NULL,
  jg   VARCHAR(6)  NULL,
  mima VARCHAR(12) NULL
)
  ENGINE = InnoDB;

ALTER TABLE elc
  ADD CONSTRAINT elc_ibfk_3
FOREIGN KEY (xh) REFERENCES stu (xh);

CREATE TABLE tch
(
  gh   CHAR(8)     NOT NULL
    PRIMARY KEY,
  xm   VARCHAR(10) NULL,
  xb   CHAR(2)     NULL,
  csrq CHAR(10)    NULL,
  mima VARCHAR(12) NULL
)
  ENGINE = InnoDB;

ALTER TABLE elc
  ADD CONSTRAINT elc_ibfk_1
FOREIGN KEY (gh) REFERENCES tch (gh);

ALTER TABLE opn
  ADD CONSTRAINT opn_ibfk_2
FOREIGN KEY (gh) REFERENCES tch (gh);

