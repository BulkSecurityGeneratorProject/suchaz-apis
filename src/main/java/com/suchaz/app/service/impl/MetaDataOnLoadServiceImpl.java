package com.suchaz.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suchaz.app.config.ApplicationConstants;
import com.suchaz.app.domain.Category;
import com.suchaz.app.domain.Hobby;
import com.suchaz.app.domain.Occassion;
import com.suchaz.app.domain.Relationship;
import com.suchaz.app.domain.Store;
import com.suchaz.app.domain.Trait;
import com.suchaz.app.repository.CategoryRepository;
import com.suchaz.app.repository.HobbyRepository;
import com.suchaz.app.repository.OccassionRepository;
import com.suchaz.app.repository.RelationshipRepository;
import com.suchaz.app.repository.StoreRepository;
import com.suchaz.app.repository.TraitRepository;
import com.suchaz.app.service.ItemService;
import com.suchaz.app.service.MetaDataOnLoadService;
import com.suchaz.app.service.QuickViewService;
import com.suchaz.app.service.SuchAzMenuService;
import com.suchaz.app.service.dto.CategoryDTO;
import com.suchaz.app.service.dto.HobbyDTO;
import com.suchaz.app.service.dto.ItemDTO;
import com.suchaz.app.service.dto.MetaDataOnLoadDTO;
import com.suchaz.app.service.dto.OccassionDTO;
import com.suchaz.app.service.dto.QuickViewDTO;
import com.suchaz.app.service.dto.RelationshipDTO;
import com.suchaz.app.service.dto.StoreDTO;
import com.suchaz.app.service.dto.SuchAzMenuDTO;
import com.suchaz.app.service.dto.TraitDTO;
import com.suchaz.app.service.mapper.CategoryMapper;
import com.suchaz.app.service.mapper.HobbyMapper;
import com.suchaz.app.service.mapper.OccassionMapper;
import com.suchaz.app.service.mapper.RelationshipMapper;
import com.suchaz.app.service.mapper.StoreMapper;
import com.suchaz.app.service.mapper.TraitMapper;

/**
 * Service Implementation for managing UserProfile.
 */
@Service
@Transactional
public class MetaDataOnLoadServiceImpl implements MetaDataOnLoadService {

	private final Logger log = LoggerFactory.getLogger(MetaDataOnLoadServiceImpl.class);

/*	private final SuchAzUserRepository suchAzUserRepository;
	private final SuchAzUserMapper suchAzUserMapper;

	private final UserProfileRepository userProfileRepository;
	private final UserProfileMapper userProfileMapper;

	private final BuyLaterListRepository buyLaterListRepository;
	private final BuyLaterListMapper buyLaterListMapper;

	private final WishListRepository wishListRepository;
	private final WishListMapper wishListMapper;

	private final ActivityListRepository activityListRepository;
	private final ActivityListMapper activityListMapper;*/
	
	private final TraitRepository traitRepository;
	private final TraitMapper traitMapper;
	
	private final HobbyRepository hobbyRepository;
	private final HobbyMapper hobbyMapper;
	
	private final RelationshipRepository relationshipRepository;
	private final RelationshipMapper relationshipMapper;
	
	private final OccassionRepository occassionRepository;
	private final OccassionMapper occassionMapper;
	
	private final StoreRepository storeRepository;
	private final StoreMapper storeMapper;
	
	private CategoryRepository categoryRepository;
	private CategoryMapper categoryMapper;
	
	private ItemService itemService;
	private QuickViewService quickViewService;
	
	private SuchAzMenuService suchAzMenuService;

	public MetaDataOnLoadServiceImpl(TraitRepository traitRepository, TraitMapper traitMapper, HobbyRepository hobbyRepository,HobbyMapper hobbyMapper,
			RelationshipRepository relationshipRepository, RelationshipMapper relationshipMapper, OccassionRepository occassionRepository,
			OccassionMapper occassionMapper, StoreRepository storeRepository, StoreMapper storeMapper,
			CategoryRepository categoryRepository, CategoryMapper categoryMapper, ItemService itemService,
			QuickViewService quickViewService, SuchAzMenuService suchAzMenuService) {
		this.traitRepository = traitRepository;
		this.traitMapper = traitMapper;
		this.hobbyRepository = hobbyRepository;
		this.hobbyMapper = hobbyMapper;
		this.relationshipRepository = relationshipRepository;
		this.relationshipMapper = relationshipMapper;
		this.occassionRepository = occassionRepository;
		this.occassionMapper = occassionMapper;
		this.storeRepository = storeRepository;
		this.storeMapper = storeMapper;
		this.categoryRepository =  categoryRepository;
		this.categoryMapper = categoryMapper;
		this.itemService = itemService;
		this.quickViewService = quickViewService;
		this.suchAzMenuService = suchAzMenuService;
	}
	

