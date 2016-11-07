package info.tiefenauer.model;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

import static java.util.stream.Collectors.toSet;

/**
 * Created by Daniel on 07.11.2016.
 */
@Component
public class ZwischerRepositoryImpl implements ZwischerRepository {

    private final Twitter twitter;

    @Autowired
    public ZwischerRepositoryImpl(Twitter twitter) {
        this.twitter = twitter;
    }

    @Override
    @HystrixCommand(fallbackMethod = "noResults", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value="5000")
    })
    public Collection<String> search(String q, int pageSize) {
        SearchResults results = twitter.searchOperations().search(q, pageSize);
        return results.getTweets().stream()
                .map(Tweet::getUnmodifiedText)
                .collect(toSet());
    }

    protected Collection<String> noResults(String q, int pageSize){
        return Collections.singleton("Error getting Tweet stream. Using fallback.");
    }
}
