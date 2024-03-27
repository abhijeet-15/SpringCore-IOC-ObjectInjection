package com.abhijeetsingh;

import com.abhijeetsingh.betterWay.BetterStudent;
import com.abhijeetsingh.wrongWay.MathCheat;
import com.abhijeetsingh.wrongWay.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        //Wrong Way
//        Student student = new Student(new MathCheat());
//        student.cheat();

        //Better way
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        BetterStudent student = context.getBean("betterStudent", BetterStudent.class);
        student.cheat();
    }
}