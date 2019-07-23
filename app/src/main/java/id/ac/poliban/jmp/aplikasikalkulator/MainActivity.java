package id.ac.poliban.jmp.aplikasikalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button op_tambah;
    private Button buttonExit;
    private Button op_kurang;
    private Button op_kali;
    private Button op_bagi;
    private Button button;
    private TextView textHasil, textAngka;
    private EditText edit1, edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    op_tambah  = findViewById(R.id.op_tambah);
    op_kurang  = findViewById(R.id.op_kurang);
    op_kali    = findViewById(R.id.op_kali);
    op_bagi    = findViewById(R.id.op_bagi);
    buttonExit = findViewById(R.id.buttonExit);
    button     = findViewById(R.id.button);
    textHasil  = findViewById(R.id.tvHasil);
    textAngka  = findViewById(R.id.tvAngka);
    edit1      = findViewById(R.id.edit1);
    edit2      = findViewById(R.id.edit2);


    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            edit1.setText("");
            edit2.setText("");
            edit1.requestFocus();
        }
    });

    op_tambah.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            double x = Double.parseDouble(edit1.getText().toString());
            double y = Double.parseDouble(edit2.getText().toString());
            double hasil = x + y;
            textAngka.setText(String.valueOf(hasil));
        }

    });
    op_kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            double x = Double.parseDouble(edit1.getText().toString());
            double y = Double.parseDouble(edit2.getText().toString());
            double hasil = x - y;
            textAngka.setText(String.valueOf(hasil));
        }
    });

    op_kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            double x = Double.parseDouble(edit1.getText().toString());
            double y = Double.parseDouble(edit2.getText().toString());
            double hasil = x * y;
            textAngka.setText(String.valueOf(hasil));
        }
    });

    op_bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(isInputEmpty()) return;
            double x = Double.parseDouble(edit1.getText().toString());
            double y = Double.parseDouble(edit2.getText().toString());
            double hasil = x / y;
            textAngka.setText(String.valueOf(hasil));
        }

            public boolean isInputEmpty() {
                EditText[] texts = new EditText[{edit2, edit1}];
                for (EditText e : texts)
                    if (e.getText().toString().isEmpty())
                        return true;

                    return false;
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        edit1.setText("");
        edit2.setText("");
        edit1.requestFocus();
    }
}
