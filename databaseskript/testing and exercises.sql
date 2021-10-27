
/*Skriver alt som er ledig*/
SELECT TOOL.TOOL_ID AS "Verktøy-ID", Tool_Name as "Verktøynavn", BOOKING_ID FROM TOOL
LEFT JOIN BOOKING ON TOOL.TOOL_ID = BOOKING.TOOL_ID
WHERE isDelivered = true OR BOOKING_ID is null;


/*Skriver alt som er opptatt*/
SELECT * FROM TOOL
RIGHT JOIN BOOKING ON TOOL.TOOL_ID = BOOKING.TOOL_ID
WHERE isDelivered = false;


/*Skriver ut de tre med flest bookinger, sortert etter antall bookinger*/
SELECT USER_ID, COUNT(USER_ID) AS ANTALL_BOOKINGER
FROM BOOKING
GROUP BY USER_ID
ORDER BY ANTALL_BOOKINGER DESC
LIMIT 3;

/*List all the equipment borrowed by the user with the
  highest number of equipment borrowed, sorted by date/time*/
SELECT BOOKING.USER_ID, BOOKING.StartDate, BOOKING.EndDate, BOOKING.TOOL_ID, TOOL.Tool_Name
FROM BOOKING
RIGHT JOIN TOOL ON BOOKING.TOOL_ID = TOOL.TOOL_ID
WHERE USER_ID = (
SELECT USER_ID FROM BOOKING GROUP BY user_id ORDER BY COUNT(USER_ID) DESC LIMIT 1)
ORDER BY EndDate DESC;


/* Admin view */

CREATE VIEW Admins AS(
SELECT USER.USER_ID AS Bruker_ID, USER.Fname AS Fornavn, USER.Lname AS Etternavn
FROM USER
INNER JOIN ADMIN on USER.USER_ID = ADMIN.USER_ID
);
