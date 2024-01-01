package com.thiagogonzalez.filahovet.repositories;

import com.thiagogonzalez.filahovet.domain.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
}
