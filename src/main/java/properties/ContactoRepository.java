package properties;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.ContactoServiceEntity;


public interface ContactoRepository extends JpaRepository<ContactoServiceEntity, Long> {

}
