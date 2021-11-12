USE AMVDB;
INSERT INTO USER(
    Fname,
    Lname,
    Phone,
    Username,
    Password,
    IsActive
)

values (
   'Marius',
   'Sørensen',
   '90807060',
   'Sorma',
   SHA2('MaSø123', 256),
   TRUE
),
(
   'Runa',
   'Jensen',
   '90708060',
   'Jenru',
   SHA2('RuJe123', 256),
   TRUE
),
(
   'Said',
   'Yasaev',
   '80405060',
   'Yassa',
   SHA2('SaYa123', 256),
   TRUE
),
(
   'Wares',
   'Amiry',
   '90302050',
   'Amiwa',
   SHA2('WaAm123', 256),
   TRUE
),
(
   'Bjørnar',
   'Somme',
   '90506070',
   'Sombj',
   SHA2('BjSo123', 256),
   TRUE
),
(
   'Vilde',
   'Elvemo',
   '9203040',
   'Elvvi',
   SHA2('ViEl123', 256),
   TRUE
),


(
   'Martin',
   'Barken',
   '91718060',
   'Barma',
   SHA2('MaBa123', 256),
   TRUE
),
(
   'Hilde',
   'Elveblest',
   '91718262',
   'Elvhi',
   SHA2('HiEl123', 256),
   TRUE
),
(
   'Hedvig',
   'Ugla',
   '92728262',
   'Uglhe',
   SHA2('HeUg123', 256),
   TRUE
),
(
   'Thomas',
   'Torget',
   '92728363',
   'Torth',
   SHA2('ThTo123', 256),
   TRUE
),
(
   'Jon',
   'Snø',
   '93728567',
   'Snøjo',
   SHA2('JoSn123', 256),
   TRUE
);


insert into TOOL(
    Tool_Name,
    Tool_Info,
    Price,
    IsActive
)

values (
           'Skruautomat',
           NULL,
           '20',
           TRUE
       ),
       (
           'Fein Multimaskin',
           NULL,
           '20',
           TRUE
       ),
       (
           'Eksentersliper 230VAC',
           '+ papir',
           '20',
           TRUE
       ),
       (
           'Båndsliper 230VAC',
           '+ papir',
           '20',
           TRUE
       ),
       (
           'Høvel 230VAC',
           NULL,
           '20',
           TRUE
       ),
       (
           'Gjære-/kombisag 230VAC',
           NULL,
           '20',
           TRUE
       ),
       (
           '9’ vinkelsliper for stein og betong',
           NULL,
           '20',
           TRUE
       ),
       (
           'Meislemaskin, 230VAC',
           NULL,
           '20',
           TRUE
       ),
       (
           'Slagdrill, Batteri, Milwaukee',
           NULL,
           '20',
           TRUE
       ),
       (
           'Kantklipper - bensin',
           'Bruker oljeblandet bensin. Bruk kun ferdigblandet 2-takt alkylatbensin (2%)
       Dette er oljeblandet spesialbensinen med lang holdbarhet som kan kjøpes på bl.a. Felleskjøpet, Biltema og Jula.',
           '20',
           TRUE
       ),
       (
           'Kompressor, 230VAC',
           'Maks. trykk: 10 bar
       Avgitt luftmengde: 255 l/min
       Effekt: 1,5 kW.',
           '20',
           TRUE
       ),
       (
           'Diagnoseverktøy, bil',
           NULL,
           '50',
           TRUE
       ),
       (
           'Vibratorplate «Hoppetusse», bensin',
           'Vekt: 86 kg
       Bruker ren bensin minimum oktantall 95.
       Motoroljenivå sjekkes før og etter bruk. Oljetype: Shell Ultra Ect 5W-30 (AMV nr. 0095-0069)',
           '50',
           TRUE
       ),
       (
           'Flisekutter for keramiske fliser',
           NULL,
           '20',
           TRUE
       ),
       (
           'Skruautomat',
           '+ skruer',
           '20',
           TRUE
       ),
       (
           'Motorisert trillebår',
           NULL,
           '50',
           TRUE
       ),
       (
           'Spikerpistol, stor (trykkluft)',
           NULL,
           '20',
           TRUE
       ),
       (
           'Spikerpistol, liten (trykkluft)',
           NULL,
           '20',
           TRUE
       ),
       (
           'Spikerpistol, stor (Milwaukee)',
           NULL,
           '20',
           TRUE
       ),
       (
           'Spikerpistol, mellom (Milwaukee)',
           NULL,
           '20',
           TRUE
       ),
       (
           'Spikerpistol, liten (Milwaukee)',
           NULL,
           '20',
           TRUE
       ),
       (
           'Vedkløyver, Bensindrevet',
           NULL,
           '50',
           TRUE
       ),
       (
           'Fliskutter for trevirke',
           NULL,
           '50',
           TRUE
       ),
       (
           'Tilhenger, boggi; RD 5702',
           'Kassemål LxBxH: 297x153x29cm
       Nyttelast max. 1150kg',
           '50',
           TRUE
       ),
       (
           'Tilhenger, liten, RC 8834',
           'Kassemål LxBxH: 197x153x29cm
       Nyttelast max. 645kg',
           '50',
           TRUE
       ),
       (
           'Tilhenger, skap, JP2591',
           'Kassemål LxBxH: 292x154x194cm
       (Dørkarm BxH: 146x190cm)
       Nyttelast: 1090 kg',
           '50',
           TRUE
       ),
       (
           'Personløfter, arb.høyde 12m.',
           'SWL 200 kg, 230 VAC',
           '100',
           TRUE
       ),
       (
           'Strømaggregat, 3.7 kW (Diesel)',
           'Bruker avgiftsfri diesel.
       Motoroljenivå sjekkes før og etter bruk. Oljetype: Shell Ultra Ect 5W-30 (AMV nr. 0095-0069)',
           '50',
           TRUE
       ),
       (
           'Bluetooth høyttaler - SOUNDBOKS',
           NULL,
           '20',
           TRUE
       ),
       (
           'Leica snekkerlaser',
           NULL,
           '20',
           TRUE
       ),
       (
           'Leirduekaster',
           NULL,
           '20',
           TRUE
       );


