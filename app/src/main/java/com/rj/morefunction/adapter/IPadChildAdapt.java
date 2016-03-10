package com.rj.morefunction.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rj.morefunction.activity.R;
import com.rj.morefunction.entity.MenuItem;

import java.util.List;

/**
 * 子listview适配器
 */
public class IPadChildAdapt extends BaseAdapter {
    private Context mContext;
    private List<MenuItem> sonItems;

    public IPadChildAdapt(Context context, List<MenuItem> sonItems) {
        this.mContext = context;
        this.sonItems = sonItems;
    }

    @Override
    public int getCount() {
        return sonItems.size();
    }

    @Override
    public Object getItem(int position) {
        return sonItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vHolder = null;
        if (convertView == null) {
            vHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.ipad_listview_son_item, null);
            vHolder.img = (ImageView) convertView.findViewById(R.id.img_son_ipad);
            vHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name_ipad);
            convertView.setTag(vHolder);
        } else {
            vHolder = (ViewHolder) convertView.getTag();
        }
        vHolder.img.setImageDrawable(sonItems.get(position).getDrawable());
        vHolder.tv_name.setText(sonItems.get(position).getTitle());
        return convertView;
    }

    class ViewHolder {
        ImageView img;
        TextView tv_name;
    }
}
