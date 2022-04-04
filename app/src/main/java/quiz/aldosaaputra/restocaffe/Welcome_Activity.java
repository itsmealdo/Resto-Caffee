package quiz.aldosaaputra.restocaffe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Welcome_Activity extends AppCompatActivity {

    Button login;
    EditText nama;
    private String KEY_NAME ="YOURNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Login Using Number
        login = (Button) findViewById(R.id.btnLanjut);
        nama = (EditText) findViewById(R.id.etName);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String nomor = nama.getText().toString();
                    if (nomor.length() == 0) {
                        Toast.makeText(getApplicationContext(), "Nama Tidak Boleh kosong bos!", Toast.LENGTH_LONG).show();
                    } else {
                        Intent i = new Intent(Welcome_Activity.this, MainActivity.class);
                        i.putExtra(KEY_NAME, nomor);
                        startActivity(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplication(), "ERROR, TRY AGAIN !",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}