package magicat.helloworld.test01;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HelloWorldActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        findViews();
        setListeners(); 
        

    };

    private Button button_calc;
    private EditText[][] TextFileds;
    private int[][] Numbers = {{16,2,3,13},{5,11,10,8},{9,7,6,12},{4,14,15,1}};

    private void findViews()
    {
        button_calc = (Button) findViewById(R.id.submit);
        //numbers[] = (EditText) findViewById(R.id.height)
        TextFileds = new EditText[4][4];
        for(int i=1; i==4;i++){
        	for(int j=1; j==4;j++){
        		TextFileds[i][j].setText(getText(Numbers[i][j]));
            }        	
        }
    };

    //Listen for button clicks
    private void setListeners() {
        button_calc.setOnClickListener(CalcMagicNumber);
    };

    private Button.OnClickListener CalcMagicNumber = new Button.OnClickListener()
    {
        public void onClick(View v)
        {            
            //Present result 
//            numbers[1].setText(getText(R.string.bmi_result) + nf.format(BMI));
// 
//            //Give health advice 
//            if(BMI>25){
//                view_suggest.setText(R.string.advice_heavy);
//            }else if(BMI<20){
//                view_suggest.setText(R.string.advice_light);
//            }else{
//                view_suggest.setText(R.string.advice_average);
//            }
            //openOptionsDialog(); 
        }
    };
    
    
    private void openOptionsDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(HelloWorldActivity.this);
        dialog.setTitle(R.string.about_title);
        dialog.setMessage(R.string.about_msg);
        dialog.setPositiveButton(R.string.ok_label,
        new DialogInterface.OnClickListener(){
        	public void onClick(
        		DialogInterface dialoginterface, int i){
        	}
        });
        dialog.setNegativeButton(R.string.homepage_label,
        	    new DialogInterface.OnClickListener(){
        	         public void onClick(
        	             DialogInterface dialoginterface, int i){
        	        	//go to url ³o¬Oµù¸Ñ
        	        	 Uri uri = Uri.parse(getString(R.string.homepage_uri));
        	        	 Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        	        	 startActivity(intent);
        	         }
        		}
        );
        			
        
        dialog.show();
        
    	Toast popup = Toast.makeText(HelloWorldActivity.this, R.string.input_error, Toast.LENGTH_SHORT);
    	popup.show();
    };
}