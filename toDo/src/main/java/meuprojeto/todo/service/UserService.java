package meuprojeto.todo.service;


import meuprojeto.todo.dto.UserRequestDTO;
import meuprojeto.todo.dto.UserResponseDTO;
import meuprojeto.todo.mapper.UserMapper;
import meuprojeto.todo.model.User;
import meuprojeto.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO create(UserRequestDTO userRequestDTO) {
        User user = UserMapper.toEntity(userRequestDTO);
        user = userRepository.save(user);
        return UserMapper.toDTO(user);

    }

    public List<UserResponseDTO> findAll()
    {
        return userRepository.findAll().stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }

    public Optional<UserResponseDTO> findById(Long id) {
        return userRepository.findById(id).map(UserMapper::toDTO);
    }

    public boolean delete(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }



}
