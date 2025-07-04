package meuprojeto.todo.mapper;

import meuprojeto.todo.dto.UserRequestDTO;
import meuprojeto.todo.dto.UserResponseDTO;
import meuprojeto.todo.model.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO dto){
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());             //request -> entidade
        user.setRole(dto.getRole());
        user.setUsername(dto.getUsername());

        return user;
    }

    public static UserResponseDTO toDTO(User user){
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());                 //entidade -> response
        dto.setRole(user.getRole());
        dto.setUsername(user.getUsername());
        return dto;

    }
}
