package software.dumi.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    private float[] yData = {25.3f, 10.6f, 66.76f, 44.32f, 46.01f, 16.89f, 23.9f};
    private String[] xData = {"Mitch", "Jessica" , "Mohammad" , "Kelsey", "Sam", "Robert", "Ashley"};
    PieChart pieChart;
    private CustomAdaptor customAdapter;
    public JSONArray dataOfNights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        our API's are not work very Well and we couldn't take information from DB with API so I just create random values to work
         */
        //getData();
        createInterfaceWithOutConnectingAPI();
    }

    private void createInterfaceWithOutConnectingAPI() {
        BarChart br=findViewById(R.id.chart);
        br.getDescription().setEnabled(false);
        setDataBRC(10,br);
        br.setFitBars(true);
        ListView listView=findViewById(R.id.listView);
        customAdapter=new CustomAdaptor(MainActivity.this,null);
        listView.setOnItemClickListener(listViewClickListener);
        listView.setAdapter(customAdapter);
    }

    private AdapterView.OnItemClickListener listViewClickListener= new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            AlertDialog.Builder mBuilder=new AlertDialog.Builder(MainActivity.this);
            View mView =getLayoutInflater().inflate(R.layout.dialog,null);

            /* if API works
                TextView eventType = mView.findViewById(R.id.eventType);
                TextView date = mView.findViewById(R.id.date);
                TextView ciro = mView.findViewById(R.id.ciro);
                TextView profit = mView.findViewById(R.id.profit);
                TextView artistName = mView.findViewById(R.id.artistName);
                TextView artistCost = mView.findViewById(R.id.artistCost);
                TextView totalEndex = mView.findViewById(R.id.totalEndex);
                TextView alcholEndex = mView.findViewById(R.id.alcholEndex);
                TextView dontPay = mView.findViewById(R.id.dontPay);

                JSONObject jso=(JSONObject)js.get(position);
                eventType.setText("Event Tipi : "+jso.getString("EventType"));
                date.setText("Tarih : "+jso.getString("Date"));
                .
                .
                .

             */
            mBuilder.setView(mView);
            final AlertDialog dialog = mBuilder.create();
            dialog.show();
        }
    };
    public void setDataBRC(int count, BarChart br) {
        ArrayList<BarEntry> yVal=new ArrayList<>();
        for ( int i = 0 ; i< count ; i++ ){
            float fv=(float)(Math.random()*90000);
            yVal.add(new BarEntry(i,(int) fv));
        }
        BarDataSet set = new BarDataSet(yVal,"data");
        set.setColors(ColorTemplate.MATERIAL_COLORS);
        set.setDrawValues(true);


        BarData bd=new BarData(set);
        br.setData(bd);
        br.invalidate();
        br.animateY(500);
    }

    public void getData() {
        DownloadData downloadData = new DownloadData();
        String url = "https://stormy-bayou-55176.herokuapp.com/getAllData";
        downloadData.execute(url);
    }
    private void fillChartswithData() {
        BarChart br=findViewById(R.id.chart);
        br.getDescription().setEnabled(false);
        setDataBRC(10,br);
        br.setFitBars(true);
        ListView listView=findViewById(R.id.listView);
        customAdapter=new CustomAdaptor(MainActivity.this,dataOfNights);
        listView.setOnItemClickListener(listViewClickListener);
        listView.setAdapter(customAdapter);
    }
    private class DownloadData extends AsyncTask<String, Void, String> {
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                if(s==null)
                    getData();
                else{
                    System.out.print(s);
                    dataOfNights=new JSONArray(s.toString());

                    //fillChartswithData();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        @Override
        protected String doInBackground(String... params) {
            String result = "";
            URL url;
            HttpURLConnection httpURLConnection;
            try {
                url = new URL(params[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                int data = inputStreamReader.read();
                while (data > 0) {
                    char character = (char) data;
                    result += character;
                    data = inputStreamReader.read();
                }
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

    }


    ////********

}