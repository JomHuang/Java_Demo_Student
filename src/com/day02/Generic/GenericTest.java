package src.com.day02.Generic;

import java.util.*;
import java.util.*;

/***
 * 泛型通配符
 * 1.类型通配符一般是使用?代替具体的类型参数。
 * 例如 List<?> 在逻辑上是List<String>,List<Integer> 等所有List<具体类型实参>的父类。
 *
 * 2、类型通配符上限通过形如List来定义，如此定义就是通配符泛型值接受Number及其下层子类类型。
 * */
public class GenericTest {
    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();

        name.add("icon");
        age.add(18);
        number.add(314);

        getData(name);
        getData(age);
        getData(number);

        //getUperNumber(name);//1
        getUperNumber(age);//2
        getUperNumber(number);//3
    }

    public static void getData(List<?> data) {
        System.out.println("data :" + data.get(0));
    }

    //限制类型
    public static void getUperNumber(List<? extends Number> data) {
        System.out.println("data :" + data.get(0));
    }
}
