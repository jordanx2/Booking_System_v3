/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.presentation ;

import java.awt.* ;
import javax.swing.*;
import java.awt.event.* ;

class ConfirmDialog extends JDialog
{
  protected JLabel   messageLabel ;
  protected JLabel   blankLabel ;
  protected boolean confirmed ;
  protected JButton  confirm ;
  protected JButton  cancel ;
  
  ConfirmDialog(Frame owner, String message, boolean choice)
  {
    super(owner, "Warning!", true) ;
    
    addWindowListener(new WindowAdapter() {
	public void windowClosing(WindowEvent e) {
	  confirmed = false ;
	  ConfirmDialog.this.setVisible(false) ;
	}
      }) ;

    messageLabel = new JLabel(message, JLabel.RIGHT) ;
    blankLabel = new JLabel("", JLabel.RIGHT) ;

    confirm = new JButton("Ok") ;
    confirm.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	  confirmed = true ;
	  ConfirmDialog.this.setVisible(false);
	}
      }) ;

    cancel = new JButton("Cancel") ;
    cancel.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	  confirmed = false ;
	  ConfirmDialog.this.setVisible(false) ;
	}
      }) ;

    setLayout( new GridLayout(0, 2) ) ;
    
    add(messageLabel) ;
    add(blankLabel) ;
    add(confirm) ;
    
    if (choice) {
      add(cancel) ;
    }

    pack() ;
  }

  boolean isConfirmed()
  {
    return confirmed ;
  }
}
