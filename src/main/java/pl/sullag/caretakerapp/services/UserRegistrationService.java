package pl.sullag.caretakerapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sullag.caretakerapp.UserDTO;
import pl.sullag.caretakerapp.model.Group;
import pl.sullag.caretakerapp.model.Roles;
import pl.sullag.caretakerapp.model.User;
import pl.sullag.caretakerapp.repositories.GroupRepository;
import pl.sullag.caretakerapp.repositories.UserRepository;

@Service
public class UserRegistrationService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    public boolean registerUser(UserDTO userDTO){
        if(userRepository.existsUserByEmail(userDTO.getEmail())){
            return false;
        }
        Group assignedGroup;
        if(userDTO.getAssignedGroupId()==null){
            assignedGroup=new Group();
            groupRepository.save(assignedGroup);
        }
        else{
            assignedGroup=groupRepository.findById(userDTO.getAssignedGroupId()).get();
        }
        userRepository.save(
                User.builder().firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .passwordHash(passwordEncoder.encode(userDTO.getPassword()))
                .role(userDTO.getRole())
                .assignedGroup(assignedGroup)
                .build()
                );
        return true;
    }

}
