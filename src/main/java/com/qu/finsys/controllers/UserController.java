package com.qu.finsys.controllers;

import com.qu.finsys.config.AppConstants;
import com.qu.finsys.payloads.UserDTO;
import com.qu.finsys.payloads.UserResponse;
import com.qu.finsys.payloads.reports.UsersReportUnit;
import com.qu.finsys.services.UserService;
import io.swagger.v3.oas.annotations.Hidden;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
//@SecurityRequirement(name = "FinSys App")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/admin/users")
	public ResponseEntity<UserResponse> getUsers(
			@RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_USERS_BY, required = false) String sortBy,
			@RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIR, required = false) String sortOrder) {
		
		UserResponse userResponse = userService.getAllUsers(pageNumber, pageSize, sortBy, sortOrder);
		
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
	}
	
	@GetMapping("/public/users/{userId}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Long userId) {
		UserDTO user = userService.getUserById(userId);
		
		return new ResponseEntity<UserDTO>(user, HttpStatus.FOUND);
	}
	
	@PutMapping("/public/users/{userId}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long userId) {
		UserDTO updatedUser = userService.updateUser(userId, userDTO);
		
		return new ResponseEntity<UserDTO>(updatedUser, HttpStatus.OK);
	}

	@GetMapping("/public/users/generateUsersReport")
	public ResponseEntity<byte[]> generateUsersReport() throws FileNotFoundException, JRException {

		try{

			List<UsersReportUnit> usersList=new ArrayList<>();

			UsersReportUnit usersReportData =new UsersReportUnit();
			usersReportData.setFIRSTNAME("Ibrahim");
			usersReportData.setLASTNAME("QU");
			usersList.add(usersReportData);

			JRBeanCollectionDataSource dataSource = new
					JRBeanCollectionDataSource(usersList);


			Map<String, Object> usersParams = new HashMap<String, Object>();
			usersParams.put("University","QU");
			usersParams.put("Department","IT");

			JasperPrint empReport =
					JasperFillManager.fillReport
							(
									JasperCompileManager.compileReport(
											ResourceUtils.getFile("classpath:users_report.jrxml")
													.getAbsolutePath()) // path of the jasper report
									, usersParams // dynamic parameters
									, dataSource
							);

			HttpHeaders headers = new HttpHeaders();
			//set the PDF format
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("filename", "users_report.pdf");

			return new ResponseEntity<byte[]>
					(JasperExportManager.exportReportToPdf(empReport), headers, HttpStatus.OK);
		}catch (Exception e){
			System.out.println(e.getMessage());
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("/admin/users/{userId}")
	@Hidden
	//@PreAuthorize("users_deleteuser")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
		String status = userService.deleteUser(userId);
		
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
}
