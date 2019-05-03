package elliajah.ro.readtogo;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class HomeActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, FinishedBooksFragment.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        openHomeFragment();

    }


    private void goToSaveBook() {
        Intent goSaveBook = new Intent(HomeActivity.this, SaveBookActivity.class);
        startActivity(goSaveBook);
    }

    public void openHomeFragment() {
        HomeFragment fragment = HomeFragment.newInstance();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right);
        ft.replace(R.id.frameLayout, fragment, "fragment");
        ft.commit();
    }

    public void openFinishedBooksFragment() {
        FinishedBooksFragment fragment = FinishedBooksFragment.newInstance();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right);
        ft.replace(R.id.frameLayout, fragment, "fragment");
        ft.commit();
    }

    @Override
    public void onHomeFragmentInteraction(String sendBackText) {

        openFinishedBooksFragment();
    }

    @Override
    public void onFinishedBooksFragmentInteraction(String sendBackText) {
        openHomeFragment();
    }
}
