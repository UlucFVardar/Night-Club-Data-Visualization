/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataVisilation;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author uluc
 */
class Artist  {
    private String artistName;
    private ArrayList<Double> costs;
    private ArrayList<EventNight> nights;
    public Artist(String artistName,double cost,EventNight night ){
        if(costs==null){
            costs=new ArrayList<>();
        }
        if(nights==null){
            nights=new ArrayList<>();
        }
        
        costs.add(cost);
        this.artistName=artistName;        
        nights.add(night);
    }

   

    public String getArtistName() {
        return artistName;
    }

    public void addCost(double cost) {
        this.costs.add(cost);
    }

    public void addNight(EventNight nights) {
        this.nights.add(nights);
    }

    public ArrayList<Double> getCosts() {
        return costs;
    }

    public ArrayList<EventNight> getNights() {
        return nights;
    }

       @Override
     public boolean equals(Object v) {
        boolean retVal = false;

        if (v instanceof String){
            String ptr = (String) v;
            if(ptr.equals(this.artistName)){
                retVal=true;
            }
        }
        return retVal;
     }
    
}
