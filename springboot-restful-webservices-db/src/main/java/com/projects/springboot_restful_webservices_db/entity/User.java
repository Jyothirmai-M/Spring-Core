package com.projects.springboot_restful_webservices_db.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(
        name="users",
        schema="usermanagement",
        uniqueConstraints = {
                @UniqueConstraint(
                        name="email-unique",
                        columnNames="email"
        )
        }
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="user-sequence-generator"

    )
    @SequenceGenerator(name="user-sequence-generator",
            sequenceName = "user-sequence",
            allocationSize=1
    )
    @Column(nullable=false)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @CreationTimestamp
    @Column(name="created_time")
    private LocalDateTime createTime;

    public User(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
