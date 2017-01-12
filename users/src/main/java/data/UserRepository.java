package data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    void addUser(User user);

    void updateUser(User user);

    void removeUser(User user);

    List<User> findUsers(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("emailAddress") String emailAddress);
}
