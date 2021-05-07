package com.ujian.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujian.main.entity.Profil;
import com.ujian.main.repository.ProfilRepository;

@RestController
@RequestMapping("/profil")
public class ProfilController {
	
	@Autowired
	ProfilRepository profilRepo;
	
	@GetMapping("/")
	public List<Profil> getAll(){
		return (List<Profil>) profilRepo.findAll();
	}
	
	@GetMapping("/{nama}")
	public List<Profil> getAllByNamaProfil(@PathVariable String nama){
		System.out.println(nama);
		return (List<Profil>) profilRepo.findByNamaProfil(nama);
	}
	
	
	@PostMapping("/register")
	public String register(@RequestBody Profil profil) {
		profilRepo.save(profil);
		return "Registrasi Berhasil!";
	}
	
	@DeleteMapping("/hapusProfil/{id}")
	public String hapusProfil(@PathVariable String id) {
		profilRepo.deleteById(Long.parseLong(id));
		return "Hapus Profil Berhasil!";
	}
	
	@PutMapping("/ubahProfil/{id}")
	public String ubahProfil(@PathVariable String id, @RequestBody Profil profil) {
		profil.setId(Long.parseLong(id));
		profilRepo.save(profil);
		return "Profil Berhasil Diperbaharui!";
	}
	

}
