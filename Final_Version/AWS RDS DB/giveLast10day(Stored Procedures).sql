#writen by Uluç Furkan Vardar

CREATE DEFINER=`master`@`%` PROCEDURE `giveLast10day`()
BEGIN

select en.eventNightDate,en.eventType,en.eventNightComment,totalProfit,totalEndersement,tip,dontPay,grupEnterenceFree,nameOfSales,sumOfProfit,sumOfGiro,numberOfSales,cl70Number,cl35Number,confetyNumber,discount,bottleNumber,alcoholIndex,generalIndex,artist_Name,price as artist_Cost
from EventNight en inner join MoneyFlow mf on en.event_id=mf.event_id
inner join Sales s on s.moneyFlow_id=mf.moneyFlow_id 
inner join Treat t on t.moneyFlow_id=mf.moneyFlow_id 
inner join Discount d on d.moneyFlow_id=mf.moneyFlow_id 
inner join IndexesOfEvent  i on en.event_id=i.event_id
inner join DaysOfArtist doa on en.event_id=doa.event_id
inner join Artist a on a.artist_id=doa.artist_id
order by eventNightDate  DESC
limit 10;
END