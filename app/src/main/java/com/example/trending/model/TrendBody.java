package com.example.trending.model;

import java.util.List;

import okhttp3.OkHttpClient;

public class TrendBody {

    /**
     * author : xingshaocheng
     * name : architect-awesome
     * avatar : https://github.com/xingshaocheng.png
     * url : https://github.com/xingshaocheng/architect-awesome
     * description : 后端架构师技术图谱
     * stars : 7333
     * forks : 1546
     * currentPeriodStars : 1528
     * builtBy : [{"href":"https://github.com/viatsko","avatar":"https://avatars0.githubusercontent.com/u/376065","username":"viatsko"}]
     * language : Go
     * languageColor : #3572A5
     */

    private String author;
    private String name;
    private String avatar;
    private String url;
    private String description;
    private int stars;
    private int forks;
    private int currentPeriodStars;
    private String language;
    private String languageColor;
    private List<BuiltByBean> builtBy;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getCurrentPeriodStars() {
        return currentPeriodStars;
    }

    public void setCurrentPeriodStars(int currentPeriodStars) {
        this.currentPeriodStars = currentPeriodStars;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguageColor() {
        return languageColor;
    }

    public void setLanguageColor(String languageColor) {
        this.languageColor = languageColor;
    }

    public List<BuiltByBean> getBuiltBy() {
        return builtBy;
    }

    public void setBuiltBy(List<BuiltByBean> builtBy) {
        this.builtBy = builtBy;
    }

    public static class BuiltByBean {
        /**
         * href : https://github.com/viatsko
         * avatar : https://avatars0.githubusercontent.com/u/376065
         * username : viatsko
         */

        private String href;
        private String avatar;
        private String username;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
