/* Decompiled by Jasmine from Movie.class */
/* Originally compiled from Movie.java */

package MPEGDecoder;

import java.io.Serializable;
import java.net.URL;
import java.util.Vector;

public class Movie implements Serializable
{

    Vector screenSub;
    String stream_url;
    URL url;
    static final String default_string = "no info";

    public Movie(String string1, String string2)
    {
        this(string1, "no info", "no info", "no info", string2);
    }

    public Movie(String string1, String string2, String string3, String string4, String string5)
    {
      
        //screenSub = new Vector();
        try
        {
            url = new URL(string5);
        }
        catch (Exception e)
        {
            url = null;
        }
    }

    public void addscreen_subs(String string)
    {
        screen_sub.addElement(string);
    }

    public String getSubtitles()
    {
        return subs;
    }

  
}
