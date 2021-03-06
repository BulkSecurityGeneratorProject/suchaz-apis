package com.suchaz.app.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.suchaz.app.domain.ConsumerProfile;
import com.suchaz.app.service.dto.ConsumerProfileDTO;

/**
 * Mapper for the entity ConsumerProfile and its DTO ConsumerProfileDTO.
 */
@Mapper(componentModel = "spring", uses = {SuchAzUserMapper.class})
public interface ConsumerProfileMapper extends EntityMapper<ConsumerProfileDTO, ConsumerProfile> {

    @Mapping(source = "suchAzUser.id", target = "suchAzUserId")
    @Mapping(source = "suchAzUser.email", target = "suchAzUserEmail")
    ConsumerProfileDTO toDto(ConsumerProfile consumerProfile);

    @Mapping(source = "suchAzUserId", target = "suchAzUser")
    ConsumerProfile toEntity(ConsumerProfileDTO consumerProfileDTO);

    default ConsumerProfile fromId(Long id) {
        if (id == null) {
            return null;
        }
        ConsumerProfile consumerProfile = new ConsumerProfile();
        consumerProfile.setId(id);
        return consumerProfile;
    }
}
