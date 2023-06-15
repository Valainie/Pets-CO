create table if not exists Acquisto
(
    usernameCliente     varchar(500)  null,
    codiceAcquisto      int           not null
        primary key,
    indirizzoSpedizione varchar(500)  null,
    dataOrdine          date          null,
    dataSpedizione      date          null,
    importo             float(5, 2)   null,
    statoProdotti       varchar(1000) null,
    metodo              bigint        null
);

create table if not exists Admin
(
    Recapito varchar(20)  not null,
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
    Telefono int          null,
    Email    varchar(255) not null,
    Dettagli varchar(255) null,
    constraint Email
        unique (Email),
    constraint Username
        unique (Username)
);

create table if not exists Effettua
(
    username       varchar(16) null,
    codiceAcquisto int         null,
    constraint Effettua_ibfk_1
        foreign key (username) references Cliente (Username)
            on update cascade on delete cascade,
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
    codiceIndirizzo int         not null
        primary key,
    citta           varchar(20) null,
    via             varchar(30) null,
    civico          int         null,
    cap             int         null
);

create table if not exists Metodo_di_Pagamento
(
    circuito char(20)   null,
    numCarta bigint     not null
        primary key,
    cvv      int        null,
    scadenza varchar(7) null
);

create table if not exists Prodotto
(
    Codice           int           not null,
    Categoria        int           not null,
    Immagine         varchar(100)  null,
    Nome             varchar(100)  null,
    Disponibilita    int           null,
    prezzo           float(5, 2)   null,
    DescrizioneBreve varchar(1000) null,
    DescrizioneLunga varchar(1000) null,
    novita           tinyint(1)    null,
    offerta          tinyint(1)    null,
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


