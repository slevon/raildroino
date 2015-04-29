package de.slevon.raildroid;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity {

ArrayList<Train> trains = new ArrayList<Train>();
ArrayList<Turnout> turnouts = new ArrayList<Turnout>();
ListView list;
TrainBaseAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    list = (ListView) findViewById(R.id.listView1);
	    
	    for(int i = 10; i< 40; i++){
	    	trains.add(new Train(i,"Roman",true,10,1));
	    }
	    
	   
	    adapter = new TrainBaseAdapter(MainActivity.this, trains);
        list.setAdapter(adapter);
        

        for(int i = 0; i< trains.size(); i++){
	    	trains.get(i).name = "Roman" + String.valueOf(i*2);
	    	trains.get(i).direction = Math.random()>.5?true:false;
	    	trains.get(i).speed = (int) Math.round(Math.random()*100);
        
	    }
        adapter.notifyDataSetChanged();
        
        //Tabview: 
        TabHost tabHost=(TabHost)findViewById(R.id.tabhost);
        tabHost.setup();

        TabSpec spec2=tabHost.newTabSpec("Weichen");
        spec2.setIndicator("Weichen");
        spec2.setContent(R.id.tabTurnout);

        TabSpec spec3=tabHost.newTabSpec("Signale");
        spec3.setIndicator("Signale");
        spec3.setContent(R.id.tabSignal);

        tabHost.addTab(spec2);
        tabHost.addTab(spec3);
        
        //Gridview 1
        for(int j = 1; j< 40; j++){
	    	turnouts.add(new Turnout(j,"Roman "+String.valueOf(j),true,false));
	    }
        GridView gridView = (GridView) findViewById(R.id.grid_view_turnout);
        TurnoutBaseAdapter turnoutBaseAdapter = new TurnoutBaseAdapter(this, R.layout.grid_turnout, turnouts);
        gridView.setAdapter(turnoutBaseAdapter);
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
