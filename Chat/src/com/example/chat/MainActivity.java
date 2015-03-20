package com.example.chat;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {
	
	private ListView msgListView;
	private EditText inputText;
	private Button send;
	private MsgAdapter adapter;
	private List<Msg> msgList = new ArrayList<Msg>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        adapter = new MsgAdapter(MainActivity.this, R.layout.msg_item, msgList);
        inputText = (EditText)findViewById(R.id.input);
        send = (Button)findViewById(R.id.send);
        msgListView = (ListView)findViewById(R.id.msg_list);
        msgListView.setAdapter(adapter);
        
        send.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String content = inputText.getText().toString();
				if(!"".equals(content)){
					Msg msg = new Msg(content, Msg.TYPE_SEND);
					msgList.add(msg);
					adapter.notifyDataSetChanged();//有消息就刷新ListView的显示
					msgListView.setSelection(msgList.size());//定位到ListView的最后一行
					inputText.setText(""); //清空输入框
				}
			}
        	
        });
    }
    
   void init(){
	   Msg msg1 = new Msg("Hi further~", Msg.TYPE_RECEIVED);
	   msgList.add(msg1);
	   Msg msg2 = new Msg("Hello~", Msg.TYPE_SEND);
	   msgList.add(msg2);
	   Msg msg3 = new Msg("I like you blog very much!", Msg.TYPE_RECEIVED);
	   msgList.add(msg3);
   }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
