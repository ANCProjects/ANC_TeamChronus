package team.chronus.amona.presentation.master;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import team.chronus.amona.R;
import team.chronus.amona.data.model.Event;
import team.chronus.amona.presentation.detail.DetailActivity;

/**
 * Created by ahmed on 8/22/17.
 */

class EventHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener{
        @BindView(R.id.group_picture)
        ImageView eventPicture;

        @BindView(R.id.event_name)
        TextView eventName;

        @BindView(R.id.event_description)
        TextView eventDescription;

        @BindView(R.id.group_name)
        TextView eventGroup;

        @BindView(R.id.event_date)
        TextView eventDate;

        private Event event;
        private Context context;

        EventHolder(View itemView, Context context){
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            this.context = context;
        }

        void bindEvent(Event event){
            this.event = event;
            String imageUrl = event.group().urlname();
            //confirm image url
            Picasso.with(context)
                    .load(imageUrl)
                    .placeholder(R.drawable.image_placeholder)
                    .into(eventPicture);

            eventName.setText(event.name());
            eventDescription.setText(event.description());
            eventGroup.setText(event.group().name());
            Date date = new Date(event.time());
            SimpleDateFormat sdf = new SimpleDateFormat
                    ("EEE, MMM d, yyyy 'at' h:mm a", Locale.US);
            String dateString = sdf.format(date);
            eventDate.setText(dateString);
        }

        @Override
        public void onClick(View view) {
            Intent detailIntent = DetailActivity.getStartIntent(context, event);
            context.startActivity(detailIntent);
        }
}
