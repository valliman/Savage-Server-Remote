package view;// Drop and Drag with a JList
import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;

public class DnDList extends JList implements DragGestureListener, DragSourceListener, DropTargetListener {
    // observation area for this components behavior
    JTextArea observer;

    // enables this component to be a dropTarget
    DropTarget dropTarget;

    // enables this component to be a Drag Source
    DragSource dragSource;

    // constructor - initializes the observation area, DragSource, and DropTarget
    public DnDList(JTextArea messageArea) {
        // allow only ONE item to be selected
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        observer = messageArea;
        dragSource = new DragSource();
        // listen for MOVE drags
        dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_MOVE, this);
        dropTarget = new DropTarget(this, this);
        observer.append("Ready (waiting for a MOVE drag)\n");
    }

    // (Interface DragGestureListener) a drag gesture has been initiated, so start the drag
    public void dragGestureRecognized(DragGestureEvent event) {
        observer.append("(DragGestureListener) dragGestureRecognized \n");
        Object listSelectedValue = getSelectedValue();
        if(listSelectedValue != null) {
            StringSelection stringTransferable = new StringSelection(listSelectedValue.toString());
            dragSource.startDrag(event, DragSource.DefaultMoveDrop, stringTransferable, this);
            observer.append("  dragging (" + listSelectedValue + ")\n");
        }
        else {
            observer.append("  nothing in List selected \n");
        }
    }

    // (Interface DragSourceListener) Drag Drop operation is complete
    public void dragDropEnd(DragSourceDropEvent event) {
        observer.append("(DragSourceListener) dragDropEnd \n");
        if(event.getDropSuccess()) {
            ((DefaultListModel)getModel()).removeElement(getSelectedValue());
            observer.append("  drop was a success \n");
        }
        else {
            observer.append("  drop was NOT a success \n");
        }
    }

    // (Interface DragSourceListener) cursor entered a Drop Site
    public void dragEnter(DragSourceDragEvent event) {
        observer.append("(DragSourceListener) dragEnter \n");
    }

    // (Interface DragSourceListener) cursor left a Drop Site
    public void dragExit(DragSourceEvent event) {
        observer.append("(DragSourceListener) dragExit \n");
    }

    // (Interface DragSourceListener) cursor moved over a Drop Site
    public void dragOver(DragSourceDragEvent event) {
        // observer.append("(DragSourceListener) dragOver \n");
    }

    // (Interface DragSourceListener) drop gesture has been changed
    public void dropActionChanged(DragSourceDragEvent event ) {
        observer.append("(DragSourceListener) dropActionChanged \n");
    }

    // (Interface DropTargetListener) drag entered this drop target
    public void dragEnter(DropTargetDragEvent event) {
        observer.append("(DropTargetListener) dragEnter \n");
    }

    // (Interface DropTargetListener) drag exited this drop target
    public void dragExit(DropTargetEvent event) {
        observer.append("(DropTargetListener) dragExit \n");
    }

    // (Interface DropTargetListener) drag moved over this drop target
    public void dragOver(DropTargetDragEvent event) {
        // observer.append("(DropTargetListener) dragOver \n");
    }

    // (Interface DropTargetListener) a drop has occurred over this drop target
    public void drop(DropTargetDropEvent event) {
        observer.append("(DropTargetListener) drop \n");
        Transferable transferable = event.getTransferable();
        // StringFlavor accepted
        if(transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            String listItem;
            try {
                listItem = (String)transferable.getTransferData(DataFlavor.stringFlavor);
            }
            catch(Exception exception) { // UnsupportedFlavorException or IOException
                observer.append("  drop NOT accepted because: " + exception + " \n");
                event.rejectDrop();
                return;
            }
            event.acceptDrop(DnDConstants.ACTION_MOVE);
            ((DefaultListModel)getModel()).addElement(listItem);
            event.getDropTargetContext().dropComplete(true);
            observer.append("  dropped (" + listItem + ")\n");
        }
        else {
            event.rejectDrop();
            observer.append("  drop NOT accepted (not StringFlavor) \n");
        }
    }

    // (Interface DropTargetListener) drop gesture changed
    public void dropActionChanged(DropTargetDragEvent event) {
        observer.append("(DropTargetListener) dropActionChanged");
    }
}