package br.edu.ifsp.ar.postodw.controler;

import br.edu.ifsp.ar.postodw.model.User;
import br.edu.ifsp.ar.postodw.repository.UserRepository;
import br.edu.ifsp.ar.postodw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_SEARCH_USER') and #oauth2.hasScope('read')")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	//@PreAuthorize("hasAuthority('ROLE_REGISTER_USER') and #oauth2.hasScope('write')")
	public User create(@Valid @RequestBody User user, 
			HttpServletResponse response) {
		return userService.save(user);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_GERENCIA') and #oauth2.hasScope('read')")
	public ResponseEntity<User> findById(@PathVariable Long id){
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_GERENCIA') and #oauth2.hasScope('write')")
	public void remove(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_GERENCIA') and #oauth2.hasScope('write')")
	public ResponseEntity<User> update(@PathVariable Long id,
			@Valid @RequestBody User user){
		User userSaved = userService.update(id, user);
		return ResponseEntity.ok(userSaved);
	}
	
	@PutMapping("/{id}/active")
	@PreAuthorize("hasAuthority('ROLE_GERENCIA') and #oauth2.hasScope('write')")
	public void updateActiveProperty(
			@PathVariable Long id,
			@RequestBody Boolean active){
		userService.updateActiveProperty(id, active);
	}
	
	
}
