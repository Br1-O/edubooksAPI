package com.br1.edubooks.model.domain;

import com.br1.edubooks.model.dto.request.dtoUser_createData;
import com.br1.edubooks.model.dto.request.dtoUser_updateData;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name="users")
@Entity(name="User")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "INT default 1")
    private int role=1;

    @Column(name="plan_type_id", columnDefinition = "INT default 0")
    private Integer planTypeId=1;

    @Column(name="is_active", columnDefinition = "tinyint default 1")
    private Boolean isActive=true;

    @Column(name="is_activated", columnDefinition = "tinyint default 0")
    private Boolean isActivated=false;

    @Column(name="activation_code", unique = true)
    private String activationCode;

    @Column(name="recovery_code", unique = true)
    private String recoveryCode;

    @Column(name="recovery_code_expiration")
    private Date recoveryCodeExpiration;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastname;

    @Column
    private Date birthday;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    @Column(name="profile_picture")
    private String profilePicture;

    @Column
    private String bio;

    @Column(name="social_media_links")
    private String socialMediaLinks;

    @Embedded
    private Address Address;

    @Column(name="is_user_since", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp isUserSince;

    public User(dtoUser_createData user) {
        this.username=user.getUsername();
        this.password=user.getPassword();
        this.name=user.getName();
        this.lastname=user.getLastname();
        this.email=user.getEmail();
    }

    public void updateData(dtoUser_updateData dtoUser_updateData){

        if(dtoUser_updateData.username()!=null){
            this.setUsername(dtoUser_updateData.username());
        }
        if(dtoUser_updateData.password()!=null){
            this.setPassword(dtoUser_updateData.password());
        }
        if(dtoUser_updateData.name()!=null){
            this.setName(dtoUser_updateData.name());
        }
        if(dtoUser_updateData.lastname()!=null){
            this.setLastname(dtoUser_updateData.lastname());
        }
        if(dtoUser_updateData.phone()!=null){
            this.setPhone(dtoUser_updateData.phone());
        }
        if(dtoUser_updateData.email()!=null){
            this.setEmail(dtoUser_updateData.email());
        }
        if(dtoUser_updateData.address()!=null){
            this.setAddress(dtoUser_updateData.address());
        }
        if(dtoUser_updateData.birthday()!=null){
            this.setBirthday(dtoUser_updateData.birthday());
        }
        if(dtoUser_updateData.profilePicture()!=null){
            this.setProfilePicture(dtoUser_updateData.profilePicture());
        }
        if(dtoUser_updateData.bio()!=null){
            this.setBio(dtoUser_updateData.bio());
        }
        if(dtoUser_updateData.socialMediaLinks()!=null){
            this.setSocialMediaLinks(dtoUser_updateData.socialMediaLinks());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

