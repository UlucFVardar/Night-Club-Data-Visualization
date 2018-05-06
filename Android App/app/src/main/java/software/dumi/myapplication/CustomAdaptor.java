package software.dumi.myapplication;

import android.content.Context;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CustomAdaptor extends BaseAdapter{
    private Context context;
    private ArrayList<JSONObject> data;
    PieChart pieChart;

    private static String TAG = "MainActivity";

    private float[] yData = {25.3f, 10.6f, 66.76f, 44.32f, 46.01f, 16.89f, 23.9f};
    private String[] xData = {"Mitch", "Jessica" , "Mohammad" , "Kelsey", "Sam", "Robert", "Ashley"};
    public JSONArray js;

    public CustomAdaptor(Context context, JSONArray dataOfNights){
        this.context=context;
        js=dataOfNights;
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
            return position;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout linearLayout = (LinearLayout) ((Activity)this.context).getLayoutInflater().inflate(R.layout.custom_listview,null);
        pieChart = (com.github.mikephil.charting.charts.PieChart) linearLayout.findViewById(R.id.idPieChart);
        pieChart.setRotationEnabled(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("");
        pieChart.setCenterTextSize(0);
        addDataSet();
        if (js==null){
            TextView turn = linearLayout.findViewById(R.id.turn);
            turn.setText("Sıra : "+(Integer.toString(position)));

        }else{//if API works
            TextView eventType = linearLayout.findViewById(R.id.eventType);
            TextView artistName = linearLayout.findViewById(R.id.artistName);
            TextView totalCiro = linearLayout.findViewById(R.id.ciro);
            TextView turn = linearLayout.findViewById(R.id.turn);
            turn.setText("Sıra : "+(Integer.toString(position)));
            JSONObject jso=null;
            try {
                jso=(JSONObject)js.get(position);
                totalCiro.setText("Toplam Ciro : "+  jso.getDouble("Endorsement"));
                artistName.setText("Sanatçı Adı : "+ jso.getString("ArtistSurname"));
                eventType.setText("Event Tipi : "+jso.getString("EventType"));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return linearLayout;
    }
    private void addDataSet() {
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for(int i = 0; i < yData.length; i++){
            yEntrys.add(new PieEntry(yData[i] , i));
        }

        for(int i = 1; i < xData.length; i++){
            xEntrys.add(xData[i]);

        }

        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "");
        pieDataSet.setSliceSpace(0);
        pieDataSet.setValueTextSize(0);

        //add colors to dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GRAY);
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.CYAN);
        colors.add(Color.YELLOW);
        colors.add(Color.MAGENTA);

        pieDataSet.setColors(colors);

        //add legend to chart
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
    public void setData(ArrayList<JSONObject> data) {
        this.data = data;
    }
}
