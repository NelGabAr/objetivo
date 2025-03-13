package com.example.objetivo.repository;

import com.example.objetivo.model.DayModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayRepo extends JpaRepository<DayModel,Long> {
    public DayModel save(DayModel dayModel);
    public List<DayModel> findByMonthModelId(Long monthModelId);

}
