package com.extravars.extravars.jpa;

import com.extravars.extravars.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
