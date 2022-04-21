package com.exe.EscobarIMS.MenuCategory;

import lombok.*;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.GenerationType.*;



@Entity(name = "menu_category")
public class MenuCategory {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long menuCategoryId;

    @Column(name = "menu_category_name")
    private String menuCategoryName;

    public MenuCategory() {
    }

    public MenuCategory(String menuCategoryName) {
        this.menuCategoryName = menuCategoryName;
    }

    public Long getMenuCategoryId() {
        return menuCategoryId;
    }


    public String getMenuCategoryName() {
        return menuCategoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuCategory that = (MenuCategory) o;
        return Objects.equals(menuCategoryId, that.menuCategoryId) && menuCategoryName.equals(that.menuCategoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuCategoryId, menuCategoryName);
    }

    @Override
    public String toString() {
        return "MenuCategory{" +
                "menuCategoryId=" + menuCategoryId +
                ", menuCategoryName='" + menuCategoryName + '\'' +
                '}';
    }
}




