package com.example.administrator.privateaccount.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.privateaccount.R;
import com.example.administrator.privateaccount.dao.Tb_inaccount;
import com.example.administrator.privateaccount.db.AccountDB;

import java.util.List;

public class showInAccountActivity extends AppCompatActivity {

    private static final String FLAG = "id";
    private ListView listView;
    private String strType = "";
    private String[] strInfos = null;
    private ArrayAdapter<String> adapter = null;
    private List<Tb_inaccount> tb_inaccountList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_in_account);
        listView = (ListView) findViewById(R.id.InAccountListView);
        AccountDB accountDB = AccountDB.getInstance(showInAccountActivity.this);
        tb_inaccountList = accountDB.queryTb_inaccount();
        strInfos = new String[tb_inaccountList.size()];
        int i = 0;
        for(Tb_inaccount tb_inaccount:tb_inaccountList) {
            strInfos[i] = tb_inaccount.get_id()+ "|" +tb_inaccount.getType()+" "+ tb_inaccount.getMoney()+"元 "+tb_inaccount.getTime();
            i++;
        }
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strInfos);
        listView.setAdapter(adapter);


    }
}
