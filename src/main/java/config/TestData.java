package config;

/**
 * Created by A.Bartolome 12/01/2019
 */
public class TestData {

    public class RunnerConfiguration{
        // Time out in seconds
        public static final int Timeout = 20;
    }

    public class TestConfiguration {
        public static final String DeviceName = "AppiumDevice";
        public static final String DeviceNVersion = "8.1";
        public static final String AppName = "CoCoin.apk";
    }

    /**
     * Number to use/reuse as a password
     */
    public class PasswordToUse{
        public static final int Digit_1 = 1;
        public static final int Digit_2 = 2;
        public static final int Digit_3 = 1;
        public static final int Digit_4 = 2;
    }

    /**
     * Data to use to create a new Entry
     * Amount and Tag
     */
    public class NewEntry {
        public static final int Digit_1 = 1;
        public static final int Digit_2 = 2;
        public static final int Digit_3 = 7;
        public static final int AmountAllDigits = 127;

        public static final String TagToUse = "Breakfast";

        /**
         * 1 tag Breakfast
         * 2 tag Lunch
         * 3 tag Dinner
         * 4 tag Midnight Snack
         * 5 tag Clothing & Footwear
         * 6 tag Home
         * 7 tag Traffic
         * 8 tag Vehicle Maintenance
         */
    }
}
