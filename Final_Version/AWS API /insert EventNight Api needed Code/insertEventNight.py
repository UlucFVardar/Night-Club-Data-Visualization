# -*- coding: utf-8 -*-
# AWS RDS MySQL
# @author =__Uluç Furkan Vardar__

import pymysql
import json 

REGION="us-east-2a"
rds_host = "nightclubproject.cdukbpxo4e76.us-east-2.rds.amazonaws.com"
name = "master"
password = "password"
db_name = "innodb"


def insert2DB(artistName, artistPrice, eventType, eventDate, eventComment, totalProfit, totalEndersement, tip,
                dontPay, totalCost, nameOfSales, sumOfProfit, sumOfGiro, salesNumber, cl70Number,
                cl35Number, confetyNumber, bottleNumber, totalDiscount, alcoholIndex, generalIndex,
                grupEnterenceFree):
    
    conn = pymysql.connect(rds_host, user=name, passwd=password, db=db_name, connect_timeout=5)
    try:
        with conn.cursor() as cur:
            query="""("%s",%s,"%s","%s","%s",%s,%s,%s,%s,%s,"%s","%s","%s","%s",%s,%s,%s,%s,%s,%s,%s);"""%(artistName, artistPrice, eventType, eventDate, eventComment, totalProfit, totalEndersement, tip,
                dontPay, totalCost, nameOfSales, sumOfProfit, sumOfGiro, salesNumber, cl70Number,
                cl35Number, confetyNumber, bottleNumber, totalDiscount, alcoholIndex, generalIndex,
                grupEnterenceFree)
            cur.execute("""call innodb.addEventNight(%s);                                                        
                                    """%(query))
            conn.commit()
            cur.close()     
        return True
    except Exception as e:
        print(str(e))
        return False
    cur.close()

def main(event, context):
    return insert2DB("Deniz","9620.0","8 binlik","2018-02-10"," ","-4658.0","7763.0","0","1200","2300","2","70cl-35cl-konfeti-sigara-bardak","3200|3212|12313|1231.221|1213","320.0|3212|12313|1231.221|1213","2|4|5|134|21","1","3","22","4","432","0.2131","0.123123,0")
    
main(None,None)
       



