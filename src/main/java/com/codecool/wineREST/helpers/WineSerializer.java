package com.codecool.wineREST.helpers;

import com.codecool.wineREST.entities.Wine;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.io.StringWriter;

public class WineSerializer extends JsonSerializer<Wine> {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void serialize(Wine wine, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        StringWriter stringWriter = new StringWriter();
        mapper.writeValue(stringWriter, wine);
        jsonGenerator.writeFieldName(stringWriter.toString());
    }
}
