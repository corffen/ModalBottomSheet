package kim.shimmer.loading.modalbottomsheet;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class BottomSheetFragment extends BottomSheetDialogFragment {

    private LinearLayout mDownload;
    private LinearLayout mShare;
    private LinearLayout mUpload;
    private LinearLayout mCopy;
    private LinearLayout mDelete;
    private IBottomSheetAction mIBottomSheetAction;

    public BottomSheetFragment(IBottomSheetAction listener) {
        // Required empty public constructor
        super();
        this.mIBottomSheetAction = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.bottom_sheet_dialog_layout, container, false);
        mCopy = view.findViewById(R.id.copyLinearLayout);
        mDownload = view.findViewById(R.id.download);
        mDelete = view.findViewById(R.id.delete);
        mShare = view.findViewById(R.id.shareLinearLayout);
        mUpload = view.findViewById(R.id.uploadLinearLayout);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIBottomSheetAction != null) {
                    mIBottomSheetAction.copy();
                }
            }
        });
        mDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIBottomSheetAction != null) {
                    mIBottomSheetAction.download();
                }
            }
        });

        mUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIBottomSheetAction != null) {
                    mIBottomSheetAction.upload();
                }
            }
        });

        mShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIBottomSheetAction != null) {
                    mIBottomSheetAction.share();
                }
            }
        });

        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIBottomSheetAction != null) {
                    mIBottomSheetAction.delete();
                }
            }
        });

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}