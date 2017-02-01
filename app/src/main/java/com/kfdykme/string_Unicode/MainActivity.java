package com.kfdykme.string_Unicode;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import java.io.IOException;
import android.view.View.*;

public class MainActivity extends Activity 
{
	EditText et;
	TextView t;
	Button b;
	static int cha;
	EditText et2;
	EditText et3;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		et = (EditText)findViewById(R.id.mainEditText);
		et3 = (EditText)findViewById(R.id.mainTextView);
		b = (Button)findViewById(R.id.mainButton);
		et2 = (EditText)findViewById(R.id.numberEdit);
		
		b.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{	
					String s = et.getText().toString();
					cha =  Integer.valueOf( et2.getText().toString());
					s = string2Unicode(s);
					s = unicode2String(s);
					et3.setText(s);
					
				}
				
			
		});
    }
	
	
	
	public static String string2Unicode(String str){
		
		StringBuffer unicode = new StringBuffer();
		
		for (int i = 0 ; i < str.length();i++){
			
			char c = str.charAt(i);
			
			unicode.append("\\u" + Integer.toHexString(c));
		}
			return unicode.toString();
	}
	public static String unicode2String(String unicode) {

	    StringBuffer string = new StringBuffer();

	    String[] hex = unicode.split("\\\\u");

	    for (int i = 1; i < hex.length; i++) {

	        // 转换出每一个代码点
	        int data = Integer.parseInt(hex[i] , 16);
	        data = data + cha;
	        // 追加成string
	        string.append((char) data);
	    }

	    return string.toString();
	}
}
