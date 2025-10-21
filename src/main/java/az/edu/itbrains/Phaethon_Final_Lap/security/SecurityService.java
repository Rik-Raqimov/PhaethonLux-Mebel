package az.edu.itbrains.Phaethon_Final_Lap.security;

import az.edu.itbrains.Phaethon_Final_Lap.models.MethodPermission;
import az.edu.itbrains.Phaethon_Final_Lap.repositories.MethodPermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("securityService")
@RequiredArgsConstructor
public class SecurityService {

    @Autowired
    private MethodPermissionRepository methodPermissionRepository;

    public String privilege(String methodName){
        MethodPermission methodPermission = methodPermissionRepository.findByName(methodName);
        List<String> roles = methodPermission.getRoles().stream().map(Enum::name).collect(Collectors.toList());
        String result = String.join(",",roles);
        return result;
    }

}