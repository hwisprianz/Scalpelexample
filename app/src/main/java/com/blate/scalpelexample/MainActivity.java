package com.blate.scalpelexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;

import com.blate.scalpel.encoder.barcode.BarcodeFormat;
import com.blate.scalpel.encoder.barcode.BarcodeEncoderParams;
import com.blate.scalpel.encoder.barcode.Code128Encoder;
import com.blate.scalpel.throwable.EncodeException;
import com.blate.scalpelexample.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "BlateDebug";

    private ActivityMainBinding mBinding;
    private Code128Encoder mCode128Encoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setHost(this);

        mCode128Encoder = new Code128Encoder(
                new BarcodeEncoderParams()
                        .setBarcodeFormat(BarcodeFormat.CODE128B));

        mBinding.etInput.setText("012QWEASZxpl[>.\\\"{~`|");

        obtainPermission();
    }

    private void obtainPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            List<String> requestPerm = new ArrayList<>();
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPerm.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            }
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPerm.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
            if (!requestPerm.isEmpty()) {
                requestPermissions(requestPerm.toArray(new String[]{}), 1001);
            } else {
                requestManageStorage();
            }
        }
    }

    private void requestManageStorage() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    if (!Environment.isExternalStorageManager()) {
                        Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                        intent.setData(Uri.parse("package:" + getPackageName()));
                        startActivityForResult(intent, 1002);
                    }
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        requestManageStorage();
    }

    public void onCode128ATestClick() {
        final int total = 5000;
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(() -> mBinding.tvMessage.setText("pressure test progressing..."));
                File workDir = new File(Environment.getExternalStorageDirectory(), "ScalpelExample/Code128A");
                if (!workDir.exists() || !workDir.isDirectory()) {
                    workDir.mkdirs();
                }
                long startTimestamp = System.currentTimeMillis();
                for (int i = 0; i < total; i += 1) {
                    String content = randomCode128String(15,"01234567899ABCDEFGHIJKLMNOPQRSTUVWXYZ!\"#$%&'()*+,-./:;<=>?@[\\]^_");
                    File file = new File(workDir, content.hashCode() + ".png");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try (OutputStream outputStream = new FileOutputStream(file)) {
                        mCode128Encoder.encode(content).compress(
                                Bitmap.CompressFormat.PNG,
                                100,
                                outputStream);
                        Log.i(TAG, String.format("generate [%s] success; progress [%s/%s]", content, i + 1, total));
                    } catch (IOException | EncodeException e) {
                        Log.i(TAG, String.format("generate [%s] fail; because : %s", content, e.getMessage()));
                    }
                }
                long endTimeStamp = System.currentTimeMillis();
                Log.i(TAG, String.format("test complete ! total [%s]; duration [%s]ms", total, endTimeStamp - startTimestamp));
                runOnUiThread(() -> mBinding.tvMessage.setText("pressure test complete !"));
            }
        }).start();
    }

    public void onCode128BTestClick() {
        final int total = 5000;
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(() -> mBinding.tvMessage.setText("pressure test progressing..."));
                File workDir = new File(Environment.getExternalStorageDirectory(), "ScalpelExample/Code128B");
                if (!workDir.exists() || !workDir.isDirectory()) {
                    workDir.mkdirs();
                }
                long startTimestamp = System.currentTimeMillis();
                for (int i = 0; i < total; i += 1) {
                    String content = randomCode128String(15,"01234567899abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");
                    File file = new File(workDir, content.hashCode() + ".png");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try (OutputStream outputStream = new FileOutputStream(file)) {
                        mCode128Encoder.encode(content).compress(
                                Bitmap.CompressFormat.PNG,
                                100,
                                outputStream);
                        Log.i(TAG, String.format("generate [%s] success; progress [%s/%s]", content, i + 1, total));
                    } catch (IOException | EncodeException e) {
                        Log.i(TAG, String.format("generate [%s] fail; because : %s", content, e.getMessage()));
                    }
                }
                long endTimeStamp = System.currentTimeMillis();
                Log.i(TAG, String.format("test complete ! total [%s]; duration [%s]ms", total, endTimeStamp - startTimestamp));
                runOnUiThread(() -> mBinding.tvMessage.setText("pressure test complete !"));
            }
        }).start();
    }

    public void onCode128CTestClick() {
        final int total = 5000;
        new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(() -> mBinding.tvMessage.setText("pressure test progressing..."));
                File workDir = new File(Environment.getExternalStorageDirectory(), "ScalpelExample/Code128C");
                if (!workDir.exists() || !workDir.isDirectory()) {
                    workDir.mkdirs();
                }
                long startTimestamp = System.currentTimeMillis();
                for (int i = 0; i < total; i += 1) {
                    String content = randomCode128String(20,"0123456789");
                    File file = new File(workDir, content + ".png");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try (OutputStream outputStream = new FileOutputStream(file)) {
                        mCode128Encoder.encode(content).compress(
                                Bitmap.CompressFormat.PNG,
                                100,
                                outputStream);
                        Log.i(TAG, String.format("generate [%s] success; progress [%s/%s]", content, i + 1, total));
                    } catch (IOException | EncodeException e) {
                        Log.i(TAG, String.format("generate [%s] fail; because : %s", content, e.getMessage()));
                    }
                }
                long endTimeStamp = System.currentTimeMillis();
                Log.i(TAG, String.format("test complete ! total [%s]; duration [%s]ms", total, endTimeStamp - startTimestamp));
                runOnUiThread(() -> mBinding.tvMessage.setText("pressure test complete !"));
            }
        }).start();
    }

    public void onEncodeClick() {
        CharSequence input = mBinding.etInput.getText();
        if (TextUtils.isEmpty(input)) {
            input = mBinding.etInput.getHint();
        }
        try {
            mBinding.ivImage.setImageBitmap(mCode128Encoder.encode(input.toString()));
            mBinding.tvMessage.setText("success");
        } catch (EncodeException e) {
            mBinding.ivImage.setImageBitmap(null);
            mBinding.tvMessage.setText(e.getMessage());
        }
    }

    private String randomCode128String(int length, String area) {
        char[] charArrays = new char[length];
        Random random = new Random();
        for (int i = 0; i < length; i += 1) {
            charArrays[i] = area.charAt(random.nextInt(area.length()));
        }
        return new String(charArrays);
    }

}