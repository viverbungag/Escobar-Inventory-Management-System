package com.exe.EscobarIMS;

import com.exe.EscobarIMS.MenuCategory.MenuCategoryForm.MenuCategoryForm;
import com.exe.EscobarIMS.Utilities.LookAndFeelUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.swing.*;

@SpringBootApplication
public class EscobarInventoryManagementSystemApplication {

	public static void main(String[] args) {
		LookAndFeelUtils.setWindowsLookAndFeel();
		ConfigurableApplicationContext context = createApplicationContext(args);
		displayMainFrame(context);
	}

	private static ConfigurableApplicationContext createApplicationContext(String[] args) {
		return new SpringApplicationBuilder(EscobarInventoryManagementSystemApplication.class)
				.headless(false)
				.run(args);
	}

	private static void displayMainFrame(ConfigurableApplicationContext context){
		SwingUtilities.invokeLater(()->{
			MenuCategoryForm menuCategoryForm = context.getBean(MenuCategoryForm.class);
			menuCategoryForm.setVisible(true);
		});
	}

}
