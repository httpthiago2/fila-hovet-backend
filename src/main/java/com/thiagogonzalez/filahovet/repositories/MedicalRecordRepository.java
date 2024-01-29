package com.thiagogonzalez.filahovet.repositories;

import com.thiagogonzalez.filahovet.domain.entities.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    @Query("SELECT m FROM MedicalRecord m where m.queue.id = :queueId and m.medicalRecordStatus = 'PENDING' order by m.attendanceOrder limit 1")
    MedicalRecord findNextAttendance(@Param("queueId") Long queueId);
}
