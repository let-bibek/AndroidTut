package com.softdrax.androidtut;

public class ObjectCall {
    public static void main(String[] args){
        ObjectCall obj=new ObjectCall();
        obj.call();
    }
    public void call(){
        ObjectInit ob=new ObjectInit();
        int res=ob.adder(2,8);
        System.out.println(res);
    }

}
