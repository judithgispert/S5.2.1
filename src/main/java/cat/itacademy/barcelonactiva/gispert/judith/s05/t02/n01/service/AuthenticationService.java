package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.response.JwtAuthenticationResponse;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.request.SignInRequest;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.request.SignUpRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signUp(SignUpRequest request);
    JwtAuthenticationResponse signIn(SignInRequest request);
}
