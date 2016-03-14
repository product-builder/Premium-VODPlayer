/* Decompiled by Mocha from Vodclient.class */
/* Originally compiled from VODClient.java */

package MPEGDecoder; 

import java.awt.*; 
import java.applet.Applet; 
import java.net.URL; 
import java.awt.event.*; 
import MPEGDecoder.ListFrameListener2; 
import MPEGDecoder.VODClientListener3; 

import MPEGDecoder.Detail; 
import MPEGDecoder.DetailListener1; 

import MPEGDecoder.VODClientListener2; 

import MPEGDecoder.VODClientListener4; 
import MPEGDecoder.ServerSelect; 
import MPEGDecoder.ServerSelectListener1; 
import MPEGDecoder.ServerSelectListener2; 
import MPEGDecoder.ServerSelectListener3; 

public   class  VODClient  extends Frame {
	
	boolean isStandalone;

	
	ServerReq server;

	
	Movie curmovie;

	

	BorderPanel bevelPanel2;

	
	BorderPanel panel1;

	
	BorderPanel panel2;

	
	Label label3;

	
    BorderPanel bevelPanel3;

	
    Label label1;

	
    Label label2;

	
   
 
   
    Video video=null;

	
    Thread vthread=null;

	
 

    public VODClient  ()
    {
	/*	Class c = BitInputStream.class;
		c = Block.class;
		c = BlockHeader.class;
		c = BorderPanel.class;
		c = DataStore.class;
	//	c = Detail.class;
		//c = DetailListener1.class;
		c = FrameImage.class;
		c = GOP.class;
		c = GOPHeader.class;
		c = IDCT.class;
		
		c = MacroblockNew.class;
		c = MacroHeader.class;
		c = Movie.class;
		c = Picture.class;
		c = PictureHeader.class;
		c = SequenceHeader.class;
		c = ServerReq.class;
		
		c = Slice.class;
		c = SliceHeaderNew.class;
		c = Video.class;
		c = VODClient.class;*/
	
		isStandalone = false;
        bevelPanel2 = new BorderPanel(1, new Color(220, 220, 220), new Color(50, 50, 50));   
        bevelPanel3 = new BorderPanel(1, new Color(220, 220, 220), new Color(50, 50, 50));
        label1 = new Label();
        label2 = new Label();
        panel1 = new BorderPanel(1, new Color(220, 220, 220), new Color(50, 50, 50));
        panel2 = new BorderPanel(1, new Color(220, 220, 220), new Color(50, 50, 50));
        label3 = new Label();
        curmovie = null;
        video = new Video(panel1, label1, label2, this);
    
        buttonControl1 = new Button();
      /*  c = ListFrame.class;
    	c = ListFrameListener4.class;
    	c = ListFrameListener2.class;
        c = VODClientListener1.class;*/
    		
           
       /* c = ListFrameListener3.class;
        c = DetailListener1.class;
        c = Detail.class;*/
   
    

		buttonControl2 = new Button();
	//	c = VODClientListener2.class;
	

        buttonControl3 = new Button();
     //   c = VODClientListener3.class;
   
    
		
        buttonControl4 = new Button();
        //c = VODClientListener4.class;
        
    
 /*
        c = ListFrameListener1.class;
        c = ServerSelect.class;	
        c = ServerSelectListener1.class;
        c = ServerSelectListener2.class;
        c = ServerSelectListener3.class;*/
    }

	

 protected void processWindowEvent(WindowEvent e) {
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
        System.exit(0);
    }
  }

	

    public final void clearmovie()
    {
        vthread.stop();
        video.setvideostream(null);
        curmovie = null;
        label3.setText("Title : ");
    }

	

   
    public final String getAppletInfo()
    {
        return "VOD3 MoviePlayer";
    }

	
