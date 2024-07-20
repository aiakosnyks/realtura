package com.realtura.realturamain.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name_surname")
    private String nameSurname;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "country")
    private String country;
//    @Column(name = "profile_picture")
//    @Lob
//    private byte[] profilePicture;
//    @Column(name = "subscription_duration")
//    private Period subscriptionDuration;
//    @Column(name = "subscribed_until")
//    private LocalDateTime subscribedUntil = LocalDateTime.now();

    public void User(String nameSurname, String username, String email, String password) {
        this.nameSurname = nameSurname;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
