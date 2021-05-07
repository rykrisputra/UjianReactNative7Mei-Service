package com.ujian.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ujian.main.entity.Profil;

public interface ProfilRepository extends CrudRepository<Profil, Long>{
	
	@Query(value="select * from profil where nama LIKE %?1%",nativeQuery=true)
	List<Profil> findByNamaProfil(String nama);
	

}
