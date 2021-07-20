package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;





public interface ImageRepository extends JpaRepository<ImageModel, Long> {

	@Query("FROM ImageModel where name=?1")
	List<ImageModel> findByUsername(String username);
}
