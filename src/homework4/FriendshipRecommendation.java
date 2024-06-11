package homework4;

public class FriendshipRecommendation implements Comparable<FriendshipRecommendation> {
    private String recommendedFriend;
    private int recommendationStrength;


    public FriendshipRecommendation(String recommendedFriend, int recommendationStrength) {
        this.recommendedFriend = recommendedFriend;
        this.recommendationStrength = recommendationStrength;
    }


    public String getRecommendedFriend() {
        return recommendedFriend;
    }

    public int getRecommendationStrength() {
        return recommendationStrength;
    }


    public void setRecommendedFriend(String recommendedFriend) {
        this.recommendedFriend = recommendedFriend;
    }

    public void setRecommendationStrength(int recommendationStrength) {
        this.recommendationStrength = recommendationStrength;
    }


    @Override
    public int compareTo(FriendshipRecommendation o) {
        return Integer.compare(o.recommendationStrength, this.recommendationStrength); // descending order
    }


    @Override
    public String toString() {
        return recommendedFriend + ": " + recommendationStrength;
    }
}