package com.rest.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Assert;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testApiTest()
    {
        EntryPoint entryPoint = new EntryPoint();
        String result = entryPoint.test();
        assertEquals(result, "Test");
    }    
    
    public void testApiTestDeployment()
    {
        EntryPoint entryPoint = new EntryPoint();
        String result = entryPoint.testDeployment().replace("\\", "\\\\");
        String expectedResult = "Response from 'http://192.168.1.143:8080/entry-point/test' => Test".replace("\\", "\\\\");
        assertEquals(result, expectedResult);
    }
}
