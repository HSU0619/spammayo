package com.example.spammayo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.text.AttributedCharacterIterator;

public class ListViewItem extends LinearLayout {

    TextView textView, textView2;
    ImageView imageView;
    public ListViewItem(Context context){
        super(context);
        init(context);
    }

    public ListViewItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private  void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.listview_item,this, true);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);
    }
    public  void setName(String name){
        textView.setText(name);
    }
    public  void setContent(String content){
        textView2.setText(content);
    }
    public  void setImage(int resId){
        imageView.setImageResource(resId);
    }
}
