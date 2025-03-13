package com.example.objetivo.repository;

import com.example.objetivo.model.MonthModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthRepo extends JpaRepository<MonthModel,Long> {
    public MonthModel save(MonthModel monthModel);
    public MonthModel findById(long id);
}
