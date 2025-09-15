package com.enterprise.ems.controllers;







import com.enterprise.ems.entities.Role;
import com.enterprise.ems.entities.User;
import com.enterprise.ems.repositories.RoleRepository;
import com.enterprise.ems.security.JwtUtil;
import com.enterprise.ems.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam String role) {

        Optional<User> userOpt = userService.findByUsername(username);

        if (userOpt.isPresent()) {
            User user = userOpt.get();

            if (user.getPassword().equals(password)) {
                // ✅ Check role
                boolean hasRole = user.getRoles().stream()
                        .anyMatch(r -> r.getName().equalsIgnoreCase(role));

                if (hasRole) {
                    String token = jwtUtil.generateToken(username, role);
                    return ResponseEntity.ok(Collections.singletonMap("token", token));
                }
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Role not assigned to user");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}
