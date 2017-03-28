package vue;

import java.io.File; 
import javax.swing.filechooser.FileFilter;

public class FiltreMenuOuvrir extends FileFilter{
 
  @Override
  public boolean accept(File f) {
 
    String extension = null;
    String nomFichier = f.getName(); 
    int i = nomFichier.lastIndexOf('.');

        if (i > 0 &&  i < nomFichier.length() - 1) {
          extension = nomFichier.substring(i + 1).toLowerCase();
        }
        
        if (f.isDirectory() || extension.equals("jpeg") || 
            extension.equals("jpg") ||
            extension.equals("png") || extension.equals("gif") ||
            extension.equals("bmp")) {
          return true;
        } 
        return false;
  }
 
  @Override
  public String getDescription() {
    return "Images";
  }
  
}
