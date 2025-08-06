package com.example.corporateapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Bir departman bir şirkete aittir
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    // Bir departmanda birden fazla kullanıcı olabilir
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<User> users;
}
