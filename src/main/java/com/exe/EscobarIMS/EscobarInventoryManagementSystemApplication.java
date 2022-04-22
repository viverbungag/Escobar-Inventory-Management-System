package com.exe.EscobarIMS;

import com.exe.EscobarIMS.MainMenu.MainMenuForm;
import com.exe.EscobarIMS.MenuCategory.AddMenuCategory.Forms.AddMenuCategoryForm;
import com.exe.EscobarIMS.MenuCategory.ViewEditDeleteMenuCategory.Forms.ViewEditDeleteMenuCategoryForm;
import com.exe.EscobarIMS.Utilities.LookAndFeelUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

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
			MainMenuForm mainMenuForm = context.getBean(MainMenuForm.class);
			mainMenuForm.setVisible(true);
		});
	}

}
