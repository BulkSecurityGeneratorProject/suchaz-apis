package com.suchaz.app.service;

import java.util.List;

import com.suchaz.app.service.dto.StoreDTO;

/**
 * Service Interface for managing Store.
 */
public interface StoreService {

    /**
     * Save a store.
     *
     * @param storeDTO the entity to save
     * @return the persisted entity
     */
    StoreDTO save(StoreDTO storeDTO);

    /**
     * Get all the stores.
     *
     * @return the list of entities
     */
    List<StoreDTO> findAll();

    /**
     * Get the "id" store.
     *
     * @param id the id of the entity
     * @return the entity
     */
    StoreDTO findOne(Long id);

    /**
     * Delete the "id" store.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
