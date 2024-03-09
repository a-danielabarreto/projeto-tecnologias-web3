package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query("select p from Professor p order by p.nome asc") //usando JPQL
    List<Professor> listarTodosProfessoresOrdenadosPorNome();

    @Query("select p from Professor p where p.email=:email")
    Professor buscarPorEmail(@Param("email") String email);

}
