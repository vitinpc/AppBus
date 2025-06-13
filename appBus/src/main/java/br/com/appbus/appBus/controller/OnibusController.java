package br.com.appbus.appBus.controller;

import br.com.appbus.appBus.dto.LocalizacaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // Permite requisições de qualquer origem
@RestController
@RequestMapping("/api/onibus")
public class OnibusController {

    @GetMapping
    public List<String> listarHorarios() {
        return List.of("06:30", "07:00", "08:00");
    }

    @PostMapping
    public ResponseEntity<String> registrarLocalizacao(@RequestBody LocalizacaoDTO dto) {
        return ResponseEntity.ok("Localização recebida: " + dto.getLatitude());
    }
}
