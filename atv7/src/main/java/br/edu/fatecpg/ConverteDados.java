package br.edu.fatecpg;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class ConverteDados implements IConverteDados{
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> JsonNode obterDado(String json) throws IOException {
        return mapper.readTree(json);
    }

}
