package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.service;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.dto.request.SignInRequest;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.dto.request.SignUpRequest;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signUp(SignUpRequest request);
    JwtAuthenticationResponse signIn(SignInRequest request);
}
