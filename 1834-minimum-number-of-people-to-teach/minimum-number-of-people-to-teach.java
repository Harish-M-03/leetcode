class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {

        // 'm' is the total number of users in our social network.
        // We get this from the number of language lists provided.
        int m = languages.length;

        // This is where the magic of BitSets happens! ✨
        // 'usersLanguages' is an array. Each element in this array will be a BitSet.
        // Think of each BitSet as a special "checklist" for a user's languages.
        // If a language is '1' (set) in the BitSet, the user knows it. If it's '0' (unset), they don't.
        // We need one BitSet for each user, so the array size is 'm'.
        BitSet[] usersLanguages = new BitSet[m];

        // Let's go through each user and set up their language checklist (BitSet).
        for (int i = 0; i < m; i++) {
            // We create a new BitSet for user 'i'. The 'n' tells the BitSet how many "slots" it might need,
            // corresponding to the 'n' possible languages.
            usersLanguages[i] = new BitSet(n);

            // Now, for the current user 'i', we look at the languages they already know.
            for (int lang : languages[i]) {
                // Languages are numbered from 1 to n. But BitSets use 0-based indexing.
                // So, if a user knows language 'lang', we set the bit at index 'lang - 1' in their BitSet.
                // It's like ticking off language 'lang' on their checklist.
                usersLanguages[i].set(lang - 1);
            }
        }

        // This variable will keep track of the minimum number of people we *ever* need to teach.
        // We start it at a very large number so that the first valid count we find will be smaller.
        int minPeopleToTeach = Integer.MAX_VALUE;

        // Now, the core loop! We're going to try teaching EACH language, one by one.
        // 'targetLangNum' represents the language number (from 1 to n) we are currently considering to teach.
        for (int targetLangNum = 1; targetLangNum <= n; targetLangNum++) {

            // Just like before, we convert the language number to its 0-based index for BitSet operations.
            int targetLangIndex = targetLangNum - 1;

            // For *this specific* target language, we need a way to track WHO needs to be taught.
            // We'll use another BitSet! 'usersToTeachCurrentLang'.
            // If the bit for a user is set in this BitSet, it means they are a candidate to learn 'targetLangNum'.
            BitSet usersToTeachCurrentLang = new BitSet(m);

            // Now, let's check all the friendships to see who needs help.
            for (int[] friendship : friendships) {
                // Get the user indices for the current friendship. Remember to adjust for 0-based indexing.
                int uIndex = friendship[0] - 1;
                int vIndex = friendship[1] - 1;

                // The crucial check: Do these two friends NOT have ANY common language?
                // The .intersects() method on BitSets is super handy here. It checks if there's any overlap (common language).
                // If it returns FALSE, it means they DON'T share any languages. Uh oh! \U0001f631
                if (!usersLanguages[uIndex].intersects(usersLanguages[vIndex])) {

                    // Okay, these friends (u and v) can't talk. Now, let's see if our 'targetLangNum' can save the day!

                    // Check user 'u': Does user 'u' know the 'targetLangNum'?
                    // If .get(targetLangIndex) returns FALSE, it means they DON'T know it.
                    // So, if we teach 'targetLangNum', this user 'u' *might* be someone we need to teach.
                    if (!usersLanguages[uIndex].get(targetLangIndex)) {
                        // We mark user 'u' in our 'usersToTeachCurrentLang' BitSet.
                        // This means user 'u' is a potential candidate to learn 'targetLangNum'.
                        usersToTeachCurrentLang.set(uIndex);
                    }

                    // Now do the same for user 'v'.
                    // If user 'v' also doesn't know the 'targetLangNum'...
                    if (!usersLanguages[vIndex].get(targetLangIndex)) {
                        // ...we mark user 'v' as a potential candidate to learn 'targetLangNum'.
                        usersToTeachCurrentLang.set(vIndex);
                    }
                    // Notice: If BOTH don't know the target language, both get marked.
                    // The BitSet's .cardinality() later will count them uniquely! \U0001f44d
                }
                // If usersLanguages[uIndex].intersects(usersLanguages[vIndex]) was TRUE,
                // it means they already have a common language, so this friendship is fine. We don't need to do anything for them.
            }

            // After checking ALL friendships for the current 'targetLangNum':
            // 'usersToTeachCurrentLang' now has bits set for all unique users who *don't* know 'targetLangNum'
            // AND are part of at least one friendship where teaching 'targetLangNum' would help resolve a communication gap.

            // .cardinality() is a super cool BitSet method! It tells us exactly HOW MANY bits are set to '1'.
            // This gives us the count of people we need to teach if we choose 'targetLangNum'.
            int peopleCountForThisTargetLang = usersToTeachCurrentLang.cardinality();

            // We compare this count with our current minimum. If this count is smaller, it becomes our new minimum!
            // This is how we find the absolute smallest number of people to teach across ALL possible target languages.
            minPeopleToTeach = Math.min(minPeopleToTeach, peopleCountForThisTargetLang);
        }

        // Finally, after trying every language as the target, 'minPeopleToTeach' holds the smallest number required.
        return minPeopleToTeach;
    }
}