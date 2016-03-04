package com.example.gridview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener{
	private GridView gridView;
	private SimpleAdapter simpleAdapter;
	private List<Map<String, Object>>datalist;
	private int[] icon = {R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,
			R.drawable.p7,R.drawable.p8,R.drawable.p9,R.drawable.p10,R.drawable.p11,R.drawable.p12,R.drawable.p13,
			R.drawable.p14,R.drawable.p15};
	private String[] iconName = {"猩猩","炸弹","总悟","蛋黄酱","萨达哈鲁","高杉","假发","凯瑟琳","神乐","土方","蛋黄饭","新八","伊丽莎白","银时","王子"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gridView = (GridView)findViewById(R.id.gridView1);
		//准备数据源
		//新建适配器（SimpleAdapter）
		//GridView加载适配器
		//GridView配置事件监听器（OnItemClickListener）
		datalist = new ArrayList<Map<String, Object>>();
		//getData();
		simpleAdapter = new SimpleAdapter(this, getData(), R.layout.item,
				new String[]{"image","text"}, new int[]{R.id.image,R.id.text});
		gridView.setAdapter(simpleAdapter);
		gridView.setOnItemClickListener(this);
	}

	private List<Map<String, Object>> getData() {
		// TODO Auto-generated method stub
		
		for(int i = 0;i < icon.length ;i++)
		{
			Map<String, Object> map  = new HashMap<String,Object>();
			map.put("image", icon[i]);
			map.put("text", iconName[i]);
			datalist.add(map);
		}
		return datalist;
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

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "我是"+iconName[position], Toast.LENGTH_SHORT).show();
	}
}
