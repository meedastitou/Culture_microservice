package com.culture.culture.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.culture.culture.Service.MonumentService;


@Controller
@RequestMapping("/api/v1/culturelle/monument/")
public class MonumentController {

	@Autowired
	private MonumentService monumentService;

	@GetMapping
	public String getAllMonuments() {
//		List<Monument> monuments = this.monumentService.getAll();
//		return monuments.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("No monument available")
//				: ResponseEntity.ok(monuments);
		return "x";
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getMonumentById(@PathVariable String id) {
		return ResponseEntity.ok(this.monumentService.getOne(id));
	}

//	@Secured({ RoleName.ROLE_ADMIN, RoleName.ROLE_CULTURELLE })
	@PostMapping
	public ResponseEntity<?> createMonument(@RequestParam("photo") MultipartFile file,
			@Valid @RequestPart("data") Monument monument) {
		try {
			monument.setPhoto(file.getBytes());
			monument = this.monumentService.save(monument);
			return ResponseEntity.ok(monument);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

//	@Secured({ RoleName.ROLE_ADMIN, RoleName.ROLE_CULTURELLE })
	@PutMapping("/{id}")
	public ResponseEntity<?> updateMonument(@RequestBody Monument monument) {
		try {
			return ResponseEntity.ok(this.monumentService.save(monument));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

//	@Secured({ RoleName.ROLE_ADMIN, RoleName.ROLE_CULTURELLE })
	@DeleteMapping("/{monument}")
	public ResponseEntity<?> deleteMonument(@PathVariable Monument monument) {
		try {
			this.monumentService.delete(monument);
			return ResponseEntity.ok("Successfully deleted Monument with id " + monument.getId());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
