package com.feilis.model.proxy.dynamic.somecase;

/**
 * @ClassName CheckUpdate
 * @Description TODO 更新实体类
 * @Author lf199
 * @Date 2020/10/20 10:02
 * @Version V1.0
 */
public class CheckUpdate {
    private boolean hasUpdate;

    private String newVersion;

    public boolean isHasUpdate() {
        return hasUpdate;
    }

    public void setHasUpdate(boolean hasUpdate) {
        this.hasUpdate = hasUpdate;
    }

    public String getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(String newVersion) {
        this.newVersion = newVersion;
    }

    @Override
    public String toString() {
        return "CheckUpdate{" +
                "hasUpdate=" + hasUpdate +
                ", newVersion='" + newVersion + '\'' +
                '}';
    }
}
