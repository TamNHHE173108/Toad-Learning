/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author My Lap
 */
public class Media {
    private String mediaID;
    private String lessonID;
    private String mediaType;
    private String mediaPath;

    // Constructors, getters and setters
    public Media(String mediaID, String lessonID, String mediaType, String mediaPath) {
        this.mediaID = mediaID;
        this.lessonID = lessonID;
        this.mediaType = mediaType;
        this.mediaPath = mediaPath;
    }

    public String getMediaID() { return mediaID; }
    public void setMediaID(String mediaID) { this.mediaID = mediaID; }

    public String getLessonID() { return lessonID; }
    public void setLessonID(String lessonID) { this.lessonID = lessonID; }

    public String getMediaType() { return mediaType; }
    public void setMediaType(String mediaType) { this.mediaType = mediaType; }

    public String getMediaPath() { return mediaPath; }
    public void setMediaPath(String mediaPath) { this.mediaPath = mediaPath; }
}

