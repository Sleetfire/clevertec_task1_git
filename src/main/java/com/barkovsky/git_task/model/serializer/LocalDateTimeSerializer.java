package com.barkovsky.git_task.model.serializer;

import com.barkovsky.git_task.util.LocalDateTimeUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;

public class LocalDateTimeSerializer extends StdSerializer<LocalDateTime> {
    protected LocalDateTimeSerializer(Class<LocalDateTime> t) {
        super(t);
    }

    public LocalDateTimeSerializer() {
        this(null);
    }

    @Override
    public void serialize(LocalDateTime dateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        long millis = LocalDateTimeUtil.convertLocalDateTimeToLong(dateTime);
        jsonGenerator.writeNumber(millis);
    }
}
