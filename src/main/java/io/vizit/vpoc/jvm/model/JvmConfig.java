package io.vizit.vpoc.jvm.model;

public class JvmConfig {
    public static final int Xms = 300; // minimum heap size
    public static final int Xmx = Xms; // maximum heap size
    public static final int SurvivorRatio = 8; // survivor:eden = 1:8
    public static final int NewRatio = 2;// young:old = 1:2
    public static final int MaxTenuringThreshold = 3;// default: 15
    private static final int G1HeapRegionSize = 25;

    public static final int getYoungSize() {
        return Xmx * 1 / (JvmConfig.NewRatio + 1);
    }

    public static final int getOldSize() {
        return Xmx - getYoungSize();
    }

    public static final int getEdenSize() {
        return getYoungSize() * JvmConfig.SurvivorRatio / (JvmConfig.SurvivorRatio + 2);
    }

    public static final int getRegionSize() {
        return G1HeapRegionSize;
    }

    public static final int getSurvivorSize() {
        return (getYoungSize() - getEdenSize()) / 2;
    }
}
