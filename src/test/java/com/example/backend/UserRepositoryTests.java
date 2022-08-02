package com.example.backend;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.backend.Models.User;
import com.example.backend.Repositories.UserRepository;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
 
    @Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private UserRepository repo;
     
    // test methods go below
    @Test
public void testCreateUser() {
    User user = new User();
    user.setEmail("ravikumar@gmail.com");
    user.setPassword("ravi2020");
    user.setGovtid("123456789012");
    user.setName("Kumar");
    user.setDob(LocalDate.from(LocalDate.now()));
    user.setAddress("A-123, Rosebury Park, Fatima Nagar.");
    user.setPhno("9876543216");

    User savedUser = repo.save(user);
     
    User existUser = entityManager.find(User.class, savedUser.getId());
     
    assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
     
}

}
