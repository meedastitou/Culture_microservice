package com.culture.culture.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.culture.culture.Model.Monument;
import com.culture.culture.Repository.MonumentRepository;
import com.culture.culture.Service.MonumentService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MonumentServiceImpl implements MonumentService{
	
	private final MonumentRepository monumentRepository;
	
	@Override
	public Monument save(@Valid Monument monument) {
		 return this.monumentRepository.save(monument);
	}

	@Override
	public List<Monument> getAll() {
		
		return this.monumentRepository.findAll();
	}

	@Override
	public Monument getOne(String id) {
		
		return this.monumentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Error: Monument is not found."));
	}

	@Override
	public void delete(Monument monument) {
		this.monumentRepository.delete(null);;
	}

}
