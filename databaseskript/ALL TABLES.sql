INSERT INTO USER(
    Fname,
    Lname,
    Phone,
    Username,
    Password
)

values (
           'Marius',
           'Sørensen',
           '90807060',
           'Sorma',
           'MaSø123'
       ),
       (
           'Runa',
           'Jensen',
           '90708060',
           'Jenru',
           'RuJe123'
       ),
       (
           'Said',
           'Yasaev',
           '80405060',
           'Yassa',
           'SaYa123'
       ),
       (
           'Wares',
           'Amiry',
           '90302050',
           'Amiwa',
           'WaAm123'
       ),
       (
           'Bjørnar',
           'Somme',
           '90506070',
           'Sombj',
           'BjSo123'
       ),
       (
           'Vilde',
           'Elvemo',
           '9203040',
           'Elvvi',
           'ViEl123'
       ),

/*    Tullenavn herfra og ned   */
       (
           'Martin',
           'Barken',
           '91718060',
           'Barma',
           'MaBa123'
       ),
       (
           'Hilde',
           'Elveblest',
           '91718262',
           'Elvhi',
           'HiEl123'
       ),
       (
           'Hedvig',
           'Ugla',
           '92728262',
           'Uglhe',
           'HeUg123'
       ),
       (
           'Thomas',
           'Torget',
           '92728363',
           'Torth',
           'ThTo123'
       ),
       (
           'Jon',
           'Snø',
           '93728567',
           'Snøjo',
           'JoSn123'
       );


insert into TOOL(
    Tool_Name,
    Tool_Info,
    Price,
    Picture
)

values (
           'Eksentersliper 230VAC',
           '+ papir',
           '20',
           NULL
       ),
       (
           'Båndsliper 230VAC',
           '+ papir',
           '20',
           NULL
       ),
       (
           'Høvel 230VAC',
           NULL,
           '20',
           NULL
       ),
       (
           'Gjære-/kombisag 230VAC',
           NULL,
           '20',
           NULL
       ),
       (
           '9’ vinkelsliper for stein og betong',
           NULL,
           '20',
           NULL
       ),
       (
           'Meislemaskin, 230VAC',
           NULL,
           '20',
           NULL
       ),
       (
           'Slagdrill, Batteri, Milwaukee',
           NULL,
           '20',
           NULL
       ),
       (
           'Kantklipper - bensin',
           'Bruker oljeblandet bensin. Bruk kun ferdigblandet 2-takt alkylatbensin (2%)
       Dette er oljeblandet spesialbensinen med lang holdbarhet som kan kjøpes på bl.a. Felleskjøpet, Biltema og Jula.',
           '20',
           NULL
       ),
       (
           'Kompressor, 230VAC',
           'Maks. trykk: 10 bar
       Avgitt luftmengde: 255 l/min
       Effekt: 1,5 kW.',
           '20',
           NULL
       ),
       (
           'Diagnoseverktøy, bil',
           NULL,
           '50',
           NULL
       ),
       (
           'Vibratorplate «Hoppetusse», bensin',
           'Vekt: 86 kg
       Bruker ren bensin minimum oktantall 95.
       Motoroljenivå sjekkes før og etter bruk. Oljetype: Shell Ultra Ect 5W-30 (AMV nr. 0095-0069)',
           '50',
           NULL
       ),
       (
           'Flisekutter for keramiske fliser',
           NULL,
           '20',
           NULL
       ),
       (
           'Skruautomat',
           '+ skruer',
           '20',
           NULL
       ),
       (
           'Motorisert trillebår',
           NULL,
           '50',
           NULL
       ),
       (
           'Spikerpistol, stor (trykkluft)',
           NULL,
           '20',
           NULL
       ),
       (
           'Spikerpistol, liten (trykkluft)',
           NULL,
           '20',
           NULL
       ),
       (
           'Spikerpistol, stor (Milwaukee)',
           NULL,
           '20',
           NULL
       ),
       (
           'Spikerpistol, mellom (Milwaukee)',
           NULL,
           '20',
           NULL
       ),
       (
           'Spikerpistol, liten (Milwaukee)',
           NULL,
           '20',
           NULL
       ),
       (
           'Vedkløyver, Bensindrevet',
           NULL,
           '50',
           NULL
       ),
       (
           'Fliskutter for trevirke',
           NULL,
           '50',
           NULL
       ),
       (
           'Tilhenger, boggi; RD 5702',
           'Kassemål LxBxH: 297x153x29cm
       Nyttelast max. 1150kg',
           '50',
           NULL
       ),
       (
           'Tilhenger, liten, RC 8834',
           'Kassemål LxBxH: 197x153x29cm
       Nyttelast max. 645kg',
           '50',
           NULL
       ),
       (
           'Tilhenger, skap, JP2591',
           'Kassemål LxBxH: 292x154x194cm
       (Dørkarm BxH: 146x190cm)
       Nyttelast: 1090 kg',
           '50',
           NULL
       ),
       (
           'Personløfter, arb.høyde 12m.',
           'SWL 200 kg, 230 VAC',
           '100',
           NULL
       ),
       (
           'Strømaggregat, 3.7 kW (Diesel)',
           'Bruker avgiftsfri diesel.
       Motoroljenivå sjekkes før og etter bruk. Oljetype: Shell Ultra Ect 5W-30 (AMV nr. 0095-0069)',
           '50',
           NULL
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
           '5'
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


INSERT INTO ADMIN(USER_ID)

VALUES ('1'),('2'),('3');


INSERT INTO UNION_MEMBER(USER_ID)

VALUES ('4'),('5'),('6');

