package com.barkovsky.git_task.service;

import com.barkovsky.git_task.model.dto.Item;
import com.barkovsky.git_task.repository.api.ItemRepository;
import com.barkovsky.git_task.repository.entity.ItemEntity;
import com.barkovsky.git_task.service.api.IItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class ItemService implements IItemService {

    private final ItemRepository itemRepository;
    private final ConversionService conversionService;
    private static final Logger logger = LoggerFactory.getLogger(ItemService.class);

    public ItemService(ItemRepository itemRepository, ConversionService conversionService) {
        this.itemRepository = itemRepository;
        this.conversionService = conversionService;
    }

    @Override
    @Transactional
    public Item create(Item item) {
        LocalDateTime now = LocalDateTime.now();
        item.setDtCreate(now);
        item.setDtUpdate(now);
        ItemEntity itemEntity = this.conversionService.convert(item, ItemEntity.class);
        if (itemEntity == null) {
            throw new RuntimeException("Conversion error");
        }
        itemEntity = this.itemRepository.save(itemEntity);
        logger.info("Create item with uuid: {}", item.getUuid());
        return this.conversionService.convert(itemEntity, Item.class);
    }

    @Override
    public Item get(UUID uuid) {
        Optional<ItemEntity> optionalItemEntity = this.itemRepository.findById(uuid);
        if (optionalItemEntity.isEmpty()) {
            throw new RuntimeException("Item with current uuid doesn't exist");
        }
        return this.conversionService.convert(optionalItemEntity.get(), Item.class);
    }

    @Override
    public List<Item> getAll() {
        List<ItemEntity> itemList = this.itemRepository.findAll();
        if (itemList.isEmpty()) {
            throw new RuntimeException("Items don't exist");
        }
        List<Item> items = new ArrayList<>();
        itemList.forEach(itemEntity -> items.add(this.conversionService.convert(itemEntity, Item.class)));
        return items;
    }
}
