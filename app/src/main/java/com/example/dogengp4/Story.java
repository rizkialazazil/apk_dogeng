package com.example.dogengp4;

public class Story {
    public String title;
    public String storyText;
    public String audio;
    public String image;

    public Story(String title, String storyText, String audio, String image) {
        this.title = title;
        this.storyText = storyText;
        this.audio = audio;
        this.image = image;
    }
    public String getTitle() {
        return title;
    }

    public String getStoryText() {
        return storyText;
    }

    public String getAudio() {
        return audio;
    }

    public String getImage() {
        return image;
    }
}
