package com.example.ysuselfstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.os.Bundle;

import com.polites.android.GestureImageView;

/**
 * 校历的相关方法
 */
public class XiaoLiActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiao_li);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            XiaoLiActivity.this.getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        findViewById(R.id.layout).setFitsSystemWindows(false);
        getWindow().setStatusBarColor(Color.TRANSPARENT);



        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        GestureImageView view = new GestureImageView(this);
        view.setImageResource(R.drawable.back);
        view.setLayoutParams(params);

        ViewGroup layout = (ViewGroup) findViewById(R.id.layout);

        layout.addView(view);
    }
}
