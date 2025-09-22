package com.tnsif.shoppingmall.controller;

import com.tnsif.shoppingmall.entity.Mall;
import com.tnsif.shoppingmall.services.MallService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/malls")
public class MallController {

    private final MallService mallService;

    public MallController(MallService mallService) {
        this.mallService = mallService;
    }

    @PostMapping
    public ResponseEntity<Mall> create(@RequestBody Mall mall) {
        Mall saved = mallService.save(mall);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mall> get(@PathVariable long id) {
        Mall mall = mallService.get(id);
        return mall != null ? ResponseEntity.ok(mall) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        mallService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
