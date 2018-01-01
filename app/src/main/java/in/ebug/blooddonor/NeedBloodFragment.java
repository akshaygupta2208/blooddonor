package in.ebug.blooddonor;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class NeedBloodFragment extends Fragment {
    private FragmentManager manager;
    private Button btnFindDonor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_need_blood, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnFindDonor = (Button) getActivity().findViewById(R.id.btnFindDonor);
        btnFindDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager = getFragmentManager();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                fragmentTransaction.replace(R.id.home_layout, new SearchDonorFragment(), "searchDonorFragment");
                fragmentTransaction.addToBackStack("searchDonorFragment");
                fragmentTransaction.commit();
            }
        });
    }

}