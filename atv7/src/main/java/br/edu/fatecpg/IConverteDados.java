package br.edu.fatecpg;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public interface IConverteDados {

    <T> JsonNode obterDado(String json) throws IOException;
}
