package de.bht.fpa.mail.s749711.utilities;

import java.io.File;
import java.io.FilenameFilter;

public class DirectoryFilter implements FilenameFilter {

  @Override
  public boolean accept(File dir, String name) {
    return new File(dir.getAbsolutePath() + "\\" + name).isDirectory();
  }

}
