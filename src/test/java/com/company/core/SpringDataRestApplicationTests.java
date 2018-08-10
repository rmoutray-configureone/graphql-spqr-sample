package com.company.core;

import javax.naming.NamingException;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringDataRestApplicationTests {
    
        @BeforeClass
        public static void setUp() throws NamingException {
            //SimpleNamingContextBuilder builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
            //builder.bind("java:comp/env/jdbc/concept", new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build());
        }

	@Test
	public void contextLoads() {
	}

}
