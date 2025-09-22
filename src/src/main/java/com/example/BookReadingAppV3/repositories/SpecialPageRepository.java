package com.example.BookReadingAppV3.repositories;

import com.example.BookReadingAppV3.model.SpecialPage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpecialPageRepository extends JpaRepository<SpecialPage,Long> {
    Optional<SpecialPage> findByBook_TitleAndPageNumber(String title, Long pageNumber);
    List<SpecialPage> findByBook_Title(String title);
    void deleteByBook_TitleAndId(String title,Long id);
}
