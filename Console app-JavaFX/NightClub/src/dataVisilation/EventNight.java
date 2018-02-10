/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataVisilation;

import java.util.ArrayList;

import java.util.HashMap;
import javafx.util.Pair;
import java.util.Date;

/**
 *
 * @author uluc
 */
public class EventNight {
    private Date date;
    private double dontPay;
    private static String [] namesOfSaledElements={"70cl","35cl","Sigara/Paket","Konfeti","Bardak","Bilet Öğrenci","Bilet Tam"};
    private String nameOfSales[];
    private double gainOfSales[];
    private double profitOfSales[];
    private int [] salesOfNight ;
    private int [] ikramOfNight;
    private double discount;
    private int discountBottle;
    private double tip;
    private Artist artist;
    private double artistCost;
    private double groupEntryFee;
    private int numberOfTotalPerson;
    private int freeEntry;
    private Pair <Integer,Integer> soldTickets;
    private double endorsement;
    private double profit;
    private String eventType;

    @Override
    public String toString() {
        if(this.artist!=null)
            return "EventNight{" + "date=" + date + "\n dontPay=" + dontPay+ ", discount=" + discount + ", discountBottle=" + discountBottle + ", tip=" + tip + ", artist=" + artist.getArtistName() + ", artistCost=" + artistCost + ", groupEntryFee=" + groupEntryFee + ", numberOfTotalPerson=" + numberOfTotalPerson + ", freeEntry=" + freeEntry + ", soldTickets=" + soldTickets + ", endorsement=" + endorsement + ", profit=" + profit + '}';
        else
            return "EventNight{" + "date=" + date + "\n dontPay=" + dontPay+ ", discount=" + discount + ", discountBottle=" + discountBottle + ", tip=" + tip +",groupEntryFee=" + groupEntryFee + ", numberOfTotalPerson=" + numberOfTotalPerson + ", freeEntry=" + freeEntry + ", soldTickets=" + soldTickets + ", endorsement=" + endorsement + ", profit=" + profit + '}';
    }

    public double getDiscount() {
        return discount;
    }

    public int getDiscountBottle() {
        return discountBottle;
    }

    public int getFreeEntry() {
        return freeEntry;
    }

    public EventNight(Date date, double dontPay, double discount, int discountBottle, double tip, double groupEntryFee, Pair<Integer, Integer> soldTickets ,int freeEntry) {
        this.freeEntry=freeEntry;
        this.date = date;
        this.dontPay = dontPay;
        this.numberOfTotalPerson =freeEntry+soldTickets.getKey()+soldTickets.getValue();
        this.discount = discount;
        this.discountBottle = discountBottle;
        this.tip = tip;
        this.groupEntryFee = groupEntryFee;
        this.soldTickets = soldTickets;
        endorsement=0;
        profit=0;    
        this.eventType="Normal Gün";
    }

    public static String[] getNamesOfSaledElements() {
        return namesOfSaledElements;
    }

    public double[] getProfitOfSales() {
        return profitOfSales;
    }