	/**
	 * Load All meta Data
	 *
	 */
	@Override
	@Transactional(readOnly = true)
	public MetaDataOnLoadDTO loadAllMetaData() {
		log.debug("Request to Load All MetaData for User : {}", "UserIP");
		ArrayList<Trait> traitListAll = (ArrayList<Trait>) traitRepository.findAll();
		ArrayList<Hobby> hobbyListAll = (ArrayList<Hobby>) hobbyRepository.findAll();
		ArrayList<Relationship> relationshipListAll = (ArrayList<Relationship>) relationshipRepository.findAll();
		ArrayList<Occassion> occasionListAll = (ArrayList<Occassion>) occassionRepository.findAll();
		ArrayList<Store> storeListAll = (ArrayList<Store>) storeRepository.findAll();
		ArrayList<Category> categoryListAll = (ArrayList<Category>) categoryRepository.findAll();
		Map<String,ArrayList<Object>> mapOfAllMetaData = new HashMap<String,ArrayList<Object>>();
		
		if(traitListAll != null && traitListAll.size()>0)
		{
			ArrayList listAllTraitsDTO = (ArrayList<TraitDTO>) traitMapper.toDto(traitListAll);
			mapOfAllMetaData.put(ApplicationConstants.TRAIT, listAllTraitsDTO);
		}
		
		if(hobbyListAll!=null && hobbyListAll.size()>0)
		{
			ArrayList listAllHobbyDTO = (ArrayList<HobbyDTO>) hobbyMapper.toDto(hobbyListAll);
			mapOfAllMetaData.put(ApplicationConstants.HOBBY, listAllHobbyDTO);
		}
		
		if(relationshipListAll!=null && relationshipListAll.size()>0)
		{
			ArrayList listAllRelationshipDTO = (ArrayList<RelationshipDTO>) relationshipMapper.toDto(relationshipListAll);
			mapOfAllMetaData.put(ApplicationConstants.RELATIONSHIP,listAllRelationshipDTO );
		}
		
		if(occasionListAll!=null && occasionListAll.size()>0)
		{
			ArrayList listAllOccassionDTO = (ArrayList<OccassionDTO>) occassionMapper.toDto(occasionListAll);
			mapOfAllMetaData.put(ApplicationConstants.OCCASSION,listAllOccassionDTO );
		}
		
		if(storeListAll!=null && storeListAll.size()>0)
		{
			ArrayList listAllStoreDTO = (ArrayList<StoreDTO>) storeMapper.toDto(storeListAll);
			mapOfAllMetaData.put(ApplicationConstants.STORE,listAllStoreDTO );
		}
		
		if(categoryListAll!=null && categoryListAll.size()>0)
		{
			ArrayList listAllCategoryDTO = (ArrayList<CategoryDTO>) categoryMapper.toDto(categoryListAll);
			mapOfAllMetaData.put(ApplicationConstants.CATEGORY,listAllCategoryDTO );
		}
		ArrayList<Object> listOfGender = new ArrayList<>();
		listOfGender.add(ApplicationConstants.GENDER.MALE);
		listOfGender.add(ApplicationConstants.GENDER.FEMALE);
		
		ArrayList<Object> listOfAgeGroup = new ArrayList<>();
		listOfAgeGroup.add(ApplicationConstants.AGE_GROUP.KIDS);
		listOfAgeGroup.add(ApplicationConstants.AGE_GROUP.TEEN);
		listOfAgeGroup.add(ApplicationConstants.AGE_GROUP.YOUTH);
		listOfAgeGroup.add(ApplicationConstants.AGE_GROUP.ELDERS);
		
		mapOfAllMetaData.put(ApplicationConstants.GENDER_TAG, listOfGender);
		mapOfAllMetaData.put(ApplicationConstants.AGE_GROUP_TAG, listOfAgeGroup);
		
		// Adding Weekly Featured products.
		ArrayList<ItemDTO> listItemDTO = (ArrayList<ItemDTO>) itemService.findAllWeeklyFeaturedItem();
		Long [] itemIds = new Long[listItemDTO.size()];
		int counter = 0;
		for(ItemDTO itemDTO : listItemDTO)
		{
			itemIds[counter] = itemDTO.getId();
			counter++;
		}
		
		ArrayList listQuickViewDTO = (ArrayList<QuickViewDTO>) quickViewService.findRangeOfItem(itemIds);
		if(listQuickViewDTO!=null && listQuickViewDTO.size()>0)
		{
			mapOfAllMetaData.put(ApplicationConstants.WEEKLY_FEATURED_PRODUTS, listQuickViewDTO);
		}
		
		MetaDataOnLoadDTO metaDataOnLoadDTO = new MetaDataOnLoadDTO();
		metaDataOnLoadDTO.setMetaDataOnLoadMap(mapOfAllMetaData);

		return metaDataOnLoadDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public MetaDataOnLoadDTO loadAllMetaDataForBeta() {
		
		log.debug("Request to Load All MetaData Beta Version for User : {}", "UserIP");
		Map<String,ArrayList<Object>> mapOfAllMetaData = new HashMap<String,ArrayList<Object>>();
		
		// Adding Weekly Featured products.
		ArrayList<ItemDTO> listItemDTO = (ArrayList<ItemDTO>) itemService.findAllWeeklyFeaturedItem();
		Long [] itemIds = new Long[listItemDTO.size()];
		int counter = 0;
		for(ItemDTO itemDTO : listItemDTO)
		{
			itemIds[counter] = itemDTO.getId();
			counter++;
		}
		
		ArrayList listQuickViewDTO = (ArrayList<QuickViewDTO>) quickViewService.findRangeOfItem(itemIds);
		if(listQuickViewDTO!=null && listQuickViewDTO.size()>0)
		{
			mapOfAllMetaData.put(ApplicationConstants.WEEKLY_FEATURED_PRODUTS, listQuickViewDTO);
		}
		
		// Adding Menu List.
		ArrayList listSuchAzMenuDTO = (ArrayList<SuchAzMenuDTO>) suchAzMenuService.findAll();
		if(listSuchAzMenuDTO!=null && !listSuchAzMenuDTO.isEmpty())
		{
			mapOfAllMetaData.put(ApplicationConstants.SUCHAZ_MENU_LIST, listSuchAzMenuDTO);
		}
		
		MetaDataOnLoadDTO metaDataOnLoadDTO = new MetaDataOnLoadDTO();
		metaDataOnLoadDTO.setMetaDataOnLoadMap(mapOfAllMetaData);
		
		return metaDataOnLoadDTO;
	}

}
