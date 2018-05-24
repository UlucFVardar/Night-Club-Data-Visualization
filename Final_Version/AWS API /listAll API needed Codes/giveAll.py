
# AWS RDS MySQL
# @author =__Uluc Furkan Vardar__

import pymysql
import json 
REGION="us-east-2a"
rds_host = "nightclubproject.cdukbpxo4e76.us-east-2.rds.amazonaws.com"
name = "master"
password = "password"
db_name = "innodb"


def main(event, context):
    conn = pymysql.connect(rds_host, user=name, passwd=password, db=db_name, connect_timeout=5)
    try:
        forms = []
        info="{"
        with conn.cursor() as cur:
            cur.execute("""call innodb.giveLast10day();""")
            conn.commit()
            cur.close()
        for row in cur:
            forms.append(json.dumps(row))
        return forms
    except Exception as e:
        print(str(e))
    cur.close()


main(None,None)

