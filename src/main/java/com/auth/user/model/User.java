package com.auth.user.model;

import com.auth.user.model.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
@Table(name = "users", schema = "util_sch")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password")
    private String password;
    @Column(name = "age")
    private int age;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "nationality")
    private String nationality;

}
