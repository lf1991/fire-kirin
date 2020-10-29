package com.feilis.model.adapter.principle;

/**
 * @ClassName ClassAdapter
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/20 14:21
 * @Version V1.0
 */
public class ClassAdapter extends Adapter implements Target {
    @Override
    public void request() {
        specificRequest();
    }
}
