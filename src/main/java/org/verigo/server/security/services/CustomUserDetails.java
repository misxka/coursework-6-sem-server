package org.verigo.server.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.verigo.server.data.entities.Course;
import org.verigo.server.data.entities.User;

import java.util.*;

public class CustomUserDetails implements UserDetails {
    private Integer id;

    private String login;

    private String email;

    private String fullname;

    private String role;

    private List<Course> courses;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(Integer id, String login, String email, String fullname, String role, List<Course> courses, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.fullname = fullname;
        this.role = role;
        this.courses = courses;
        this.password = password;
        this.authorities = authorities;
    }
    public static CustomUserDetails build(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new CustomUserDetails(
            user.getId(),
            user.getLogin(),
            user.getEmail(),
            user.getFullname(),
            user.getRole(),
            user.getCourses(),
            user.getPassword(),
            authorities
        );
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    public Integer getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getFullname() {
        return fullname;
    }
    public String getRole() {
        return role;
    }
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return login;
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
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CustomUserDetails user = (CustomUserDetails) o;
        return Objects.equals(id, user.id);
    }
}
