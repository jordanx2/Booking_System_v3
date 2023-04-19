/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.presentation ;

//was here AT 2.53PM
// was here with Apple at 2.35pm also.

import booksys.application.domain.WalkIn ;

import java.awt.* ;

class WalkInDialog extends BookingDialog
{
  WalkInDialog(Frame owner, String title)
  {
    this(owner, title, null) ;
  }

  // This constructor initializes fields with data from an existing booking.
  // This is useful for completing Exercise 7.6.
  
  WalkInDialog(Frame owner, String title, WalkIn w)
  {
    super(owner, title, w) ;

    setLayout( new GridLayout(0, 2) ) ;
    
    add(tableNumberLabel) ;
    add(tableNumber) ;
    
    add(coversLabel) ;
    add(covers) ;
    
    add(timeLabel) ;
    add(time) ;
    
    add(ok) ;
    add(cancel) ;

    pack() ;
  }
}
