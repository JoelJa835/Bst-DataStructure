package org.tuc.isc.util;


public class Generate {


//    public String getAlphaNumericString(int length)
//    {
//
//        // chose a Character random from this String
//        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
//                + "0123456789"
//                + "abcdefghijklmnopqrstuvxyz";
//
//        // create StringBuffer size of AlphaNumericString
//        StringBuilder sb = new StringBuilder(length);
//
//        for (int i = 0; i < length; i++) {
//
//            // generate a random number between
//            // 0 to AlphaNumericString variable length
//            int index
//                    = (int)(AlphaNumericString.length()
//                    * Math.random());
//
//            // add Character one by one in end of sb
//            sb.append(AlphaNumericString
//                    .charAt(index));
//        }
//
//        return sb.toString();
//    }


    public int[] RandomInts(int START_INT,int END_INT,int NO_OF_ELEMENTS) {
        java.util.Random randomGenerator = new java.util.Random();
        int[] randomInts = randomGenerator.ints(START_INT, END_INT).distinct().limit(NO_OF_ELEMENTS).toArray();
        return  randomInts;
    }

//    public String[] GenerateRandomStrings(int size, int length){
//        String string[] = new String[size];
//        for (int i=0; i<size; i++){
//            string[i] = getAlphaNumericString(length);
//        }
//        return  string;
//    }
}