/*
    public String getParameter(String string1, String string2)
    {
        return isStandalone ? System.getProperty(string1, string2) : ((getParameter(string1) != null) ? getParameter(string1) : string2);
    }
*/
    public final String[][] getParameterInfo()
    {
        return null;
    }

	

     private final void  init__wrappee__VODPlayer  ()
    {
        try
        {
            jbInit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //String string = getParameter("rate", "off");
       // if (!string.equals("off"))
        //    video.setratecontrol(true);
        short s = 5006;
        video.setratecontrol(true);

        server = new ServerReq( "127.0.0.1", s);//192.168.10.108
        server.connect();
        //listframe = new ListFrame(server, this);
    }

	
    
    public final void init(){
    	init__wrappee__VODPlayer();
    	listframe = new ListFrame(server, this);
    }

	

     private final void  jbInit__wrappee__VODPlayer  ()
        throws Exception
    {
        setLayout(null);
        setBackground(Color.lightGray);
        setSize(new Dimension(376, 407));
        bevelPanel2.setBounds(new Rectangle(5, 314, 364, 87));
        bevelPanel2.setLayout(null);
            
        bevelPanel3.setLayout(null);
        bevelPanel3.setBounds(new Rectangle(229, 15, 124, 56));
       
        label1.setBounds(new Rectangle(7, 5, 110, 22));
        label2.setBounds(new Rectangle(9, 27, 110, 21));
        label2.setText("Time :");
        panel1.setBounds(new Rectangle(5, 63, 364, 244));
        panel2.setBounds(new Rectangle(5, 10, 364, 45));
        panel2.setLayout(null);
        label3.setFont(new Font("Dialog", 3, 20));
        label3.setBounds(new Rectangle(32, 11, 330, 26));
        label3.setText("Title :");
        add(bevelPanel2, null);             
        bevelPanel2.add(bevelPanel3, null);
        bevelPanel3.add(label1, null);
        bevelPanel3.add(label2, null);
        add(panel1, null);
        add(panel2, null);
        panel2.add(label3, null);
    }

	 
     private final void  jbInit__wrappee__ViewMovieDetail  ()throws Exception{
        jbInit__wrappee__VODPlayer();
        buttonControl1.setBounds(new Rectangle(5, 22, 60, 45));
        buttonControl1.setLabel("Movies");
        buttonControl1.addActionListener(new VODClientListener1(this));
        bevelPanel2.add(buttonControl1, null);
    }

	
    
     private void  jbInit__wrappee__PauseMovie  () throws Exception {
		jbInit__wrappee__ViewMovieDetail();
		buttonControl2.setBounds(new Rectangle(70, 22, 40, 45));
		buttonControl2.setLabel("PLAY");
		buttonControl2.addActionListener(new VODClientListener2(this));
		bevelPanel2.add(buttonControl2, null);
	}

	

  

    private  void jbInit()
        throws Exception
    {
        jbInit__wrappee__PauseMovie();
        buttonControl4.setBounds(new Rectangle(165, 22, 45, 45));
        buttonControl4.setLabel("Quit");
        buttonControl4.addActionListener(new VODClientListener4(this));
        bevelPanel2.add(buttonControl4, null);
       
    }

	

    public static void main(String astring[])
    {
		/*
        VODClient vODClient = new VODClient();
        vODClient.isStandalone = true;
        Frame frame = new Frame();
        frame.setTitle("VOD3 Movie Player");
        frame.add(vODClient, "Center");
        vODClient.init();
        vODClient.start();
        frame.setSize(393, 441);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((dimension.width - frame.getSize().width) / 2, (dimension.height - frame.getSize().height) / 2);
        frame.setVisible(true);
		*/
        VODClient vODClient = new VODClient();
        vODClient.isStandalone = true;
        vODClient.setTitle("VOD3 MoviePlayer");
        vODClient.init();
        vODClient.setSize(370, 400);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        vODClient.setLocation((dimension.width - vODClient.getSize().width) / 2, (dimension.height - vODClient.getSize().height) / 2);
        vODClient.setVisible(true);
    }

	

   public  void stopmovie()
    {
        if (curmovie == null)
            return;
    }

	
    Button buttonControl1;

	//button Movie
    ListFrame listframe;

	
    void buttonControl1_actionPerformed(ActionEvent actionEvent)
    {
		//movies
        listframe.show();
    }

	

    public final void selectmovie(String string)
    {
        curmovie = server.getmovie(string);
        listframe.setVisible(false);
        if (curmovie == null)
            return;
        if (vthread != null && vthread.isAlive())
        {
            vthread.stop();
            video.stopmovie();
            setButtonPlay();
        }
        panel1.clearscreen();
        video.setvideostream(curmovie.getstream_url());
        label3.setText(new StringBuffer("Title: ").append(string).toString());

       

    }

	
    
     private void  setButtonPlay__wrappee__ViewMovieDetail  (){}

	
    
    void setButtonPlay(){//if feature play is included
    	setButtonPlay__wrappee__ViewMovieDetail();
    	buttonControl2.setLabel("PLAY");
    }

	
    
   
    Button buttonControl2;

	

    
    void buttonControl2_actionPerformed(ActionEvent actionEvent) {
		// play, pause, resume
		if (buttonControl2.getLabel().equals("PLAY")) {
			if (curmovie == null)
				return;
			vthread = new Thread(video);
			vthread.start();
		
			setLabelPause();//lo refinaPause si es necesario
					//buttonControl2.setLabel("PAUSE");	
			return;	
		}					
		ifActionPause();//lo refina la feature pause
		
	}

	
    
     private void  ifActionPause__wrappee__StopMovie  (){}

	//play, pause, resume
	
	
	
	 private void ifActionPause(){//lo refina el pause para el starMov
		
		ifActionPause__wrappee__StopMovie();
		
		if (buttonControl2.getLabel().equals("PAUSE")) {
			vthread.suspend();
			buttonControl2.setLabel("CLICK TO RESUME");
			return;//
		} 
		
		if(buttonControl2.getLabel().equals("CLICK TO RESUME")) {
			vthread.resume();
			buttonControl2.setLabel("PAUSE");
			return;//
		}
	}

	
    
    
    public final void destroy()//al hacer quit? R11
    {
        vthread.stop();
        video.stopmovie();
        buttonControl2.setLabel("PLAY");
        System.out.println("destroy");
		super.dispose();
    }

	
     private void  setLabelPause__wrappee__StopMovie  (){  }

	

	
	 void setLabelPause(){
		 setLabelPause__wrappee__StopMovie();
		 buttonControl2.setLabel("PAUSE");
	 }

	
    
    Button buttonControl3;

	

    void buttonControl3_actionPerformed(ActionEvent actionEvent)
    {
		//stop
        if (curmovie == null)
            return;
        vthread.stop();
        video.stopmovie();
        buttonControl2.setLabel("PLAY");
    }

	
  
	Button buttonControl4;

	

    void buttonControl4_actionPerformed(ActionEvent actionEvent)
    {
		int success = 0;
		
		if (server!=null)
		{
			success = server.terminateConnection();
		}
		
		//quit
		if (vthread != null)
			vthread.stop();
		
		if (video != null)
		{
			video.stopmovie();
			video.destroy();
		}
		
		vthread = null;
		video = null;
		
		super.dispose();
		
      System.exit(success);
    }


}
