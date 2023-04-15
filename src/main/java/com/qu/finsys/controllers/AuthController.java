package com.qu.finsys.controllers;

import com.qu.finsys.exceptions.UserNotFoundException;
import com.qu.finsys.payloads.LoginCredentials;
import com.qu.finsys.payloads.UserDTO;
import com.qu.finsys.security.JWTUtil;
import com.qu.finsys.services.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "FinSys App")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public ResponseEntity<Map<String, Object>> registerHandler(@Valid @RequestBody UserDTO user) throws UserNotFoundException {
		String encodedPass = passwordEncoder.encode(user.getPassword());

		user.setPassword(encodedPass);

		UserDTO userDTO = userService.registerUser(user);

		String token = jwtUtil.generateToken(userDTO.getEmail());

		return new ResponseEntity<Map<String, Object>>(Collections.singletonMap("jwt-token", token),
				HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public Map<String, Object> loginHandler(@Valid @RequestBody LoginCredentials credentials) {

		UsernamePasswordAuthenticationToken authCredentials = new UsernamePasswordAuthenticationToken(
				credentials.getEmail(), credentials.getPassword());

		authenticationManager.authenticate(authCredentials);

		String token = jwtUtil.generateToken(credentials.getEmail());
		UserDTO userDTO=userService.getUserByEmail(credentials.getEmail());
		userDTO.setPassword("");
		Map<String,Object> rs=new HashMap<>();
		rs.put("accessToken", token);
		rs.put("user",userDTO);



		//return Collections.map .Map(["jwt-token", token]);
		return rs;
	}
}