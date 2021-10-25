
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
SELECT USER_ID, StartDate, EndDate, TOOL_ID, COUNT(USER_ID) AS ANTALL_BOOKINGER FROM BOOKING
GROUP BY USER_ID
ORDER BY ANTALL_BOOKINGER DESC
LIMIT 1;
