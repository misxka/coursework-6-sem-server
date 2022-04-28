package org.verigo.server.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.stereotype.Service;
import org.verigo.server.data.entities.Course;

@Service
public class CourseService {
    public Course applyPatchToCourse(JsonPatch patch, Course targetCourse) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched = patch.apply(objectMapper.convertValue(targetCourse, JsonNode.class));
        return objectMapper.treeToValue(patched, Course.class);
    }
}
