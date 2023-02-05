package com.barkovsky.git_task.model.converter;

import com.barkovsky.git_task.model.dto.Item;
import com.barkovsky.git_task.repository.entity.ItemEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemDtoToEntityConverter implements Converter<Item, ItemEntity> {

    @Override
    public ItemEntity convert(Item source) {
        return ItemEntity.Builder.builder()
                .setUuid(source.getUuid())
                .setDtCreate(source.getDtCreate())
                .setDtUpdate(source.getDtUpdate())
                .setTitle(source.getTitle())
                .setDescription(source.getDescription())
                .build();
    }
}
