package com.rj.morefunction.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.rj.morefunction.adapter.ParentAdaptLeft;
import com.rj.morefunction.adapter.ParentAdaptRight;
import com.rj.morefunction.entity.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class IpadMainActivity extends Activity {

    private ParentAdaptLeft mParentAdaptLeft;
    private ParentAdaptRight mParentAdaptRight;
    private List<MenuItem> fartherItems_left, fartherItems_right;
    private List<MenuItem> sonitems1, sonitems2, sonitems3, sonitems4, sonitems5;
    public static List<MenuItem> selectSon_left, selectSon_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ipad_activity_main);
        initData();
        initView();
    }

    private void initData() {
        fartherItems_left = new ArrayList<>();
        fartherItems_right = new ArrayList<>();
        sonitems1 = new ArrayList<>();
        sonitems2 = new ArrayList<>();
        sonitems3 = new ArrayList<>();
        sonitems4 = new ArrayList<>();
        sonitems5 = new ArrayList<>();

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
        MenuItem sonItem1 = new MenuItem(drawable1, "A发文1");
        MenuItem sonItem2 = new MenuItem(drawable2, "B发文2");
        MenuItem sonItem3 = new MenuItem(drawable3, "C发文3");
        MenuItem sonItem4 = new MenuItem(drawable4, "D发文4");
        MenuItem sonItem5 = new MenuItem(drawable5, "E发文5");
        MenuItem sonItem6 = new MenuItem(drawable6, "F发文6");
        MenuItem sonItem7 = new MenuItem(drawable7, "G发文7");
        MenuItem sonItem8 = new MenuItem(drawable8, "H发文8");
        MenuItem sonItem9 = new MenuItem(drawable9, "I发文9");
        MenuItem sonItem10 = new MenuItem(drawable10, "J发文10");
        MenuItem sonItem11 = new MenuItem(drawable11, "K发文11");
        MenuItem sonItem12 = new MenuItem(drawable1, "L发文12");
        MenuItem sonItem13 = new MenuItem(drawable2, "M发文13");
        MenuItem sonItem14 = new MenuItem(drawable1, "N发文14");
        MenuItem sonItem15 = new MenuItem(drawable2, "O发文15");
        MenuItem sonItem16 = new MenuItem(drawable3, "P发文16");
        MenuItem sonItem17 = new MenuItem(drawable4, "Q发文17");
        MenuItem sonItem18 = new MenuItem(drawable5, "R发文18");
        MenuItem sonItem19 = new MenuItem(drawable6, "S发文19");
        MenuItem sonItem20 = new MenuItem(drawable7, "T发文20");
        MenuItem sonItem21 = new MenuItem(drawable8, "U发文21");
        MenuItem sonItem22 = new MenuItem(drawable9, "V发文22");
        MenuItem sonItem23 = new MenuItem(drawable10, "W发文23");
        MenuItem sonItem24 = new MenuItem(drawable11, "X发文24");
        MenuItem sonItem25 = new MenuItem(drawable1, "Y发文25");
        MenuItem sonItem26 = new MenuItem(drawable2, "Z发文26");

        sonitems1.add(sonItem1);
        sonitems1.add(sonItem2);
        sonitems1.add(sonItem3);
        sonitems1.add(sonItem4);
        sonitems1.add(sonItem5);
        sonitems2.add(sonItem6);
        sonitems2.add(sonItem7);
        sonitems2.add(sonItem8);
        sonitems3.add(sonItem9);
        sonitems3.add(sonItem10);
        sonitems4.add(sonItem11);
        sonitems4.add(sonItem12);
        sonitems4.add(sonItem13);
        sonitems5.add(sonItem14);
        sonitems5.add(sonItem15);
        sonitems5.add(sonItem16);
        sonitems5.add(sonItem17);
        sonitems5.add(sonItem18);
        sonitems5.add(sonItem19);
        sonitems5.add(sonItem20);
        sonitems5.add(sonItem21);
        sonitems5.add(sonItem22);
        sonitems5.add(sonItem23);
        sonitems5.add(sonItem24);
        sonitems5.add(sonItem25);
        sonitems5.add(sonItem26);

        MenuItem fartherItem1 = new MenuItem("A全部发文", sonitems1);
        MenuItem fartherItem2 = new MenuItem("B全部发文", sonitems2);
        MenuItem fartherItem3 = new MenuItem("C全部发文", sonitems3);
        MenuItem fartherItem4 = new MenuItem("D全部发文", sonitems4);
        MenuItem fartherItem5 = new MenuItem("E全部发文", sonitems5);

        fartherItems_left.add(fartherItem1);
        fartherItems_right.add(fartherItem2);
        fartherItems_left.add(fartherItem3);
        fartherItems_right.add(fartherItem4);
        fartherItems_left.add(fartherItem5);
    }

    private void initView() {
        ListView listViewLeft = (ListView) findViewById(R.id.lv_farther_left);
        mParentAdaptLeft = new ParentAdaptLeft(this, fartherItems_left);
        //回调，点击item要执行什么动作
        mParentAdaptLeft.setCallBack(new ParentAdaptLeft.callBack() {
            @Override
            public void onAction(MenuItem menuItem) {
                Toast.makeText(IpadMainActivity.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        listViewLeft.setAdapter(mParentAdaptLeft);
        listViewLeft.setOnItemClickListener(new AdaptItemClickLeft());

        ListView listViewRight = (ListView) findViewById(R.id.lv_farther_right);
        mParentAdaptRight = new ParentAdaptRight(this, fartherItems_right);
        //回调，点击item要执行什么动作
        mParentAdaptRight.setCallBack(new ParentAdaptRight.callBack() {
            @Override
            public void onAction(MenuItem menuItem) {
                Toast.makeText(IpadMainActivity.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        listViewRight.setAdapter(mParentAdaptRight);
        listViewRight.setOnItemClickListener(new AdaptItemClickRight());
    }

    /**
     * 左边父listview的单击事件的监听
     */
    private class AdaptItemClickLeft implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            selectSon_left = fartherItems_left.get(position).getSonitems();
            if (ParentAdaptLeft.mParentItem == position && ParentAdaptLeft.mbShowChild) {
                ParentAdaptLeft.mbShowChild = false;
            } else {
                ParentAdaptLeft.mbShowChild = true;
            }
            ParentAdaptLeft.mParentItem = position;
            mParentAdaptLeft.notifyDataSetChanged();
        }
    }

    /**
     * 右边父listview的单击事件的监听
     */
    private class AdaptItemClickRight implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            selectSon_right = fartherItems_right.get(position).getSonitems();
            if (ParentAdaptRight.mParentItem == position && ParentAdaptRight.mbShowChild) {
                ParentAdaptRight.mbShowChild = false;
            } else {
                ParentAdaptRight.mbShowChild = true;
            }
            ParentAdaptRight.mParentItem = position;
            mParentAdaptRight.notifyDataSetChanged();
        }
    }

}
