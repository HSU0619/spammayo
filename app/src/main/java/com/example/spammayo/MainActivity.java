package com.example.spammayo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
        toggleButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    Toast.makeText(getApplicationContext(), "감시 시스템이 활성화되었습니다", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "감시 시스템이 비활성화되었습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ToggleButton toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);
        toggleButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    Toast.makeText(getApplicationContext(), "출처를 알 수 없는 앱 설치가 제한되었습니다", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "출처를 알 수 없는 앱 설치가 허용되었습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ImageButton Button1 = (ImageButton) findViewById(R.id.btn1);

        Button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

            ListView listView = findViewById(R.id.listView);
            ListAdapter adapter = new ListAdapter();
            adapter.addItem(new ListItem("spammoyo", "공지사항1", R.drawable.icon));
            adapter.addItem(new ListItem("spammoyo", "공지사항2", R.drawable.icon));
            adapter.addItem(new ListItem("spammoyo", "공지사항3", R.drawable.icon));
            adapter.addItem(new ListItem("spammoyo", "공지사항4", R.drawable.icon));
            adapter.addItem(new ListItem("spammoyo", "공지사항5", R.drawable.icon));
            adapter.addItem(new ListItem("spammoyo", "공지사항6", R.drawable.icon));
            adapter.addItem(new ListItem("spammoyo", "공지사항7", R.drawable.icon));
            listView.setAdapter(adapter);
        }


        class ListAdapter extends BaseAdapter {
            ArrayList<ListItem> items = new ArrayList<ListItem>();

            @Override
            public int getCount() {
                return items.size();
            }

            public void addItem(ListItem item) {
                items.add(item);
            }

            @Override
            public Object getItem(int position) {
                return items.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ListViewItem listViewItem = null;
                if (convertView == null) {
                    listViewItem = new ListViewItem(getApplicationContext());
                } else {
                    listViewItem = (ListViewItem) convertView;
                }
                ListItem item = items.get(position);
                listViewItem.setName(item.getName());
                listViewItem.setContent(item.getContent());
                listViewItem.setImage(item.getResId());
                return listViewItem;

            }
        }
    }