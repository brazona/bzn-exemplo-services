package br.brazona.bzn_exemplo_services_users.domain.model;


import org.springframework.stereotype.Component;

@Component
public class UserModel {

    private Long id;
    private String email;

    public UserModel() {
    }

    
    public UserModel(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
