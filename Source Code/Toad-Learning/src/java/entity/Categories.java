package entity;

public class Categories {
    private String topicID;
    private String categoryName;

    public Categories(String topicID, String categoryName) {
        this.topicID = topicID;
        this.categoryName = categoryName;
    }

    public String getTopicID() {
        return topicID;
    }

    public void setTopicID(String topicID) {
        this.topicID = topicID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
