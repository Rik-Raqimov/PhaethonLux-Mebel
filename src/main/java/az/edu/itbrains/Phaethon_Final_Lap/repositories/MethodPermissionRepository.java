package az.edu.itbrains.Phaethon_Final_Lap.repositories;

import az.edu.itbrains.Phaethon_Final_Lap.models.MethodPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MethodPermissionRepository extends JpaRepository<MethodPermission, Long> {
    MethodPermission findByName(String methodName);
}