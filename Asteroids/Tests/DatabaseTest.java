package Tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import database.Database;

public class DatabaseTest
{
    private Database database;
    
    // Will read database properties, getConnection
    @Before
    public void setUpDatabase() throws Exception
    {
        database = new Database();
    }
    
    @Test 
    public void testCreateAccount()
    {
        String username = "JaneDoe";
        String password = "password";
        boolean oldAccount = database.createNewAccount(username, password);
        assertTrue("Account created already", oldAccount);
        
    }
    @Test
    public void verifyAccount()
    {
        String username = "JaneDoe";
        String password = "password";
        boolean found = database.verifyAccount(username, password);
        
        if (!found)
        {
            fail("Account not found/Does not exist");
        }
    }
}
