package com.example.administrator.privateaccount.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.administrator.privateaccount.R;
import com.example.administrator.privateaccount.adapter.pictureAdapter;

public class MainActivity extends AppCompatActivity {

    private GridView gvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] titles = new String[]{"新增支出","新增收入","我的支出","我的收入","数据管理","系统设置","收支便签","退出"};
        int[] images = new int[]{R.drawable.addoutaccount,R.drawable.addinaccount,R.drawable.outaccountinfo,
        R.drawable.inaccountinfo,R.drawable.showinfo,R.drawable.sysset,R.drawable.accountflag,R.drawable.exit};
        gvInfo = (GridView)findViewById(R.id.gvInfo);
        pictureAdapter adapter = new pictureAdapter(titles,images,this);
        gvInfo.setAdapter(adapter);
        gvInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 1: {
                        intent = new Intent(MainActivity.this,addinaccunt.class);
                        startActivity(intent);

                        break;
                    }

                    case 3: {
                        intent = new Intent(MainActivity.this,showInAccountActivity.class);
                        startActivity(intent);

                        break;
                    }
                }
            }
        });
     }
}
