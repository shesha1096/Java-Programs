package com.listeners;

import java.sql.Connection;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.utilities.DbUtility;

/**
 * Application Lifecycle Listener implementation class ContextListenerDemo
 *
 */
@WebListener
public class ContextListenerDemo implements ServletContextListener {
	private String url="";
	private String driverUrl="";
	private String dbusername="";
	private String dbpassword="";
	private Connection connection;
	
    /**
     * Default constructor. 
     */
    public ContextListenerDemo() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    	System.out.println("Context Initialized");
    	url= event.getServletContext().getInitParameter("url");
		driverUrl = event.getServletContext().getInitParameter("driver");
		dbusername = event.getServletContext().getInitParameter("dbusername");
		dbpassword = event.getServletContext().getInitParameter("dbpassword");
		DbUtility dbUtility = new DbUtility(url,driverUrl,dbusername,dbpassword);
		connection = DbUtility.getConnection();
		if(connection!=null)
		{
			System.out.println("Connected");
		}
		else
		{
			System.out.println("Not Connected");
		}
    }
    
	
}
