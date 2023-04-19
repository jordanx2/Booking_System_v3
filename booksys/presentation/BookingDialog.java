/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.presentation ;

import booksys.application.domain.Booking ;
import booksys.application.domain.BookingSystem ;

import java.awt.* ;
import javax.swing.*;
import java.awt.event.* ;
import java.sql.Time ;
import java.util.Enumeration ;

abstract class BookingDialog extends JDialog
{
  protected JComboBox     tableNumber ;
  protected JTextField covers ;
  protected JTextField time ;
  protected JLabel     tableNumberLabel ;
  protected JLabel     coversLabel ;
  protected JLabel     timeLabel ;
  protected boolean    confirmed ;
  protected JButton    ok ;
  protected JButton    cancel ;
  
  BookingDialog(Frame owner, String title)
  {
	
    this(owner, title, null) ;
  }

  // This constructor initializes fields with data from an existing booking.
  // This is useful for completing Exercise 7.6.
  
  BookingDialog(Frame owner, String title, Booking booking)
  {
    super(owner, title, true) ;
    
    addWindowListener(new WindowAdapter() {
	public void windowClosing(WindowEvent e) {
	  confirmed = false ;
	  BookingDialog.this.setVisible(false) ;
	}
      }) ;
    
    tableNumberLabel = new JLabel("Table number:", JLabel.RIGHT) ;
    tableNumber = new JComboBox() ;
    
    Enumeration enumer = BookingSystem.getTableNumbers().elements() ;
    while (enumer.hasMoreElements()) {
      tableNumber.addItem(((Integer) enumer.nextElement()).toString()) ;
    }
    
    if (booking != null) {
      tableNumber.setSelectedItem(Integer.toString(booking.getTable().getNumber())) ;
    }

    coversLabel = new JLabel("Covers:", JLabel.RIGHT) ;
    covers = new JTextField(4) ;
    if (booking != null) {
      covers.setText(Integer.toString(booking.getCovers())) ;
    }
    
    timeLabel = new JLabel("Time:", JLabel.RIGHT) ;
    time = new JTextField("HH:MM:SS", 8) ;
    if (booking != null) {
      time.setText(booking.getTime().toString()) ;
    }
    
    ok = new JButton("Ok") ;
    ok.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	  confirmed = true ;
	  BookingDialog.this.setVisible(false) ;
	}
      }) ;
    
    cancel = new JButton("Cancel") ;
    cancel.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	  confirmed = false ;
	  BookingDialog.this.setVisible(false) ;
	}
      }) ;
  }
  
  int getTableNumber()
  {
    return Integer.parseInt((String)tableNumber.getSelectedItem()) ;
  }

  int getCovers()
  {
    return Integer.parseInt(covers.getText()) ;
  }

  Time getTime()
  {
    return Time.valueOf(time.getText()) ;
  }

  boolean isConfirmed()
  {
    return confirmed ;
  }
}
