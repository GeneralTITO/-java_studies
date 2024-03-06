package br.com.teste.myapp;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class primeiraRotaPost {
    @PostMapping("/primeira_rota_post")
    public String create() {
        return "minha primeira rota post";
    };
}
