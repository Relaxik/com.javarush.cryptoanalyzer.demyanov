package src;

public class BruteForce {
}
//    public static char[] shiftArray(char[] arrayToShift, int shiftKey) {
//        if ((arrayToShift == null) || (arrayToShift.length == 0) || (shiftKey <= 0)) {
//            throw new java.lang.IllegalArgumentException();
//        }
//        while (shiftKey > 0) {
//            int lastVar = arrayToShift[arrayToShift.length - 1];
//            for (int i = 0; i < arrayToShift.length; i++) {
//                int curVal = arrayToShift[i];
//                arrayToShift[i] = (char) lastVar;
//                lastVar = curVal;
//            }
//            shiftKey--;
//        }
//        return arrayToShift;
//    }