package com.jerry.study.generic;

public class GenericClass<T> {
    private T obj;

    public T getObj(){
        return obj;
    }

    public void setObj(T obj){
        this.obj = obj;
    }

    public static void main(String[] args){
        GenericClass<String> tool = new GenericClass<>();

        tool.setObj("abc");
        String s = tool.getObj();
        System.out.println(s);

        GenericClass<Integer> objectTool = new GenericClass<>();
        objectTool.setObj(10);
        int i = objectTool.getObj();
        System.out.println(i);
    }
}
