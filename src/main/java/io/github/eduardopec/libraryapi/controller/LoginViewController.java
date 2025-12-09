package io.github.eduardopec.libraryapi.controller;

import io.github.eduardopec.libraryapi.security.CustomAuthentication;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Tag(name = "Login")
public class LoginViewController {

    @GetMapping("/login")
    public String paginaLogin() {
        return "login";
    }

    @GetMapping("/")
    @ResponseBody
    @Operation(summary = "Login", description = "Login de usuario")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Login realizado"),
    })
    public String paginaHome(Authentication authentication) {
        if (authentication instanceof CustomAuthentication customAuthentication) {
            System.out.println(customAuthentication.getUsuario());
        }
        return "Olá " + authentication.getName();
    }
}
