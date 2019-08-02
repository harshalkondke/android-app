package Cancer.project1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private ActionBar toolbar;

    private AboutUsFragment aboutUsFragment;
    private HomeFragment homeFragment;
    private  ContactUsFragment contactUsFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    loadFragment(homeFragment);
                    //mTextMessage.setText(R.string.title_home);
                    toolbar.setTitle("Home");
                    return true;
                case R.id.navigation_AboutUs:
                    //mTextMessage.setText(R.string.title_AboutUs);
                    toolbar.setTitle("About Us");
                    loadFragment(aboutUsFragment);
                    return true;
                case R.id.navigation_ContactUs:
                    //mTextMessage.setText(R.string.title_ContactUs);
                    toolbar.setTitle("Contact Us");
                    loadFragment(contactUsFragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar = getSupportActionBar();

        toolbar.setTitle("Home");
        homeFragment = new HomeFragment();
        aboutUsFragment = new AboutUsFragment();
        contactUsFragment = new ContactUsFragment();

        loadFragment(homeFragment);
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }

}
