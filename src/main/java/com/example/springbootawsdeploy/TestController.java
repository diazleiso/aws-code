package com.example.springbootawsdeploy;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/demo")
public class TestController {
    @GetMapping("/data")
    public String getData() {
        return "First message from AWS Ecs sii cr7";
    }

    @GetMapping("/message")
    public String getMessage() {
        return "Second message from AWS Ecs";
    }

    // Endpoint que retorna un mensaje OK y código 200 en formato JSON
    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getStatusOk() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "ok");
        response.put("code", 200);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/prueba")
    public String getPrueba() {
        return "AWS Prueba";
    }

    // Endpoint que retorna la hora del servidor
    @GetMapping("/time")
    public Map<String, Object> getServerTime() {
        Map<String, Object> response = new HashMap<>();
        response.put("serverTime", LocalDateTime.now().toString());
        response.put("timezone", TimeZone.getDefault().getID());
        response.put("timestamp", System.currentTimeMillis());
        return response;
    }

    // Endpoint con parámetro de ruta
    @GetMapping("/greet/{name}")
    public String greetUser(@PathVariable String name) {
        return "¡Hola " + name + "! Bienvenido a AWS ECS desde Spring Boot";
    }

    // Endpoint con parámetro de consulta
    @GetMapping("/search")
    public Map<String, Object> searchData(@RequestParam(defaultValue = "default") String query,
                                          @RequestParam(defaultValue = "10") int limit) {
        Map<String, Object> response = new HashMap<>();
        response.put("query", query);
        response.put("limit", limit);
        response.put("results", Arrays.asList("Resultado 1", "Resultado 2", "Resultado 3"));
        response.put("timestamp", LocalDateTime.now());
        return response;
    }

    // Endpoint POST para crear datos
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createData(@RequestBody Map<String, Object> data) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Datos recibidos correctamente");
        response.put("receivedData", data);
        response.put("id", UUID.randomUUID().toString());
        response.put("createdAt", LocalDateTime.now());
        return ResponseEntity.ok(response);
    }

    // Endpoint PUT para actualizar
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateData(@PathVariable String id,
                                                          @RequestBody Map<String, Object> data) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "updated");
        response.put("id", id);
        response.put("updatedData", data);
        response.put("updatedAt", LocalDateTime.now());
        return ResponseEntity.ok(response);
    }

    // Endpoint DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteData(@PathVariable String id) {
        Map<String, String> response = new HashMap<>();
        response.put("status", "deleted");
        response.put("id", id);
        response.put("message", "Recurso eliminado exitosamente");
        return ResponseEntity.ok(response);
    }

    // Endpoint para información del sistema
    @GetMapping("/info")
    public Map<String, Object> getSystemInfo() {
        Map<String, Object> response = new HashMap<>();
        response.put("application", "Spring Boot AWS Deploy");
        response.put("version", "0.0.1-SNAPSHOT");
        response.put("javaVersion", System.getProperty("java.version"));
        response.put("osName", System.getProperty("os.name"));
        response.put("osVersion", System.getProperty("os.version"));
        response.put("availableProcessors", Runtime.getRuntime().availableProcessors());
        response.put("maxMemory", Runtime.getRuntime().maxMemory() / (1024 * 1024) + " MB");
        response.put("totalMemory", Runtime.getRuntime().totalMemory() / (1024 * 1024) + " MB");
        response.put("freeMemory", Runtime.getRuntime().freeMemory() / (1024 * 1024) + " MB");
        return response;
    }

    // Endpoint de salud personalizado
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "springboot-aws-deploy");
        response.put("timestamp", LocalDateTime.now().toString());
        return ResponseEntity.ok(response);
    }
}
