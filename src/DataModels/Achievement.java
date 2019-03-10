package DataModels;

public class Achievement {
    public String name;
    public String info;
    public String imageSource;

    public Achievement(String name, String info, String imageSource){
        this.name = name;
        this.info = info;
        this.imageSource = imageSource;
    }

    public String getName() {
        return name;
    }

    public String getImageSource() {
        return imageSource;
    }
}
