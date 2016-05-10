package gamebrodev.de.second;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by mathi on 10.05.2016.
 */
public class Menu extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);
    }

    @Override
    public void onClick(View v) {
    }
}
