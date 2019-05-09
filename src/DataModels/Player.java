package DataModels;

import java.util.LinkedList;

public class Player {
    public String username;
    public String password;

    public int[][] arcadeLevelStars;

    public int ThreeMinuteBestScore;
    public int ThreePuzzleBestScore;
    public int RestrictedBestScore;

    public LinkedList<Achievement> achivements;

    public LinkedList<GameLevel> levels;

    public Player(String name, String pass){

        System.out.println(name + " " + pass);

        username = name;
        password = pass;
        arcadeLevelStars = new int[4][10];
        achivements = new LinkedList<Achievement>();
        levels = new LinkedList<GameLevel>();
    }

    public String getUsername() {
        return username;
    }

    public int[][] getArcadeLevelStars() {
        return arcadeLevelStars;
    }

    public int getArcadeLevelStars(int difficulty, int level) {
        return arcadeLevelStars[difficulty][level];
    }

    public int getThreeMinuteBestScore() {
        return ThreeMinuteBestScore;
    }

    public int getThreePuzzleBestScore() {
        return ThreePuzzleBestScore;
    }

    public int getRestrictedBestScore() {
        return RestrictedBestScore;
    }

    public LinkedList<Achievement> getAchivements() {
        return achivements;
    }

    public LinkedList<GameLevel> getLevels() {
        return levels;
    }
}