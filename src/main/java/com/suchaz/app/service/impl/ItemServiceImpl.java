package com.suchaz.app.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suchaz.app.domain.Item;
import com.suchaz.app.repository.ItemRepository;
import com.suchaz.app.service.ItemService;
import com.suchaz.app.service.dto.ItemDTO;
import com.suchaz.app.service.mapper.ItemMapper;

/**
 * Service Implementation for managing Item.
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    private final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    /**
     * Save a item.
     *
     * @param itemDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ItemDTO save(ItemDTO itemDTO) {
        log.debug("Request to save Item : {}", itemDTO);
        Item item = itemMapper.toEntity(itemDTO);
        item = itemRepository.save(item);
        return itemMapper.toDto(item);
    }

    /**
     * Get all the items.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ItemDTO> findAll() {
        log.debug("Request to get all Items");
        return itemRepository.findAllWithEagerRelationships().stream()
            .map(itemMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one item by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public ItemDTO findOne(Long id) {
        log.debug("Request to get Item : {}", id);
        Item item = itemRepository.findOneWithEagerRelationships(id);
        return itemMapper.toDto(item);
    }

    /**
     * Delete the item by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Item : {}", id);
        itemRepository.delete(id);
    }

	@Override
	@Transactional(readOnly = true)
	public List<ItemDTO> findAllWeeklyFeaturedItem() {
		log.debug("Request to get all Weekly Featured Items Items");
        return itemRepository.findAllWithEagerRelationships().stream()
            .map(itemMapper::toDto)
            .collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public Long[] findAllItemsIdsWithKeyWord(String keyWord) {
		log.debug("Request to get all search Items");
        return itemRepository.findAllItemsIdsWithSearchedKeyWords(keyWord);
	}

}
