package com.thiagogonzalez.filahovet.mapper;

import com.thiagogonzalez.filahovet.domain.dto.MedicalRecordDTO;
import com.thiagogonzalez.filahovet.domain.entities.MedicalRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MedicalRecordMapper {
    MedicalRecordMapper INSTANCE = Mappers.getMapper( MedicalRecordMapper.class );
    MedicalRecordDTO fromModel(MedicalRecord model);
    MedicalRecord toModel(MedicalRecordDTO dto);
    List<MedicalRecordDTO> fromModelList(List<MedicalRecord> listModel);
}
