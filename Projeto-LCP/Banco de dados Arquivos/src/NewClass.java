
import javax.swing.SwingWorker;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.util.concurrent.ExecutionException;

public class NewClass extends JFrame {
   private final JPanel workerJPanel = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField numberJTextField = new JTextField();
   private final JButton goJButton = new JButton( "Go" );
   private final JLabel fibonacciJLabel = new JLabel();

   private final JPanel eventThreadJPanel = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private int n1 = 0; 
   private int n2 = 1; 
   private int count = 1;
   private final JLabel nJLabel = new JLabel( "Fibonacci of 1: " );
   private final JLabel nFibonacciJLabel = new JLabel( String.valueOf( n2 ) );
   private final JButton nextNumberJButton = new JButton( "Next Number" );

   public NewClass ()  {
      super( "Fibonacci Numbers" );
      setLayout( new GridLayout( 2, 1, 10, 10 ) );
      workerJPanel.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Inserir Morador" ) );
      workerJPanel.add( numberJTextField );
      goJButton.addActionListener( 
         new ActionListener()  {
            public void actionPerformed( ActionEvent event ) {
               int n;
               try { n = Integer.parseInt( numberJTextField.getText() );
               } catch( NumberFormatException ex ) {
                  fibonacciJLabel.setText( "Enter an integer." );
                  return;} 
               fibonacciJLabel.setText( "Calculating..." );

               BackgroundCalculator task = new BackgroundCalculator( n, fibonacciJLabel );         
               task.execute(); 
            } } );       
      workerJPanel.add( goJButton );
      workerJPanel.add( fibonacciJLabel );
      
       eventThreadJPanel.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Excluir Morador" ) );
       eventThreadJPanel.add( nextNumberJButton );
      add( workerJPanel );
      add( eventThreadJPanel );
      setSize( 275, 200 );
      setVisible( true );
   } 


   public static void main( String[] args ) {
      NewClass application = new NewClass();
      application.setDefaultCloseOperation( EXIT_ON_CLOSE );
   }
} 
// end class FibonacciNumbers
class BackgroundCalculator extends SwingWorker< String, Object > {
   private final int n; // Fibonacci number to calculate
   private final JLabel resultJLabel; // JLabel to display the result

   public BackgroundCalculator( int number, JLabel label )   {
      n = number;
      resultJLabel = label;
   } 
   public String doInBackground() {
      long nthFib = fibonacci( n );
      return String.valueOf( nthFib );
   } 
   protected void done(){
      try { resultJLabel.setText( get() );
      } catch ( InterruptedException ex ){
         resultJLabel.setText( "Interrupted while waiting for results." );
      } catch ( ExecutionException ex ){
         resultJLabel.setText("Error encountered while performing calculation." );
      } 
   } 

  public long fibonacci( long number ) {
      if ( number == 0 || number == 1 ) return number;
      else return fibonacci( number - 1 ) + fibonacci( number - 2 );
   } 
} 