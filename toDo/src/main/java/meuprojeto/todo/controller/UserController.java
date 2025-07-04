package meuprojeto.todo.controller;
import jakarta.validation.Valid;
import meuprojeto.todo.dto.UserRequestDTO;
import meuprojeto.todo.dto.UserResponseDTO;
import meuprojeto.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDTO> getUsers() {
        return userService.findAll();
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        Optional<UserResponseDTO> userOpt = userService.findById(id);

        if(userOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userOpt.get());

    }*/

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO userRequestDTO){
        UserResponseDTO  createdUser = userService.create(userRequestDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdUser);

    }





}
