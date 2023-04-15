package com.qu.finsys.payloads;

import com.qu.finsys.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private Long userId;
	private String username;
	private String mobileNumber;
	private String email;
	private String password;
	private Set<Role> roles = new HashSet<>();

}
