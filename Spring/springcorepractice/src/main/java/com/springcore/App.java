package com.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
//        College myCollege = (College)context.getBean("collegeObj");
//        College myCollege2 = (College)context.getBean("collegeObj");
//        
//        System.out.println(myCollege);
        
        
        CollegeCollection myCollection = (CollegeCollection) context.getBean("myData");
        
        System.out.println(myCollection);
        System.out.println(myCollection.getCollegeIdList());
        System.out.println(myCollection.getCollegeIdList().getClass().getName());
    }
}
