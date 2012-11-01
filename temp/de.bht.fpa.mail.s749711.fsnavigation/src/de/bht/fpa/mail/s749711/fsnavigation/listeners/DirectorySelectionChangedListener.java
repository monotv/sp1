package de.bht.fpa.mail.s749711.fsnavigation.listeners;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;

import de.bht.fpa.mail.s749711.items.DirectoryItem;
import de.bht.fpa.mail.s749711.utilities.Config;
import de.bht.fpa.mail.s749711.utilities.OutputFactory;
import de.bht.fpa.mail.s749711.utilities.WatchDog;

public class DirectorySelectionChangedListener implements ISelectionChangedListener {

  @Override
  public void selectionChanged(SelectionChangedEvent event) {
    Object sel = event.getSelection();
    if (sel instanceof TreeSelection) {
      Object item = ((TreeSelection) sel).getFirstElement();
      if (item instanceof DirectoryItem) {
        // we really need to tell the viewer if something got lost
        if (!((DirectoryItem) item).getFile().exists()) {
          WatchDog.getInstance().setItemDeleted(item);
        }
        Object[] obj = ((DirectoryItem) item).getChildren(Config.getInstance().getExtensionFilter());
        OutputFactory.getInstance().produceOutput(obj, (DirectoryItem) item);
      }
    }
  }
}
