package com.example.t11;

import org.xmlpull.v1.XmlPullParser;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	private TextView textView1;
	private Button button1;
	private boolean setFlag;
	private MenuInflater mi;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Menu
		mi = new MenuInflater(this);
		
		setContentView(R.layout.activity_main);
		textView1=(TextView)findViewById(R.id.TextView1);
		button1=(Button)findViewById(R.id.Button1);
		setFlag=true;
		button1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				StringBuilder sb= new StringBuilder("");
				int counter=0;
				Resources r = getResources();
				XmlResourceParser xrp = r.getXml(R.xml.test);
				try{
					while(xrp.getEventType()!= XmlResourceParser.END_DOCUMENT){
						if(xrp.getEventType()==XmlResourceParser.START_TAG){
							String name=xrp.getName();
							if(name.equals("customer")){
								sb.append("No."+counter+" customer");
								sb.append(xrp.getAttributeValue(0)+" ");
								sb.append(xrp.getAttributeValue(1)+" ");
								sb.append(xrp.getAttributeValue(2)+" ");
								sb.append(xrp.getAttributeValue(3)+" \n");
								counter++;
							}
							else if(xrp.getEventType()==XmlPullParser.END_TAG){}
							else if(xrp.getEventType()==XmlPullParser.TEXT){
					
							}		
							
						}
						xrp.next();
					}
					textView1.setText(sb.toString());
					
				}catch(Exception e){
					e.printStackTrace();
				};
				
				//textView1.setText("Done");
				
		}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		mi.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch(item.getItemId()){
		case R.id.about:
			Dialog alertDialog = new AlertDialog.Builder(this). 
            setTitle("确定删除？"). 
            setMessage("您确定删除该条信息吗？"). 
            setIcon(R.drawable.ic_launcher). 
            setPositiveButton("确定", new DialogInterface.OnClickListener() { 
                 
                @Override 
                public void onClick(DialogInterface dialog, int which) { 
                    // TODO Auto-generated method stub  
                } 
            }). 
            setNegativeButton("取消", new DialogInterface.OnClickListener() { 
                 
                @Override 
                public void onClick(DialogInterface dialog, int which) { 
                    // TODO Auto-generated method stub  
                } 
            }). 
            setNeutralButton("查看详情", new DialogInterface.OnClickListener() { 
                 
                @Override 
                public void onClick(DialogInterface dialog, int which) { 
                    // TODO Auto-generated method stub  
                } 
            }).create();
			alertDialog.show();
			break;
		case R.id.exit:
			break;
		}
		return true;
	}
}
