package de.slevon.raildroid;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TrainBaseAdapter extends BaseAdapter {
	
	private Activity activity;
	// private ArrayList&lt;HashMap&lt;String, String&gt;&gt; data;
	private static ArrayList<Train> trains;
	private static LayoutInflater inflater = null;
	
	public TrainBaseAdapter(Activity a, ArrayList<Train> trains) {
	    activity = a;
	    this.trains = trains;
	
	    inflater = (LayoutInflater) activity
	            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	
	}
	
	public int getCount() {
	    return trains.size();
	}
	
	public Object getItem(int position) {
	    return position;
	}
	
	public long getItemId(int position) {
	    return position; 
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
	    View vi = convertView;
	    if (convertView == null)
	        vi = inflater.inflate(R.layout.row_trainlist, null);
	
	    Train currentTrain = trains.get(position);
	    
	    final TextView title2 = (TextView) vi.findViewById(R.id.train_list_adress); // Adress der Lok
	    String song = String.valueOf(currentTrain.adress);
	    title2.setText(song);
	
	    final TextView title22 = (TextView) vi.findViewById(R.id.train_list_name); // Name der Lok
	    String song2 = currentTrain.name;
	    title22.setText(song2);
	    
	    final ToggleButton tb= (ToggleButton) vi.findViewById(R.id.train_list_direction);
	    tb.setChecked(currentTrain.direction);
	    
	    final SeekBar sb = (SeekBar) vi.findViewById(R.id.train_list_speed);
	    sb.setProgress(currentTrain.speed);
	    
	    tb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				sb.setProgress(0);
				
			}
		});
	    

	
	    return vi;
	
	}
	
	 public void updateValues(ArrayList trains) {
	        this.trains = trains;
	        //Triggers the list update !!!!!
	        notifyDataSetChanged();
	 }
}