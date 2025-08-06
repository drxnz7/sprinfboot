package com.example.corporateapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Bir şirketin birden fazla departmanı olabilir
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Department> departments;

    // Bir şirketin birden fazla kullanıcısı olabilir
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<User> users;
}
