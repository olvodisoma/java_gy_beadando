package hu.nje.nb1.controller;

import hu.nje.nb1.model.Labdarugo;
import hu.nje.nb1.service.LabdarugoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/labdarugok")
public class LabdarugoRestController {

    private final LabdarugoService labdarugoService;

    public LabdarugoRestController(LabdarugoService labdarugoService) {
        this.labdarugoService = labdarugoService;
    }

    // GET /api/labdarugok  -> összes labdarúgó
    @GetMapping
    public ResponseEntity<List<Labdarugo>> getAll() {
        List<Labdarugo> lista = labdarugoService.findAll();
        return ResponseEntity.ok(lista);
    }

    // GET /api/labdarugok/{id}  -> egy labdarúgó
    @GetMapping("/{id}")
    public ResponseEntity<Labdarugo> getOne(@PathVariable Integer id) {
        try {
            Labdarugo labdarugo = labdarugoService.findById(id);
            return ResponseEntity.ok(labdarugo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // POST /api/labdarugok  -> új labdarúgó létrehozása
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Labdarugo labdarugo) {

        if (labdarugo.getId() == null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Az ID megadása kötelező (nincs auto_increment).");
        }

        if (labdarugoService.existsById(labdarugo.getId())) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Már létezik labdarúgó ezzel az ID-val: " + labdarugo.getId());
        }

        labdarugoService.save(labdarugo);
        return ResponseEntity.status(HttpStatus.CREATED).body(labdarugo);
    }

    // PUT /api/labdarugok/{id}  -> meglévő labdarúgó módosítása
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Labdarugo ujAdatok) {

        if (!labdarugoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        // biztosítjuk, hogy az ID a path változóval egyezzen
        ujAdatok.setId(id);

        labdarugoService.save(ujAdatok);
        return ResponseEntity.ok(ujAdatok);
    }

    // DELETE /api/labdarugok/{id}  -> törlés
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        if (!labdarugoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        labdarugoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
