package team.chronus.amona.data;

import java.util.List;

import io.reactivex.Observable;
import team.chronus.amona.data.model.Event;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

public interface AppDataSource {

    Observable<List<Event>> getRecommendedEvents();

    Observable<List<Event>> getSelfEvents();

    void saveRecommendedEvents(List<Event> events);

    void saveSelfEvents(List<Event> events);
}
