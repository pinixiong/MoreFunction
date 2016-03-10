package com.rj.morefunction.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.rj.morefunction.adapter.ParentAdapt;
import com.rj.morefunction.entity.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class PhoneMainActivity extends Activity {

    private ParentAdapt mParentAdapt;
    private List<MenuItem> fartherItems;
    private List<MenuItem> sonitems;
    public static List<MenuItem> selectSon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_activity_main);
        initData();
        initView();
    }

    private void initData() {
        fartherItems = new ArrayList<>();
        sonitems = new ArrayList<>();

        Drawable drawable1 = this.getResources().getDrawable(R.drawable.icon);
        Drawable drawable2 = this.getResources().getDrawable(R.drawable.icon1);
        Drawable drawable3 = this.getResources().getDrawable(R.drawable.icon2);
        Drawable drawable4 = this.getResources().getDrawable(R.drawable.icon3);
        Drawable drawable5 = this.getResources().getDrawable(R.drawable.icon4);
        Drawable drawable6 = this.getResources().getDrawable(R.drawable.icon5);
        Drawable drawable7 = this.getResources().getDrawable(R.drawable.icon6);
        Drawable drawable8 = this.getResources().getDrawable(R.drawable.icon7);
        Drawable drawable9 = this.getResources().getDrawable(R.drawable.icon8);
        Drawable drawable10 = this.getResources().getDrawable(R.drawable.icon9);
        Drawable drawable11 = this.getResources().getDrawable(R.drawable.icon10);
        MenuItem sonItem1 = new MenuItem(drawable1, "A全部发文");
        MenuItem sonItem2 = new MenuItem(drawable2, "B全部发文");
        MenuItem sonItem3 = new MenuItem(drawable3, "C全部发文");
        MenuItem sonItem4 = new MenuItem(drawable4, "D全部发文");
        MenuItem sonItem5 = new MenuItem(drawable5, "E全部发文");
        MenuItem sonItem6 = new MenuItem(drawable6, "F全部发文");
        MenuItem sonItem7 = new MenuItem(drawable7, "G全部发文");
        MenuItem sonItem8 = new MenuItem(drawable8, "H全部发文");
        MenuItem sonItem9 = new MenuItem(drawable9, "I全部发文");
        MenuItem sonItem10 = new MenuItem(drawable10, "J全部发文");
        MenuItem sonItem11 = new MenuItem(drawable1, "K全部发文");
        MenuItem sonItem12 = new MenuItem(drawable2, "L全部发文");
        MenuItem sonItem13 = new MenuItem(drawable3, "M全部发文");
        sonitems.add(sonItem1);
        sonitems.add(sonItem2);
        sonitems.add(sonItem3);
        sonitems.add(sonItem4);
        sonitems.add(sonItem5);
        sonitems.add(sonItem6);
        sonitems.add(sonItem7);
        sonitems.add(sonItem8);
        sonitems.add(sonItem9);
        sonitems.add(sonItem10);
        sonitems.add(sonItem11);
        sonitems.add(sonItem12);
        sonitems.add(sonItem13);

        MenuItem fartherItem1 = new MenuItem("A全部发文", sonitems);
        MenuItem fartherItem2 = new MenuItem("B全部发文", sonitems);
        MenuItem fartherItem3 = new MenuItem("C全部发文", sonitems);
        MenuItem fartherItem4 = new MenuItem("D全部发文", sonitems);
        MenuItem fartherItem5 = new MenuItem("E全部发文", sonitems);

        fartherItems.add(fartherItem1);
        fartherItems.add(fartherItem2);
        fartherItems.add(fartherItem3);
        fartherItems.add(fartherItem4);
        fartherItems.add(fartherItem5);
    }

    private void initView() {
        ListView listView = (ListView) findViewById(R.id.lv_farther);
        mParentAdapt = new ParentAdapt(this, fartherItems);
        mParentAdapt.setCallBack(new ParentAdapt.callBack() {
            @Override
            public void onAction(MenuItem menuItem) {
                Toast.makeText(PhoneMainActivity.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        listView.setAdapter(mParentAdapt);
        listView.setOnItemClickListener(new AdaptItemClick());
    }

    /**
     * 父listview的单击事件的监听
     */
    private class AdaptItemClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            selectSon = fartherItems.get(position).getSonitems();
            if (ParentAdapt.mParentItem == position && ParentAdapt.mbShowChild) {
                ParentAdapt.mbShowChild = false;
            } else {
                ParentAdapt.mbShowChild = true;
            }
            ParentAdapt.mParentItem = position;
            mParentAdapt.notifyDataSetChanged();
        }
    }

}
