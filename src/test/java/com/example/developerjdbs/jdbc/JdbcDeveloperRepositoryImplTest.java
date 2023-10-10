package com.example.developer.jdbc;

import com.example.developer.model.Developer;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class JdbcDeveloperRepositoryImplTest {

    Developer developer = new Developer();

    @Before
    public void setUp(){
        developer.setFirstName("FFF");
        developer.setLastName("LLL");
    }
    @Test
    public void shouldCreateDeveloperInstanceTest(){

//        assertEquals("FFF", developer.getLastName());
//        assertEquals("LLL", developer.getLastName());
    }
}
