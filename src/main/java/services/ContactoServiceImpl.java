package services;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import entities.ContactoServiceEntity;
import properties.ContactoRepository;


@Service
public class ContactoServiceImpl implements ContactoService {

		private final ContactoRepository repository;  
		
	    public ContactoServiceImpl(ContactoRepository repository) {  
	        this.repository = repository;  
	    }  
	    
	    @Override  
	    public List<ContactoServiceEntity> findAll() {  
	        return repository.findAll();  
	    } 

	    @Transactional(readOnly = true)  
	    @Override  
	    public Optional<ContactoServiceEntity> findById(@NonNull Long id) {  
	        return repository.findById(id);  
	    }  

	    @Transactional  
	    public ContactoServiceEntity save(ContactoServiceEntity nuevaSolicitud) {  
	        return repository.save(nuevaSolicitud);  
	    }  

	    @Transactional  
	    @Override  
	    public void deleteById(Long id) {  
	        repository.deleteById(id);  
	    }

		}    
	


