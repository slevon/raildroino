package de.slevon.raildroid;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * 
 * @author manish.s 
 *
 */
public class TurnoutBaseAdapter extends BaseAdapter {
 Context context;
 int layoutResourceId;
 ArrayList<Turnout> data = new ArrayList<Turnout>();

 public TurnoutBaseAdapter(Context context, int layoutResourceId,
   ArrayList<Turnout> data) {
  this.layoutResourceId = layoutResourceId;
  this.context = context;
  this.data = data;
 }
 public int getCount() {
     return data.size();
 }

 public Object getItem(int position) {
     return null;
 }

 public long getItemId(int position) {
     return 0;
 }



 @Override
 public View getView(int position, View convertView, ViewGroup parent) {
  View vi = convertView;
  LayoutInflater inflater = ((Activity) context).getLayoutInflater();
  if (convertView == null)
      vi = inflater.inflate(R.layout.grid_turnout, null);

   ToggleButton tb = (ToggleButton) vi.findViewById(R.id.grid_turnout_button);
   TextView tv = (TextView) vi.findViewById(R.id.grid_turnout_text);
   Turnout item = data.get(position);
   tb.setText(String.valueOf(item.adress));
   tv.setText(item.name);
  
  return vi;

 }

}
