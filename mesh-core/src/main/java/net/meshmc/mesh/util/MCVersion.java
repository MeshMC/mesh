package net.meshmc.mesh.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * We, of course, will not be supporting every version listed here,
 * but the data is here... for whoever needs it.
 */
public enum MCVersion {
    v1_19_2("1.19.2", 760),
    v1_19_1("1.19.1", 760),
    v1_19("1.19", 759),

    v1_18_2("1.18.2", 758, Loader.Fabric),
    v1_18_1("1.18.1", 757, Loader.Fabric, v1_18_2),
    v1_18("1.18", 757, Loader.Fabric, v1_18_2),

    v1_17_1("1.17.1", 756),
    v1_17("1.17", 755),

    v1_16_5("1.16.5", 754),
    v1_16_4("1.16.4", 754),
    v1_16_3("1.16.3", 753),
    v1_16_2("1.16.2", 751),
    v1_16_1("1.16.1", 736),
    v1_16("1.16", 735),

    v1_15_2("1.15.2", 578),
    v1_15_1("1.15.1", 575),
    v1_15("1.15", 573),

    v1_14_4("1.14.4", 498),
    v1_14_3("1.14.3", 490),
    v1_14_2("1.14.2", 485),
    v1_14_1("1.14.1", 480),
    v1_14("1.14", 477),

    v1_13_2("1.13.2", 404),
    v1_13_1("1.13.1", 401),
    v1_13("1.13", 393),

    v1_12_2("1.12.2", 340, Loader.Forge),
    v1_12_1("1.12.1", 338),
    v1_12("1.12", 335),

    v1_11_2("1.11.2", 316),
    v1_11_1("1.11.1", 316),
    v1_11("1.11", 315),

    v1_10_2("1.10.2", 210),
    v1_10_1("1.10.1", 210),
    v1_10("1.10", 210),

    v1_9_4("1.9.4", 110),
    v1_9_3("1.9.3", 110),
    v1_9_2("1.9.2", 109),
    v1_9_1("1.9.1", 108),
    v1_9("1.9", 107),

    v1_8_9("1.8.9", 47),
    v1_8_8("1.8.8", 47),
    v1_8_7("1.8.7", 47),
    v1_8_6("1.8.6", 47),
    v1_8_5("1.8.5", 47),
    v1_8_4("1.8.4", 47),
    v1_8_3("1.8.3", 47),
    v1_8_2("1.8.2", 47),
    v1_8_1("1.8.1", 47),
    v1_8("1.8", 47),

    v1_7_10("1.7.10", 5),
    v1_7_9("1.7.9", 5),
    v1_7_8("1.7.8", 5),
    v1_7_7("1.7.7", 5),
    v1_7_6("1.7.6", 5),
    v1_7_5("1.7.5", 4),
    v1_7_4("1.7.4", 4),
    v1_7_3("1.7.3", 4),
    v1_7_2("1.7.2", 4),
    v1_7_1("1.7.1", 3),
    v1_7("1.7", 3),

    // -- Netty Rewrite --

    v1_6_4("1.6.4", 78),
    v1_6_3("1.6.3", 77),
    v1_6_2("1.6.2", 74),
    v1_6_1("1.6.1", 73),
    v1_6("1.6", 72),

    v1_5_2("1.5.2", 61),
    v1_5_1("1.5.1", 60),
    v1_5("1.5", 60),

    v1_4_7("1.4.7", 51),
    v1_4_6("1.4.6", 51),
    v1_4_5("1.4.5", 49),
    v1_4_4("1.4.4", 49),
    v1_4_3("1.4.3", 48),
    v1_4_2("1.4.2", 47),
    v1_4_1("1.4.1", 47),
    v1_4("1.4", 47),

    v1_3_2("1.3.2", 39),
    v1_3_1("1.3.1", 39),
    v1_3("1.3", 39),

    v1_2_5("1.2.5", 29),
    v1_2_4("1.2.4", 29),
    v1_2_3("1.2.3", 28),
    v1_2_2("1.2.2", 28),
    v1_2_1("1.2.1", 28),

    v1_1("1.1", 23),

    v1_0_1("1.0.1", 22),
    v1_0("1.0", 22),
    ;

    enum Loader {
        Fabric,
        Forge,
        Both
    }

    public final String version;
    public final int procotol;
    public final Loader compatibleLoader;
    public final MCVersion compatibleVersion;

    MCVersion(String version, int procotol, Loader compatibleLoader, MCVersion compatibleVersion) {
        this.version = version;
        this.procotol = procotol;
        this.compatibleLoader = compatibleLoader;
        this.compatibleVersion = compatibleVersion;
    }

    MCVersion(String version, int procotol, Loader loader) {
        this.version = version;
        this.procotol = procotol;
        this.compatibleLoader = loader;
        this.compatibleVersion = this;
    }

    MCVersion(String version, int procotol) {
        this.version = version;
        this.procotol = procotol;
        this.compatibleLoader = null;
        this.compatibleVersion = null;
    }

    /**
     * Used to annotate what versions of Minecraft are required for certain methods, fields or parameters to have any effect.
     */
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
    public @interface OnlyOn {
        MCVersion[] value();

        boolean minimumVersion() default false;

        boolean maximumVersion() default false;
    }
}
