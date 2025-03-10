package peaksoft.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.RegisterRequest;
import peaksoft.dto.response.LoginRequest;

@Service
public interface AuthService {
    ResponseEntity<?> login(LoginRequest request);

    ResponseEntity<?> registration(RegisterRequest request);
}
