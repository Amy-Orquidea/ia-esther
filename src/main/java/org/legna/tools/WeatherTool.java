package org.legna.tools;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.tool.Tool;

public class WeatherTool {
    @Tool
    public String getWeather(String city) {
        return "Temperatura em " + city + ": 25°C";
    }
}