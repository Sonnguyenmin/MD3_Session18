package com.ra.springorm_hibernate.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @Column(name = "category_name", length = 100, nullable = false, unique = true)
    private String categoryName;
    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
