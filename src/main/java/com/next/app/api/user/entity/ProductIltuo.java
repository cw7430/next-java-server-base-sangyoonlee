package com.next.app.api.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "`products_iltuo`")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductIltuo {

    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`name`", nullable = false)
    private String name;

    @Column(name = "`price`", precision = 12, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(name = "`description`", nullable = false)
    private String description;

}
