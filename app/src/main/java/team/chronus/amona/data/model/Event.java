package team.chronus.amona.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.Serializable;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

@AutoValue
public abstract class Event implements Serializable{

    public abstract Long created();
    public abstract String id();
    public abstract String name();
    public abstract Integer rsvp_limit();
    public abstract String status();
    public abstract Long time();
    public abstract String rsvp_close_offset();
    public abstract Long updated();
    public abstract Integer utc_offset();
    public abstract Integer waitlist_count();
    public abstract Integer yes_rsvp_count();
    public abstract Venue venue();
    public abstract Group group();
    public abstract String link();
    public abstract String description();
    public abstract String how_to_find_us();
    public abstract String visibility();


    public static Builder builder() {
        return new AutoValue_Event.Builder();
    }

    public static TypeAdapter<Event> typeAdapter(Gson gson) {
        return new AutoValue_Event.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder created(Long created);
        public abstract Builder id(String id);
        public abstract Builder name(String name);
        public abstract Builder rsvp_limit(Integer rsvp_limit);
        public abstract Builder status(String status);
        public abstract Builder time(Long time);
        public abstract Builder rsvp_close_offset(String rsvp_close_offset);
        public abstract Builder updated(Long updated);
        public abstract Builder utc_offset(Integer utc_offset);
        public abstract Builder waitlist_count(Integer waitlist_count);
        public abstract Builder yes_rsvp_count(Integer yes_rsvp_count);
        public abstract Builder venue(Venue venue);
        public abstract Builder group(Group group);
        public abstract Builder link(String link);
        public abstract Builder description(String description);
        public abstract Builder how_to_find_us(String how_to_find_us);
        public abstract Builder visibility(String visibility);

        public abstract Event build();
    }


//    @SerializedName("created")
//    @Expose
//    private Integer created;
//    @SerializedName("id")
//    @Expose
//    private String id;
//    @SerializedName("name")
//    @Expose
//    private String name;
//    @SerializedName("rsvp_limit")
//    @Expose
//    private Integer rsvpLimit;
//    @SerializedName("status")
//    @Expose
//    private String status;
//    @SerializedName("time")
//    @Expose
//    private Integer time;
//    @SerializedName("rsvp_close_offset")
//    @Expose
//    private String rsvpCloseOffset;
//    @SerializedName("updated")
//    @Expose
//    private Integer updated;
//    @SerializedName("utc_offset")
//    @Expose
//    private Integer utcOffset;
//    @SerializedName("waitlist_count")
//    @Expose
//    private Integer waitlistCount;
//    @SerializedName("yes_rsvp_count")
//    @Expose
//    private Integer yesRsvpCount;
//    @SerializedName("venue")
//    @Expose
//    private Venue venue;
//    @SerializedName("group")
//    @Expose
//    private Group group;
//    @SerializedName("link")
//    @Expose
//    private String link;
//    @SerializedName("description")
//    @Expose
//    private String description;
//    @SerializedName("how_to_find_us")
//    @Expose
//    private String howToFindUs;
//    @SerializedName("visibility")
//    @Expose
//    private String visibility;
//
//    public Integer getCreated() {
//        return created;
//    }
//
//    public void setCreated(Integer created) {
//        this.created = created;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getRsvpLimit() {
//        return rsvpLimit;
//    }
//
//    public void setRsvpLimit(Integer rsvpLimit) {
//        this.rsvpLimit = rsvpLimit;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public Integer getTime() {
//        return time;
//    }
//
//    public void setTime(Integer time) {
//        this.time = time;
//    }
//
//    public String getRsvpCloseOffset() {
//        return rsvpCloseOffset;
//    }
//
//    public void setRsvpCloseOffset(String rsvpCloseOffset) {
//        this.rsvpCloseOffset = rsvpCloseOffset;
//    }
//
//    public Integer getUpdated() {
//        return updated;
//    }
//
//    public void setUpdated(Integer updated) {
//        this.updated = updated;
//    }
//
//    public Integer getUtcOffset() {
//        return utcOffset;
//    }
//
//    public void setUtcOffset(Integer utcOffset) {
//        this.utcOffset = utcOffset;
//    }
//
//    public Integer getWaitlistCount() {
//        return waitlistCount;
//    }
//
//    public void setWaitlistCount(Integer waitlistCount) {
//        this.waitlistCount = waitlistCount;
//    }
//
//    public Integer getYesRsvpCount() {
//        return yesRsvpCount;
//    }
//
//    public void setYesRsvpCount(Integer yesRsvpCount) {
//        this.yesRsvpCount = yesRsvpCount;
//    }
//
//    public Venue getVenue() {
//        return venue;
//    }
//
//    public void setVenue(Venue venue) {
//        this.venue = venue;
//    }
//
//    public Group getGroup() {
//        return group;
//    }
//
//    public void setGroup(Group group) {
//        this.group = group;
//    }
//
//    public String getLink() {
//        return link;
//    }
//
//    public void setLink(String link) {
//        this.link = link;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getHowToFindUs() {
//        return howToFindUs;
//    }
//
//    public void setHowToFindUs(String howToFindUs) {
//        this.howToFindUs = howToFindUs;
//    }
//
//    public String getVisibility() {
//        return visibility;
//    }
//
//    public void setVisibility(String visibility) {
//        this.visibility = visibility;
//    }

}