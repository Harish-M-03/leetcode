import java.util.*;

class Solution {

    private boolean isValidCode(String str) {
        if (str.length() == 0) return false;

        for (char ch : str.toCharArray()) {
            if (!(Character.isLetterOrDigit(ch) || ch == '_')) {
                return false;
            }
        }
        return true;
    }

    public List<String> validateCoupons(String[] code,
                                        String[] businessLine,
                                        boolean[] isActive) {

        // Business line priority
        Map<String, Integer> priority = new HashMap<>();
        priority.put("electronics", 0);
        priority.put("grocery", 1);
        priority.put("pharmacy", 2);
        priority.put("restaurant", 3);

        // Store valid coupons as (businessLine, code)
        List<String[]> valid = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (isActive[i]
                    && isValidCode(code[i])
                    && priority.containsKey(businessLine[i])) {

                valid.add(new String[]{businessLine[i], code[i]});
            }
        }

        // Sorting
        Collections.sort(valid, (a, b) -> {
            int cmp = priority.get(a[0]) - priority.get(b[0]);
            if (cmp != 0) return cmp;
            return a[1].compareTo(b[1]);
        });

        // Extract only codes
        List<String> result = new ArrayList<>();
        for (String[] v : valid) {
            result.add(v[1]);
        }

        return result;
    }
}
