package com.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.utilities.DbConnection;

/**
 * Application Lifecycle Listener implementation class SessionListenerDemo
 *
 */
@WebListener
public class SessionListenerDemo implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SessionListenerDemo() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    	String url = event.getServletContext().getInitParameter("url");
    	String DbUrl = event.getServletContext().getInitParameter("driver");
    	String username = event.getServletContext().getInitParameter("dbusername");
    	String password = event.getServletContext().getInitParameter("dbpassword");
    	DbConnection dbConnection = new DbConnection(url,DbUrl,username,password);
    	if(dbConnection.getConnection()!=null)
    	{
    		System.out.println("Connected");
    	}
    	else
    	{
    		System.out.println("Not Connected");
    	}
    }
	
}
