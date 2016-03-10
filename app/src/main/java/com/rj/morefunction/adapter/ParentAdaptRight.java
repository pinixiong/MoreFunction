package com.rj.morefunction.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rj.morefunction.activity.IpadMainActivity;
import com.rj.morefunction.activity.R;
import com.rj.morefunction.entity.MenuItem;

import java.util.List;

/**
 * 父listview适配器
 */
public class ParentAdaptRight extends BaseAdapter {

    private Context mContext;
    private List<MenuItem> fartherItems;
    private callBack callBack;

    public static int mParentItem = -1;
    public static boolean mbShowChild = false;

    public ParentAdaptRight(Context context, List<MenuItem> fartherItems) {
        this.mContext = context;
        this.fartherItems = fartherItems;
    }

    public interface callBack {
        void onAction(MenuItem menuItem);
    }

    public void setCallBack(callBack call) {
        this.callBack = call;
    }

    @Override
    public int getCount() {
        return fartherItems.size();
    }

    @Override
    public Object getItem(int position) {
        return fartherItems.get(position);
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_farther_item_right, null);
            vHolder.textViewTitle = (TextView) convertView.findViewById(R.id.tv_dad_title_right);
            vHolder.img = (ImageView) convertView.findViewById(R.id.img_dad_right);
            vHolder.listViewItem = (ListView) convertView.findViewById(R.id.listView_child_right);
            vHolder.ll_listViewItem = (LinearLayout) convertView.findViewById(R.id.ll_child_right);
            vHolder.rl_dad = (RelativeLayout) convertView.findViewById(R.id.rl_dad_right);
            convertView.setTag(vHolder);
        } else {
            vHolder = (ViewHolder) convertView.getTag();
        }
        vHolder.textViewTitle.setText(fartherItems.get(position).getTitle());

        //点击哪个弹出那个，如果已经弹出就收回子listview
        if (mParentItem == position && mbShowChild) {
            vHolder.img.setBackgroundResource(R.drawable.down);
            vHolder.rl_dad.setBackgroundResource(R.drawable.dad_corners_pressed);
            //子listview实在这里加载数据的
            IPadChildAdapt tempAdapt = new IPadChildAdapt(mContext, fartherItems.get(position).getSonitems());
            vHolder.listViewItem.setAdapter(tempAdapt);
            vHolder.ll_listViewItem.setVisibility(View.VISIBLE);
            //子listview的点击监听
            vHolder.listViewItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    callBack.onAction(IpadMainActivity.selectSon_right.get(position));
//                    Toast.makeText(mContext, IpadMainActivity.selectSon_right.get(position).getTitle() + "----", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            vHolder.ll_listViewItem.setVisibility(View.GONE);
            vHolder.img.setBackgroundResource(R.drawable.left);
            vHolder.rl_dad.setBackgroundResource(R.drawable.dad_corners_normal);
        }
        return convertView;
    }

    class ViewHolder {
        TextView textViewTitle;
        ListView listViewItem;
        ImageView img;
        LinearLayout ll_listViewItem;
        RelativeLayout rl_dad;
    }
}
