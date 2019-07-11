package com.jerry.study.generic;

import java.lang.reflect.ParameterizedType;

abstract class BaseDao<T>{
    private Session session;
    private Class clazz;

    public BaseDao(){
        Class clazz = this.getClass();
        ParameterizedType pt = (ParameterizedType)clazz.getGenericSuperclass();
        clazz = (Class)pt.getActualTypeArguments()[0];
        System.out.println(clazz);
    }

    public void add(T t){
        session.save(t);
    }

    public T find(String id){
        return (T) session.get(clazz, id);
    }

    public void update(T t){
        session.update(t);
    }

    public void delete(String id){
        session.delete(id);
    }
}

class Session<T>{
    public void save(T t){}
    public T get(Class<?> clazz, String id){ return null;}
    public void update(T t){};
    public void delete(String id){}
}

class Category{}
class Book{}

class CategoryDao extends BaseDao<Category>{}
class BookDao extends BaseDao<Book>{}

public class Practice {
    public static void main(String[] args){
        CategoryDao cd = new CategoryDao();
        cd.add(new Category());
        Category c = cd.find("123");
    }
}