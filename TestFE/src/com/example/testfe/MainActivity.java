package com.example.testfe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.testfe.Constant;
import com.example.testfe.R;
import com.example.testfe.Winset;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	int id;
	int reservedId = 0;
	int index;
	Map<Integer, Integer> map; // hashmap of button IDs and indices
	List<Integer> indexArray;
	int p1Placement;
	int p2BtId;
	boolean init = true;
	List<Map<Integer, String>> winSet;
	Map<String, Integer> individualSetState;
	int p2ButtonId;
	Map<Integer, String> testMap;
	Winset w;
	List<Map<Integer, String>> winset;
	List<Map<String, Integer>> setstate;
	int turn = 1;
	
	
	TextView tv;
	Button button0;
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button button6;
	Button button7;
	Button button8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d("Hui", "run onCreate()");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		
		
		button0 = (Button)findViewById(R.id.button1);
		button1 = (Button)findViewById(R.id.button2);
		button2 = (Button)findViewById(R.id.button3);
		button3 = (Button)findViewById(R.id.button4);
		button4 = (Button)findViewById(R.id.button5);
		button5 = (Button)findViewById(R.id.button6);
		button6 = (Button)findViewById(R.id.button7);
		button7 = (Button)findViewById(R.id.button8);
		button8 = (Button)findViewById(R.id.button9);
		
		testMap = new HashMap<Integer, String>();
		testMap.put(R.id.button1, button0.getText().toString());
		testMap.put(R.id.button2, button1.getText().toString());
		testMap.put(R.id.button3, button2.getText().toString());
		testMap.put(R.id.button4, button3.getText().toString());
		testMap.put(R.id.button5, button4.getText().toString());
		testMap.put(R.id.button6, button5.getText().toString());
		testMap.put(R.id.button7, button6.getText().toString());
		testMap.put(R.id.button8, button7.getText().toString());
		testMap.put(R.id.button9, button8.getText().toString());
		
		setListener(button0);
		setListener(button1);
		setListener(button2);
		setListener(button3);
		setListener(button4);
		setListener(button5);
		setListener(button6);
		setListener(button7);
		setListener(button8);
		
		
	}


	
	protected void printMessage(String msg){
		tv = (TextView)findViewById(R.id.textView1);
		tv.setText(msg);
	}
	
	
	protected void setListener(Button bt){
		w = new Winset();
		winset = w.getWinSet();
		setstate = new ArrayList<Map<String, Integer>>();
			
		bt.setOnClickListener(new OnClickListener(){
			//MainActivity ma = new MainActivity();

			@Override
			public void onClick(View v) {
				
				Button bt2;
				id = v.getId(); 
				((Button)v).setText(Constant.CROSS);
				//p1Placement = getIndex(id, map);
				printMessage("Button " + id + " is clicked");
				
				/// check state of game 
				/// if player 1 doesn't win 
				/// then trigger placement for player 2
				
				testMap.put(id, Constant.CROSS);
				printMessage("id: " + id + "; " + Constant.CROSS);
				
				
				printMessage("sum = " + String.format("%d", w.Add(2, 3)));
				
//				w.updateTestMap(testMap);
				w.updateWinSet(winset, testMap);
				printMessage("run updateWinSet()");
//				setstate = w.updateState(winset);
//				printMessage("run updateState()");
				
				
//				printMessage(String.valueOf(w.checkState(setstate, turn)));
				
//				if (w.checkState(w.setState, turn) == true) {		
//					System.exit(0);
//				}
//				else if (turn == 1) {
//					p2BtId = w.getBtIdForCircle(w.setState, turn, testMap);
//					if (p2BtId == -2){
//						printMessage("Game Over");
//						//System.exit(0);
//					}
//					else {
//						bt2 = (Button)findViewById(p2BtId);
//						bt2.setText(Constant.CIRCLE);
//						testMap.put(p2BtId, Constant.CIRCLE);
//						w.updateTestMap(testMap);
//						w.updateWinSet(winset, testMap);
//						w.updateState(winset);		
//						if (w.checkState(w.setState, turn) == true) {		
//							//System.exit(0);
//							printMessage("Game Over");
//						}
//						else {
//							turn = 1;
//						}
//					}	
//				}
				
			}
		});
	}
	

	
}
