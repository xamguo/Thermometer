package challenge.qualcomm.guoxiao.thermo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by guoxiao on 3/2/16.
 */
public class MyListAdapter extends BaseAdapter {

    private ArrayList<Double> temps;
    private LayoutInflater mInflater;
    private boolean cels;

    public MyListAdapter(Context context, ArrayList<Double> temps){
        this.mInflater = LayoutInflater.from(context);
        this.temps = temps;
        this.cels = true;
    }

    public void isCels(boolean input) {
        this.cels = input;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return temps.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {

            holder =new ViewHolder();

            //可以理解为从vlist获取view  之后把view返回给ListView

            convertView = mInflater.inflate(R.layout.list_component, null);
            holder.day = (TextView)convertView.findViewById(R.id.day);
            holder.temp = (TextView)convertView.findViewById(R.id.temp);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }

        String[] days = new String[]{"Mon", "Tue", "Wed", "Thr", "Fri"};
        holder.day.setText(days[position]);
        if(this.cels) {
            holder.temp.setText(this.temps.get(position).intValue() + "\u00b0" + "C");
        } else {
            holder.temp.setText(jniTranform(this.temps.get(position).intValue()) + "\u00b0" + "F");
        }

        return convertView;
    }

    public final class ViewHolder {
        public TextView day;
        public TextView temp;
    }

    public native int  jniTranform(int input);

    static {
        System.loadLibrary("transform");
    }
}
