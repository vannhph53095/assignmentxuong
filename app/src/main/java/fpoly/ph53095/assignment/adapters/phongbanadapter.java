package fpoly.ph53095.assignment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import fpoly.ph53095.assignment.R;
import fpoly.ph53095.assignment.models.phongban;


public class phongbanadapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<phongban> phongbanArrayList;

    public phongbanadapter(Context mContext, ArrayList<phongban> phongbanArrayList) {
        this.mContext = mContext;
        this.phongbanArrayList = phongbanArrayList;
    }

    @Override
    public int getCount() {
        if (phongbanArrayList!=null)
            return phongbanArrayList.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(mContext).inflate(R.layout.layoutitemlistphongban,parent,false);
        ImageView imgavata =convertView.findViewById(R.id.imgavata);
        TextView tvname =convertView.findViewById(R.id.tvname);
        phongban phongban =phongbanArrayList.get(position);
        imgavata.setImageResource(phongban.getImgavata());
        tvname.setText(phongban.getTvname());
        return convertView;
    }


}
