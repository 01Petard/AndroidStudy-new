package com.hzxcompany.androidstudy.AboutAdapter.ListView;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String banji;
    private String name;
    private int age;
    public Student() {
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student(String banji,String name, int age) {
        this.banji = banji;
        this.name = name;
        this.age = age;
    }
    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getData(){
        List<Student> stuList=new ArrayList<>();
        stuList.add(new Student("18软工1","张三",18));
        stuList.add(new Student("18软工2","李四",21));
        stuList.add(new Student("18软工（UI）1","黄泽校",20));
        stuList.add(new Student("17软工1","王五",19));
        stuList.add(new Student("17软工2","赵六",20));
        stuList.add(new Student("17软工（UI）1","钱七",18));
        stuList.add(new Student("18软工1","张三",18));
        stuList.add(new Student("18软工2","李四",21));
        stuList.add(new Student("18软工（UI）1","黄泽校",20));
        stuList.add(new Student("17软工1","王五",19));
        stuList.add(new Student("17软工2","赵六",20));
        stuList.add(new Student("17软工（UI）1","钱七",18));
        stuList.add(new Student("18软工1","张三",18));
        stuList.add(new Student("18软工2","李四",21));
        stuList.add(new Student("18软工（UI）1","黄泽校",20));
        stuList.add(new Student("17软工1","王五",19));
        stuList.add(new Student("17软工2","赵六",20));
        stuList.add(new Student("17软工（UI）1","钱七",18));
        stuList.add(new Student("18软工1","张三",18));
        stuList.add(new Student("18软工2","李四",21));
        stuList.add(new Student("18软工（UI）1","黄泽校",20));
        stuList.add(new Student("17软工1","王五",19));
        stuList.add(new Student("17软工2","赵六",20));
        stuList.add(new Student("17软工（UI）1","钱七",18));
        stuList.add(new Student("18软工1","张三",18));
        stuList.add(new Student("18软工2","李四",21));
        stuList.add(new Student("18软工（UI）1","黄泽校",20));
        stuList.add(new Student("17软工1","王五",19));
        stuList.add(new Student("17软工2","赵六",20));
        stuList.add(new Student("17软工（UI）1","钱七",18));
        stuList.add(new Student("18软工1","张三",18));
        stuList.add(new Student("18软工2","李四",21));
        stuList.add(new Student("18软工（UI）1","黄泽校",20));
        stuList.add(new Student("17软工1","王五",19));
        stuList.add(new Student("17软工2","赵六",20));
        stuList.add(new Student("17软工（UI）1","钱七",18));
        stuList.add(new Student("18软工1","张三",18));
        stuList.add(new Student("18软工2","李四",21));
        stuList.add(new Student("18软工（UI）1","黄泽校",20));
        stuList.add(new Student("17软工1","王五",19));
        stuList.add(new Student("17软工2","赵六",20));
        stuList.add(new Student("17软工（UI）1","钱七",18));
        stuList.add(new Student("18软工1","张三",18));
        stuList.add(new Student("18软工2","李四",21));
        stuList.add(new Student("18软工（UI）1","黄泽校",20));
        stuList.add(new Student("17软工1","王五",19));
        stuList.add(new Student("17软工2","赵六",20));
        stuList.add(new Student("17软工（UI）1","钱七",18));
        stuList.add(new Student("18软工1","张三",18));
        stuList.add(new Student("18软工2","李四",21));
        stuList.add(new Student("18软工（UI）1","黄泽校",20));
        stuList.add(new Student("17软工1","王五",19));
        stuList.add(new Student("17软工2","赵六",20));
        stuList.add(new Student("17软工（UI）1","钱七",18));
        return stuList;
    }
}
