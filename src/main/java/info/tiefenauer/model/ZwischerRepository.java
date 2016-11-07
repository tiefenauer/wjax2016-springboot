package info.tiefenauer.model;

import java.util.Collection;

/**
 * Created by Daniel on 07.11.2016.
 */
public interface ZwischerRepository {

    Collection<String> search(String q, int pageSize);
}
