from flask import Flask, request, url_for, redirect
from flask_sqlalchemy import SQLAlchemy
from flask import render_template
from flask import jsonify, json
from datetime import date


app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'Your Key'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
app.debug = True
db = SQLAlchemy(app)


class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(80), unique= True)
    email = db.Column(db.String(120), unique=True)

    def __init__(self, email, username):
        self.email = email
        self.username = username

    def __repr__(self):
        return '<User %r>' % self.username


class artists(db.Model):
    ArtistID = db.Column(db.Integer, primary_key=True)
    ArtistName = db.Column(db.String(50))
    ArtistSurname = db.Column(db.String(50))
    def __init__(self,ArtistName,ArtistSurname):
        self.ArtistName = ArtistName
        self.ArtistSurname = ArtistSurname



class days_of_artists(db.Model):
    ArtistID = db.Column(db.Integer, db.ForeignKey('artists.ArtistID'))
    EventID = db.Column(db.Integer, primary_key=True)
    Price = db.Column(db.Float)
    ArtistType = db.Column(db.String(50))

    def __init__(self,ArtistID,EventID, Price, ArtistType):
        self.ArtistID = ArtistID
        self.EventID = EventID
        self.Price = Price
        self.ArtistType = ArtistType


class discount(db.Model):
    DiscountID = db.Column(db.Integer, primary_key=True)
    MoneyFlowID = db.Column(db.Integer, db.ForeignKey('money_flow.MoneyFlowID'))
    _70_ClNum = db.Column(db.Integer)
    _35_ClNum = db.Column(db.Integer)
    DiscOf_70_ = db.Column(db.Float)
    Discof_35_ = db.Column(db.Float)

    def __init__(self,MoneyFlowID,_70_ClNum,_35_ClNum, DiscOf_70_, Discof_35_):
        self.MoneyFlowID = MoneyFlowID
        self._70_ClNum = _70_ClNum
        self._35_ClNum = _35_ClNum
        self.DiscOf_70_ = DiscOf_70_
        self.Discof_35_ = Discof_35_


class event_night(db.Model):
    EventID = db.Column(db.Integer, primary_key=True)
    Date = db.Column(db.Date)
    EventType = db.Column(db.String(50))
    Comment = db.Column(db.String(100))

    def __init__(self, Date, EventType, Comment):
        self.Date = Date
        self.EventType = EventType
        self.Comment = Comment

class indexes(db.Model):
    IndexID = db.Column(db.Integer, primary_key=True)
    EventID = db.Column(db.Integer,db.ForeignKey('event_night.EventID'))
    GeneralIndex = db.Column(db.Float)
    AlcoholIndex = db.Column(db.Float)

    def __init__(self,EventID,GeneralIndex,AlcoholIndex):
        self.EventID = EventID
        self.GeneralIndex = GeneralIndex
        self.AlcoholIndex = AlcoholIndex


class money_flow(db.Model):
    MoneyFlowID = db.Column(db.Integer, primary_key=True)
    EventID = db.Column(db.Integer,db.ForeignKey('event_night.EventID'))
    Cost = db.Column(db.Float)
    Endorsement = db.Column(db.Float)
    Profit = db.Column(db.Float)
    Tip = db.Column(db.Float)
    DontPay = db.Column(db.Float)

    def __init__(self,EventID,Cost,Endorsement, Profit, Tip, DontPay):
        self.EventID = EventID
        self.Cost = Cost
        self.Endorsement = Endorsement
        self.Profit = Profit
        self.Tip = Tip
        self.DontPay = DontPay


class sales(db.Model):
    SalesID = db.Column(db.Integer, primary_key=True)
    MoneyFlowID = db.Column(db.Integer, db.ForeignKey('money_flow.MoneyFlowID'))
    SalesNumber = db.Column(db.Integer)
    SumOfSales = db.Column(db.Float)
    SumOfProfit = db.Column(db.Float)
    Name = db.Column(db.String(50))


    def __init__(self,MoneyFlowID,SalesNumber,SumOfSales, SumOfProfit, Name):
        self.MoneyFlowID = MoneyFlowID
        self.SalesNumber = SalesNumber
        self.SumOfSales = SumOfSales
        self.SumOfProfit = SumOfProfit
        self.Name = Name


class treat(db.Model):
    TreatID = db.Column(db.Integer, primary_key=True)
    MoneyFlowID = db.Column(db.Integer, db.ForeignKey('money_flow.MoneyFlowID'))
    _70_Cl = db.Column(db.Integer)
    _35_Cl = db.Column(db.Integer)
    Confety = db.Column(db.Integer)


    def __init__(self,MoneyFlowID,_70_Cl,_35_Cl, Confety):
        self.MoneyFlowID = MoneyFlowID
        self._70_Cl = _70_Cl
        self._35_Cl = _35_Cl
        self.Confety = Confety



@app.route("/")
def index():
    return render_template('add_user.html')


