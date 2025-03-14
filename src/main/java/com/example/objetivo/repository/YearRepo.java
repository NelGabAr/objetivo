package com.example.objetivo.repository;

import com.example.objetivo.model.YearModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearRepo extends JpaRepository<YearModel,Long> {
    public YearModel save(YearModel yearModel);

    YearModel findYearModelById(Long id);
}
