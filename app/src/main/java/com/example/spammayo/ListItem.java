package com.example.spammayo;

public class ListItem {
    String name;
    String Content;
    int resId;
    private String content;

    public ListItem(String name, String Content, int resId){
        this.name=name;
        this.Content=Content;
        this.resId=resId;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getContent(){
        return Content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public int getResId(){
        return resId;
    }
    @Override
    public String toString(){
        return  "ListItem{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' + '}';
    }
}
