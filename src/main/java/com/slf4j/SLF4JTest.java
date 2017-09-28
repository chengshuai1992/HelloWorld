package com.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class SLF4JTest 
{
    public static void main( String[] args ) throws Exception, IllegalAccessException
    {
    	//logger 
    	Logger LOG  =LoggerFactory.getLogger(SLF4JTest.class);
    	LOG.info("hello");
        
    }
}