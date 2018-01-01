package in.ebug.blooddonor;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class HomeFragment extends Fragment {

    private Button btnDonateBlood;
    private Button btnSeekBlood;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnDonateBlood = (Button) getActivity().findViewById(R.id.imageButton2);
        btnSeekBlood = (Button) getActivity().findViewById(R.id.imageButton);
        btnDonateBlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ( (MainActivity)getActivity()).switchFragment(new DonorRegistrationFragment(), "donorRegistrationFragment");
                Toast.makeText(getActivity(), "donate blood", Toast.LENGTH_SHORT).show();
            }
        });

        btnSeekBlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ( (MainActivity)getActivity()).switchFragment(new NeedBloodFragment(), "needBloodFragment");
                Toast.makeText(getActivity(),"seek blood", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
