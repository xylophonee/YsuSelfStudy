package com.example.ysuselfstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import yuan.data.EmptyRoom;
import yuan.data.RoomExAdapter;
import yuan.data.SchoolBuilding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static ImageView image;
    TextView textView;
    TextView Today;
    String temp;
    ArrayList<SchoolBuilding> grouplist;
    ArrayList<List> childlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //每日必应图片
        image=(ImageView) findViewById(R.id.image);
        loadImage(image);

        //图片上显式的字
        Today=findViewById(R.id.text);
        Today.setText(AllString.Today);

        //时间的点击触发底部弹窗
        textView=(TextView) findViewById(R.id.showTime);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DemoPopup(MainActivity.this).showPopupWindow();
            }
        });

        initdata();
        ExpandableListView expandableListView=(ExpandableListView) findViewById(R.id.expand_list);
        RoomExAdapter roomExAdapter = new RoomExAdapter(this,
                R.layout.parent_item,
                R.layout.child_item,
                grouplist,
                childlist);
        expandableListView.setAdapter(roomExAdapter);

    }
        /*
        * 加载必应每日一图，可以通过 Jsoup 来实现。
        * 这里还没有准备好
        * */
    private void loadImage(final ImageView imageView) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //子线程获取地址
               temp=Spider.SearchForBiYing();

                //切换到主线程进行更新
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(MainActivity.this ).load(temp).into(imageView);
                    }
                });
            }
        }).start();


    }

    private  void initdata()
    {
        grouplist=new ArrayList<>();
        childlist =new ArrayList<>();

        grouplist.add(new SchoolBuilding("东区"));
        grouplist.add(new SchoolBuilding("西区"));

        ArrayList xs =new ArrayList<>();
        xs.add(new EmptyRoom("第一教学楼",16,"东"));
        xs.add(new EmptyRoom("第二教学楼",16,"东"));
        xs.add(new EmptyRoom("第三教学楼",16,"东"));
        childlist.add(xs);

        ArrayList bg =new ArrayList<>();
        bg.add(new EmptyRoom("第4教学楼",16,"东"));
        bg.add(new EmptyRoom("第6教学楼",16,"东"));
        bg.add(new EmptyRoom("第7教学楼",16,"东"));
        childlist.add(bg);

    }
}
