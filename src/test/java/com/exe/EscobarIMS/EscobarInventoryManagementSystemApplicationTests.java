package com.exe.EscobarIMS;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = "spring.main.lazy-initialization=true")
class EscobarInventoryManagementSystemApplicationTests {

	@Test
	 void contextLoads(ApplicationContext context) {

	}

}
