package com.abac.keycloak.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/secured")
@Slf4j
public class ProdregController {


    @PostMapping("/create-product")
    @RolesAllowed("sales")
    public String createProduct() {
        log.info("create product api");
        return "Product created successfully";
    }

    @PutMapping("/approve-product")
    @RolesAllowed("approver")
    public String approveProduct() {
        log.info("approved product api");

        return "Product approved successfully";
    }

    @GetMapping("/dealer")
    @RolesAllowed("dealer")
    public String dealer() {
        log.info("dealer api");
        return "This is from dealer api";
    }

    @DeleteMapping("/ops")
    @RolesAllowed("opsteam")
    public String ops() {
        log.info("ops api");
        return "This is from ops api";
    }

    @GetMapping("/reject-product-list")
    @RolesAllowed({"sales", "approver", "dealer", "ops"})
    public String rejectedProductList() {
        log.info("rejected product  list");
        return "This is from rejected product  list";
    }

    @GetMapping("/approved-product-list")
    @RolesAllowed({"sales", "approver", "dealer", "ops"})
    public String approvedProductList() {
        log.info("approved product api");
        return "approved product api";
    }

    @GetMapping("/admin")
    public String admin() {
        log.info("admin");
        return "admin";
    }
}
