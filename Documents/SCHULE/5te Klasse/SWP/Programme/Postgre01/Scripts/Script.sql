drop database if exists dbp_bestellung01;
create database dbp_bestellung01;

CREATE TABLE Kunde (
Kunden_ID SERIAL not null,
TitelV varchar,
Vorname varchar,
Nachname varchar not null,
TitelN varchar,

primary key(Kunden_ID)
); 

CREATE TABLE Adresse (
Adresse_ID SERIAL not null,
Stadt varchar not null,
Strasse varchar not null,
PLZ integer not null,
HausNr varchar,

primary key(Adresse_ID)
);


CREATE TABLE Artikel (
artikel_ID integer not null,
Name varchar,
Preis float not null,

primary key(artikel_ID)
);


CREATE TABLE Bestellung (
Bestellung_ID SERIAL not null,
Kunde_ID integer not null,
Adresse_Rechnung_ID integer not null,
Adresse_Liefer_ID integer not null,

primary key(Bestellung_ID),

FOREIGN KEY (Kunde_ID) REFERENCES Kunde(Kunden_ID),
FOREIGN KEY (Adresse_Rechnung_ID) REFERENCES Adresse(Adresse_ID),
FOREIGN KEY (Adresse_Liefer_ID) REFERENCES Adresse(Adresse_ID)
);

CREATE TABLE Bestellung_Artikel (
Bestellung_ID int null,
Artikel_ID integer not null,
Menge integer not null,

FOREIGN KEY (Bestellung_ID) REFERENCES Bestellung(Bestellung_ID),
FOREIGN KEY (Artikel_ID) REFERENCES Artikel(artikel_ID)
);

