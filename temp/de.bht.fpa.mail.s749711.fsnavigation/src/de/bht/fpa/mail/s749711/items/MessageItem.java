package de.bht.fpa.mail.s749711.items;

import java.io.File;

import javax.xml.bind.JAXB;

import de.bht.fpa.mail.s000000.common.mail.model.Message;

public class MessageItem extends AbstractFileSystemItem {

  private final File srcFile;
  private final Message message;

  public MessageItem(File srcFile) {
    this.srcFile = srcFile;
    this.message = JAXB.unmarshal(srcFile, Message.class);
  }

  public File getSrcFile() {
    return srcFile;
  }

  public Message getMessage() {
    return message;
  }

}
