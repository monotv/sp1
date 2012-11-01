package de.bht.fpa.mail.s749711.utilities;

public final class Config {
  private static Config instance = null;
  private static String fileFilter = null;
  private static String extensionFilter = null;

  private Config() {

  }

  public static Config getInstance() {
    if (instance == null) {
      instance = new Config();
    }
    return instance;
  }

  public void setFileFilter(String str) {
    fileFilter = str;
  }

  public String getFileFilter() {
    return fileFilter;
  }

  public void setExtensionFilter(String str) {
    extensionFilter = str;
  }

  public String getExtensionFilter() {
    return extensionFilter;
  }

}
