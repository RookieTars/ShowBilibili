package com.example.showbilibili;

public class Lists {
    String aid;
    String title;
    String play;
    String video_review;
    String author;
    String pic;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    public String getVideo_review() {
        return video_review;
    }

    public void setVideo_review(String video_review) {
        this.video_review = video_review;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Lists{" +
                "aid='" + aid + '\'' +
                ", title='" + title + '\'' +
                ", play='" + play + '\'' +
                ", video_review='" + video_review + '\'' +
                ", author='" + author + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
