package capstone.sejong.ocr;

public final class MorphemeUtil {

    /**
     * 초성 - 가(ㄱ), 날(ㄴ) 닭(ㄷ)
     */
    private static char[] arrChoSung = {0x3131, 0x3132, 0x3134, 0x3137, 0x3138, 0x3139, 0x3141, 0x3142, 0x3143, 0x3145,
            0x3146, 0x3147, 0x3148, 0x3149, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e};
    /**
     * 중성 - 가(ㅏ), 야(ㅑ), 뺨(ㅑ)
     */
    private static char[] arrJungSung = {0x314f, 0x3150, 0x3151, 0x3152, 0x3153, 0x3154, 0x3155, 0x3156, 0x3157,
            0x3158, 0x3159, 0x315a, 0x315b, 0x315c, 0x315d, 0x315e, 0x315f, 0x3160, 0x3161, 0x3162, 0x3163};
    /**
     * 종성 - 가(없음), 갈(ㄹ) 천(ㄴ)
     */
    private static char[] arrJongSung = {0x0000, 0x3131, 0x3132, 0x3133, 0x3134, 0x3135, 0x3136, 0x3137, 0x3139,
            0x313a, 0x313b, 0x313c, 0x313d, 0x313e, 0x313f, 0x3140, 0x3141, 0x3142, 0x3144, 0x3145, 0x3146, 0x3147,
            0x3148, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e};

    public static String getUniKorean(String word) {

        String result = ""; // 결과 저장할 변수

        for (int i = 0; i < word.length(); i++) {

            /* 한글자씩 읽어들인다. */
            char chars = (char) (word.charAt(i) - 0xAC00);

            if (chars >= 0 && chars <= 11172) {
                /* A. 자음과 모음이 합쳐진 글자인경우 */

                /* A-1. 초/중/종성 분리 */
                int chosung = chars / (21 * 28);
                int jungsung = chars % (21 * 28) / 28;
                int jongsung = chars % (21 * 28) % 28;

                /* A-2. result에 담기 */
                result = result + arrChoSung[chosung] + arrJungSung[jungsung];

                /* 자음분리 */
                if (jongsung != 0x0000) {
                    /* A-3. 종성이 존재할경우 result에 담는다 */
                    result = result + arrJongSung[jongsung];
                }

            } else {
                /* B. 한글이 아니거나 자음만 있을경우 */

                /* 자음분리 */
                result = result + ((char) (chars + 0xAC00));

                /* 알파벳으로 */
                if (chars >= 34097 && chars <= 34126) {
                    /* 단일자음인 경우 */
                    int jaum = (chars - 34097);
                } else if (chars >= 34127 && chars <= 34147) {
                    /* 단일모음인 경우 */
                    int moum = (chars - 34127);
                }
            } // if

        } // for

        return result;
    }

    public static double compareWord(String word) {
        double weight = 0;
        char cWord = word.charAt(0);
        // System.out.println(word);
        for (int i = 0; i < arrChoSung.length; i++) {
            if (cWord == arrChoSung[i])
                weight = 0.65;
        }
        for (int j = 0; j < arrJungSung.length; j++) {
            if (cWord == arrJongSung[j])
                weight = 0.45;
        }
        return weight;
    }// 자모음에 따른 가중치 조절
}