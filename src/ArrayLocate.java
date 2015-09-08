public class ArrayLocate {

    public static <ArrayType> Integer findStartIndexOfMatchingSubArray(ArrayType[] parentValues, ArrayType[] matchValues) {
        if (parentValues == null || matchValues == null || matchValues.length > parentValues.length) {
            return null;
        }
        for (int parentIndex = 0; parentIndex < parentValues.length; parentIndex++) {
            for (int matchIndex = 0; matchIndex < matchValues.length; matchIndex++) {
                boolean valueMatches = valuesMatch(parentValues[parentIndex + matchIndex], (matchValues[matchIndex]));
                if (!valueMatches) {
                    break;
                } else if (matchIndex == matchValues.length - 1) {
                    return parentIndex;
                }
            }
        }
        return null;
    }

    private static <ArrayType> boolean valuesMatch(ArrayType first, ArrayType second) {
        return first == null ? second == null : first.equals(second);
    }
}
