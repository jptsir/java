package com.bean;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jingpengtao
 * @create 2021-11-14 12:58
 */
@Component
public class Msg {
    private Integer num;

    private String str;


    private Map<String, Object> map = new HashMap();


    public static Msg success() {
        Msg msg = new Msg();
        msg.setNum(200);
        msg.setStr("成功");
        return msg;

    }

    public static Msg fail() {
        Msg msg = new Msg();
        msg.setNum(100);
        msg.setStr("失败");
        return msg;
    }
    public Msg add(String pageinfo,Object obj){
        this.getMap().put(pageinfo, obj);
        return this;

    }

    public Msg() {
    }


    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "num=" + num +
                ", str='" + str + '\'' +
                ", map=" + map +
                '}';
    }



}
