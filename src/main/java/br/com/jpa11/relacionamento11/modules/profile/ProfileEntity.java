package br.com.jpa11.relacionamento11.modules.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.jpa11.relacionamento11.modules.user.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "profiles")
@JsonIgnoreProperties(value = "user")
// jsonigorne aqui em cima é um quebra galho. o certo é
// usar um DTO

public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String hobby;

    @OneToOne(mappedBy = "profile")
    private UserEntity user;
}