    public void calculateEndorsement_and_Profit(HashMap<String,Double> unitSalesPrice,HashMap<String,Double>  unitCostPrice){
        endorsement=0;
        profit=0;       
        endorsement+=unitSalesPrice.get("70cl")*salesOfNight[0];
        endorsement+=unitSalesPrice.get("35cl")*salesOfNight[1];
        endorsement+=unitSalesPrice.get("Sigara/Paket")*salesOfNight[2];
        endorsement+=unitSalesPrice.get("Konfeti")*salesOfNight[3];
        endorsement+=unitSalesPrice.get("Bardak")*salesOfNight[4];
        
        profit+=(unitSalesPrice.get("70cl")-unitCostPrice.get("70cl"))*salesOfNight[0];
        profit+=(unitSalesPrice.get("35cl")-unitCostPrice.get("35cl"))*salesOfNight[1];
        profit+=(unitSalesPrice.get("Sigara/Paket")-unitCostPrice.get("Sigara/Paket"))*salesOfNight[2];
        profit+=(unitSalesPrice.get("Konfeti")-unitCostPrice.get("Konfeti"))*salesOfNight[3];
        profit+=(unitSalesPrice.get("Bardak")-unitCostPrice.get("Bardak"))*salesOfNight[4];
        
        profit-=unitCostPrice.get("70cl")*ikramOfNight[0];
        profit-=unitCostPrice.get("35cl")*ikramOfNight[1];
        profit-=unitCostPrice.get("Konfeti")*ikramOfNight[2];
        profit-=discount;
        profit-=groupEntryFee;
        
        endorsement+=soldTickets.getKey()*unitSalesPrice.get("Bilet Öğrenci");
        endorsement+=soldTickets.getValue()*unitSalesPrice.get("Bilet Tam");
        
        profit+=soldTickets.getKey()*unitSalesPrice.get("Bilet Öğrenci");
        profit+=soldTickets.getValue()*unitSalesPrice.get("Bilet Tam");
        
        //profit-=dontPay;
        if(artist!=null){
            profit-=artistCost;
        }
        
        //
        double [] values;
        String [] names;       
        double [] valuesP;
        int size=EventNight.getNamesOfSaledElements().length;
       
        valuesP=new double[size];
        names=new String[size];
        values=new double[size];
                   
        for (int k=0 ; k<size ; k++){
            names[k]=EventNight.getNamesOfSaledElements()[k];     
            if(k<size-2){
                values[k]=this.getSalesOfNight()[k]*(unitSalesPrice.get(names[k]));                                
                valuesP[k]=this.getSalesOfNight()[k]*(unitSalesPrice.get(names[k])-unitCostPrice.get(names[k]));                                
            }            
        }  
        values[size-2]=this.soldTickets.getKey()*(unitSalesPrice.get(names[size-2]));  
        values[size-1]=this.soldTickets.getValue()*(unitSalesPrice.get(names[size-1]));  
        valuesP[size-2]=this.soldTickets.getKey()*(unitSalesPrice.get(names[size-2])-unitCostPrice.get(names[size-2]));                                
        valuesP[size-1]=this.soldTickets.getValue()*(unitSalesPrice.get(names[size-1])-unitCostPrice.get(names[size-1]));                                
        
        this.nameOfSales=names;
        this.gainOfSales=values;
        this.profitOfSales=valuesP;
        //
        
        
        
        
    }

    public String[] getNameOfSales() {
        return nameOfSales;
    }

    public double[] getGainOfSales() {
        return gainOfSales;
    }
    
    public int[] getIkramOfNight() {
        return ikramOfNight;
    }

    public void setIkramOfNight(int bigBottle,int liddleBottel,int konfeti) {
        this.ikramOfNight =new int []{bigBottle,liddleBottel,konfeti};         
    }
    
    public void setSalesOfNight(int bigBottle,int liddleBottel,int sigara,int konfeti,int bardak) {
        this.salesOfNight =new int []{bigBottle,liddleBottel,sigara,konfeti,bardak};
    }

    public int[] getSalesOfNight() {
        return salesOfNight;
    }

    public double getEndorsement() {
        return endorsement;
    }

    public double getProfit() {
        return profit;
    }
    
    public Date getDate() {
        return date;
    }

    public double getDontPay() {
        return dontPay;
    }

    public double getTip() {
        return tip;
    }

    public Artist getArtist() {
        if(artist!=null)
        return artist;
        
        return null;
    }

    public String getEventType() {
        return eventType;
    }

    public void setArtist(Artist artist, double cost) {
        this.artist = artist;
        this.artistCost=cost;
        
        if(cost>4500 && cost<15000){
            this.eventType="8 Binlik";
        }else if(cost>15001 && cost<30000){
            this.eventType="25 Binlik";
        }else if(cost>30001 && cost<55000){
            this.eventType="40 Binlik";
        }else if(cost>55001 ){
            this.eventType="+70 Binlik";
        }
    }

    public double getArtistCost() {
        return artistCost;
    }

    public double getGroupEntryFee() {
        return groupEntryFee;
    }

    public int getNumberOfTotalPerson() {
        return numberOfTotalPerson;
    }

    public Pair<Integer, Integer> getSoldTickets() {
        return soldTickets;
    }

    void setArtist(Artist newArtist) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
