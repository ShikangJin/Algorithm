/**
    Unique Email Addresses
    Every email consists of a local name and a domain name, separated by the @ sign.

    For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.

    Besides lowercase letters, these emails may contain '.'s or '+'s.

    If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)

    If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)

    It is possible to use both of these rules at the same time.

    Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails? 
*/

//Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
//Output: 2
//Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails

import java.util.Set;
import java.util.HashSet;
import java.util.StringBuilder;

// Time Complexity: O(N)  N = total character number in String array  
// Space Complexity: O(M) M = size of HashSet 
public class UniqueEmailAddress {
    public static int numUniqueEmails(String[] emails) {
      // parse each string and use a set to store the result in order to dedup
        if (emails == null || emails.length == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            boolean domain = false;
            for (int i = 0; i < email.length(); i++) {
                char curCh = email.charAt(i);
                if (domain) {
                    sb.append(curCh);
                    continue;
                }
                switch(curCh) {
                    default: sb.append(curCh); break;
                    case '+': while (i + 1 < email.length() && email.charAt(i + 1) != '@') i++; break;
                    case '@': sb.append(curCh); domain = true; break;
                    case '.': break;
                }
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}



