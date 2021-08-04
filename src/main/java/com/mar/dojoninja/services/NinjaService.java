package com.mar.dojoninja.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mar.dojoninja.models.Ninja;
import com.mar.dojoninja.repositories.NinjaRepository;



@Service
@Transactional
public class NinjaService {
	
	 @Autowired 
	    NinjaRepository ninjaRepo;
	    //la variable estática establece el número de ninjas que queremos mostrar por página.
	    private static final int PAGE_SIZE = 5;
	    public Page<Ninja> ninjasPerPage(int pageNumber) {
	        // Obtener todas las páginas de ninjas y clasificarlas en orden ascendente por apellido.
	        PageRequest pageRequest = new PageRequest(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "lastName");
	        Page<Ninja> ninjas = ninjaRepo.findAll(pageRequest);
	        return ninjaRepo.findAll(pageRequest);
	    }	
	
}
