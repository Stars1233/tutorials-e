package com.baeldung.jsonnodetojsonobject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonNodeToObjectNodeUnitTest {
    
    public static String jsonString = "{\"name\": \"John\", \"gender\": \"male\", \"company\": \"Baeldung\", \"isEmployee\": true, \"age\": 30}";

    @Test
    public void givenJsonNode_whenConvertingToObjectNode_thenVerifyFieldsIntegrity() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonString);
        ObjectNode objectNode = (ObjectNode) jsonNode;

        assertEquals("John", objectNode.get("name").asText());
        assertEquals("male", objectNode.get("gender").asText());
        assertEquals("Baeldung", objectNode.get("company").asText());
        assertTrue(objectNode.get("isEmployee").asBoolean());
        assertEquals(30, objectNode.get("age").asInt());
    }
}
