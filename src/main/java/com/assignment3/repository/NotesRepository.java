package com.assignment3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment3.entity.Notes;

public interface NotesRepository extends JpaRepository<Notes, Long>{

}
