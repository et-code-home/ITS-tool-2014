/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modeling.and.analysis.tool;

import com.sun.jna.NativeLibrary;
import java.awt.Canvas;
import java.awt.Color;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/**
 *
 * @author Elissa
 */
public class VideoView {
    
    private Canvas ourCanvas = new Canvas();
    private String mediaPath = "";        
    private EmbeddedMediaPlayer mediaPlayer;
    
    VideoView(String vlcPath,String mediaURL)
    {
        this.mediaPath = mediaURL;
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), vlcPath);
        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();        
        ourCanvas.setBackground(Color.black);
        mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
        mediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(ourCanvas));
        ourCanvas.setSize(400,250);
        ourCanvas.setVisible(true);
    }
    
    public Canvas getVideoDisplay()
    {
        return ourCanvas;
    }
        
    public void run()
    {
        mediaPlayer.playMedia(mediaPath);
    }
    

}
