package dataVisilation;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author uluc
 */
class Artist implements Comparable<Object> {
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
    public Artist(){}

   

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
    public boolean equals(Object o)
    {
        boolean sameSame = false;
        if (o != null && o instanceof String)
        {
            sameSame = this.artistName.equalsIgnoreCase((String) o);
        }
        return sameSame;
    }
    @Override
    public int compareTo(Object o) {
        if(o instanceof String){
            String str=(String)o;
            if(this.getArtistName().equalsIgnoreCase(str)){
                return 0;
            }
        }
        return 1;
    }
    
}
