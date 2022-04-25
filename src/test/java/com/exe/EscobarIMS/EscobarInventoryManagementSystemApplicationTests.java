package com.exe.EscobarIMS;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EscobarInventoryManagementSystemApplicationTests {

	@BeforeAll
	void beforeAllSetUp(){
		System.setProperty("java.awt.headless", "false");
	}

	@Test
	 void contextLoads(ApplicationContext context) {

	}

}
