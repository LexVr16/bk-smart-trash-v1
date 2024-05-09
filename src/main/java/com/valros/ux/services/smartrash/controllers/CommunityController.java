package com.valros.ux.services.smartrash.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("${application.api.base-path}")
public class CommunityController {
//
//    @RequestMapping(
//            method = RequestMethod.GET,
//            value = "/communities",
//            produces = { "application/json" }
//    )
//    public ResponseEntity<List<Community>> getCommunities() {
//        log.info("Entro a este metodo getCommunities()");
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @RequestMapping(
//            method = RequestMethod.POST,
//            value = "/communities/create",
//            produces = { "application/json" },
//            consumes = { "application/json" }
//    )
//    public ResponseEntity<Community> postCreateCommunity(Community community) {
//        return null;
//    }
}