INSERT INTO BOOKING(
    StartDate, EndDate, Cmnt, IsDelivered, TotalPrice, USER_ID, TOOL_ID
)

values (
           '2021-10-02',
           '2021-10-04',
           'Knekt del',
           true,
           '50',
           '1',
           '14'
       ),
       (
           '2021-10-24',
           '2021-10-26',
           '',
           false,
           '50',
           '2',
           '10'
       ),
       (
           '2021-09-15',
           '2021-09-17',
           'Ødelagt spak',
           true,
           '100',
           '3',
           '11'
       ),
       (
           '2021-10-24',
           '2021-10-26',
           '',
           false,
           '20',
           '4',
           '9'
       ),
       (
           '2021-08-12',
           '2021-08-13',
           '',
           true,
           '50',
           '5',
           '24'
       ),
       (
           '2021-10-01',
           '2021-10-02',
           '',
           true,
           '0',
           '2',
           '15'
       ),
       (
           '2021-10-25',
           '2021-10-27',
           '',
           false,
           '20',
           '1',
           '5'
       ),
       (
           '2021-05-10',
           '2021-05-12',
           'Bensinlokk ødelagt',
           true,
           '20',
           '8',
           '2'
       ),
       (
           '2021-09-01',
           '2021-09-03',
           '',
           true,
           '100',
           '3',
           '26'
       ),
       (
           '2021-02-08',
           '2021-02-10',
           '',
           true,
           '20',
           '10',
           '3'
       ),
       (
           '2021-10-23',
           '2021-10-27',
           '',
           false,
           '60',
           '2',
           '1'
       );

INSERT INTO COURSE(Course_Title)

VALUES ('Personløftersertifikat');

insert into ROLE (Rolename)
values ('user'), ('administrator'), ('union-member');

insert into USER_ROLE (Username, Rolename)
values (
           'Sorma',
           'user'
       ),
       (
           'Sorma',
           'administrator'
       ),
       (
           'Jenru',
           'user'
       ),
       (
           'Jenru',
           'administrator'
       ),
       (
           'Yassa',
           'user'
       ),
       (
           'Yassa',
           'administrator'
       ),
       (
           'Amiwa',
           'user'
       ),
       (
           'Amiwa',
           'administrator'
       ),
       (
           'Sombj',
           'user'
       ),
       (
           'Sombj',
           'administrator'
       ),
       (
           'Elvvi',
           'user'
       ),
       (
           'Elvvi',
           'administrator'
       ),
       (
           'Barma',
           'user'
       ),
       (
           'Elvhi',
           'user'
       ),
       (
           'Uglhe',
           'user'
       ),
       (
           'Torth',
           'user'
       ),
       (
           'Snøjo',
           'user'
       );