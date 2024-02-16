package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.controller;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.request.SignInRequest;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.request.SignUpRequest;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.response.JwtAuthenticationResponse;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth") 
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signUp")
    public ResponseEntity<JwtAuthenticationResponse> signUp(@RequestBody SignUpRequest request){
        return ResponseEntity.ok(authenticationService.signUp(request));
    }

    @PostMapping("/signIn")
    public ResponseEntity<JwtAuthenticationResponse> signIp(@RequestBody SignInRequest request){
        return ResponseEntity.ok(authenticationService.signIn(request));
    }
}
