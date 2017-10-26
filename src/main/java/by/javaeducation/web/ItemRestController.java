package by.javaeducation.web;

import by.javaeducation.model.Item;
import by.javaeducation.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(ItemRestController.REST_URL)
public class ItemRestController {

    private static final Logger LOG = LoggerFactory.getLogger(ItemRestController.class);
    static final String REST_URL = "/rest/items";

    @Autowired
    private ItemService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> create(@RequestBody Item item) {
        LOG.info("create {}.", item);
        Item newItem = service.save(item);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(newItem.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(newItem);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        LOG.info("delete item id = {}.", id);
        service.delete(id);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Item get(@PathVariable("id") int id) {
        LOG.info("get item id = {}.", id);
        return service.get(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Item update(@RequestBody Item item) {
        LOG.info("update {}.", item);
        return service.update(item);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getAll() {
        LOG.info("get all items.");
        return service.getAll();
    }
}
