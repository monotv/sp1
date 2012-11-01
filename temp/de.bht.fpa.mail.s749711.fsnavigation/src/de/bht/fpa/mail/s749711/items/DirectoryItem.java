package de.bht.fpa.mail.s749711.items;

import java.io.File;
import java.util.ArrayList;

import de.bht.fpa.mail.s749711.utilities.DirectoryFilter;
import de.bht.fpa.mail.s749711.utilities.XMLFilter;

public class DirectoryItem extends AbstractFileSystemItem {

  private final File file;
  private final String name;
  private final boolean isHidden;

  public DirectoryItem(File file) {
    this.file = file;
    this.name = this.file.getName();
    this.isHidden = this.file.isHidden();
  }

  @Override
  public File getFile() {
    return file;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean isHidden() {
    return isHidden;
  }

  @Override
  public AbstractFileSystemItem[] getChildren(String filterString) {
    File[] files;
    if (filterString == "directory") {
      files = this.file.listFiles(new DirectoryFilter());
    } else if (filterString == "xml") {
      files = this.file.listFiles(new XMLFilter());
    } else {
      files = this.file.listFiles();
    }
    // maybe something got deleted
    if (files == null) {
      return new AbstractFileSystemItem[0];
    }
    ArrayList<AbstractFileSystemItem> children = new ArrayList<AbstractFileSystemItem>();
    AbstractFileSystemItem[] arr = new AbstractFileSystemItem[children.size()];
    for (int i = 0; i < files.length; i++) {
      if (files[i].isDirectory()) {
        children.add(new DirectoryItem(files[i]));
      } else if (filterString == "xml") {
        children.add(new MessageItem(files[i]));
      } else {
        children.add(new FileItem(files[i]));
      }
    }
    return children.toArray(arr);
  }
}
