package org.xrogapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xrogapp.domain.EBook;

@Repository
public interface EBookRepository extends JpaRepository<EBook, Integer> {


}
