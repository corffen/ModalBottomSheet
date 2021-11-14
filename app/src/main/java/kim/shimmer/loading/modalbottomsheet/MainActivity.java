package kim.shimmer.loading.modalbottomsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity implements IBottomSheetAction {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mBottton = findViewById(R.id.button);
        mBottton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog();
            }
        });
        Button mBottton2 = findViewById(R.id.button2);
        mBottton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetFragment blankFragment = new BottomSheetFragment(MainActivity.this);
                blankFragment.show(getSupportFragmentManager(), blankFragment.getTag());
            }
        });
    }

    private void showBottomSheetDialog() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog_layout);

        LinearLayout copy = bottomSheetDialog.findViewById(R.id.copyLinearLayout);
        LinearLayout share = bottomSheetDialog.findViewById(R.id.shareLinearLayout);
        LinearLayout upload = bottomSheetDialog.findViewById(R.id.uploadLinearLayout);
        LinearLayout download = bottomSheetDialog.findViewById(R.id.download);
        LinearLayout delete = bottomSheetDialog.findViewById(R.id.delete);

        bottomSheetDialog.show();

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                copy();
                bottomSheetDialog.dismiss();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
                bottomSheetDialog.dismiss();
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upload();
                bottomSheetDialog.dismiss();
            }
        });

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
                bottomSheetDialog.dismiss();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
                bottomSheetDialog.dismiss();
            }
        });
    }

    @Override
    public void download() {
        Toast.makeText(getApplicationContext(), "Download is Clicked", Toast.LENGTH_LONG).show();
    }

    @Override
    public void upload() {
        Toast.makeText(getApplicationContext(), "Upload is Clicked", Toast.LENGTH_LONG).show();
    }

    @Override
    public void copy() {
        Toast.makeText(getApplicationContext(), "Copy is Clicked ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void share() {
        Toast.makeText(getApplicationContext(), "Share is Clicked", Toast.LENGTH_LONG).show();
    }

    @Override
    public void delete() {
        Toast.makeText(getApplicationContext(), "Delete is Clicked", Toast.LENGTH_LONG).show();
    }
}
