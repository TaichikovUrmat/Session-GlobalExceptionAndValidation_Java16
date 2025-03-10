package peaksoft.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peaksoft.dto.request.RegisterRequest;
import peaksoft.dto.response.LoginRequest;
import peaksoft.service.AuthService;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthAPI {
    private final AuthService authService;

    // sign-in
    @PostMapping("/sign-in")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
       return authService.login(request);
    }

    //sign-up
    @PostMapping("/sign-up")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest request){
        return authService.registration(request);
    }
}
