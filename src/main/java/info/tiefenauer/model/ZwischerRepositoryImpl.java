package info.tiefenauer.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Component;

import java.util.Collection;

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
    public Collection<String> search(String q, int pageSize) {
        SearchResults results = twitter.searchOperations().search(q, pageSize);
        return results.getTweets().stream()
                .map(Tweet::getUnmodifiedText)
                .collect(toSet());
    }
}
