drop schema if exists PetsECo;
create schema PetsECo;
use PetsECo;

create table if not exists Acquisto
(
    codiceAcquisto      int           not null
        primary key,
    indirizzoSpedizione varchar(500)  not null,
    dataOrdine          date          not null,
    dataSpedizione      date          not null,
    importo             float(5, 2)   not null,
    statoProdotti       varchar(1000) not null,
    metodo              bigint        not null
);
create table if not exists Effettua
(
    Cliente     varchar(500)  not null,
    codiceAcquisto      int           not null,
    foreign key (Cliente) references Cliente (Username),
    foreign key (codiceAcquisto) references Acquisto (codiceAcquisto)
);

create table if not exists Admin
(
    Recapito varchar(50)  not null,
    Username varchar(255) not null
        primary key,
    Password varchar(255) not null,
    Nome     varchar(255) not null,
    Cognome  varchar(255) not null,
    constraint Username
        unique (Username)
);

create table if not exists Cliente
(
    Cf       varchar(255) not null,
    Username varchar(255) not null
        primary key,
    Password varchar(255) not null,
    Nome     varchar(255) not null,
    Cognome  varchar(255) not null,
    Telefono varchar(16)  not null,
    Email    varchar(255) ,
    constraint Email
        unique (Email)
);

create table if not exists Effettua
(
    username       varchar(16) not null,
    codiceAcquisto int         not null,
    constraint Effettua_ibfk_1
        foreign key (username) references Cliente (Username)
            on update cascade,
    constraint Effettua_ibfk_2
        foreign key (codiceAcquisto) references Acquisto (codiceAcquisto)
            on update cascade on delete cascade
);

create index codiceAcquisto
    on Effettua (codiceAcquisto);

create index username
    on Effettua (username);

create table if not exists Indirizzo
(
    codiceIndirizzo int
        primary key,
    citta           varchar(20) ,
    via             varchar(30),
    civico          int        ,
    cap             int        ,
    usernameCliente varchar(255),
    constraint Indirizzo_ibfk_1
        foreign key (usernameCliente) references Cliente (Username)
);

create table if not exists Metodo_di_Pagamento
(
    circuito char(20)   not null,
    numCarta bigint     not null
        primary key,
    cvv      int        not null,
    scadenza varchar(7) not null,
    User varchar(255)

);
create table if not exists Possiede
(
    numCarta bigint,
    User varchar(255),
        constraint Possiede_1
        foreign key (User) references Cliente (Username),
        constraint Possiede_2
        foreign key (numCarta)references Metodo_di_Pagamento(numCarta)

);

create table if not exists Prodotto
(
    Codice           int           not null,
    Categoria        varchar(30)   not null,
    Immagine         varchar(1000)  not null,
    Nome             varchar(100)  not null,
    Disponibilita    int           not null,
    prezzo           float(5, 2)   not null,
    DescrizioneBreve varchar(1000) not null,
    DescrizioneLunga longtext not null,
    novita           tinyint(1)    not null,
    offerta          tinyint(1)    not null,
    primary key (Codice, Categoria)
);

create table if not exists Gestione
(
    Useradmin      varchar(255) not null,
    CodiceProdotto int          not null,
    primary key (Useradmin, CodiceProdotto),
    constraint Gestione_ibfk_1
        foreign key (Useradmin) references Admin (Username),
    constraint Gestione_ibfk_2
        foreign key (CodiceProdotto) references Prodotto (Codice)
);

create index CodiceProdotto
    on Gestione (CodiceProdotto);

create table if not exists Preferiti
(
    Username       varchar(255) not null,
    CodiceProdotto int          not null,
    primary key (Username, CodiceProdotto),
    constraint Preferiti_ibfk_1
        foreign key (Username) references Cliente (Username),
    constraint Preferiti_ibfk_2
        foreign key (CodiceProdotto) references Prodotto (Codice)
);

create index CodiceProdotto
    on Preferiti (CodiceProdotto);

create fulltext index Nome
    on Prodotto (Nome, DescrizioneBreve);

create table if not exists Recensione
(
    Commenti       varchar(255) not null,
    Zampette       int          not null,
    username       varchar(255) not null,
    CodiceProdotto int          not null,
    primary key (username, CodiceProdotto),
    constraint Recensione_ibfk_1
        foreign key (username) references Cliente (Username),
    constraint Recensione_ibfk_2
        foreign key (CodiceProdotto) references Prodotto (Codice),
    check ((`Zampette` >= 0) and (`Zampette` <= 5))
);

create index CodiceProdotto
    on Recensione (CodiceProdotto);

create table if not exists Tag
(
    Nome varchar(255) not null
        primary key
);

create table if not exists Navigazione
(
    Tag            varchar(255) not null,
    CodiceProdotto int          not null,
    primary key (Tag, CodiceProdotto),
    constraint Navigazione_ibfk_1
        foreign key (CodiceProdotto) references Prodotto (Codice),
    constraint Navigazione_ibfk_2
        foreign key (Tag) references Tag (Nome)
);

create index CodiceProdotto
    on Navigazione (CodiceProdotto);


