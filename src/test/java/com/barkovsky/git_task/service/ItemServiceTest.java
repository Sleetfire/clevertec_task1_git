package com.barkovsky.git_task.service;

import com.barkovsky.git_task.model.dto.Item;
import com.barkovsky.git_task.service.api.IItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    private IItemService itemService;

    @Test()
    @DisplayName("Test create operation")
    void create() {
        Item item = this.itemService.create(this.getTestItem());
        assertNotNull(item.getUuid());
        assertNotNull(item.getDtCreate());
        assertNotNull(item.getDtUpdate());
    }

    private Item getTestItem() {
        return Item.Builder.builder()
                .setTitle("title")
                .setDescription("description")
                .build();
    }
}