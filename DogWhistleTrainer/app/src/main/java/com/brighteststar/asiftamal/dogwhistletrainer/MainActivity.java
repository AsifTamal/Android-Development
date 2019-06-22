package com.brighteststar.asiftamal.dogwhistletrainer;

import android.graphics.Color;
import android.media.AudioTrack;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import static com.brighteststar.asiftamal.dogwhistletrainer.ToneGenerator.m_audioTrack;

public class MainActivity extends AppCompatActivity {
    //MediaPlayer mp;
    SeekBar sb;
    EditText et;
    AudioTrack mAudioTrack;
    boolean isplaying=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb = (SeekBar) findViewById(R.id.seekbar_frequency);
        et = (EditText) findViewById(R.id.editTextforseekbar);
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.parseColor("#8E8E38"));
      //  mp = MediaPlayer.create(this, R.raw.dog_whistle);

        final Button b = (Button) findViewById(R.id.btnPlay);


        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                //---change the font size of the EditText---
             //   mAudioTrack = null;
                et.setText(String.valueOf(progress));
                if (!isplaying&& m_audioTrack!=null) {
                    if (m_audioTrack != null) {
                        m_audioTrack.stop();
                        m_audioTrack.release();
                        m_audioTrack = null;
                    }
                    ToneGenerator.PlayTone((int) Double.parseDouble(et.getText().toString()), 60);
                    //playSound(Double.parseDouble(et.getText().toString()), 2);
                }


            }
        });

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    //Update Seekbar value after entering a number
                    sb.setProgress(Integer.parseInt(s.toString()));
                } catch (Exception ex) {
                }
            }
        });


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (!isplaying) {


                        b.setBackground(getDrawable(R.drawable.ic_play));
                        isplaying=true;
                        m_audioTrack.pause();

                    } else {

                        ToneGenerator.PlayTone((int) Double.parseDouble(et.getText().toString()), 60);
                        //playSound(Double.parseDouble(et.getText().toString()), 2);
                        b.setBackground(getDrawable(R.drawable.ic_pause));
                        isplaying=false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
      /*  mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });*/
    }

/*
    private void playSound(double frequency, int duration) {
        duration *= 44100;
        double[] mSound = new double[duration];
        short[] mBuffer = new short[duration];
        // AudioTrack definition

        int mBufferSize = AudioTrack.getMinBufferSize(44100,
                AudioFormat.CHANNEL_OUT_STEREO,
                AudioFormat.ENCODING_PCM_16BIT);
        if (mAudioTrack != null) {
            mAudioTrack.stop();
            mAudioTrack.release();
            mAudioTrack = null;
        }

         mAudioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 44100,
               AudioFormat.CHANNEL_OUT_STEREO, AudioFormat.ENCODING_PCM_16BIT,
             mBufferSize, AudioTrack.MODE_STREAM);

        // Sine wave
        //double[] mSound = new double[4410];
       // short[] mBuffer = new short[duration];
        for (int i = 0; i < mSound.length; i++) {
            mSound[i] = Math.sin((2.0*Math.PI * i/(44100/frequency)));
            mBuffer[i] = (short) (mSound[i]*Short.MAX_VALUE);
        }

        mAudioTrack.setStereoVolume(AudioTrack.getMaxVolume(), AudioTrack.getMaxVolume());
        mAudioTrack.play();
        mAudioTrack.write(mBuffer, 0, mSound.length);

     //  mAudioTrack.release();
       // mAudioTrack = null;
    }
*/

/*    private void playSound(double freqHz, int durationMs)
    {

   // 11,200 Hz, 12,200 Hz, 16,000 Hz i 20,000 HZ
        int count = (int)(44100.0 * 2.0 * (durationMs / 1000.0)) & ~1;
        short[] samples = new short[count];
        for(int i = 0; i < count; i += 2){
            short sample = (short)(Math.sin(2 * Math.PI * i / (44100.0 / freqHz)) * 0x7FFF);
            samples[i + 0] = sample;
            samples[i + 1] = sample;
        }
         mAudioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, 44100,
                AudioFormat.CHANNEL_OUT_STEREO, AudioFormat.ENCODING_PCM_16BIT,
                count * (Short.SIZE / 8), AudioTrack.MODE_STATIC);
        mAudioTrack.write(samples, 0, count);
        mAudioTrack.play();
        //mAudioTrack.stop();
       // mAudioTrack.release();
       // mAudioTrack = null;
    }*/




}
