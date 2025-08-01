package com.next.app.api.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "`business_sangyoon`")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Business {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`business_number`", nullable = false)
    private String businessNumber;

    @Column(name = "`company_name`", nullable = false)
    private String companyName;

    @Column(name = "`representative_name`", nullable = false)
    private String representativeName;

    @Column(name = "`contact_email`", nullable = false)
    private String contactEmail;

    @Column(name = "`contact_phone`", nullable = false)
    private String contactPhone;

    @Column(name = "`address`", nullable = false)
    private String address;

    @Column(name = "`registered_at`", nullable = false)
    private LocalDateTime registeredAt;

    @PrePersist
    protected void onCreate() {
        registeredAt = LocalDateTime.now();
    }
}
