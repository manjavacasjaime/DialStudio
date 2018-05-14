package iphonemusicplayer.jaime.com.dialstudio;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    float x = 0, y = 0, z = 0, s = 0;
    int r, g, b = 0;
    public int p_width, p_height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p_width=this.getWindowManager().getDefaultDisplay().getWidth();
        p_height=this.getWindowManager().getDefaultDisplay().getHeight();


        //Start Color (The first color the user sees as it opens the app)
        int random_r = (int)Math.floor(Math.random()*257) - 1;
        int random_g = (int)Math.floor(Math.random()*257) - 1;
        int random_b = (int)Math.floor(Math.random()*257) - 1;

        paint_color(random_r, random_g, random_b);
    }

    //Reads finger position
    public boolean onTouchEvent(MotionEvent event) {
        int x_forOnTouch = Math.round(event.getX());
        int y_forOnTouch = Math.round(event.getY());

        box_position(x_forOnTouch, y_forOnTouch);
        paint_color(r, g, b);

        splash();

        return true;

    }

    //Calculates the color depending on the coordinates
    public void box_position(int x_touch, int y_touch){
        if((x_touch >= 100) && (x_touch < p_width - 99) )
            x = x_touch - 100;
        if((y_touch >= 150) && (y_touch < p_height - 149))
            y = y_touch - 150;
        z = ((Math.round(x) ^ 2) + (Math.round(y) ^ 2)) ^ (1/2);

        r = Math.round((x / (p_width-198)) * 255);
        g = Math.round((y / (p_height-298)) * (255));
        b = ((r^2) + (g^2)) ^ (1/2);

        if(r >= 127)
            if(g >= 127)
                if(r < g) {
                    b = 255 - b; //Seccion 2
                    if(b < 0)
                        b = 0;
                }
                else
                    b = b/2;
            else
            if(r <= (255 - g)) {
                b = 255 - b; //Seccion 4
                if(b < 0)
                    b = 0;
            }
            else
            if(g >= 127.5)
                if(g <= (255 - r)) {
                    b = 255 - b; //Seccion 6
                    if(b < 0)
                        b = 0;
                }
                else
                    b = ((r^2) + (g^2)) ^ (1/2); // Seccion 5
            else
            if (g >= r)
                b = ((r^2) + (g^2)) ^ (1/2); // Seccion 8
    }

    //Paints the background of the app
    public void paint_color(int r, int g, int b){
        ImageView i = (ImageView) findViewById(R.id.imageView);
        ImageView box = (ImageView) findViewById(R.id.light);
        ImageView bottom = (ImageView) findViewById(R.id.imageView2);
        int ra = r * 2 / 4;
        int ga = g * 2 / 4;
        int ba = b * 2 / 4;

        i.setBackgroundColor(Color.rgb(r, g, b));
        box.setBackgroundColor(Color.rgb(ra, ga, ba));
        bottom.setBackgroundColor(Color.rgb(ra, ga, ba));

        String hex = Integer.toHexString(Color.rgb(r, g, b));
        String hexUpper = ("#" + hex.charAt(2)+hex.charAt(3)+hex.charAt(4)+hex.charAt(5)+hex.charAt(6)+hex.charAt(7)).toUpperCase();
        String mycode = Integer.toBinaryString(Color.rgb(r, g, b));
        String mycodeBinS = (""+mycode.charAt(8)+mycode.charAt(9)+mycode.charAt(10)+mycode.charAt(11)+mycode.charAt(12)+mycode.charAt(13)+mycode.charAt(14)+mycode.charAt(15)+mycode.charAt(16)+mycode.charAt(17)+mycode.charAt(18)+mycode.charAt(19)+mycode.charAt(20)+mycode.charAt(21)+mycode.charAt(22)+mycode.charAt(23)+mycode.charAt(24)+mycode.charAt(25)+mycode.charAt(26)+mycode.charAt(27)+mycode.charAt(28)+mycode.charAt(29)+mycode.charAt(30)+mycode.charAt(31));

        int aRed1 = Integer.parseInt(""+mycodeBinS.charAt(0)) * 8;
        int bRed1 = Integer.parseInt(""+mycodeBinS.charAt(1)) * 4;
        int cRed1 = Integer.parseInt(""+mycodeBinS.charAt(2)) * 2;
        int dRed1 = Integer.parseInt(""+mycodeBinS.charAt(3));
        int sumaRed1 = aRed1+bRed1+cRed1+dRed1;
        int aRed2 = Integer.parseInt(""+mycodeBinS.charAt(4)) * 8;
        int bRed2 = Integer.parseInt(""+mycodeBinS.charAt(5)) * 4;
        int cRed2 = Integer.parseInt(""+mycodeBinS.charAt(6)) * 2;
        int dRed2 = Integer.parseInt(""+mycodeBinS.charAt(7));
        int sumaRed2 = aRed2+bRed2+cRed2+dRed2;
        int sumaRed = sumaRed1+sumaRed2;

        int aGreen1 = Integer.parseInt(""+mycodeBinS.charAt(8)) * 8;
        int bGreen1 = Integer.parseInt(""+mycodeBinS.charAt(9)) * 4;
        int cGreen1 = Integer.parseInt(""+mycodeBinS.charAt(10)) * 2;
        int dGreen1 = Integer.parseInt(""+mycodeBinS.charAt(11));
        int sumaGreen1 = aGreen1+bGreen1+cGreen1+dGreen1;
        int aGreen2 = Integer.parseInt(""+mycodeBinS.charAt(12)) * 8;
        int bGreen2 = Integer.parseInt(""+mycodeBinS.charAt(13)) * 4;
        int cGreen2 = Integer.parseInt(""+mycodeBinS.charAt(14)) * 2;
        int dGreen2 = Integer.parseInt(""+mycodeBinS.charAt(15));
        int sumaGreen2 = aGreen2+bGreen2+cGreen2+dGreen2;
        int sumaGreen = sumaGreen1+sumaGreen2;

        int aBlue1 = Integer.parseInt(""+mycodeBinS.charAt(16)) * 8;
        int bBlue1 = Integer.parseInt(""+mycodeBinS.charAt(17)) * 4;
        int cBlue1 = Integer.parseInt(""+mycodeBinS.charAt(18)) * 2;
        int dBlue1 = Integer.parseInt(""+mycodeBinS.charAt(19));
        int sumaBlue1 = aBlue1+bBlue1+cBlue1+dBlue1;
        int aBlue2 = Integer.parseInt(""+mycodeBinS.charAt(20)) * 8;
        int bBlue2 = Integer.parseInt(""+mycodeBinS.charAt(21)) * 4;
        int cBlue2 = Integer.parseInt(""+mycodeBinS.charAt(22)) * 2;
        int dBlue2 = Integer.parseInt(""+mycodeBinS.charAt(23));
        int sumaBlue2 = aBlue2+bBlue2+cBlue2+dBlue2;
        int sumaBlue = sumaBlue1+sumaBlue2;

        int percRed = (sumaRed*100) / 29;
        int percGreen = (sumaGreen*100) / 30;
        int percBlue = (sumaBlue*100) / 30;
        String redF = "      " +Integer.toString(percRed);
        String greenF = "      "+Integer.toString(percGreen);
        String blueF = "      "+Integer.toString(percBlue);

        TextView Code = (TextView) findViewById(R.id.Hex);
        TextView code1 = (TextView) findViewById(R.id.textView);
        TextView code2 = (TextView) findViewById(R.id.percG);
        TextView code3 = (TextView) findViewById(R.id.percB);

        Code.setText(hexUpper);
        code1.setText(redF);
        code2.setText(greenF);
        code3.setText(blueF);

        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.rgb(ra, ga, ba));
            window.setNavigationBarColor(Color.rgb(r,g,b));
        }
    }

    //Removes App Name and instruction after first click
    public void splash(){
        if(s == 0) {
            //Initial Splash Screen
            AlphaAnimation ani = new AlphaAnimation(1.0f, 0.0f);
            ani.setDuration(500);
            ani.setFillAfter(true);
            TextView v = (TextView) findViewById(R.id.v);
            TextView t = (TextView) findViewById(R.id.Touch);
            TextView w = (TextView) findViewById(R.id.w);
            v.startAnimation(ani);
            t.startAnimation(ani);
            w.startAnimation(ani);
            s++;
        }
    }


}

