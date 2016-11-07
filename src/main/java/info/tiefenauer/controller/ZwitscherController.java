package info.tiefenauer.controller;

import info.tiefenauer.model.ZwischerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Daniel on 07.11.2016.
 */
@RestController
@RequestMapping("/tweets")
public class ZwitscherController {

    private final ZwischerRepository repository;

    @Autowired
    public ZwitscherController(ZwischerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(path = "/{q}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public HttpEntity<Collection<String>> tweets(
            @PathVariable("q") String q,
            @RequestParam(name = "limit", defaultValue = "10") int limit){
        Collection<String> tweets = repository.search(q, limit);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }
}
