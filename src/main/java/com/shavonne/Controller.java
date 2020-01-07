package com.shavonne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class Controller {
    @Autowired
    private BlogEntryRepository blogEntryRepository;

    @GetMapping(path = "/entries")
    public @ResponseBody
    Iterable<BlogEntry> getAllBlogEntries() {
        return blogEntryRepository.findAll();
    }

    @GetMapping("/entry/{entryId}")
    public BlogEntry getBlogEntryById(@PathVariable Integer entryId) {
        return blogEntryRepository.findById(entryId).get();
    }


    @PostMapping("/entries")
    public ResponseEntity<BlogEntry> createBlogEntry(@RequestBody BlogEntry blogEntry) {
        BlogEntry savedBlogEntry = blogEntryRepository.save(blogEntry);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/entries")
                .buildAndExpand(savedBlogEntry.getEntryId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/entries/{entryId}")
    public ResponseEntity<BlogEntry> updateBlogEntry(@RequestBody BlogEntry blogEntry) {
        BlogEntry savedBlogEntry = blogEntryRepository.save(blogEntry);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{entryId}")
                .buildAndExpand(savedBlogEntry.getEntryId()).toUri();
        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/delete/{entryId}")
    public void deleteBlogEntry(@PathVariable("entryId") Integer entryId) {
        BlogEntry deletedBlogEntry = blogEntryRepository.findById(entryId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Blog Entry Id:" + entryId));
        blogEntryRepository.delete(deletedBlogEntry);
    }
}
