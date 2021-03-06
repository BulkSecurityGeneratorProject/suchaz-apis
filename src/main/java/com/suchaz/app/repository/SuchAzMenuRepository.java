package com.suchaz.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.suchaz.app.domain.SuchAzMenu;

/**
 * Spring Data JPA repository for the SuchAzMenu entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SuchAzMenuRepository extends JpaRepository<SuchAzMenu, Long> {
    @Query("select distinct such_az_menu from SuchAzMenu such_az_menu left join fetch such_az_menu.items")
    List<SuchAzMenu> findAllWithEagerRelationships();

    @Query("select such_az_menu from SuchAzMenu such_az_menu left join fetch such_az_menu.items where such_az_menu.id =:id")
    SuchAzMenu findOneWithEagerRelationships(@Param("id") Long id);
    
    @Query("select such_az_menu from SuchAzMenu such_az_menu left join fetch such_az_menu.items where such_az_menu.menuCode =:menuCode")
    SuchAzMenu findOneWithMenuCodeAndItems(@Param("menuCode") String menuCode);

}
