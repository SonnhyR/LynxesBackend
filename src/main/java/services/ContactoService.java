package services;  

import java.util.List;  
import java.util.Optional;  

import org.springframework.lang.NonNull;  

import entities.ContactoServiceEntity;  

public interface ContactoService {  

    List<ContactoServiceEntity> findAll();  

    Optional<ContactoServiceEntity> findById(@NonNull Long id); 
    
    ContactoServiceEntity save(ContactoServiceEntity nuevaSolicitud);    

    void deleteById(Long id);  
}