package com.example.locadora.repository;

import com.example.locadora.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
