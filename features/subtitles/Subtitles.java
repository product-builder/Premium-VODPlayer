
package MPEGDecoder;
import java.awt.*;
import java.awt.event.ActionEvent;
public class Subtitles extends Frame
{
    BorderPanel bevelPanel3;
    
    Button button1;
    Label label1;
    
    public Detail()
    {


        button1 = new Button();
        label1 = new Label();
        
        
        
        try
        {
            jbInit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    void button1_actionPerformed(ActionEvent actionEvent)
    {
        setVisible(false);
    }

    private final void jbInit()
        throws Exception
    {
        setSize(new Dimension(347, 293));
        setLayout(null);
        button1.setBounds(new Rectangle(93, 226, 157, 30));
        button1.setLabel("OK");
//        button1.addActionListener(new DetailListener1(this));
        label1.setFont(new Font("Dialog", 3, 15));
        label1.setBounds(new Rectangle(17, 6, 292, 25));
        label1.setText("Language :");
        label2.setFont(new Font("Dialog", 0, 14));
        label2.setBounds(new Rectangle(24, 16, 265, 24));
        label2.setText("Actor :");
       
        
        setBackground(Color.lightGray);
        setTitle("-- Subtitles -- ");
        //bevelPanel1.setLayout(null);
       // bevelPanel1.setBounds(new Rectangle(8, 30, 324, 40));
      //  bevelPanel2.setLayout(null);
//        bevelPanel2.setBounds(new Rectangle(7, 77, 324, 139));
        add(bevelPanel3, null);
  //      bevelPanel1.add(label1, null);
    //    add(bevelPanel2, null);
        bevelPanel3.add(label2, null);
        bevelPanel3.add(label3, null);
        bevelPanel3.add(label4, null);
        bevelPanel3.add(label5, null);
        add(button1, null);
    }

    public final void setmovie(Movie movie)
    {
        label1.setText(new StringBuffer("Subs : ").append(movie.getSubtitles()).toString());
        
    }
}
