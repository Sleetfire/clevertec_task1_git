package com.barkovsky.git_task.model.deserializer;

import com.barkovsky.git_task.util.LocalDateTimeUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;

public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {
    protected LocalDateTimeDeserializer(Class<?> vc) {
        super(vc);
    }

    public LocalDateTimeDeserializer() {
        this(null);
    }

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return LocalDateTimeUtil.convertLongToLocalDateTime(jsonParser.getValueAsLong());
    }
}
