package bt.mythimphu.android.mythimphu.events;

/**
 * Created by moic on 11/2/16.
 */

public class TEvents {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private int image;
    private String desc;

    TEvents() {


    }
    public TEvents(String name, int image, String desc){

        this.name = name;
        this.image = image;
        this.desc = desc;

    }
}
