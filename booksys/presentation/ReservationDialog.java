/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.presentation ;

import booksys.application.domain.Reservation ;

import java.awt.* ;
import javax.swing.*;
import java.awt.event.* ;

class ReservationDialog extends BookingDialog
{
  protected JTextField name ;
  protected JTextField phone ;
  protected JLabel     nameLabel ;
  protected JLabel     phoneLabel ;
  
  ReservationDialog(Frame owner, String title)
  {
    this(owner, title, null) ;
  }

  // This constructor initializes fields with data from an existing booking.
  // This is useful for completing Exercise 7.6.
  
  ReservationDialog(Frame owner, String title, Reservation r)
  {
    super(owner, title, r) ;

    nameLabel = new JLabel("Name:", JLabel.RIGHT) ;
    name = new JTextField(30) ;
    if (r != null) {
      name.setText(r.getCustomer().getName()) ;
    }

    phoneLabel = new JLabel("Phone no:", JLabel.RIGHT) ;
    phone = new JTextField(15) ;
    if (r != null) {
      phone.setText(r.getCustomer().getPhoneNumber()) ;
    }
        
    // Lay out components in dialog
    
    setLayout( new GridLayout(0, 2) ) ;

    add(timeLabel) ;
    add(time) ;

    add(nameLabel) ;
    add(name) ;

    add(phoneLabel) ;
    add(phone) ;
    
    add(coversLabel) ;
    add(covers) ;

    add(tableNumberLabel) ;
    add(tableNumber) ;
    
    add(ok) ;
    add(cancel) ;
    
    pack() ;
  }

  String getCustomerName()
  {
    return name.getText() ;
  }

  String getPhoneNumber()
  {
    return phone.getText() ;
  }
}
