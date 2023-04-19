/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

 package booksys.presentation ;


 import javax.swing.*;
 
 
 import java.awt.event.* ;
 
 public class BookingSystemApp extends JFrame
 {
   private StaffUI ui ;
 
   public BookingSystemApp()
   {
     setTitle("Restaurant Booking System") ;
    
     setResizable(false) ;
     JMenuBar mb  = new JMenuBar();
     setJMenuBar(mb) ;
     
     JMenu fileMenu = new JMenu("File") ;
     mb.add(fileMenu) ;
 
     JMenuItem quit = new JMenuItem("Quit") ;
     quit.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
     System.exit(0) ;
   }
       }) ;
     
     fileMenu.add(quit) ;
     
     JMenu dateMenu = new JMenu("Date") ;
     mb.add(dateMenu) ;
 
     JMenuItem display = new JMenuItem("Display...") ;
     display.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
     ui.displayDate() ;
   }
       }) ;
     dateMenu.add(display) ;
     
     JMenu bookingMenu = new JMenu("Booking") ;
     mb.add(bookingMenu) ;
     
     JMenuItem newReservation = new JMenuItem("New Reservation...") ;
     newReservation.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
     ui.addReservation() ;
   }
       }) ;
     bookingMenu.add(newReservation) ;
 
     JMenuItem newWalkIn = new JMenuItem("New Walk-in...") ;
     newWalkIn.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
     ui.addWalkIn() ;
   }
       }) ;
     bookingMenu.add(newWalkIn) ;
 
     JMenuItem cancel = new JMenuItem("Cancel") ;
     cancel.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
     ui.cancel() ;
   }
       });
     bookingMenu.add(cancel) ;
 
     JMenuItem recordArrival = new JMenuItem("Record Arrival") ;
     recordArrival.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
     ui.recordArrival() ;
   }
       });
     bookingMenu.add(recordArrival) ;


    // EDIT
    JMenuItem updateReservation = new JMenuItem("Update Reservation") ;
    updateReservation.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	  ui.updateReservation();

	}
      });
    bookingMenu.add(updateReservation) ;
    
    this.addWindowListener(new WindowAdapter() {
	public void windowClosing(WindowEvent e) {
	  System.exit(0) ;
	}
      }) ;

    ui = new StaffUI(this) ;
    
    this.add(ui) ;
    this.pack() ;
    this.setVisible(true) ;
  }
  
  
  public static void main(String args[])
  {
    new BookingSystemApp() ;
  }
}
