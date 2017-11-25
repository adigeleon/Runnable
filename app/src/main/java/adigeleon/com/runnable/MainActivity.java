package adigeleon.com.runnable;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView textView2;
    int sayac;
    Handler handler;
    Runnable run;
    View basla;
    View bitir;
    float a = sayac % 10;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        basla = findViewById(R.id.baslabuttn);
        bitir = findViewById(R.id.bititbuttn);
        textView2 = (TextView) findViewById(R.id.toastxt);
    }

    public void basla(View view){
        textView = (TextView) findViewById(R.id.textview);
         sayac = 0;
         basla.setVisibility(View.INVISIBLE);
        handler = new Handler();
        run = new Runnable() {
            @Override
            public void run() {

                textView.setText("Time: " + sayac);
                sayac++;
                textView.setText("Time: " + sayac);
                handler.postDelayed(this,1000);
//                if(sayac == 3){
//                    handler.removeCallbacks(run);
//                    AlertDialog.Builder alert1 = new AlertDialog.Builder(context);
//                    alert1.setTitle("Zaman Uyarısı");
//                    alert1.setMessage("süre doldu devam etmek ister miniz ? ");
//                    alert1.setPositiveButton("evet", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//
//                            handler.post(run);
//                            Toast.makeText(getApplicationContext(),"Devam Ediliyor",Toast.LENGTH_LONG).show();
//                        }
//                    });
//
//                    alert1.setNegativeButton("hayır", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            sayac=0;
//                            handler.removeCallbacks(run);
//                            basla.setVisibility(View.VISIBLE);
//                            Toast.makeText(getApplicationContext(),"işlem Durduruldu",Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                    alert1.show();
//                }
//
                if((sayac % 10) == 0){
                    Toast.makeText(getApplicationContext(),"Devam Ediliyor",Toast.LENGTH_SHORT).show();

                    textView2.setText(sayac + " oldu");
                }
                else {
                    textView2.setText("Uygulama çalışıyorrr..");
                }

            }

        };

        handler.post(run);



    }

    public void bitir(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Sayac");
        alert.setMessage("işlem durdurulsun mu?");
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                handler.removeCallbacks(run);
                textView = (TextView) findViewById(R.id.textview);
                sayac = 0;
                textView.setText("Time: " + sayac);
                Toast.makeText(getApplicationContext(),"İşlem Durduruldu",Toast.LENGTH_LONG).show();
                basla.setVisibility(View.VISIBLE);
            }
        });
        alert.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"İşlem Devam Ettirildi",Toast.LENGTH_LONG).show();
            }
        });
        alert.show();
    }
}
