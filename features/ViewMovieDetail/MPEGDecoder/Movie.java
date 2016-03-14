/* Decompiled by Jasmine from Movie.class */
/* Originally compiled from Movie.java */

package MPEGDecoder;

import java.io.Serializable;
import java.net.URL;
import java.util.Vector;

public class Movie implements Serializable
{
    String review;
    String awards;
    
    
    
    

    public Movie(String string1, String string2, String string3, String string4, String string5, String string6 ,String string7)
    {
        title = string1;
        actor = string2;
        director = string3;
        description = string4;
        stream_url = string5;
        review = string6;
        awards = string7;
        screen_shut = new Vector();
        try
        {
            url = new URL(string5);
        }
        catch (Exception e)
        {
            url = null;
        }
    }

    
    public URL getawards()
    {
        return awards;
    }

    public String getReviews()
    {
        return reviews;
    }
}
