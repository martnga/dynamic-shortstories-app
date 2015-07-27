package com.parse.starter;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by root on 7/27/15.
 */
@ParseClassName("TestObject")
public class TestObject  extends ParseObject{

    public String getTitle(){
        return getString("Title");
    }

    public void setName(String title){
        put("Title", title);
    }

    public String getbody(){
        return getString("body");
    }

    public void setBody(String body){
        put("body", body);
    }

    public String getimage(){
        return getString("image");
    }

    public void setimage(String image){
        put("image", image);
    }
}
