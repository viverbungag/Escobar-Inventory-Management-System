package com.exe.EscobarIMS.MenuCategory;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity(name = "menu_category")
public class MenuCategory {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long menuCategoryId;

    @Column(name = "menu_category_name")
    private String menuCategoryName;
}


