package com.barkovsky.git_task.service.api;

import com.barkovsky.git_task.model.dto.Item;

import java.util.List;
import java.util.UUID;

public interface IItemService {

    Item create(Item item);

    Item get(UUID uuid);

    List<Item> getAll();

}
