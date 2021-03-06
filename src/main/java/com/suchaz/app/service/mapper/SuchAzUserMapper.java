package com.suchaz.app.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.suchaz.app.domain.SuchAzUser;
import com.suchaz.app.service.dto.SuchAzUserDTO;

/**
 * Mapper for the entity SuchAzUser and its DTO SuchAzUserDTO.
 */
@Mapper(componentModel = "spring", uses = {TraitMapper.class})
public interface SuchAzUserMapper extends EntityMapper<SuchAzUserDTO, SuchAzUser> {


    @Mapping(target = "userGiftWrappers", ignore = true)
    @Mapping(target = "consumerProfiles", ignore = true)
    @Mapping(target = "userProfile", ignore = true)
    @Mapping(target = "wishList", ignore = true)
    @Mapping(target = "buyLaterList", ignore = true)
    @Mapping(target = "activityList", ignore = true)
    SuchAzUser toEntity(SuchAzUserDTO suchAzUserDTO);

    default SuchAzUser fromId(Long id) {
        if (id == null) {
            return null;
        }
        SuchAzUser suchAzUser = new SuchAzUser();
        suchAzUser.setId(id);
        return suchAzUser;
    }
}