@app.route("/getAllData")
def getAllData():
    AllData = db.engine.execute('SELECT ART.ArtistName, ART.ArtistSurname, EN.Date, EN.EventType, EN.Comment, DOA.Price, DOA.ArtistType, DIS._70_ClNum, DIS.`_35_ClNum` , DIS.`DiscOf_70_` , DIS.`Discof_35_` , IND.`GeneralIndex` , IND.`AlcoholIndex` , MF.`Cost` , MF.`Endorsement` , MF.`Profit` , MF.`Tip` , MF.`DontPay` , SA.`SalesNumber` , SA.`SumOfSales` , SA.`SumOfProfit` , SA.`Name` , TRE.`_70_Cl` , TRE.`_35_Cl` , TRE.`Confety` FROM artists ART INNER JOIN days_of_artists DOA ON ART.ArtistID = DOA.ArtistID INNER JOIN event_night EN ON DOA.EventID = EN.EventID INNER JOIN money_flow MF ON MF.EventID = EN.EventID INNER JOIN indexes IND ON IND.EventID = EN.EventID INNER JOIN discount DIS ON DIS.MoneyFlowID = MF.MoneyFlowID INNER JOIN sales SA ON SA.MoneyFlowID = MF.MoneyFlowID INNER JOIN treat TRE ON TRE.MoneyFlowID = MF.MoneyFlowID')
    return json.dumps([dict(r) for r in AllData])


@app.route("/getwDate/<date>")
def getWDate(date):
    Date = date
    print(Date)
    DateData = db.engine.execute('SELECT ART.ArtistName, ART.ArtistSurname, EN.Date, EN.EventType, EN.Comment, DOA.Price, DOA.ArtistType, DIS._70_ClNum, DIS.`_35_ClNum` , DIS.`DiscOf_70_` , DIS.`Discof_35_` , IND.`GeneralIndex` , IND.`AlcoholIndex` , MF.`Cost` , MF.`Endorsement` , MF.`Profit` , MF.`Tip` , MF.`DontPay` , SA.`SalesNumber` , SA.`SumOfSales` , SA.`SumOfProfit` , SA.`Name` , TRE.`_70_Cl` , TRE.`_35_Cl` , TRE.`Confety` FROM artists ART INNER JOIN days_of_artists DOA ON ART.ArtistID = DOA.ArtistID INNER JOIN event_night EN ON DOA.EventID = EN.EventID INNER JOIN money_flow MF ON MF.EventID = EN.EventID INNER JOIN indexes IND ON IND.EventID = EN.EventID INNER JOIN discount DIS ON DIS.MoneyFlowID = MF.MoneyFlowID INNER JOIN sales SA ON SA.MoneyFlowID = MF.MoneyFlowID INNER JOIN treat TRE ON TRE.MoneyFlowID = MF.MoneyFlowID WHERE EN.Date = "'+Date+'"')
    return json.dumps([dict(r) for r in DateData])


@app.route('/post/<uuid>', methods=['GET', 'POST'])
def my_post(uuid):

    content = request.json
    Date = content['Date']
    EventType = content['EventType']
    Comment = content['Comment']
    name = content['name']
    surname = content['surname']
    Price = content['Price']
    ArtistType = content['ArtistType']
    Cost = content['Cost']
    Endorsement = content['Endorsement']
    Profit = content['Profit']
    Tip = content['Tip']
    DontPay = content['DontPay']
    _70_ClNum = content['_70_ClNum']
    _35_ClNum = content['_35_ClNum']
    DiscOf_70_ = content['DiscOf_70_']
    Discof_35_ = content['Discof_35_']
    GeneralIndex = content['GeneralIndex']
    AlcoholIndex = content['AlcoholIndex']
    SalesNumber = content['SalesNumber']
    SumOfSales = content['SumOfSales']
    SumOfProfit = content['SumOfProfit']
    Name = content['Name']
    _70_Cl = content['_70_Cl']
    _35_Cl = content['_35_Cl']
    Confety = content['Confety']


    # Add Event Night
    EventNight = event_night(Date, EventType, Comment)
    db.session.add(EventNight)
    db.session.commit()
    currentEvent = event_night.query.filter_by(Date=Date).first()

    # if Event is not normal add Artist
    if (EventType != 'Normal'):
        # Add Artists
        artist = artists.query.filter_by(ArtistSurname=surname).first()
        if (artist != None):
            print(artist.ArtistID)
        else:
            Artist = artists(name, surname)
            db.session.add(Artist)
            db.session.commit()

    # add days_of_artist
    if (EventType != 'Normal'):
        artist = artists.query.filter_by(ArtistSurname=surname).first()
        currentEvent = event_night.query.filter_by(Date=Date).first()
        daysofartists = days_of_artists(artist.ArtistID, currentEvent.EventID, Price, ArtistType)
        db.session.add(daysofartists)
        db.session.commit()

    # Add MoneyFlow
    MoneyFlow = money_flow(currentEvent.EventID, Cost, Endorsement, Profit, Tip, DontPay)
    db.session.add(MoneyFlow)
    db.session.commit()

    # Add Discount
    Discount = discount(MoneyFlow.MoneyFlowID, _70_ClNum, _35_ClNum, DiscOf_70_, Discof_35_)
    db.session.add(Discount)
    db.session.commit()

    # Add Indexes
    Indexes = indexes(currentEvent.EventID, GeneralIndex, AlcoholIndex)
    db.session.add(Indexes)
    db.session.commit()

    # Add Sales
    Sales = sales(MoneyFlow.MoneyFlowID, SalesNumber, SumOfSales, SumOfProfit, Name)
    db.session.add(Sales)
    db.session.commit()

    # Add Treat
    Treat = treat(MoneyFlow.MoneyFlowID, _70_Cl, _35_Cl, Confety)
    db.session.add(Treat)
    db.session.commit()

    return redirect(url_for('index'))



@app.route("/getlastdays")
def getUser():
    myUser = db.engine.execute('SELECT * FROM (SELECT * FROM event_night ORDER BY EventID DESC LIMIT 20 )sub ORDER BY EventID DESC')
    return json.dumps([dict(r) for r in myUser])



if __name__ == '__main__':
    app.run()

