#writen by Uluç Furkan Vardar

CREATE DEFINER=`master`@`%` PROCEDURE `updateComment`(eventDate varchar(60),commentOfNight varchar(1000))
BEGIN
#Artist eklendi
IF (  (SELECT @eventID:=event_id FROM EventNight as e WHERE e.eventNightDate = eventDate limit 1 )!= 0 ) then 
	(SELECT @eventID:=event_id FROM EventNight as e WHERE e.eventNightDate = eventDate limit 1 );
	UPDATE EventNight
	SET eventNightComment = commentOfNight   
	WHERE event_id= @eventID;
    
ELSE 	
 (SELECT @eventID:=event_id FROM EventNight as e WHERE e.eventNightDate = eventDate limit 1 );	
END IF;


END