/**
 * Created by Matthew on 2017-01-22.
 */
public class MainChannel extends UserChannel{
    public MainChannel(){
        super("MainChannel"); // cos tam xD
    }

    @Override
    public boolean removalPermission(){
        return false;
    }
}
