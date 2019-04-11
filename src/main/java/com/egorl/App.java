package com.egorl;

import com.egorl.view.AppCreator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {
        ApplicationContext context =new  AnnotationConfigApplicationContext(ViewsConfiguration.class);
        AppCreator mainWindow = (AppCreator) context.getBean("appCreator");
        mainWindow.createApp();
        System.out.println( "Hello World!" );
    }
}


