package xpfei.demo.build;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xpfei.demo.R;

public class MyTitleBar {
    private String value;
    private int layoutId;
    private View.OnClickListener onLeftClickListener;
    private boolean isRightShow;
    private String rightTxt;
    private View.OnClickListener onRightClickListener;
    private Context mContext;
    private ViewGroup viewGroup;
    private int titleId, leftId, rightId;

    private MyTitleBar(Builder mBuilder) {
        this.titleId = mBuilder.titleId;
        this.leftId = mBuilder.leftId;
        this.rightId = mBuilder.rightId;
        this.value = mBuilder.value;
        this.layoutId = mBuilder.layoutId;
        this.onLeftClickListener = mBuilder.onLeftClickListener;
        this.isRightShow = mBuilder.isRightShow;
        this.rightTxt = mBuilder.rightTxt;
        this.onRightClickListener = mBuilder.onRightClickListener;
        this.mContext = mBuilder.mContext;
        this.viewGroup = mBuilder.viewGroup;
        crete();
    }

    private void crete() {
        View view = LayoutInflater.from(mContext).inflate(layoutId, viewGroup, false);
        TextView tvTitle = view.findViewById(titleId);
        tvTitle.setText(value);
        View vLeft = view.findViewById(leftId);
        if (onLeftClickListener == null) {
            vLeft.setOnClickListener(v -> ((Activity) mContext).finish());
        } else {
            vLeft.setOnClickListener(onLeftClickListener);
        }
        if (isRightShow) {
            TextView tvRight = view.findViewById(rightId);
            tvRight.setVisibility(View.VISIBLE);
            tvRight.setText(rightTxt);
            if (onRightClickListener != null) {
                tvRight.setOnClickListener(onRightClickListener);
            }
        }
        viewGroup.addView(view, 0);
    }

    @SuppressWarnings("SameParameterValue")
    public static class Builder {
        int titleId = R.id.tvTitle, leftId = R.id.llLeft, rightId = R.id.tvRight;
        String value = "未知";
        int layoutId = R.layout.view_defulttitlebar;
        View.OnClickListener onLeftClickListener;
        boolean isRightShow = false;
        String rightTxt = "点击我";
        View.OnClickListener onRightClickListener;
        Context mContext;
        ViewGroup viewGroup;

        public Builder(Context mContext, ViewGroup viewGroup) {
            this.mContext = mContext;
            this.viewGroup = viewGroup;
        }

        public Builder setLayoutId(int layoutId) {
            if (layoutId > 0) {
                this.layoutId = layoutId;
            }
            return this;
        }

        public Builder setTitle(String value) {
            this.value = value;
            return this;
        }

        public Builder setTitle(int id, String value) {
            this.titleId = id;
            this.value = value;
            return this;
        }

        public Builder setOnLeftClickListener(View.OnClickListener onLeftClickListener) {
            this.onLeftClickListener = onLeftClickListener;
            return this;
        }

        public Builder setOnLeftClickListener(int id, View.OnClickListener onLeftClickListener) {
            this.leftId = id;
            this.onLeftClickListener = onLeftClickListener;
            return this;
        }

        Builder setRightShow(boolean rightShow) {
            isRightShow = rightShow;
            return this;
        }

        public Builder setRightShow(int id, boolean rightShow) {
            this.rightId = id;
            isRightShow = rightShow;
            return this;
        }

        public Builder setRightTxt(String rightTxt) {
            this.rightTxt = rightTxt;
            return this;
        }

        Builder setOnRightClickListener(View.OnClickListener onRightClickListener) {
            this.onRightClickListener = onRightClickListener;
            return this;
        }

        public void create() {
            new MyTitleBar(this);
        }
    }
}
