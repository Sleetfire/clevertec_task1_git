package com.barkovsky.git_task.service.api;

import com.barkovsky.git_task.model.dto.Item;

import java.util.List;
import java.util.UUID;

public interface IItemService {

    /**
     * Creating new item in database
     * @param item our item
     * @return item with uuid
     */
    Item create(Item item);

    /**
     * Getting item from database by uuid
     * @param uuid item's uuid
     * @return item from database
     */
    Item get(UUID uuid);

    /**
     * Getting list of items
     * @return list of items
     */
    List<Item> getAll();

}
