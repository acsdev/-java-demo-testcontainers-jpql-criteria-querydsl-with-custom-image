package eti.query.demonstration.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.core.Response;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class Util {

    private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

    public static String getJson(Response response) {
        StringWriter sw = new StringWriter();
        try {
            String result = response.readEntity(String.class);
            JsonReader jr = Json.createReader(new StringReader(result));
            JsonObject jobj = jr.readObject();

            Map<String, Object> properties = new HashMap<>(1);
            properties.put(JsonGenerator.PRETTY_PRINTING, true);

            JsonWriterFactory writerFactory = Json.createWriterFactory(properties);
            JsonWriter jsonWriter = writerFactory.createWriter(sw);

            jsonWriter.writeObject(jobj);
            jsonWriter.close();

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        return sw.toString();
    }
}
