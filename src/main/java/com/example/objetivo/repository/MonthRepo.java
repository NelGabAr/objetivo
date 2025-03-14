package com.example.objetivo.repository;

import com.example.objetivo.model.MonthModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonthRepo extends JpaRepository<MonthModel,Long> {
    public MonthModel save(MonthModel monthModel);
    public MonthModel findById(long id);

    List<MonthModel> findByYearModel_Id(Long yearModelId);
}
