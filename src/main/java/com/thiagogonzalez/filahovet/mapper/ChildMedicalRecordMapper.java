package com.thiagogonzalez.filahovet.mapper;

import com.thiagogonzalez.filahovet.domain.dto.ChildMedicalRecordDTO;
import com.thiagogonzalez.filahovet.domain.dto.MedicalRecordDTO;
import com.thiagogonzalez.filahovet.domain.entities.MedicalRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ChildMedicalRecordMapper {
    ChildMedicalRecordMapper INSTANCE = Mappers.getMapper( ChildMedicalRecordMapper.class );
    ChildMedicalRecordDTO fromModel(MedicalRecord model);
    MedicalRecord toModel(ChildMedicalRecordDTO dto);
    List<ChildMedicalRecordDTO> fromModelList(List<MedicalRecord> listModel);
}
