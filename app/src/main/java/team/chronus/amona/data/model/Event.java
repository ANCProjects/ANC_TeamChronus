package team.chronus.amona.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */


public class Event {

    @SerializedName("created")
    @Expose
    private Integer created;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rsvp_limit")
    @Expose
    private Integer rsvpLimit;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("rsvp_close_offset")
    @Expose
    private String rsvpCloseOffset;
    @SerializedName("updated")
    @Expose
    private Integer updated;
    @SerializedName("utc_offset")
    @Expose
    private Integer utcOffset;
    @SerializedName("waitlist_count")
    @Expose
    private Integer waitlistCount;
    @SerializedName("yes_rsvp_count")
    @Expose
    private Integer yesRsvpCount;
    @SerializedName("venue")
    @Expose
    private Venue venue;
    @SerializedName("group")
    @Expose
    private Group group;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("how_to_find_us")
    @Expose
    private String howToFindUs;
    @SerializedName("visibility")
    @Expose
    private String visibility;

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRsvpLimit() {
        return rsvpLimit;
    }

    public void setRsvpLimit(Integer rsvpLimit) {
        this.rsvpLimit = rsvpLimit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getRsvpCloseOffset() {
        return rsvpCloseOffset;
    }

    public void setRsvpCloseOffset(String rsvpCloseOffset) {
        this.rsvpCloseOffset = rsvpCloseOffset;
    }

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    public Integer getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Integer utcOffset) {
        this.utcOffset = utcOffset;
    }

    public Integer getWaitlistCount() {
        return waitlistCount;
    }

    public void setWaitlistCount(Integer waitlistCount) {
        this.waitlistCount = waitlistCount;
    }

    public Integer getYesRsvpCount() {
        return yesRsvpCount;
    }

    public void setYesRsvpCount(Integer yesRsvpCount) {
        this.yesRsvpCount = yesRsvpCount;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHowToFindUs() {
        return howToFindUs;
    }

    public void setHowToFindUs(String howToFindUs) {
        this.howToFindUs = howToFindUs;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

}