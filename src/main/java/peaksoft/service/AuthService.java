package peaksoft.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.RegisterRequest;
import peaksoft.dto.request.LoginRequest;
import peaksoft.dto.response.SingUpResponse;

@Service
public interface AuthService {
    SingUpResponse login(LoginRequest request);

    ResponseEntity<?> registration(RegisterRequest request);
}
