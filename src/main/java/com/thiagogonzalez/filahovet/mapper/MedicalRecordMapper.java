package com.thiagogonzalez.filahovet.mapper;

import com.thiagogonzalez.filahovet.domain.entities.MedicalRecord;
import com.thiagogonzalez.filahovet.domain.dto.MedicalRecordDTO;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.modelmapper.spi.MappingContext;

import java.util.List;

@Mapper
public interface MedicalRecordMapper {
    MedicalRecordMapper INSTANCE = Mappers.getMapper( MedicalRecordMapper.class );
    MedicalRecordDTO fromModel(MedicalRecord model);
    MedicalRecord toModel(MedicalRecordDTO dto);
    List<MedicalRecordDTO> fromModelList(List<MedicalRecord> listModel);
}
