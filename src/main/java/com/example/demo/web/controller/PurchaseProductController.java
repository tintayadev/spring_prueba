package com.example.demo.web.controller;

import com.example.demo.domain.dto.PurchaseProduct;
import com.example.demo.domain.service.PurchaseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase-products")
public class PurchaseProductController {
    @Autowired
    private PurchaseProductService purchaseProductService;

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseProduct>> getAll() {
        return new ResponseEntity<>(purchaseProductService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/purchase/{purchaseId}/product/{productId}")
    public ResponseEntity<PurchaseProduct> getPurchaseProduct(@PathVariable("purchaseId") int purchaseId,
                                                              @PathVariable("productId") int productId) {
        return purchaseProductService.getPurchaseProduct(purchaseId, productId)
                .map(purchaseProduct -> new ResponseEntity<>(purchaseProduct, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<PurchaseProduct> save(@RequestBody PurchaseProduct purchaseProduct) {
        return new ResponseEntity<>(purchaseProductService.save(purchaseProduct), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/purchase/{purchaseId}/product/{productId}")
    public ResponseEntity delete(@PathVariable("purchaseId") int purchaseId, @PathVariable("productId") int productId) {
        if (purchaseProductService.delete(purchaseId, productId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
