package ndk.banee.circuitloop;

import java.util.Comparator;


/**
 * A collection of {@link Comparator}s for {@link RawMaterialModel} objects.
 */
public final class RawMaterialComparator {

    private RawMaterialComparator() {
        //no instance
    }

    public static Comparator<RawMaterialModel> getRawMaterialNameComparator() {

        return new RawMaterialNameComparator();
    }

    public static Comparator<RawMaterialModel> getRawMaterialCurrentStockComparator() {

        return new RawMaterialCurrentStockComparator();
    }

    public static Comparator<RawMaterialModel> getRawMaterialMinimumStockComparator() {

        return new RawMaterialMinimumStockComparator();
    }

    public static Comparator<RawMaterialModel> getRawMaterialSerialNumberComparator() {

        return new RawMaterialSerialNumberComparator();
    }

    private static class RawMaterialNameComparator implements Comparator<RawMaterialModel> {

        @Override
        public int compare(final RawMaterialModel rawMaterial1, final RawMaterialModel rawMaterial12) {

            return rawMaterial1.getName().compareTo(rawMaterial12.getName());
        }
    }

    private static class RawMaterialCurrentStockComparator implements Comparator<RawMaterialModel> {

        @Override
        public int compare(final RawMaterialModel rawMaterial1, final RawMaterialModel rawMaterial2) {

            return Float.compare(rawMaterial1.getCurrentStock(), rawMaterial2.getCurrentStock());
        }
    }

    private static class RawMaterialMinimumStockComparator implements Comparator<RawMaterialModel> {

        @Override
        public int compare(final RawMaterialModel rawMaterial1, final RawMaterialModel rawMaterial2) {

            return Float.compare(rawMaterial1.getMinimumStock(), rawMaterial2.getMinimumStock());
        }
    }

    private static class RawMaterialSerialNumberComparator implements Comparator<RawMaterialModel> {

        @Override
        public int compare(final RawMaterialModel rawMaterial1, final RawMaterialModel rawMaterial2) {

            return Integer.compare(rawMaterial1.getSerialNumber(), rawMaterial2.getSerialNumber());
        }
    }
}
