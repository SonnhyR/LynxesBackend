package controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.ContactoServiceEntity;
import services.ContactoService;


@CrossOrigin(origins = "http://localhost:4200") 
@RestController  
@RequestMapping("/api/lynxes")  
public class ContactoController {  

    private final ContactoService contactoService;  

  
    public ContactoController(ContactoService contactoService) {  
        this.contactoService = contactoService;  
    }  

    @GetMapping  
    public List<ContactoServiceEntity> getAllSolicitudes() {  
        return contactoService.findAll();  
    }  
    
    @GetMapping("/{id}")  
    public ResponseEntity<ContactoServiceEntity> getContactoServiceEntityById(@PathVariable Long id) {  
        Optional<ContactoServiceEntity> nuevaSolicitud = contactoService.findById(id);  
        return nuevaSolicitud.map(ResponseEntity::ok)  
                     .orElseGet(() -> ResponseEntity.notFound().build());  
    }  

    @PostMapping  
    public ContactoServiceEntity createContactoServiceEntity(@RequestBody ContactoServiceEntity nuevaSolicitud) {  
        return contactoService.save(nuevaSolicitud);  
    }  

    @PutMapping("/{id}")  
    public ResponseEntity<ContactoServiceEntity> updateContactoServiceEntity(@PathVariable Long id, @RequestBody ContactoServiceEntity solicitudDetails) {  
        Optional<ContactoServiceEntity> optionalSolicitud= contactoService.findById(id);  
        if (!optionalSolicitud.isPresent()) {  
            return ResponseEntity.notFound().build();  
            
        }
        ContactoServiceEntity registrarSolicitud = optionalSolicitud.get();
        registrarSolicitud.setNombre(solicitudDetails.getNombre());
        registrarSolicitud.setTlf(solicitudDetails.getTlf());
        registrarSolicitud.setCorreo(solicitudDetails.getCorreo());
        registrarSolicitud.setDireccion(solicitudDetails.getDireccion());
        registrarSolicitud.setHorario(solicitudDetails.getHorario());
        registrarSolicitud.setNota(solicitudDetails.getNota());
	
        ContactoServiceEntity updatedSolicitud = contactoService.save(registrarSolicitud);
        return ResponseEntity.ok(updatedSolicitud);
        
    }
    
    @DeleteMapping("/{id}")  
    public ResponseEntity<Void> deleteSolicitud(@PathVariable Long id) {  
        if (!contactoService.findById(id).isPresent()) {  
            return ResponseEntity.notFound().build();  
        }  
        contactoService.deleteById(id);  
        return ResponseEntity.noContent().build();  
    }  
}
        