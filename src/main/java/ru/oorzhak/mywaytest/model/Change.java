package ru.oorzhak.mywaytest.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "CHANGES")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Change {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "val", nullable = false)
    private Long value;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
}
