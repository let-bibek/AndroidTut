package com.softdrax.androidtut;

public class ObjectCall {
    public static void main(String[] args){
        ObjectCall obj=new ObjectCall();
        obj.call();
        ConstructorC con=new ConstructorC(12);
    }
    public void call(){
        ObjectInit ob=new ObjectInit();
        int res=ob.adder(2,8);
        System.out.println(res);
    }

}
