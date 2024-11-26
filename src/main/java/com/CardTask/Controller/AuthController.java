package com.CardTask.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.CardTask.JWTutility.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam Long userId, @RequestParam String password) {
        // Mock validation (replace with actual user validation)
    	if ("password123".equals(password)) {
    	    String token = jwtUtil.generateToken(userId);
    	    return ResponseEntity.ok("Bearer " + token);
    	}
    	return ResponseEntity.status(401).body("Invalid credentials");
    }
}
