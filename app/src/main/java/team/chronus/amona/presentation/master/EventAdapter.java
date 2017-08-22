package team.chronus.amona.presentation.master;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import team.chronus.amona.R;
import team.chronus.amona.data.model.Event;

/**
 * Created by ahmed on 8/22/17.
 */

class EventAdapter extends RecyclerView.Adapter<EventHolder>{
        private List<Event> eventList;
        private Context context;
        EventAdapter(List<Event> eventList, Context context){
            this.eventList = eventList;
            this.context = context;
        }

        @Override
        public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.master_list_item, parent,
                    false);
            return new EventHolder(view, context);
        }

        @Override
        public void onBindViewHolder(EventHolder holder, int position) {
            Event event = eventList.get(position);
            holder.bindEvent(event);
        }

        @Override
        public int getItemCount() {
            return eventList.size();
        }

        void setEventList(List<Event> eventList){
            this.eventList = eventList;

        }
}
