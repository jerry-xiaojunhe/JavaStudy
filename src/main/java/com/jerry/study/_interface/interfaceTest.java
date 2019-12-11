package com.jerry.study._interface;

import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * @auther Jerry
 */
public interface interfaceTest {
    static Path get(String first, String... more){
        return FileSystems.getDefault().getPath(first, more);
    }

    default void show(){
        System.out.println("this is in the interface");
    }
}
