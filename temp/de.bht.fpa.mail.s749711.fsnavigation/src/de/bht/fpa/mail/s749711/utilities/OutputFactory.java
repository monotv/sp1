package de.bht.fpa.mail.s749711.utilities;

import java.util.Observable;

import de.bht.fpa.mail.s749711.items.AbstractFileSystemItem;
import de.bht.fpa.mail.s749711.items.DirectoryItem;
import de.bht.fpa.mail.s749711.items.MessageItem;

public final class OutputFactory extends Observable {
  private static OutputFactory instance = null;

  private OutputFactory() {

  }

  public static OutputFactory getInstance() {
    if (instance == null) {
      instance = new OutputFactory();
    }
    return instance;
  }

  public void produceOutput(Object[] obj, AbstractFileSystemItem item) {
    if (obj instanceof AbstractFileSystemItem[] && item instanceof DirectoryItem) {
      System.out.println("Selected directory: " + item.getFile().getAbsolutePath());
      System.out.println("Number of messages: " + obj.length);
      for (int i = 0; i < obj.length; i++) {
        if (obj[i] instanceof MessageItem) {
          System.out.println(((MessageItem) obj[i]).getMessage().toString());
        }
      }
    }
  }
}
