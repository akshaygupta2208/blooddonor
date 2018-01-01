package in.ebug.blooddonor;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchDonorFragment extends Fragment {
    private String bloodGroup;
    private Float lon;
    private Float lat;

    public SearchDonorFragment() {
        super();
    }

    public SearchDonorFragment(String bloodGroup, Float lon, Float lat) {

        this.bloodGroup = bloodGroup;
        this.lon = lon;
        this.lat = lat;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_donor, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
