package com.example.nachbarschaftsapp.controller;

import com.example.nachbarschaftsapp.domain.Nutzer;
import com.example.nachbarschaftsapp.dto.NutzerDto;
import com.example.nachbarschaftsapp.mapper.NutzerMapper;
import com.example.nachbarschaftsapp.services.NutzerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/nutzer")
@CrossOrigin(origins = "http://localhost:4200")
public class NutzerController {

    private final NutzerService nutzerService;

    public NutzerController(NutzerService nutzerService) {
        this.nutzerService = nutzerService;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<NutzerDto> zeigeNutzer(@PathVariable UUID uuid) {
        return nutzerService.zeigeNutzer(uuid).ifPresentOrElse((nutzer -> ResponseEntity.ok(NutzerMapper.INSTANCE.toDto(nutzer))), () -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Void> speichereNutzer(@PathVariable UUID uuid, @RequestBody Nutzer nutzer) {
        Nutzer bearbeiteterNutzer = nutzerService.speichereNutzer(nutzer, uuid);
        if (bearbeiteterNutzer != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<Nutzer> erstelleNutzer(@RequestBody Nutzer nutzer) {
        Nutzer neuerNutzer = nutzerService.erstelleNutzer(nutzer);
        return ResponseEntity.status(HttpStatus.CREATED).body(neuerNutzer);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> loescheNutzer(@PathVariable UUID uuid) {
        Optional<Nutzer> nutzer = nutzerService.zeigeNutzer(uuid);
        if (nutzer.isPresent()) {
            nutzerService.loescheNutzer(uuid);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
